package gzmtu.xt.dzsw.dao;
import gzmtu.xt.dzsw.entity.Cart;
import java.util.List;
public interface ICartDao{
	public abstract boolean addToCart(Cart cart);
	public abstract List<Cart> getCartsByAccount(String account);
	public abstract boolean removeFromCart(int clotheID);
}