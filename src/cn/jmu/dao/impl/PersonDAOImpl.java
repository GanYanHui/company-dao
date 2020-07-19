package cn.jmu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.jmu.dao.IPersonDAO;
import cn.jmu.dbc.ConnectionManager;
import cn.jmu.vo.Person;

public class PersonDAOImpl implements IPersonDAO {

	@Override
	public boolean doInsert(Person per) throws Exception {
		boolean flag = false;
		String sql = "insert into person(id, name, password) values (?,?,?)";
		Connection con = null;
		PreparedStatement pStatement = null;
		try {
			con = ConnectionManager.getConnection();
			pStatement = con.prepareStatement(sql);
			pStatement.setString(1, per.getId());
			pStatement.setString(2, per.getName());
			pStatement.setString(3, per.getPassword());
			if (pStatement.executeUpdate() > 0) {
				flag = true;
			}
		} catch (SQLException sqlE) {
			sqlE.printStackTrace();
		} finally {
			ConnectionManager.closeStatement(pStatement);// 4.关闭语句总管、连接
			ConnectionManager.closeConnection(con);
		}
		return flag;
	}

	@Override
	public boolean doDelete(String id) throws Exception {
		boolean flag = false;
		String sql = "delete from person where id = ?";
		Connection con = null;
		PreparedStatement pStatement = null;
		try {
			con = ConnectionManager.getConnection();
			pStatement = con.prepareStatement(sql);
			pStatement.setString(1, id);
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

	@Override
	public boolean doUpdate(Person per) throws Exception {
		boolean flag = false;
		String sql = "update person set name = ?, password = ? where id = ?";
		Connection con = null;
		PreparedStatement pStatement = null;
		try {
			con = ConnectionManager.getConnection();
			pStatement = con.prepareStatement(sql);
			pStatement.setString(1, per.getName());
			pStatement.setString(2, per.getPassword());
			pStatement.setString(3, per.getId());
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

	@Override
	public Person findById(String id) throws Exception {
		Person per = null;
		String sql = "select * from person where id = ?";
		Connection con = null;
		PreparedStatement pStatement = null;
		ResultSet rs = null;
		try {
			con = ConnectionManager.getConnection();
			pStatement = con.prepareStatement(sql);
			pStatement.setString(1, id);
			rs = pStatement.executeQuery();
			if (rs.next()) {
				per = new Person();
				per.setId(rs.getString(1));
				per.setName(rs.getString(2));
				per.setPassword(rs.getString(3));
			}
		} catch (SQLException sqlE) {
			sqlE.printStackTrace();
		} finally {
			ConnectionManager.closeResultSet(rs);
			ConnectionManager.closeStatement(pStatement);// 4.关闭语句总管、连接
			ConnectionManager.closeConnection(con);
		}
		return per;
	}

	@Override
	public List<Person> findAll() throws Exception {
		List<Person> all = new ArrayList<Person>();
		Person per = null;
		String sql = "select * from person";
		Connection con = null;
		PreparedStatement pStatement = null;
		ResultSet rs = null;
		try {
			con = ConnectionManager.getConnection();
			pStatement = con.prepareStatement(sql);
			rs = pStatement.executeQuery();
			while (rs.next()) {
				per = new Person();
				per.setId(rs.getString(1));
				per.setName(rs.getString(2));
				per.setPassword(rs.getString(3));
				all.add(per);
			}
		} catch (SQLException sqlE) {
			sqlE.printStackTrace();
		} finally {
			ConnectionManager.closeResultSet(rs);// 关闭结果集对象
			ConnectionManager.closeStatement(pStatement);// 关闭语句总管
			ConnectionManager.closeConnection(con);// 关闭连接
		}
		return all;
	}

	@Override
	public List<Person> findByLike(String cond) throws Exception {
		List<Person> all = new ArrayList<Person>();
		Person per = null;
		String sql = "select * from person where name like ?";
		Connection con = null;
		PreparedStatement pStatement = null;
		ResultSet rs = null;
		try {
			con = ConnectionManager.getConnection();
			pStatement = con.prepareStatement(sql);
			pStatement.setString(1, "%" + cond + "%");
			rs = pStatement.executeQuery();
			while (rs.next()) {
				per = new Person();
				per.setId(rs.getString("id"));
				per.setName(rs.getString(2));
				per.setPassword(rs.getString(3));
				all.add(per);
			}
		} catch (SQLException sqlE) {
			sqlE.printStackTrace();
		} finally {
			ConnectionManager.closeResultSet(rs);
			ConnectionManager.closeStatement(pStatement);// 4.关闭语句总管、连接
			ConnectionManager.closeConnection(con);
		}
		return all;
	}

}
