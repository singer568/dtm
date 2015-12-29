/**
 * Copyright By Grandsoft Company Limited.  
 * 2015年12月23日 下午5:39:25
 */
package com.glodon.dtm.common.repository;

import java.util.List;

import com.glodon.dtm.common.model.Log;

public interface ILogRepository {

	List<Log> findAll();

	int save(Log log);
}
