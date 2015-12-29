/**
 * Copyright By Grandsoft Company Limited.  
 * 2015年12月23日 下午5:39:25
 */
package com.glodon.dtm.common.repository;

import java.util.List;

import com.glodon.dtm.common.model.Task;

public interface ITaskRepository {

	List<Task> findAll();

	
	int save(Task task);
	
	int update(Task task);

	Task queryByNameGroup(String name, String group);
	Task queryByPk(String pk);
}
