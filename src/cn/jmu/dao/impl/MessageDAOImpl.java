package cn.jmu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.jmu.dao.IMessageDAO;
import cn.jmu.dbc.ConnectionManager;
import cn.jmu.vo.Message;

public class MessageDAOImpl implements IMessageDAO {

	// 查询所有留言记录
	public List<Message> findAll() throws Exception {
		List<Message> all = new ArrayList<Message>();
		Message mes = null;
		String sql = "select * from message";
		Connection con = null;
		PreparedStatement pStatement = null;
		ResultSet rs = null;
		try {
			con = ConnectionManager.getConnection();
			pStatement = con.prepareStatement(sql);
			rs = pStatement.executeQuery();
			while (rs.next()) {
				mes = new Message();
				mes.setMessageID(rs.getInt(1));
				mes.setTitle(rs.getString(2));
				mes.setContent(rs.getString(3));
				mes.setWriter(rs.getString(4));
				mes.setWriteDate(rs.getString(5));
				mes.setCount(rs.getInt(6));
				all.add(mes);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectionManager.closeResultSet(rs);
			ConnectionManager.closeStatement(pStatement);
			ConnectionManager.closeConnection(con);
		}

		return all;
	}

	// 根据messageID查询具体某条留言的详细信息
	public Message findById(int messageID) throws Exception {
		Message mes = null;
		String sql = "select * from message where messageID = ?";
		Connection con = null;
		PreparedStatement pStatement = null;
		ResultSet rs = null;
		try {
			con = ConnectionManager.getConnection();
			pStatement = con.prepareStatement(sql);
			pStatement.setInt(1, messageID);
			rs = pStatement.executeQuery();
			if (rs.next()) {
				mes = new Message();
				mes.setMessageID(rs.getInt(1));
				mes.setTitle(rs.getString(2));
				mes.setContent(rs.getString(3));
				mes.setWriter(rs.getString(4));
				mes.setWriteDate(rs.getString(5));
				mes.setCount(rs.getInt(6));
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectionManager.closeResultSet(rs);
			ConnectionManager.closeStatement(pStatement);
			ConnectionManager.closeConnection(con);
		}
		return mes;
	}

	// 增加一条新的留言记录
	public boolean doInsert(Message mes) throws Exception {
		boolean flag = false;
		String sql = "insert into message(title, content, writer, writeDate, count) values (?,?,?,?,?)";
		Connection con = null;
		PreparedStatement pStatement = null;
		try {
			con = ConnectionManager.getConnection();
			pStatement = con.prepareStatement(sql);
			pStatement.setString(1, mes.getTitle());
			pStatement.setString(2, mes.getContent());
			pStatement.setString(3, mes.getWriter());
			pStatement.setString(4, mes.getWriteDate());
			pStatement.setInt(5, mes.getCount());
			if (pStatement.executeUpdate() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectionManager.closeStatement(pStatement);// 4.关闭语句总管、连接
			ConnectionManager.closeConnection(con);
		}
		return flag;
	}
}
