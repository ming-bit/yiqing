package com.hqyj.yiqing.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqyj.yiqing.dao.InfoDao;
import com.hqyj.yiqing.pojo.Info;

@Service        //��ʦ�����������Բ��������֣�
//spring��new����Ҳ��ʾ�����
public class InfoService {
	//�������Ӷ���
	@Autowired   //spring�������󣬲���Ҫ�Լ�new
	InfoDao dao;
	//����   ��ѯȷ������
	public int selectConfirmAllCount(){
		return dao.selectConfirmAllCount();
	}
	
	//�����������
	public List<HashMap<String,String>>  yiQingFenXi(){
		//��ȡȷ������
		int confirmCount = dao.selectConfirmAllCount();
		//��ȡ��������
		int curedCount = dao.selectCuredAllCount();
		//��ȡ��������
		int deadCount = dao.selectDeadAllCount();
		//����һ�����϶���
		List list = new ArrayList<HashMap<String,String>>();
		//����ȷ������
		HashMap<String,String> confirmMap = new HashMap<String,String>();
		confirmMap.put("name","����ȷ��");
		confirmMap.put("value", confirmCount+"");
		//��ӵ�������
		list.add(confirmMap);
		//������������
		HashMap curedMap = new HashMap<String,String>();
		curedMap.put("name","��������");
		curedMap.put("value", curedCount+"");
		list.add(curedMap);
		//������������
		HashMap deadMap = new HashMap<String,String>();
		deadMap.put("name","��������");
		deadMap.put("value", deadCount+"");
		list.add(deadMap);
		return list;
	}
	//�����û�ѡ���ʡ�ݲ�ѯ��ʡ������ȷ���������������
	public List<HashMap<String,String>> selectAllCountByPName(String name){
		//��ȡ����ʡ�ݲ�ѯ������,����ѯ�����ݴ������
		Info info = dao.selectAllCountByPName(name);
		//��������
		List list = new ArrayList<HashMap<String,String>>();
		//������ʡ��ȷ֤����
		HashMap confirmCount = new HashMap<String,String>();
		confirmCount.put("name", "����ȷ��");
		confirmCount.put("value", info.getConfirmCount()+"");
		list.add(confirmCount);
		//������ʡ����������
		HashMap curedCount = new HashMap<String,String>();
		curedCount.put("name", "��������");
		curedCount.put("value", info.getCuredCount()+"");
		list.add(curedCount);
		//������ʡ����������
		HashMap deadCount = new HashMap<String,String>();
		deadCount.put("name", "��������");
		deadCount.put("value", info.getDeadCount()+"");
		list.add(deadCount);
		return list;
	}
	//��ѯ34��ʡ����������
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
	//����ʡ�����Ʋ�ѯ��ʡ�����е�����������Ϣ
	public List<HashMap<String, String>> selectInfoByName(String name){
		List list = new ArrayList<HashMap<String,String>>();
		List<Info> listInfo = dao.selectInfoByName(name);
		for(Info i:listInfo){
			HashMap map = new HashMap<String,String>();
			map.put("name", i.getAreaName()+"��");
			map.put("value", i.getConfirmCount()+"");
			list.add(map);
		}
		return list;
	}
	//����34��ʡ�ݵĵ�������
	public List<String> loadCity(){
		List<String> list = new ArrayList<String>();
		List<Info> listInfo = dao.selectChinaInfo();
		//��������
		for(Info i:listInfo){
			list.add(i.getProvinceName());
		}
		return list;
	}
}