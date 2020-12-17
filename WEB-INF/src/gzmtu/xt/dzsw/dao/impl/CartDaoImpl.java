package gzmtu.xt.dzsw.dao.impl;
import gzmtu.xt.dzsw.dao.ICartDao;
import gzmtu.xt.dzsw.utils.JDBCUtil;
import gzmtu.xt.dzsw.entity.Cart;
import gzmtu.xt.dzsw.entity.Clothes;
import java.sql.*;
import java.util.*;
import java.time.LocalDate;
public class CartDaoImpl implements ICartDao{
	public boolean addToCart(Cart cart){
      Connection conn=JDBCUtil.getConnection();
      PreparedStatement pstmt=null;
      ResultSet rs=null;	
	   boolean result=false;
	   String sql="select cartID from cart where account=? and clotheID=?"; //在购物车中查询是否已经存在该商品  
	   try{
		   pstmt=conn.prepareStatement(sql);
		   pstmt.setString(1,cart.getAccount());
		   pstmt.setInt(2,cart.getClotheID());
            rs=pstmt.executeQuery();
            if(rs.next()){	
               //如果sql执行结果不为空，则该用户购物车中已有该商品，此时不用插入一条新记录到购物车，只需在原来的+1
               int cartID=rs.getInt(1);				  
               sql="update cart set quantity=quantity+1,updateTime=? where cartID=?";//数量+1
               pstmt=conn.prepareStatement(sql);			 
		         pstmt.setObject(1,cart.getUpdateTime());
			      pstmt.setInt(2,cartID);
			      System.out.println(pstmt);
		   }else{			
            //如果执行结果为空，则插入记录
               sql="insert into cart values(null,?,?,1,?,?)";
               pstmt=conn.prepareStatement(sql);
			      pstmt.setInt(1,cart.getClotheID());
		         pstmt.setString(2,cart.getAccount());		     
		         pstmt.setObject(3,cart.getCreateTime());
               pstmt.setObject(4,cart.getUpdateTime());		  
		   }
         pstmt.executeUpdate();
		   result=true;
      }catch(Exception e){
         e.printStackTrace();
      }finally{
         JDBCUtil.close(rs,pstmt,conn);	    
      }
      return result;
	}

	public List<Cart> getCartsByAccount(String account){
      Connection conn=JDBCUtil.getConnection();
      PreparedStatement pstmt=null;
      ResultSet rs=null;	  
      String sql="select cart.clotheID,cart.quantity,clothes.clotheName,clothes.cover,clothes.price,clothes.discount from cart inner join clothes on clothes.clotheID=cart.clotheID where cart.account=? order by cart.updateTime desc";	  
	   Cart cart;
	   Clothes clothe;
	   List<Cart> cartList=new ArrayList<Cart>();     
	   try{
         pstmt=conn.prepareStatement(sql);
		   pstmt.setString(1,account);          
         rs=pstmt.executeQuery();        
         while(rs.next()){
			clothe=new Clothes();
			clothe.setClotheName(rs.getString("clotheName"));
			clothe.setCover(rs.getString("cover"));
			clothe.setPrice(rs.getDouble("price"));
			clothe.setDiscount(rs.getDouble("discount"));
         cart=new Cart();			 
			cart.setClotheID(rs.getInt("clotheID"));
			cart.setQuantity(rs.getInt("quantity"));
         cart.setClothe(clothe);
         cartList.add(cart);
         }
       }catch(Exception e){
          e.printStackTrace();
       }finally{
          JDBCUtil.close(rs,pstmt,conn);	    
      }
      return cartList;
   }
   public boolean deleteFromCart(Cart cart){
      Connection conn=JDBCUtil.getConnection();
      PreparedStatement pstmt=null;     
	   boolean result=false;
	   String sql="delete from cart where clotheID=? and account=?"; 	  
	   try{
		   pstmt=conn.prepareStatement(sql);		 
		   pstmt.setInt(1,cart.getClotheID());  
		   pstmt.setString(2,cart.getAccount()); 
         if(pstmt.executeUpdate()==1){//executeUpdate()函数的返回结果是sql语句执行后影响的记录数量
		      result=true;
		   }
      }catch(Exception e){
         e.printStackTrace();
      }finally{
         JDBCUtil.close(pstmt,conn);	    
      }
      return result;
   }

   public boolean updateCart(Cart cart){
      Connection conn=JDBCUtil.getConnection();
      PreparedStatement pstmt=null;     
	   boolean result=false;
	   String sql="update cart set quantity=?,updateTime=? where clotheID=? and account=?"; 	  
	   try{
		   pstmt=conn.prepareStatement(sql);		 
		   pstmt.setInt(1,cart.getQuantity()); 
		   pstmt.setObject(2,cart.getUpdateTime());
		   pstmt.setInt(3,cart.getClotheID());
		   pstmt.setString(4,cart.getAccount());
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

   public List<Cart> getCartsByAccountAndClotheIDs(String account,String[] clotheIDs){
      Connection conn=JDBCUtil.getConnection();	 
      PreparedStatement pstmt=null;
      ResultSet rs=null;		 
	   StringBuilder sb = new StringBuilder();	 
	   String clotheIDsstr="("+String.join(",",clotheIDs)+")";
      String sql="select cart.clotheID,cart.quantity,clothes.clotheName,clothes.cover,clothes.price,clothes.discount from cart inner join clothes on clothes.clotheID=cart.clotheID where account=? and cart.clotheID in "+clotheIDsstr+" order by cart.updateTime desc";	  
	   Cart cart;
	   Clothes clothe;
	   List<Cart> cartList=new ArrayList<Cart>();     
	   try{
         pstmt=conn.prepareStatement(sql);
		   System.out.println(pstmt);
		   pstmt.setString(1, account); 
		   System.out.println(pstmt);
         rs=pstmt.executeQuery();  		   
         while(rs.next()){
			   clothe=new Clothes();			  
			   clothe.setClotheName(rs.getString("clotheName"));
			   clothe.setCover(rs.getString("cover"));
			   clothe.setPrice(rs.getDouble("price"));
			   clothe.setDiscount(rs.getDouble("discount"));
            cart=new Cart();			 
			   cart.setClotheID(rs.getInt("clotheID"));
			   cart.setQuantity(rs.getInt("quantity"));
            cart.setClothe(clothe);
            cartList.add(cart);
         }
      }catch(Exception e){
          e.printStackTrace();
      }finally{
          JDBCUtil.close(rs,pstmt,conn);	    
      }
      return cartList;
   }
   

}