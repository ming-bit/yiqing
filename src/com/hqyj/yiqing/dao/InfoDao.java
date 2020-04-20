package com.hqyj.yiqing.dao;

import java.util.List;

import com.hqyj.yiqing.pojo.Info;

public interface InfoDao {
	
	//�в�
	//��ѯȷ������
	int selectConfirmAllCount();
	//��ѯ��������
	int selectCuredAllCount();
	//��ѯ��������
	int selectDeadAllCount();
	//�����û�ѡ���ʡ�ݲ�ѯ��ʡ������ȷ���������������
	Info selectAllCountByPName(String name);
	//��ѯ34��ʡ����������
	List<Info> selectChinaInfo();
	//����ʡ�����Ʋ�ѯ��ʡ�����е�����������Ϣ
	List<Info> selectInfoByName(String name);
}
