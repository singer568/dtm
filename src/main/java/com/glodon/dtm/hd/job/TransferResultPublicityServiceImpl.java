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
import com.glodon.dtm.hd.model.CZ_ResultPublicity;
import com.glodon.dtm.hd.model.HD_ResultPublicity;
import com.glodon.dtm.hd.service.CZResultPublicityService;
import com.glodon.dtm.hd.service.DataConverter;
import com.glodon.dtm.hd.service.HDResultPublicityService;

@Service("transferResultPublicity")
public class TransferResultPublicityServiceImpl implements ITransferService {

	@Autowired
	private CZResultPublicityService czService;

	@Autowired
	private HDResultPublicityService hdService;

	@Autowired
	private ILogRepository logService;

	@Autowired
	private ExtraScheduleConfig hdConfig;

	public void transfer() {
		Log log = new Log();
		log.setStartDate(new Date());
		log.setLongStartDate(System.currentTimeMillis() + "");
		log.setTransType("PUBLICITY");

		StringBuffer allIds = new StringBuffer();

		Integer allCount = new Integer(0);

		List<HD_ResultPublicity> hdLst = hdService.findDatePair(hdConfig.getStartDate(hdConfig.getPublicityStartDate()),
				hdConfig.getEndDate(hdConfig.getPublicityEndDate()));
		if (hdLst != null && hdLst.size() > 0) {
			allCount = hdLst.size();
		}

		for (int i = 0; null != hdLst && i < hdLst.size(); i++) {
			HD_ResultPublicity hdNotice = hdLst.get(i);
			saveNotice(hdNotice);
		}

		log.setAllIds(allIds.toString());
		log.setAllCount(allCount.toString());

		log.setEndDate(new Date());
		log.setLongEndDate(System.currentTimeMillis() + "");

		log.setCosts((Long.valueOf(log.getLongEndDate()) - Long.valueOf(log.getLongStartDate())) + "");

		log.setPk(DateUtil.getCurrentDateStr());

		logService.save(log);

	}

	private void saveNotice(HD_ResultPublicity hd) {
		boolean isExist = czService.isExists(hd.getBbid());
		if (isExist) {
			return;
		}
		CZ_ResultPublicity cz = DataConverter.convertOne(hd);
		czService.save(cz);
	}

	public void transferOne(String bbid) {
		Log log = new Log();
		log.setStartDate(new Date());
		log.setLongStartDate(System.currentTimeMillis() + "");
		HD_ResultPublicity czNotice = hdService.findOne(bbid);

		if (czNotice == null) {
			throw new RuntimeException("根据项目ID查询不到对应中标公告。");
		}

		saveNotice(czNotice);

		log.setAllIds(czNotice.getBbid() + ",");
		log.setAllCount("1");
		log.setEndDate(new Date());
		log.setLongEndDate(System.currentTimeMillis() + "");

		log.setCosts((Long.valueOf(log.getLongEndDate()) - Long.valueOf(log.getLongStartDate())) + "");

		log.setPk(DateUtil.getCurrentDateStr());//40位主键

		logService.save(log);
	}

}
