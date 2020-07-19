package cn.jmu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.jmu.dao.IRevertDAO;
import cn.jmu.dbc.ConnectionManager;
import cn.jmu.vo.Revert;

public class RevertDAOImpl implements IRevertDAO {

	// 根据messageId查询某条留言的所有回复
	public List<Revert> findById(int messageId) throws Exception {
		List<Revert> all = new ArrayList<Revert>();
		Revert rev = null;
		String sql = "select * from revert where messageID = ?";
		Connection con = null;
		PreparedStatement pStatement = null;
		ResultSet rs = null;
		try {
			con = ConnectionManager.getConnection();
			pStatement = con.prepareStatement(sql);
			pStatement.setInt(1, messageId);
			rs = pStatement.executeQuery();
			while (rs.next()) {
				rev = new Revert();
				rev.setRevertID(rs.getInt(1));
				rev.setMessageID(rs.getInt(2));
				rev.setContent(rs.getString(3));
				rev.setWriter(rs.getString(4));
				rev.setWriteDate(rs.getString(5));
				all.add(rev);
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

	// 根据messageID增加某条留言的回复
	public boolean doInsert(Revert rev) throws Exception {
		boolean flag = false;
		String sql = "insert into revert(messageID, content, writer, writeDate) values (?,?,?,?)";
		String sql_count = "update message set count = count + 1 where messageID = ?";
		Connection con = null;
		PreparedStatement pStatement = null;
		PreparedStatement pStatement2 = null;
		try {
			con = ConnectionManager.getConnection();
			pStatement = con.prepareStatement(sql);
			pStatement.setInt(1, rev.getMessageID());
			pStatement.setString(2, rev.getContent());
			pStatement.setString(3, rev.getWriter());
			pStatement.setString(4, rev.getWriteDate());
			if (pStatement.executeUpdate() > 0) {
				pStatement2 = con.prepareStatement(sql_count);
				pStatement2.setInt(1, rev.getMessageID());
				pStatement2.executeUpdate();
				flag = true;
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectionManager.closeStatement(pStatement);
			ConnectionManager.closeConnection(con);
		}
		return flag;
	}
}
