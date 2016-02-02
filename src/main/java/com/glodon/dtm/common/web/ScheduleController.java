/**
 * Copyright By Grandsoft Company Limited.  
 * 2015年12月25日 下午5:33:51
 */
package com.glodon.dtm.common.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	@Qualifier("transferExecNotice")
	private ITransferService transExecNoticeService;

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
		transExecNoticeService.transferOne(pk);
	}

	//	@RequestMapping(value = "/runall", method = RequestMethod.GET)
	//	public void run() {
	//		tranService.transfer();
	//	}
	@RequestMapping(value = "/runall", method = RequestMethod.GET)
	public void runAll(HttpServletRequest req, HttpServletResponse res){
		System.out.println("==========================");
		transExecNoticeService.transfer();
		
		
		res.setContentType("text/plain");
		String callbackFunName = req.getParameter("callbackparam");
		try{
			res.getWriter().write(callbackFunName + "([{ name : \"同步完成，请稍后刷新查看。\"}])");
		} catch(IOException e){
			e.printStackTrace();
		}
	}

}
