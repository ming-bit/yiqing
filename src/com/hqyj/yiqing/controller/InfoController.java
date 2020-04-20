package com.hqyj.yiqing.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqyj.yiqing.service.InfoService;

//服务员（控制层定义的类）
@Controller  //注解（理解：相当于工作员服装装，来区分不同）
//由spring创建对象
@RequestMapping("xiaoming")    //（理解：相当于服务员名字）
//在tomcat上跑时服务器的名字
public class InfoController {
	
	//创建一个厨师对象
	@Autowired
	InfoService service;
	
	//端菜——>统计新冠肺炎确诊人数
	@RequestMapping("hongshaorou.do")
	@ResponseBody//把菜端给顾客
	public int selectConfirmAllCount(){
		
		return service.selectConfirmAllCount();
	}
	//疫情分析
	@RequestMapping("yiqingfenxi.do")
	@ResponseBody
	public List<HashMap<String,String>> yiQingFenXi(){
		
		return service.yiQingFenXi();
	}
	//根据用户选择的省份查询该省的现有确诊，治愈，死亡人数
	@RequestMapping("selectAllCountByPName.do")
	@ResponseBody
	public List<HashMap<String,String>> selectAllCountByPName(String name){
		System.out.println("name:"+name);
		return service.selectAllCountByPName(name);
	}
	//查询34个省的疫情数据
	@RequestMapping("selectChinaInfo.do")
	@ResponseBody
	public List<HashMap<String,String>> selectChinaInfo(){
		return service.selectChinaInfo();
	}
	
	//根据省份名称查询该省的所有地区的疫情信息
	@RequestMapping("selectInfoByName.do")
	@ResponseBody
	public List<HashMap<String,String>> selectInfoByName(String name){
		return service.selectInfoByName(name);
	}
	//加载34个省份的地区名称
	@RequestMapping("loadCity.do")
	@ResponseBody
	public List<String> loadCity(){
		return service.loadCity();
	}
}



