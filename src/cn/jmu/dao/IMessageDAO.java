package cn.jmu.dao;

import java.util.List;

import cn.jmu.vo.Message;

public interface IMessageDAO {
	// ��ѯ�������Լ�¼
	public List<Message> findAll() throws Exception;

	// ����messageID��ѯ����ĳ�����Ե���ϸ��Ϣ
	public Message findById(int messageID) throws Exception;

	// ����һ���µ����Լ�¼
	public boolean doInsert(Message mes) throws Exception;
}
