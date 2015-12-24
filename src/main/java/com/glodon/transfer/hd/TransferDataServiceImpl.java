/**
 * Copyright By Grandsoft Company Limited.  
 * 2015年12月23日 下午4:43:39
 */
package com.glodon.transfer.hd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.glodon.transfer.hd.model.CZ_ExecuteNotice;
import com.glodon.transfer.hd.model.HD_ExecuteNotice;
import com.glodon.transfer.hd.service.CZExecuteNoticeService;
import com.glodon.transfer.hd.service.DataConverter;
import com.glodon.transfer.hd.service.HDExecuteNoticeService;
import com.glodon.transfer.model.TransferLog;
import com.glodon.transfer.service.ITransferDataService;

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
