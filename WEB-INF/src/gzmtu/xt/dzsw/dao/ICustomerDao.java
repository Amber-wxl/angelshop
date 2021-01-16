package gzmtu.xt.dzsw.dao;
import gzmtu.xt.dzsw.entity.Customer;
import java.util.List;
public interface ICustomerDao{
    // 实现注册功能
    public boolean register(Customer customer);
    // 实现登录功能
    public boolean login(String account,String pwd); 
    // 管理员查询用户
    public List<Customer> getCustomer();
    // 管理员注销用户
    public boolean deleteCustomer(String account);
}
