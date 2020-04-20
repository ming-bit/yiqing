package com.hqyj.yiqing.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqyj.yiqing.service.InfoService;

//����Ա�����Ʋ㶨����ࣩ
@Controller  //ע�⣨��⣺�൱�ڹ���Ա��װװ�������ֲ�ͬ��
//��spring��������
@RequestMapping("xiaoming")    //����⣺�൱�ڷ���Ա���֣�
//��tomcat����ʱ������������
public class InfoController {
	
	//����һ����ʦ����
	@Autowired
	InfoService service;
	
	//�˲ˡ���>ͳ���¹ڷ���ȷ������
	@RequestMapping("hongshaorou.do")
	@ResponseBody//�Ѳ˶˸��˿�
	public int selectConfirmAllCount(){
		
		return service.selectConfirmAllCount();
	}
	//�������
	@RequestMapping("yiqingfenxi.do")
	@ResponseBody
	public List<HashMap<String,String>> yiQingFenXi(){
		
		return service.yiQingFenXi();
	}
	//�����û�ѡ���ʡ�ݲ�ѯ��ʡ������ȷ���������������
	@RequestMapping("selectAllCountByPName.do")
	@ResponseBody
	public List<HashMap<String,String>> selectAllCountByPName(String name){
		System.out.println("name:"+name);
		return service.selectAllCountByPName(name);
	}
	//��ѯ34��ʡ����������
	@RequestMapping("selectChinaInfo.do")
	@ResponseBody
	public List<HashMap<String,String>> selectChinaInfo(){
		return service.selectChinaInfo();
	}
	
	//����ʡ�����Ʋ�ѯ��ʡ�����е�����������Ϣ
	@RequestMapping("selectInfoByName.do")
	@ResponseBody
	public List<HashMap<String,String>> selectInfoByName(String name){
		return service.selectInfoByName(name);
	}
	//����34��ʡ�ݵĵ�������
	@RequestMapping("loadCity.do")
	@ResponseBody
	public List<String> loadCity(){
		return service.loadCity();
	}
}



