package com.bdqn.fx.dao;

import java.sql.*;

public class BaseDao {

	private Connection conn;
	private PreparedStatement ppst;
	private ResultSet rs;

	//
	public Connection getConn() {
		try {
			//
			Class.forName("com.mysql.jdbc.Driver");
			//
			String url = "jdbc:mysql://localhost:3306/kgcnews";
			conn = DriverManager.getConnection(url, "root", "1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 澧炲垹鏀�update,insert,delete)
	public String executeUpdate(String sql, Object... objects) {
		try {
			// 鑾峰彇鏁版嵁搴撹繛鎺�
			ppst = getConn().prepareStatement(sql);
			// 缁欓�閰嶇璧嬪�
			for (int i = 0; i < objects.length; i++) {
				ppst.setObject(i + 1, objects[i]);
			}
			// 鎵цsql
			ppst.executeUpdate();
			return "ok";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close2();
		}
		return "error";
	}

	// 鏌ヨ
	public ResultSet executeQuery(String sql, Object... objects) {
		try {
			// 鑾峰彇鏁版嵁搴撹繛鎺�
			ppst = getConn().prepareStatement(sql);
			// 缁欓�閰嶇璧嬪�
			if (objects != null) {
				for (int i = 0; i < objects.length; i++) {
					ppst.setObject(i + 1, objects[i]);
				}
			}
			// 鎵цsql
			rs = ppst.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 鍏抽棴杩炴帴
	public void close1() {
		try {
			rs.close();
			ppst.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 鍏抽棴杩炴帴
	public void close2() {
		try {
			ppst.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
