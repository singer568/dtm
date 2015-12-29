package com.glodon.dtm.common.model;

public class TaskType implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6150450030078651624L;

	protected String id;

	private String code;

	private String name;

	/** 表、视图，webservice，文件(excel，txt等)  */
	private String fromType;

	private String fromService;

	/** 表或webservice */
	private String toType;

	private String toService;

	
	public String getId() {
		return id;
	}

	
	public void setId(String id) {
		this.id = id;
	}

	
	public String getCode() {
		return code;
	}

	
	public void setCode(String code) {
		this.code = code;
	}

	
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	
	public String getFromType() {
		return fromType;
	}

	
	public void setFromType(String fromType) {
		this.fromType = fromType;
	}

	
	public String getFromService() {
		return fromService;
	}

	
	public void setFromService(String fromService) {
		this.fromService = fromService;
	}

	
	public String getToType() {
		return toType;
	}

	
	public void setToType(String toType) {
		this.toType = toType;
	}

	
	public String getToService() {
		return toService;
	}

	
	public void setToService(String toService) {
		this.toService = toService;
	}

}
