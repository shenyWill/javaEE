package com.yuanwill.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class JDBCUtils {
	private static BasicDataSource datasource = new BasicDataSource();
	
	static{
		InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("database.properties");
		Properties pro = new Properties();
		try {
			pro.load(is);
			System.out.println(pro.getProperty("url"));
			datasource.setDriverClassName("com.mysql.jdbc.Driver");
			datasource.setUrl(pro.getProperty("url"));
			datasource.setUsername(pro.getProperty("username"));
			datasource.setPassword(pro.getProperty("password"));
			
			// 连接池其他配置
			datasource.setInitialSize(10); // 初始化连接数
			datasource.setMaxActive(8); // 最大连接数
			datasource.setMaxIdle(5);
			datasource.setMinIdle(1);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static DataSource getDataSource() {
		return datasource;
	}
}
