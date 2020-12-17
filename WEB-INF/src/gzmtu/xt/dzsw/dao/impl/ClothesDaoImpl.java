package gzmtu.xt.dzsw.dao.impl;
import gzmtu.xt.dzsw.dao.IClothesDao;
import gzmtu.xt.dzsw.utils.JDBCUtil;
import gzmtu.xt.dzsw.entity.Clothes;
import java.sql.*;
import java.util.*;
import java.time.LocalDate;
public class ClothesDaoImpl implements IClothesDao{
	public int getRowsByType(String type){
      Connection conn=JDBCUtil.getConnection();//创建数据库连接对象
      PreparedStatement pstmt=null;//声明类型为PreparedStatement的对象pstmt
      ResultSet rs=null;	//声明类型为ResultSet的对象rs
	    String sql="select count(*) from clothes where type=?";  //将sql语句作为字符串保存在sql变量中
	    int rows=0;
	    try{
        pstmt=conn.prepareStatement(sql);
		    pstmt.setString(1,type);
        rs=pstmt.executeQuery();
        if(rs.next()){//如果sql语句执行结果不为空，则将执行结果返回给rows变量，即查询到的该类型商品的数量
          rows=rs.getInt(1);
        }
      }catch(Exception e){ 
        e.printStackTrace(); //捕获异常但不处理
      }finally{ 
        JDBCUtil.close(rs,pstmt,conn); //关闭数据库连接对象
      }
      return rows;
  }
  public int getRowsAll(){
    Connection conn=JDBCUtil.getConnection();
    PreparedStatement pstmt=null;
    ResultSet rs=null;	
    String sql="select count(*) from clothes";  
    int rows=0;
    try{
      pstmt=conn.prepareStatement(sql);
      rs=pstmt.executeQuery();
      if(rs.next()){
        rows=rs.getInt(1);
      }
    }catch(Exception e){ e.printStackTrace(); }
    finally{ JDBCUtil.close(rs,pstmt,conn); }
    return rows;
}

  public List<Clothes> getClothesByType(String type,int pageSize,int page){      
	    Connection conn=JDBCUtil.getConnection();
      PreparedStatement pstmt=null;
      ResultSet rs=null;	  
      String sql="select * from clothes where type=? limit ?,?";
	    int index;
	    Clothes clothes;
	    List<Clothes> clothesList=new ArrayList<Clothes>();   //创建一个以Clothes对象为元素的数组  
	    try{		
		    index=(page-1)*pageSize;//计算出当前页之前有多少商品
        pstmt=conn.prepareStatement(sql);
		    pstmt.setString(1,type);
        pstmt.setInt(2,index);
        pstmt.setInt(3,pageSize);
        rs=pstmt.executeQuery();        
        while(rs.next()){//遍历sql语句执行的结果
          clothes=createClothesByRs(rs);           
          clothesList.add(clothes);
        }
      }catch(Exception e){ 
        e.printStackTrace(); 
      }finally{ 
        JDBCUtil.close(rs,pstmt,conn); 
      }
      return clothesList;
   } 

   public List<Clothes> getClothesAll(int pageSize,int page){
    Connection conn=JDBCUtil.getConnection();
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    String sql="select * from clothes limit ?,?";
    int index;
    Clothes clothes=null;
    List<Clothes> clothesList=new ArrayList<Clothes>();
    try{
      index=(page-1)*pageSize;
      pstmt=conn.prepareStatement(sql);
      pstmt.setInt(1,index);
      pstmt.setInt(2,pageSize);
      rs=pstmt.executeQuery();
      while(rs.next()){
        clothes=createClothesByRs(rs);
        clothesList.add(clothes);
      }
    }catch(Exception e){ 
      e.printStackTrace();
    }finally{ 
      JDBCUtil.close(rs,pstmt,conn);
    }
    return clothesList;
   }
      
    public Clothes getClothesByID(int clotheID){
      Connection conn=JDBCUtil.getConnection();
      PreparedStatement pstmt=null;
      ResultSet rs=null;
      String sql="select * from clothes where ClotheID=?";
      Clothes clothes=null;
      try{
          pstmt=conn.prepareStatement(sql);
          pstmt.setInt(1,clotheID);
          rs=pstmt.executeQuery();
          if(rs.next()){         
             clothes=createClothesByRs(rs);
          }       
      }catch(Exception e) { 
        e.printStackTrace(); 
      }finally{ 
        JDBCUtil.close(rs,pstmt,conn); 
      }
     return clothes;
   }   

  // 将clothe对象的创建封装为一个私有类，提高代码的可重用性，减少冗余
  private Clothes createClothesByRs(ResultSet rs)throws Exception{
	  Clothes clothes=new Clothes();
	  clothes.setClotheID(rs.getInt("clotheID"));
	  clothes.setClotheName(rs.getString("clotheName"));
	  clothes.setOrigin(rs.getString("origin"));
	  clothes.setStyle(rs.getString("style"));
    clothes.setColor(rs.getString("color"));
	  clothes.setDeliveryTime(rs.getString("deliveryTime"));
    clothes.setPrice(rs.getDouble("price"));
	  clothes.setDiscount(rs.getDouble("discount"));
	  clothes.setCover(rs.getString("cover"));	 
	  clothes.setType(rs.getString("type"));
	  clothes.setContent(rs.getString("content"));
	  return clothes;
   }
}