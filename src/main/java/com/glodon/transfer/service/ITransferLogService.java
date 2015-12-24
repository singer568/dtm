/**
 * Copyright By Grandsoft Company Limited.  
 * 2015年12月23日 下午5:39:25
 */
package com.glodon.transfer.service;

import java.util.List;

import com.glodon.transfer.model.TransferLog;

public interface ITransferLogService {

	List<TransferLog> findAll();

	int save(TransferLog log);
}