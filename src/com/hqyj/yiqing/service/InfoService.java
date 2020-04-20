package com.hqyj.yiqing.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqyj.yiqing.dao.InfoDao;
import com.hqyj.yiqing.pojo.Info;

@Service        //厨师工作服（可以不配置名字）
//spring来new对象，也表示服务层
public class InfoService {
	//创建墩子对象
	@Autowired   //spring创建对象，不需要自己new
	InfoDao dao;
	//炒菜   查询确诊人数
	public int selectConfirmAllCount(){
		return dao.selectConfirmAllCount();
	}
	
	//今日疫情分析
	public List<HashMap<String,String>>  yiQingFenXi(){
		//获取确诊人数
		int confirmCount = dao.selectConfirmAllCount();
		//获取治愈人数
		int curedCount = dao.selectCuredAllCount();
		//获取死亡人数
		int deadCount = dao.selectDeadAllCount();
		//创建一个集合对象
		List list = new ArrayList<HashMap<String,String>>();
		//构建确诊人数
		HashMap<String,String> confirmMap = new HashMap<String,String>();
		confirmMap.put("name","现有确诊");
		confirmMap.put("value", confirmCount+"");
		//添加到集合中
		list.add(confirmMap);
		//构建治愈人数
		HashMap curedMap = new HashMap<String,String>();
		curedMap.put("name","现有治愈");
		curedMap.put("value", curedCount+"");
		list.add(curedMap);
		//构建死亡人数
		HashMap deadMap = new HashMap<String,String>();
		deadMap.put("name","现有死亡");
		deadMap.put("value", deadCount+"");
		list.add(deadMap);
		return list;
	}
	//根据用户选择的省份查询该省的现有确诊，治愈，死亡人数
	public List<HashMap<String,String>> selectAllCountByPName(String name){
		//获取根据省份查询的数据,将查询的数据存入对象
		Info info = dao.selectAllCountByPName(name);
		//创建集合
		List list = new ArrayList<HashMap<String,String>>();
		//构建各省的确证人数
		HashMap confirmCount = new HashMap<String,String>();
		confirmCount.put("name", "现有确诊");
		confirmCount.put("value", info.getConfirmCount()+"");
		list.add(confirmCount);
		//构建各省的治愈人数
		HashMap curedCount = new HashMap<String,String>();
		curedCount.put("name", "现有治愈");
		curedCount.put("value", info.getCuredCount()+"");
		list.add(curedCount);
		//构建各省的死亡人数
		HashMap deadCount = new HashMap<String,String>();
		deadCount.put("name", "现有死亡");
		deadCount.put("value", info.getDeadCount()+"");
		list.add(deadCount);
		return list;
	}
	//查询34个省的疫情数据
	public List<HashMap<String, String>> selectChinaInfo(){
		List list = new ArrayList<HashMap<String,String>>();
		List<Info> listInfo = dao.selectChinaInfo();
		for(Info i:listInfo){
			HashMap map = new HashMap<String,String>();
			map.put("name",i.getProvinceName());
			map.put("value", i.getConfirmCount()+"");
			list.add(map);
		}
		return list;
	}
	//根据省份名称查询该省的所有地区的疫情信息
	public List<HashMap<String, String>> selectInfoByName(String name){
		List list = new ArrayList<HashMap<String,String>>();
		List<Info> listInfo = dao.selectInfoByName(name);
		for(Info i:listInfo){
			HashMap map = new HashMap<String,String>();
			map.put("name", i.getAreaName()+"市");
			map.put("value", i.getConfirmCount()+"");
			list.add(map);
		}
		return list;
	}
	//加载34个省份的地区名称
	public List<String> loadCity(){
		List<String> list = new ArrayList<String>();
		List<Info> listInfo = dao.selectChinaInfo();
		//遍历集合
		for(Info i:listInfo){
			list.add(i.getProvinceName());
		}
		return list;
	}
}