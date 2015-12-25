/**
 * Copyright By Grandsoft Company Limited.  
 * 2015年12月23日 下午4:43:39
 */
package com.glodon.dtm.hd;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glodon.dtm.common.model.TransferLog;
import com.glodon.dtm.common.repository.ITransferLogService;
import com.glodon.dtm.common.service.ITransferDataService;
import com.glodon.dtm.common.util.DateUtil;
import com.glodon.dtm.common.util.ExceptionUtil;
import com.glodon.dtm.hd.model.CZ_ExecuteNotice;
import com.glodon.dtm.hd.model.HD_ExecuteNotice;
import com.glodon.dtm.hd.service.CZExecuteNoticeService;
import com.glodon.dtm.hd.service.DataConverter;
import com.glodon.dtm.hd.service.HDExecuteNoticeService;

@Service
public class TransferDataServiceImpl implements ITransferDataService {

	@Autowired
	private CZExecuteNoticeService czService;

	@Autowired
	private HDExecuteNoticeService hdService;

	@Autowired
	private ITransferLogService logService;

	public void transferData() {
		TransferLog log = new TransferLog();
		log.setStartDate(new Date());
		log.setLongStartDate(System.currentTimeMillis() + "");

		StringBuffer allIds = new StringBuffer();
		StringBuffer successIds = new StringBuffer();
		StringBuffer failIds = new StringBuffer();
		StringBuffer noIds = new StringBuffer();
		StringBuffer failInfo = new StringBuffer();

		List<CZ_ExecuteNotice> czLst = czService.findCurrentDay();
		List<HD_ExecuteNotice> hdLst = DataConverter.convertDatas(czLst);

		for (int i = 0; null != hdLst && i < hdLst.size(); i++) {
			HD_ExecuteNotice tmp = hdLst.get(i);
			allIds.append(tmp.getXmid()).append(",");

			try {
				boolean isExist = hdService.isExists(hdLst.get(i).getXmid());
				if (!isExist) {
					hdService.save(hdLst.get(i));
					successIds.append(tmp.getXmid()).append(",");
				} else {
					noIds.append(tmp.getXmid()).append(",");
				}

			} catch (Exception e) {
				failIds.append(tmp.getXmid()).append(",");
				failInfo.append("{").append(tmp.getXmid()).append(",").append(ExceptionUtil.getStackMsg(e)).append("}");
			}
		}
		log.setFailIds(failIds.toString());
		log.setSuccessIds(successIds.toString());
		log.setAllIds(allIds.toString());
		log.setFailInfo(failInfo.toString());
		log.setNoIds(noIds.toString());

		log.setEndDate(new Date());
		log.setLongEndDate(System.currentTimeMillis() + "");

		log.setCosts((Long.valueOf(log.getLongEndDate()) - Long.valueOf(log.getLongStartDate())) + "");

		log.setPk("000000000000000000000" + DateUtil.getCurrentDateStr());//40位主键

		logService.save(log);
	}

}
