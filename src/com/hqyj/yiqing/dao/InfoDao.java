package com.hqyj.yiqing.dao;

import java.util.List;

import com.hqyj.yiqing.pojo.Info;

public interface InfoDao {
	
	//切菜
	//查询确诊人数
	int selectConfirmAllCount();
	//查询治愈人数
	int selectCuredAllCount();
	//查询死亡人数
	int selectDeadAllCount();
	//根据用户选择的省份查询该省的现有确诊，治愈，死亡人数
	Info selectAllCountByPName(String name);
	//查询34个省的疫情数据
	List<Info> selectChinaInfo();
	//根据省份名称查询该省的所有地区的疫情信息
	List<Info> selectInfoByName(String name);
}
