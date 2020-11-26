package gzmtu.xt.dzsw.dao.impl;
import gzmtu.xt.dzsw.dao.ICustomerDao;
import gzmtu.xt.dzsw.entity.Customer;
import gzmtu.xt.dzsw.utils.Md5Util;
import gzmtu.xt.dzsw.utils.JDBCUtil;
import java.sql.*;
public class CustomerDaoImpl implements ICustomerDao{
  public boolean register(Customer customer){
      Connection conn=JDBCUtil.getConnection();
      PreparedStatement pstmt=null;          
      String sql="insert into customer values(?,?,?,?)" ;	
	  String md5Pwd=Md5Util.md5(customer.getPwd());
      boolean result=false;
      try{
        pstmt=conn.prepareStatement(sql); 
        pstmt.setString(1,customer.getAccount());
        pstmt.setString(2,md5Pwd);
        pstmt.setString(3,customer.getPhone()); 
        pstmt.setString(4,customer.getAddress());		
        if(pstmt.executeUpdate()==1){
			result=true;
	}             
      }catch(Exception e){
		  e.printStackTrace();
	  }finally{
		  JDBCUtil.close(pstmt,conn);
	  }
      return result;
   } 
   public boolean login(String account,String pwd){
      Connection conn=JDBCUtil.getConnection();
      PreparedStatement pstmt=null;  
	  ResultSet rs=null;
      String sql="select * from customer where account=? and pwd=?";      
      boolean result=false;
	  try{
        pstmt=conn.prepareStatement(sql);
        pwd=Md5Util.md5(pwd); 
        pstmt.setString(1,account); 
        pstmt.setString(2,pwd);
        rs=pstmt.executeQuery();
        if(rs.next()){		
		   result=true;
        }
	  }catch(Exception e){
		  e.printStackTrace();
	  }finally{
		  JDBCUtil.close(rs,pstmt,conn);
	  }
      return result;
  }
}
