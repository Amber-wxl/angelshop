package gzmtu.xt.dzsw.dao.impl;
import gzmtu.xt.dzsw.dao.ICustomerDao;
import gzmtu.xt.dzsw.entity.Customer;
import gzmtu.xt.dzsw.utils.Md5Util;
import gzmtu.xt.dzsw.utils.JDBCUtil;
import java.util.*;
import java.sql.*;
public class CustomerDaoImpl implements ICustomerDao{
    public boolean register(Customer customer){//注册用户
        Connection conn=JDBCUtil.getConnection();//创建数据库连接对象
        PreparedStatement pstmt=null;          
        String sql="insert into customer values(?,?,?,?)" ;	
	    String md5Pwd=Md5Util.md5(customer.getPwd());//使用md5对密码进行加密
        boolean result=false;
        try{
            pstmt=conn.prepareStatement(sql); 
            pstmt.setString(1,customer.getAccount());
            pstmt.setString(2,md5Pwd);
            pstmt.setString(3,customer.getPhone()); 
            pstmt.setString(4,customer.getAddress());	
            if(pstmt.executeUpdate()==1){//SQL语句执行结果影响了一行则插入记录成功
                result=true;
	        }             
        }catch(Exception e){ e.printStackTrace(); }
        finally{ JDBCUtil.close(pstmt,conn); }
        System.out.println(result);
      return result;
    } 
    public boolean login(String account,String pwd){//登录
        Connection conn=JDBCUtil.getConnection();//创建数据库连接对象
        PreparedStatement pstmt=null;  
	    ResultSet rs=null;
        String sql="select * from customer where account=? and pwd=?";
        boolean result=false;
	        try{
                pstmt=conn.prepareStatement(sql);
                pwd=Md5Util.md5(pwd); //使用md5函数对密码进行加密
                pstmt.setString(1,account); 
                pstmt.setString(2,pwd);
                rs=pstmt.executeQuery();
                if(rs.next()){ result=true; }//判断结果是否为空，不为空则登录成功
            }catch(Exception e){ e.printStackTrace(); }
            finally{ JDBCUtil.close(rs,pstmt,conn); } 
        return result;//返回result结果
    }
    public List<Customer> getCustomer(){// 管理员查询用户
        Connection conn=JDBCUtil.getConnection();//创建数据库连接对象
        PreparedStatement pstmt=null;
        String sql="select * from customer";
        List<Customer> customerlist=new ArrayList<Customer>(); ;
        ResultSet rs=null;
        try{
            pstmt=conn.prepareStatement(sql);
            System.out.println(pstmt);
            rs=pstmt.executeQuery();
            while(rs.next()){//遍历SQL语句执行的结果集
                Customer customer=new Customer();
                customer.setAccount(rs.getString("account"));
                customer.setPhone(rs.getString("phone"));
                customer.setAddress(rs.getString("address"));
                customerlist.add(customer);
            }
        }catch(SQLException e){ e.printStackTrace(); }
        finally{ JDBCUtil.close(rs,pstmt,conn); }
        return customerlist;
    }
    public boolean deleteCustomer(String account){// 管理员注销用户
        Connection conn=JDBCUtil.getConnection();//创建数据库连接对象
        PreparedStatement pstmt=null;     
        boolean result=false;
        String sql="delete from customer where account=?"; 	  
        try{
            pstmt=conn.prepareStatement(sql);		 
            pstmt.setString(1,account);  
            if(pstmt.executeUpdate()==1){ result=true;  }//影响行数为 1
        }catch(Exception e){ e.printStackTrace(); }
        finally{ JDBCUtil.close(pstmt,conn); }
        return result;
    }
}
