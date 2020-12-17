package gzmtu.xt.dzsw.dao.impl;
import gzmtu.xt.dzsw.dao.IOrderDao;
import gzmtu.xt.dzsw.entity.Order;
import gzmtu.xt.dzsw.entity.Suborder;
import gzmtu.xt.dzsw.entity.Customer;
import gzmtu.xt.dzsw.entity.Clothes;
import gzmtu.xt.dzsw.utils.JDBCUtil;
import java.time.LocalDateTime;
import java.util.*;
import java.sql.*;
public class OrderDaoImpl implements IOrderDao{
    public boolean createOrder(Order order){
        Connection conn=JDBCUtil.getConnection();
        PreparedStatement pstmt=null;
        String orderSql="insert into orders values(?,?,?,?,?,?,?)";
        String suborderSql="insert into suborders values"+genSqlValue(order)[0];
        String cartSql="delete from cart where account=? and clotheID in"+genSqlValue(order)[1];
        boolean result=false;
        try{
            conn.setAutoCommit(false);
            String account=order.getAccount();
            pstmt=conn.prepareStatement(orderSql);
            pstmt.setString(1,order.getOrderID());
	        pstmt.setString(2,account);
            pstmt.setDouble(3,order.getTotal());
		    pstmt.setString(4,order.getPaymentWay());
		    pstmt.setString(5,order.getDeliverWay());          
            pstmt.setObject(6,order.getOrderTime());
		    pstmt.setString(7,"待审核"); 
		    pstmt.executeUpdate();
		    System.out.println(pstmt);//在控制台输出pstmt的内容
		    pstmt=conn.prepareStatement(suborderSql);	  
		    pstmt.executeUpdate();
		    System.out.println(pstmt);
		    pstmt=conn.prepareStatement(cartSql);
		    pstmt.setString(1,account);
		    pstmt.executeUpdate();
		    System.out.println(pstmt);		   
	        conn.commit();
		    result=true;
        }catch(SQLException e){
            e.printStackTrace();
            try{
                conn.rollback();
            }catch(SQLException se){e.printStackTrace();}
        }
        finally{
            JDBCUtil.close(pstmt,conn);
        }
        return result;
    }
	public Order getOrderByOrderID(String orderID){
        Connection conn=JDBCUtil.getConnection();
        PreparedStatement pstmt=null;
	    ResultSet rs=null;
	    String sql="select orders.total,orders.paymentWay,orders.deliverWay,orders.orderTime,customer.account,customer.address,customer.phone, suborders.count,clothes.clotheID,clothes.clotheName,clothes.cover,clothes.price,clothes.discount from orders inner join customer  on customer.account=orders.account  inner join suborders on  suborders.orderID=orders.orderID inner join clothes on clothes.clotheID=suborders.clotheID where orders.orderID=?";
	    Order order=new Order();
	    Customer customer;
		Suborder suborder;
	    ArrayList<Suborder> suborderList=new ArrayList();     
	    Clothes clothe;
        try{     
            pstmt=conn.prepareStatement(sql);
	        pstmt.setString(1,orderID);
		    rs=pstmt.executeQuery();
		    rs.next();			       
            order.setOrderID(orderID);	
			order.setTotal(rs.getDouble("orders.total"));	
			order.setPaymentWay(rs.getString("orders.paymentWay"));
			order.setDeliverWay(rs.getString("orders.deliverWay"));            
			order.setOrderTime(rs.getObject("orders.orderTime",LocalDateTime.class));
			customer=new Customer();
			customer.setAccount(rs.getString("customer.account"));				 
			customer.setAddress(rs.getString("customer.address"));
			customer.setPhone(rs.getString("customer.phone"));
			order.setCustomer(customer);			
			do{
                suborder=new Suborder();
				suborder.setCount(rs.getInt("suborders.count"));
				clothe=new Clothes();
                clothe.setClotheID(rs.getInt("clothes.clotheID"));
			    clothe.setClotheName(rs.getString("clothes.clotheName"));
				clothe.setCover(rs.getString("clothes.cover"));
				clothe.setPrice(rs.getDouble("clothes.price"));
				clothe.setDiscount(rs.getDouble("clothes.discount"));
                suborder.setClothe(clothe);
                suborderList.add(suborder);
			}while(rs.next());//如果一个订单有多个商品信息，这里将会执行循环
			order.setSuborderList(suborderList);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs,pstmt,conn);
		}
	   return order;
    }
    public List<Order> getOrdersByAccount(String account){
        Connection conn=JDBCUtil.getConnection();
        PreparedStatement pstmt=null;
        String sql="select * from orders where account=?";
        List<Order> orderlist=new ArrayList<Order>(); ;
        ResultSet rs=null;
        try{
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,account);
            rs=pstmt.executeQuery();
            while(rs.next()){
                Order order=new Order();
                order.setOrderID(rs.getString("orderID"));
                order.setAccount(rs.getString("account"));
                order.setTotal(rs.getDouble("total"));
                order.setDeliverWay(rs.getString("deliverWay"));
                order.setPaymentWay(rs.getString("paymentWay"));
                order.setOrderTime(rs.getObject("orderTime",LocalDateTime.class));
                order.setOrderState(rs.getString("orderState"));
                orderlist.add(order);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            JDBCUtil.close(rs,pstmt,conn);
        }
        return orderlist;
    }

    private String[] genSqlValue(Order order){
        String[] sqlValue=new String[2];
        StringBuilder suborderSb=new StringBuilder();
        StringBuilder cartSb=new StringBuilder();
        cartSb.append("(");
        ArrayList<Suborder> suborderList=order.getSuborderList();
        for(Suborder suborder:suborderList){
             suborderSb.append("(null,");
             suborderSb.append(suborder.getClotheID()).append(",").append(suborder.getOrderID()).append(",").append(suborder.getCount());
             suborderSb.append("),");			
             cartSb.append(suborder.getClotheID()).append(",");		   
         }
         suborderSb.deleteCharAt(suborderSb.length()-1);
         cartSb.deleteCharAt(cartSb.length()-1);
         cartSb.append(")");
         sqlValue[0]=suborderSb.toString();
         sqlValue[1]=cartSb.toString();
         return sqlValue;
    } 
}