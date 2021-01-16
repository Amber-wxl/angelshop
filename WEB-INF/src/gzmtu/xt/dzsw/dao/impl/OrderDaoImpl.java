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
    public boolean createOrder(Order order){// 创建订单
        Connection conn=JDBCUtil.getConnection();//创建数据库连接
        PreparedStatement pstmt=null;
        String orderSql="insert into orders values(?,?,?,?,?,?,?)";//订单表insert
        String suborderSql="insert into suborders values"+genSqlValue(order)[0];//这里封装了私有类genSqlValue来将购物车里提交的产品遍历来获取子订单各属性的值
        String cartSql="delete from cart where account=? and clotheID in"+genSqlValue(order)[1];//购物车表delete
        boolean result=false;
        try{
            conn.setAutoCommit(false);//因为几个sql语句应该是都执行或都不执行的，所以设置不自动提交
            String account=order.getAccount();
            pstmt=conn.prepareStatement(orderSql);
            pstmt.setString(1,order.getOrderID());
	        pstmt.setString(2,account);
            pstmt.setDouble(3,order.getTotal());
		    pstmt.setString(4,order.getDeliverWay());
		    pstmt.setString(5,order.getPaymentWay());          
            pstmt.setObject(6,order.getOrderTime());
		    pstmt.setString(7,"待审核"); 
		    pstmt.executeUpdate();//先执行订单表的insert操作
		    System.out.println(pstmt);//在控制台输出pstmt的内容
		    pstmt=conn.prepareStatement(suborderSql);	  
		    pstmt.executeUpdate();//执行子订单表的insert操作
		    System.out.println(pstmt);
		    pstmt=conn.prepareStatement(cartSql);//执行购物车的delete操作
		    pstmt.setString(1,account);
		    pstmt.executeUpdate();
		    System.out.println(pstmt);		   
	        conn.commit();//提交sql
		    result=true;
        }catch(SQLException e){
            e.printStackTrace();
            try{ conn.rollback(); }
            catch(SQLException se){ e.printStackTrace();}
        }
        finally{ JDBCUtil.close(pstmt,conn); }
        return result;
    }

	public Order getOrderByOrderID(String orderID){// 通过订单号查询订单详情
        Connection conn=JDBCUtil.getConnection();//创建数据库连接
        PreparedStatement pstmt=null;
	    ResultSet rs=null;
	    String sql="select orders.total,orders.paymentWay,orders.deliverWay,orders.orderState,orders.orderTime,customer.account,customer.address,customer.phone, suborders.count,clothes.clotheID,clothes.clotheName,clothes.cover,clothes.price,clothes.discount from orders inner join customer  on customer.account=orders.account  inner join suborders on  suborders.orderID=orders.orderID inner join clothes on clothes.clotheID=suborders.clotheID where orders.orderID=?";
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
			order.setTotal(rs.getDouble("orders.total"));	//从订单表获取total
			order.setPaymentWay(rs.getString("orders.paymentWay"));//从订单表获取paymentWay
			order.setDeliverWay(rs.getString("orders.deliverWay"));//从订单表获取deliverWay
            order.setOrderTime(rs.getObject("orders.orderTime",LocalDateTime.class));//从订单表获取orderTime
            order.setOrderState(rs.getString("orders.orderState"));//从订单表获取orderState
			customer=new Customer();
			customer.setAccount(rs.getString("customer.account"));//从用户表获取account				 
			customer.setAddress(rs.getString("customer.address"));//从用户表获取address
			customer.setPhone(rs.getString("customer.phone"));//从用户表获取phone
			order.setCustomer(customer);			
			do{//订单至少有一件产品，所以这里使用do while循环
                suborder=new Suborder();
				suborder.setCount(rs.getInt("suborders.count"));//从子订单表获取count
				clothe=new Clothes();
                clothe.setClotheID(rs.getInt("clothes.clotheID"));//从产品表获取clotheID
			    clothe.setClotheName(rs.getString("clothes.clotheName"));//从产品表获取clotheName
				clothe.setCover(rs.getString("clothes.cover"));//从产品表获取cover
				clothe.setPrice(rs.getDouble("clothes.price"));//从产品表获取price
				clothe.setDiscount(rs.getDouble("clothes.discount"));//从产品表获取discount
                suborder.setClothe(clothe);
                suborderList.add(suborder);
			}while(rs.next());//如果一个订单有多个商品，这里将会执行循环
			order.setSuborderList(suborderList);
        }catch(SQLException e){ e.printStackTrace(); }
        finally{ JDBCUtil.close(rs,pstmt,conn); }
	    return order;
    }

    public List<Order> getOrdersByAccount(String account){// 查询用户的订单
        Connection conn=JDBCUtil.getConnection();//创建数据库连接
        PreparedStatement pstmt=null;
	    ResultSet rs=null;
	    String sql="select orders.orderID,orders.account,orders.total,orders.deliverWay,orders.paymentWay,orders.orderTime,orders.orderState,clothes.clotheID,clothes.cover,clothes.clotheName,clothes.price,suborders.count from orders inner join suborders on suborders.orderID=orders.orderID inner join clothes on clothes.clotheID=suborders.clotheID where orders.account=? order by orders.orderTime desc";
	    List<Order> orderList=new ArrayList();	
        try{
		    pstmt=conn.prepareStatement(sql);
	        pstmt.setString(1,account);
		    rs=pstmt.executeQuery();		  
		    Order order;
		    Suborder suborder;
		    ArrayList<Suborder> suborderList=null;		   
		    Clothes clothe;
		    String orderID=null;
	        while(rs.next()){
			    if(!rs.getString("orders.orderID").equals(orderID)){
                    // 查询结果的orderID不为 null
				    orderID=rs.getString("orders.orderID");
				    order=new Order();
				    order.setOrderID(orderID);
				    order.setAccount(rs.getString("orders.account"));				   
				    order.setTotal(rs.getDouble("orders.total"));
				    order.setPaymentWay(rs.getString("orders.paymentWay"));
				    order.setDeliverWay(rs.getString("orders.deliverWay"));				   
				    order.setOrderTime(rs.getObject("orders.orderTime",LocalDateTime.class));
				    order.setOrderState(rs.getString("orders.orderState"));
				    suborderList=new ArrayList();
				    order.setSuborderList(suborderList);
				    orderList.add(order);
			    }
			    suborder=new Suborder();	
			    clothe=new Clothes();
			    clothe.setClotheID(rs.getInt("clothes.clotheID"));//从clothes表获取的clotheID
                clothe.setCover(rs.getString("clothes.cover"));	//从clothes表获取的cover
                clothe.setClotheName(rs.getString("clothes.clotheName"));//从clothes表获取的clotheName
                clothe.setPrice(rs.getDouble("clothes.price"));//从clothes表获取的price
                suborder.setClothe(clothe);
                suborder.setCount(rs.getInt("suborders.count"));//从suborders表获取的count
			    suborderList.add(suborder);
		    }
        }catch(SQLException e){ e.printStackTrace(); }
        finally{ JDBCUtil.close(rs,pstmt,conn); }
	    return orderList;
    }

    public List<Order> getOrder(){// 管理员查询订单
        Connection conn=JDBCUtil.getConnection();//创建数据库连接
        PreparedStatement pstmt=null;
        String sql="select * from orders order by orderTime desc";
        List<Order> orderlist=new ArrayList<Order>(); ;
        ResultSet rs=null;
        try{
            pstmt=conn.prepareStatement(sql);
            System.out.println(pstmt);
            rs=pstmt.executeQuery();
            while(rs.next()){//遍历sql语句执行结果集
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
        }catch(SQLException e){ e.printStackTrace();  }
        finally{ JDBCUtil.close(rs,pstmt,conn); }
        return orderlist;
    }
    public boolean updateOrder(Order order){// 管理员修改订单信息
        Connection conn=JDBCUtil.getConnection();//创建数据库连接
        PreparedStatement pstmt=null;
        boolean result=false;
        String sql="update orders set paymentWay=?,deliverWay=?,orderState=? where orderID=?";
        try{
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,order.getPaymentWay());
            pstmt.setString(2,order.getDeliverWay());
            pstmt.setString(3,order.getOrderState());
            pstmt.setString(4,order.getOrderID());
            pstmt.executeUpdate();
            System.out.println(pstmt);
            result=true;
        }catch(SQLException e){ e.printStackTrace(); }
        finally{ JDBCUtil.close(pstmt,conn); }
        return result;
    }
    public boolean deleteOrder(String orderID){// 管理员删除订单
        Connection conn=JDBCUtil.getConnection();//创建数据库连接
        PreparedStatement pstmt=null;     
        boolean result=false;
        String sql="delete from orders where orderID=?"; 	  
        try{
            pstmt=conn.prepareStatement(sql);		 
            pstmt.setString(1,orderID);  
            if(pstmt.executeUpdate()==1){ result=true; }//影响行数 1
        }catch(Exception e){ e.printStackTrace(); }
        finally{ JDBCUtil.close(pstmt,conn); }
        return result;
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