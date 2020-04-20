package com.hqyj.yiqing.pojo;

//info表的定义类
public class Info {
	//对应表的code列
	private int code;
	//对应表的time列
	private String time;
	//对应表的provinceName
	private String provinceName;
	//对应表的areaName
	private String areaName;
	//对应表的confirmCount
	private int confirmCount;
	//对应表的curedCount
	private int curedCount;
	//对应表的deadCount
	private int deadCount;
	//对应表的locationId
	private String locationId;
	
	public int getCode(){
		return code;
	}
	public void setCode(int code){
		this.code = code;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public int getConfirmCount() {
		return confirmCount;
	}
	public void setConfirmCount(int confirmCount) {
		this.confirmCount = confirmCount;
	}
	public int getCuredCount() {
		return curedCount;
	}
	public void setCuredCount(int curedCount) {
		this.curedCount = curedCount;
	}
	public int getDeadCount() {
		return deadCount;
	}
	public void setDeadCount(int deadCount) {
		this.deadCount = deadCount;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	

}
