package com.yuanwill.transaction;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.yuanwill.utils.JDBCUtilsConfig;

public class Demo1 {
	public static void main(String[] args) {
		Connection conn = JDBCUtilsConfig.getConnection();
		QueryRunner runner = new QueryRunner();
		String sql = "insert into student values (null, ?,?,?)";
		Object[] params = {"haha", "26", 185.5};
		try {
			// ¿ªÆôÊÂÎñ
			conn.setAutoCommit(false);
			int row = runner.update(conn, sql, params);
			if (params[0] == "haha") {
				conn.commit();
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
