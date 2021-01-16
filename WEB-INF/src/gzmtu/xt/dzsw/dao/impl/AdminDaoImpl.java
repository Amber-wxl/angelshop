package gzmtu.xt.dzsw.dao.impl;
import gzmtu.xt.dzsw.dao.IAdminDao;
import gzmtu.xt.dzsw.entity.Admin;
import gzmtu.xt.dzsw.utils.Md5Util;
import gzmtu.xt.dzsw.utils.JDBCUtil;
import java.util.*;
import java.sql.*;
public class AdminDaoImpl implements IAdminDao{
    public boolean register(Admin admin){// 实现注册功能
        Connection conn=JDBCUtil.getConnection();//获取数据库连接
        PreparedStatement pstmt=null;          
        String sql="insert into admin values(?,?)" ;	
	    String md5Pwd=Md5Util.md5(admin.getPwd());//密码加密
        boolean result=false;
        try{
            pstmt=conn.prepareStatement(sql); 
            pstmt.setString(1,admin.getAdminID());
            pstmt.setString(2,md5Pwd);	
            if(pstmt.executeUpdate()==1){//影响行数等于 1
                result=true;
	        }             
        }catch(Exception e){ e.printStackTrace();}
        finally{ JDBCUtil.close(pstmt,conn); }
        return result;
    } 

    public boolean login(String adminID,String pwd){//实现登录功能
        Connection conn=JDBCUtil.getConnection();//获取数据库连接
        PreparedStatement pstmt=null;  
	    ResultSet rs=null;
        String sql="select * from admin where adminID=? and pwd=?";      
        boolean result=false;
	    try{
            pstmt=conn.prepareStatement(sql);
            pwd=Md5Util.md5(pwd); //密码加密
            pstmt.setString(1,adminID); 
            pstmt.setString(2,pwd);
            rs=pstmt.executeQuery();
            if(rs.next()){ result=true; }//查询结果不为空
        }catch(Exception e){  e.printStackTrace(); }
        finally{ JDBCUtil.close(rs,pstmt,conn); } 
        return result;
    }

    public List<Admin> getAdmin(){// 查询管理员
        Connection conn=JDBCUtil.getConnection();//获取数据库连接
        PreparedStatement pstmt=null;
        String sql="select * from admin";
        List<Admin> adminlist=new ArrayList<Admin>(); ;
        ResultSet rs=null;
        try{
            pstmt=conn.prepareStatement(sql);
            System.out.println(pstmt);
            rs=pstmt.executeQuery();
            while(rs.next()){//遍历sql语句执行的结果集
                Admin admin=new Admin();
                admin.setAdminID(rs.getString("adminID"));
                adminlist.add(admin);
            }
        }catch(SQLException e){ e.printStackTrace(); }
        finally{ JDBCUtil.close(rs,pstmt,conn); }
        return adminlist;
    }

    public boolean deleteAdmin(String adminID){//注销管理员账号
        Connection conn=JDBCUtil.getConnection();//获取数据库连接
        PreparedStatement pstmt=null;     
        boolean result=false;
        String sql="delete from admin where adminID=?"; 	  
        try{
            pstmt=conn.prepareStatement(sql);		 
            pstmt.setString(1,adminID);  
            if(pstmt.executeUpdate()==1){ result=true; }//影响行数 1
        }catch(Exception e){ e.printStackTrace();  }
        finally{ JDBCUtil.close(pstmt,conn); }
        return result;
    }
}
