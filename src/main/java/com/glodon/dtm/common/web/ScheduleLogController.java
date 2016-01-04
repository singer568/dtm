/**
 * Copyright By Grandsoft Company Limited.  
 * 2015年12月25日 下午5:34:03
 */
package com.glodon.dtm.common.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glodon.dtm.common.repository.ILogRepository;

@RestController
@RequestMapping("/logs")
public class ScheduleLogController {

	@Autowired
	private ILogRepository logRepository;
	
	
	
}
