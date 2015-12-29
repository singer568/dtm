package com.glodon.dtm.common.model;

public class Task implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6150450030078651624L;

	protected String taskPk;

	private String taskCode;

	private String taskName;

	private String taskGroup;

	/**
	 * 抓取类型
	 */
	private String taskType;

	/**
	 * 抓取频率
	 */
	private String taskCron;

	public static final String TASKPK = "taskPk";

	public static final String TASKCODE = "taskCode";

	public static final String TASKNAME = "taskName";

	public static final String TASKGROUP = "taskGroup";

	public static final String TASKTYPE = "taskType";

	public static final String TASKCRON = "taskCron";

	public String getTaskPk() {
		return taskPk;
	}

	public void setTaskPk(String taskPk) {
		this.taskPk = taskPk;
	}

	public String getTaskCode() {
		return taskCode;
	}

	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskGroup() {
		return taskGroup;
	}

	public void setTaskGroup(String taskGroup) {
		this.taskGroup = taskGroup;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getTaskCron() {
		return taskCron;
	}

	public void setTaskCron(String taskCron) {
		this.taskCron = taskCron;
	}

}
