package gzmtu.xt.dzsw.dao.impl;
import gzmtu.xt.dzsw.dao.IClothesDao;
import gzmtu.xt.dzsw.utils.JDBCUtil;
import gzmtu.xt.dzsw.entity.Clothes;
import java.sql.*;
import java.util.*;
import java.time.LocalDate;
public class ClothesDaoImpl implements IClothesDao{
	public int getRowsByType(String type){
      Connection conn=JDBCUtil.getConnection();
      PreparedStatement pstmt=null;
      ResultSet rs=null;	
	    String sql="select count(*) from clothes where type=?";  
	    int rows=0;
	    try{
        pstmt=conn.prepareStatement(sql);
		    pstmt.setString(1,type);
        rs=pstmt.executeQuery();
        if(rs.next()){
          rows=rs.getInt(1);
        }
      }catch(Exception e){ e.printStackTrace(); }
      finally{ JDBCUtil.close(rs,pstmt,conn); }
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
	    List<Clothes> clothesList=new ArrayList<Clothes>();     
	    try{		
		    index=(page-1)*pageSize;
        pstmt=conn.prepareStatement(sql);
		    pstmt.setString(1,type);
        pstmt.setInt(2,index);
        pstmt.setInt(3,pageSize);
        rs=pstmt.executeQuery();        
        while(rs.next()){
          clothes=createClothesByRs(rs);           
          clothesList.add(clothes);
           }
       }catch(Exception e){ e.printStackTrace(); }
       finally{ JDBCUtil.close(rs,pstmt,conn); }
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
    }catch(Exception e){ e.printStackTrace();}
    finally{ JDBCUtil.close(rs,pstmt,conn);}
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
      }catch(Exception e) { e.printStackTrace(); }
      finally{ JDBCUtil.close(rs,pstmt,conn); }
     return clothes;
   }   

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