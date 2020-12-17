package gzmtu.xt.dzsw.dao;
import gzmtu.xt.dzsw.entity.Customer;
public interface ICustomerDao{
    // 实现注册功能
    public boolean register(Customer customer);
    // 实现登录功能
    public boolean login(String account,String pwd); 
}
