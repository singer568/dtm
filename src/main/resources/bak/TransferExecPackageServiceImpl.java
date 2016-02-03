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
import com.glodon.dtm.hd.model.HD_ExecPackage;
import com.glodon.dtm.hd.service.CZExecPackageService;
import com.glodon.dtm.hd.service.DataConverter;
import com.glodon.dtm.hd.service.HDExecPackageService;

@Service("transferExecPackage")
public class TransferExecPackageServiceImpl implements ITransferService {

	@Autowired
	private CZExecPackageService czService;

	@Autowired
	private HDExecPackageService hdService;

	@Autowired
	private ILogRepository logService;

	@Autowired
	private ExtraScheduleConfig hdConfig;

	public void transfer() {
		Log log = new Log();
		log.setStartDate(new Date());
		log.setLongStartDate(System.currentTimeMillis() + "");
		log.setTransType("EXECPACKAGE");

		StringBuffer allIds = new StringBuffer();

		Integer allCount = new Integer(0);

		List<HD_ExecPackage> hdLst = hdService.findAll();
		if (hdLst != null && hdLst.size() > 0) {
			allCount = hdLst.size();
		}
		czService.deleteAll();

		for (int i = 0; null != hdLst && i < hdLst.size(); i++) {
			HD_ExecPackage hdNotice = hdLst.get(i);
			saveNotice(hdNotice);
		}

		log.setAllIds(allIds.toString());
		log.setAllCount(allCount.toString());

		log.setEndDate(new Date());
		log.setLongEndDate(System.currentTimeMillis() + "");

		log.setCosts((Long.valueOf(log.getLongEndDate()) - Long.valueOf(log.getLongStartDate())) + "");

		log.setPk(DateUtil.getCurrentDateStr() + "_" + log.getTransType());

		logService.save(log);

	}

	private void saveNotice(HD_ExecPackage hd) {
		CZ_ExecPackage cz = DataConverter.convertOne(hd);
		czService.save(cz);
	}

	public void transferOne(String project_id) {
		Log log = new Log();
		log.setStartDate(new Date());
		log.setLongStartDate(System.currentTimeMillis() + "");
		List<HD_ExecPackage> hdNotices = hdService.findByProjectId(project_id);

		if (hdNotices == null) {
			throw new RuntimeException("根据项目ID查询不到对应执行通知书。");
		}

		czService.deleteByProjectPk(project_id);
		for (int i = 0; null != hdNotices && i < hdNotices.size(); i++) {
			saveNotice(hdNotices.get(i));
		}

		log.setAllIds(project_id + ",");
		log.setAllCount("1");
		log.setEndDate(new Date());
		log.setLongEndDate(System.currentTimeMillis() + "");

		log.setCosts((Long.valueOf(log.getLongEndDate()) - Long.valueOf(log.getLongStartDate())) + "");

		log.setPk(DateUtil.getCurrentDateStr());//40位主键

		logService.save(log);
	}

}
