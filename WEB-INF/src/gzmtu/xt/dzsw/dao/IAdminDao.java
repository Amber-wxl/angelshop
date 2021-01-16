package gzmtu.xt.dzsw.dao;
import gzmtu.xt.dzsw.entity.Admin;
import java.util.List;
public interface IAdminDao{
    // 实现注册功能
    public boolean register(Admin admin);
    // 实现登录功能
    public boolean login(String admin,String pwd); 
    // 查询管理员
    public List<Admin> getAdmin();
    // 注销管理员账号
    public boolean deleteAdmin(String adminID);
}
