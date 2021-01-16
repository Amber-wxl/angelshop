// dao接口
package gzmtu.xt.dzsw.dao;
import gzmtu.xt.dzsw.entity.Cart;
import java.util.List;
public interface ICartDao{
	// 加入购物车功能
	public abstract boolean addToCart(Cart cart);
	// 通过用户名查询购物车内容
	public abstract List<Cart> getCartsByAccount(String account);
	// 删除购物车
	public abstract boolean deleteFromCart(Cart cart);
	// 更新购物车
	public abstract boolean updateCart(Cart cart);
	// 通过用户名和商品ID查询购物车
	public abstract List<Cart> getCartsByAccountAndClotheIDs(String account,String[] clotheIDs);

}