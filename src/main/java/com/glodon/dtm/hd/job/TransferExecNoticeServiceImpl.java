/**
 * Copyright By Grandsoft Company Limited.  
 * 2015年12月23日 下午4:43:39
 */
package com.glodon.dtm.hd.job;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glodon.dtm.common.model.Log;
import com.glodon.dtm.common.plugin.ITransferService;
import com.glodon.dtm.common.repository.ILogRepository;
import com.glodon.dtm.common.util.DateUtil;
import com.glodon.dtm.hd.ExtraScheduleConfig;
import com.glodon.dtm.hd.model.CZ_ExecPackage;
import com.glodon.dtm.hd.model.CZ_ExecuteNotice;
import com.glodon.dtm.hd.model.CZ_ExecuteNoticeDetail;
import com.glodon.dtm.hd.model.CZ_ExecuteNoticeTZ;
import com.glodon.dtm.hd.model.HD_ExecuteNotice;
import com.glodon.dtm.hd.model.HD_ExecuteNoticeDetail;
import com.glodon.dtm.hd.model.HD_ExecuteNoticeTZ;
import com.glodon.dtm.hd.service.CZExecPackageService;
import com.glodon.dtm.hd.service.CZExecuteNoticeService;
import com.glodon.dtm.hd.service.DataConverter;
import com.glodon.dtm.hd.service.HDExecuteNoticeService;

@Service("transferExecNotice")
public class TransferExecNoticeServiceImpl implements ITransferService {

	@Autowired
	private CZExecuteNoticeService czService;

	@Autowired
	private HDExecuteNoticeService hdService;
	
	@Autowired
	private CZExecPackageService czExeService;

	@Autowired
	private ILogRepository logService;

	@Autowired
	private ExtraScheduleConfig hdConfig;

	public void transfer() {
		Log log = new Log();
		log.setStartDate(new Date());
		log.setLongStartDate(System.currentTimeMillis() + "");
		log.setTransType("EXENOTICE");

		StringBuffer allIds = new StringBuffer();

		Integer allCount = new Integer(0);

		List<CZ_ExecuteNotice> czLst = czService.findDatePair(hdConfig.getStartDate(hdConfig.getNoticeStartDate()),
				hdConfig.getEndDate(hdConfig.getNoticeEndDate()));
		if (czLst != null && czLst.size() > 0) {
			allCount = czLst.size();
		}
		czExeService.deleteAll();//全删再插，仅一个字段有效
		
		for (int i = 0; null != czLst && i < czLst.size(); i++) {
			CZ_ExecuteNotice czNotice = czLst.get(i);

			saveNotice(czNotice);

			saveDetails(czNotice);

			saveTzs(czNotice);
			
			saveExed(czNotice);
		}

		log.setAllIds(allIds.toString());
		log.setAllCount(allCount.toString());

		log.setEndDate(new Date());
		log.setLongEndDate(System.currentTimeMillis() + "");

		log.setCosts((Long.valueOf(log.getLongEndDate()) - Long.valueOf(log.getLongStartDate())) + "");

		log.setPk(DateUtil.getCurrentDateStr() + "_" + log.getTransType());

		logService.save(log);

	}

	private void saveExed(CZ_ExecuteNotice czNotice) {
		CZ_ExecPackage o = new CZ_ExecPackage();
		o.setXmid(czNotice.getXMID());
		czExeService.save(o);
	}

	private void saveNotice(CZ_ExecuteNotice czNotice) {
		boolean isExist = hdService.isExists(czNotice.getXMID());
		if (isExist) {
			return;
			//hdService.deleteByPk(czNotice.getXMID());
		}
		HD_ExecuteNotice hdNotice = DataConverter.convertOne(czNotice);
		hdService.save(hdNotice);
	}

	private void saveTzs(CZ_ExecuteNotice czNotice) {
		List<CZ_ExecuteNoticeTZ> tzs = czService.findTZByXMID(czNotice.getXMID());
		for (int j = 0; null != tzs && j < tzs.size(); j++) {
			CZ_ExecuteNoticeTZ czTz = tzs.get(j);
			if (hdService.isExistsTZ(czTz.getTZID())) {
				continue;
				//hdService.deleteTZByPk(czNotice.getXMID());
			}
			HD_ExecuteNoticeTZ hdTz = DataConverter.convertOne(czTz);
			hdService.saveTZ(hdTz);
		}
	}

	private void saveDetails(CZ_ExecuteNotice czNotice) {
		List<CZ_ExecuteNoticeDetail> details = czService.findDetailByXMID(czNotice.getXMID());
		for (int j = 0; null != details && j < details.size(); j++) {
			CZ_ExecuteNoticeDetail czDetail = details.get(j);
			if (hdService.isExistsDetail(czDetail.getCGMXID())) {
				continue;
				//hdService.deleteDetailByPk(czNotice.getXMID());
			}
			HD_ExecuteNoticeDetail hdDetail = DataConverter.convertOne(czDetail);
			hdService.saveDetail(hdDetail);
		}
	}

	public void transferOne(String pk) {
		Log log = new Log();
		log.setStartDate(new Date());
		log.setLongStartDate(System.currentTimeMillis() + "");
		CZ_ExecuteNotice czNotice = czService.findOne(pk);

		if (czNotice == null) {
			throw new RuntimeException("根据项目ID查询不到对应执行通知书。");
		}

		saveNotice(czNotice);
		saveDetails(czNotice);
		saveTzs(czNotice);

		log.setAllIds(czNotice.getXMID() + ",");
		log.setAllCount("1");
		log.setEndDate(new Date());
		log.setLongEndDate(System.currentTimeMillis() + "");

		log.setCosts((Long.valueOf(log.getLongEndDate()) - Long.valueOf(log.getLongStartDate())) + "");

		log.setPk(DateUtil.getCurrentDateStr());//40位主键

		logService.save(log);
	}

}
