package cn.jmu.dao;

import java.util.List;

import cn.jmu.vo.Message;

public interface IMessageDAO {
	// 查询所有留言记录
	public List<Message> findAll() throws Exception;

	// 根据messageID查询具体某条留言的详细信息
	public Message findById(int messageID) throws Exception;

	// 增加一条新的留言记录
	public boolean doInsert(Message mes) throws Exception;
}
