package cn.com.agree.jdbcUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.agree.jdbc.RowMap;

public class JdbcUtil {
	public static Connection getConnection(){
		Connection connection=null;
		//������
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//2�������ӣ�������˿ںţ��û������룩
			connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "123456");
		}
		 catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return connection;
	
	}

	public static void close(Connection connection){
		try {
			if(connection!=null){
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int executeUpdate(String sql,Object... params){
		int result=0;
		Connection connection=getConnection();
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement(sql);
			if(params!=null){
				for(int i=0;i<params.length;i++){
					pstmt.setObject(i+1, params[i]);
				}
			result=pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catc h block
			e.printStackTrace();
		}finally {
			close(connection);
		}
		return result;
	}	
	
	
	public static <T>List<T> executeSelect(String sql,RowMap<T> rowMap,Object...params){
		List<T> result=new ArrayList<>();
		Connection connection=getConnection();
		try {
			PreparedStatement pstmt=connection.prepareStatement(sql);
			if(params!=null){
				for(int i=0;i<params.length;i++){
					pstmt.setObject(i+1, params[i]);
				}
			}
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				//������� ӳ�䵽������
				T t=rowMap.rowMapping(rs);
				result.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(connection);
		}
		return result;
	}
}
