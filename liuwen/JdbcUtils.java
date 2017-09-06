package com.pang.manager.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {
	//连接数据库参数
	private static String url = null;
	private static String user = null;
	private static String password = null;
	private static String driver = null;
	
	//配置文件
	private static Properties prop = new Properties();
	
	private JdbcUtils(){
		
	}
	
	private static JdbcUtils instance = null;

	public static JdbcUtils getInstance() {
		if(instance == null){
			synchronized (JdbcUtils.class) {
				if(instance == null){
					instance = new JdbcUtils();
				}
			}
		}
		return instance;
	}
	
	//注册驱动
	static{
		// 利用类加载器读取配置文件
		try{
			InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("config.properties");
			prop.load(is);
			url = prop.getProperty("jdbc_url");
			user = prop.getProperty("jdbc_user");
			password = prop.getProperty("jdbc_password");
			driver = prop.getProperty("driver");
			
			Class.forName(driver);
			
		}catch (ClassNotFoundException e) {
			e.getStackTrace();
		}catch (IOException e) {
			e.getStackTrace();
		}
	}
	
	//该方法获得连接
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,user,password);
	}
	
	//释放资源
	public void free(Connection conn,Statement st,ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				if(st != null){
					try {
						st.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}finally{
						if(conn != null){
							try {
								conn.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}

}
