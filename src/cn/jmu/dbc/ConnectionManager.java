package cn.jmu.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {

	private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/test? characterEncoding=utf8 & useSSL=false & serverTimezone=UTC & rewriteBatchedStatements=true & allowPublicKeyRetrieval=true";
	private static final String DATABASE_USRE = "root";
	private static final String DATABASE_PASSWORD = "gyh123456";

	/** 返回连接 */
	public static Connection getConnection() {
		Connection dbConnection = null;
		try {
			Class.forName(DRIVER_CLASS);
			dbConnection = DriverManager.getConnection(DATABASE_URL, DATABASE_USRE, DATABASE_PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dbConnection;
	}

	/** 关闭连接 */
	public static void closeConnection(Connection dbConnection) {
		try {
			if (dbConnection != null && (!dbConnection.isClosed())) {
				dbConnection.close();
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}

	}

	/** 关闭结果集 */
	public static void closeResultSet(ResultSet res) {
		try {
			if (res != null) {
				res.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/** 关闭语句 */
	public static void closeStatement(PreparedStatement pStatement) {
		try {
			if (pStatement != null) {
				pStatement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeStatement(Statement statement) {
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
