/**
 * Copyright By Grandsoft Company Limited.  
 * 2015年12月23日 下午4:43:39
 */
package com.glodon.dtm.hd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.glodon.dtm.hd.model.CZ_ExecuteNotice;
import com.glodon.dtm.hd.model.HD_ExecuteNotice;
import com.glodon.dtm.hd.service.CZExecuteNoticeService;
import com.glodon.dtm.hd.service.DataConverter;
import com.glodon.dtm.hd.service.HDExecuteNoticeService;
import com.glodon.dtm.model.TransferLog;
import com.glodon.dtm.service.ITransferDataService;

@Component
public class TransferDataServiceImpl implements ITransferDataService {

	@Autowired
	private CZExecuteNoticeService czService;

	@Autowired
	private HDExecuteNoticeService hdService;

	public TransferLog transferData() {
		TransferLog log = new TransferLog();
		List<CZ_ExecuteNotice> czLst = czService.findCurrentDay();

		List<HD_ExecuteNotice> hdLst = DataConverter.convertDatas(czLst);

		for (int i = 0; null != hdLst && i < hdLst.size(); i++) {
			boolean isExist = hdService.isExists(hdLst.get(i).getXmid());
			if (!isExist) {
				hdService.save(hdLst.get(i));
			}
		}
		return log;
	}

}
