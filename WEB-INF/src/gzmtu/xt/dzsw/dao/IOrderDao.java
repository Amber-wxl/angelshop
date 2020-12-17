package gzmtu.xt.dzsw.dao;
import gzmtu.xt.dzsw.entity.Order;
import java.util.List;
public interface IOrderDao{
	// 创建订单
	public abstract boolean createOrder(Order order);
	// 通过订单号查询订单详情
	public abstract Order getOrderByOrderID(String orderID);
	// 查询用户的订单
	public abstract List<Order> getOrdersByAccount(String account);
	
}