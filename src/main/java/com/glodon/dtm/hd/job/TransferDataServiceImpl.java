/**
 * Copyright By Grandsoft Company Limited.  
 * 2015年12月23日 下午4:43:39
 */
package com.glodon.dtm.hd.job;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glodon.dtm.common.config.ExtraScheduleConfig;
import com.glodon.dtm.common.model.Log;
import com.glodon.dtm.common.plugin.ITransferService;
import com.glodon.dtm.common.repository.ILogRepository;
import com.glodon.dtm.common.util.DateUtil;
import com.glodon.dtm.common.util.ExceptionUtil;
import com.glodon.dtm.hd.model.CZ_ExecuteNotice;
import com.glodon.dtm.hd.model.HD_ExecuteNotice;
import com.glodon.dtm.hd.service.CZExecuteNoticeService;
import com.glodon.dtm.hd.service.DataConverter;
import com.glodon.dtm.hd.service.HDExecuteNoticeService;

@Service
public class TransferDataServiceImpl implements ITransferService {

	@Autowired
	private CZExecuteNoticeService czService;

	@Autowired
	private HDExecuteNoticeService hdService;

	@Autowired
	private ILogRepository logService;

	@Autowired
	private ExtraScheduleConfig hdConfig;

	public void transfer() {
		Log log = new Log();
		log.setStartDate(new Date());
		log.setLongStartDate(System.currentTimeMillis() + "");

		StringBuffer allIds = new StringBuffer();
		StringBuffer successIds = new StringBuffer();
		StringBuffer failIds = new StringBuffer();
		StringBuffer noIds = new StringBuffer();
		StringBuffer failInfo = new StringBuffer();

		Integer allCount = new Integer(0);

		Integer successCount = new Integer(0);

		Integer failCount = new Integer(0);

		Integer noCount = new Integer(0);

		List<CZ_ExecuteNotice> czLst = czService.findDatePair(hdConfig.getDateBegin(), hdConfig.getDateEnd());
		if (czLst != null && czLst.size() > 0) {
			allCount = czLst.size();
		}
		List<HD_ExecuteNotice> hdLst = DataConverter.convertDatas(czLst);
		for (int i = 0; null != hdLst && i < hdLst.size(); i++) {
			HD_ExecuteNotice tmp = hdLst.get(i);
			allIds.append(tmp.getXmid()).append(",");
			try {
				boolean isExist = hdService.isExists(hdLst.get(i).getXmid());
				if (!isExist) {
					hdService.save(hdLst.get(i));
					successIds.append(tmp.getXmid()).append(",");
					++successCount;
				} else {
					noIds.append(tmp.getXmid()).append(",");
					++noCount;
				}
			} catch (Exception e) {
				failIds.append(tmp.getXmid()).append(",");
				failInfo.append("{").append(tmp.getXmid()).append(",").append(ExceptionUtil.getStackMsg(e)).append("};");
				++failCount;
			}
		}
		log.setFailIds(failIds.toString());
		log.setSuccessIds(successIds.toString());
		log.setAllIds(allIds.toString());
		log.setFailInfo(failInfo.toString());
		log.setNoIds(noIds.toString());
		log.setFailCount(failCount.toString());
		log.setAllCount(allCount.toString());
		log.setSuccessCount(successCount.toString());
		log.setNoCount(noCount.toString());

		log.setEndDate(new Date());
		log.setLongEndDate(System.currentTimeMillis() + "");

		log.setCosts((Long.valueOf(log.getLongEndDate()) - Long.valueOf(log.getLongStartDate())) + "");

		log.setPk("000000000000000000000" + DateUtil.getCurrentDateStr());//40位主键

		logService.save(log);
	}

	public void transferOne(String pk) {
		Log log = new Log();
		log.setStartDate(new Date());
		log.setLongStartDate(System.currentTimeMillis() + "");
		CZ_ExecuteNotice czObj = czService.findOne(pk);

		if (czObj == null) {
			throw new RuntimeException("根据项目ID查询不到对应执行通知书。");
		}

		HD_ExecuteNotice hdObj = DataConverter.convertOne(czObj);
		StringBuffer allIds = new StringBuffer();
		StringBuffer successIds = new StringBuffer();
		StringBuffer failIds = new StringBuffer();
		StringBuffer noIds = new StringBuffer();
		StringBuffer failInfo = new StringBuffer();

		Integer allCount = new Integer(1);
		Integer successCount = new Integer(0);
		Integer failCount = new Integer(0);
		Integer noCount = new Integer(0);

		allIds.append(hdObj.getXmid()).append(",");
		try {
			boolean isExist = hdService.isExists(hdObj.getXmid());
			if (isExist) {
				hdService.deleteByPk(hdObj.getXmid());
			}
			hdService.save(hdObj);
			successIds.append(hdObj.getXmid()).append(",");
			++successCount;
		} catch (Exception e) {
			failIds.append(hdObj.getXmid()).append(",");
			failInfo.append("{").append(hdObj.getXmid()).append(",").append(ExceptionUtil.getStackMsg(e)).append("};");
			++failCount;
		}
		log.setFailIds(failIds.toString());
		log.setSuccessIds(successIds.toString());
		log.setAllIds(allIds.toString());
		log.setFailInfo(failInfo.toString());
		log.setNoIds(noIds.toString());
		log.setFailCount(failCount.toString());
		log.setAllCount(allCount.toString());
		log.setSuccessCount(successCount.toString());
		log.setNoCount(noCount.toString());
		log.setEndDate(new Date());
		log.setLongEndDate(System.currentTimeMillis() + "");

		log.setCosts((Long.valueOf(log.getLongEndDate()) - Long.valueOf(log.getLongStartDate())) + "");

		log.setPk("000000000000000000000" + DateUtil.getCurrentDateStr());//40位主键

		logService.save(log);
	}

}
