package gzmtu.xt.dzsw.dao;
import gzmtu.xt.dzsw.entity.Customer;
public interface ICustomerDao{
    public boolean register(Customer customer);
    public boolean login(String account,String pwd); 
}
