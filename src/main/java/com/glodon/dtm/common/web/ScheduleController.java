/**
 * Copyright By Grandsoft Company Limited.  
 * 2015年12月25日 下午5:33:51
 */
package com.glodon.dtm.common.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.glodon.dtm.common.model.Task;
import com.glodon.dtm.common.plugin.ITransferService;
import com.glodon.dtm.common.service.IScheduleService;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

	@Autowired
	private IScheduleService scheduleService;

	@Autowired
	private ITransferService tranService;

	@RequestMapping(value = "/{pk}", method = RequestMethod.GET)
	public void delete(@PathVariable String pk) {
		scheduleService.delete(pk);
	}

	@RequestMapping(value = "/running", method = RequestMethod.GET)
	public List<Task> getAll() {
		List<Task> result = scheduleService.queryRunnningJobs();
		return result;
	}

	@RequestMapping(value = "/runone/{pk}", method = RequestMethod.GET)
	public void runOne(@PathVariable String pk) {
		tranService.transferOne(pk);
	}

	@RequestMapping(value = "/runall", method = RequestMethod.GET)
	public void run() {
		tranService.transfer();
	}

}
