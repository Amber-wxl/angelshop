package gzmtu.xt.dzsw.utils;
import java.sql.*;
public class JDBCUtil{
    public static final String url="jdbc:mysql://localhost:3306/angelshop?characterEncoding=utf-8&useSSL=false";
    public static final String user="root";
    public static final String password="123456";
    public static Connection getConnection(){       
        try{
	        return DriverManager.getConnection(url, user, password);
         }catch (SQLException e){	
            e.printStackTrace();
            return null; 
	    }
     }	
     public static void close(PreparedStatement pstmt,Connection conn){
         if(pstmt!=null){
              try{
                    pstmt.close();
              }catch(SQLException e){
				  e.printStackTrace();
			  }
          }
	     if(conn!=null){
              try{
                   conn.close();
              }catch(SQLException e){
                    e.printStackTrace();
			  }
         }
      }
      public static void close(ResultSet rs,PreparedStatement pstmt,Connection conn){
	     if(rs!=null){
                try{
                   rs.close();
                }catch(SQLException e){
					e.printStackTrace();
				}
          }
        close(pstmt,conn);
      }
}