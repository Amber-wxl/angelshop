package gzmtu.xt.dzsw.dao;
import gzmtu.xt.dzsw.entity.Clothes;
import java.util.List;
public interface IClothesDao{
    // 查询某一类商品的总数
    public int getRowsByType(String type);
    // 查询所有商品的总数
    public int getRowsAll();
    // 查询某一类商品，并实现分页显示
    public List<Clothes> getClothesByType(String type,int pageSize,int page);	
    // 通过商品ID查询到商品详情
    public Clothes getClothesByID(int clotheID);
    // 查询所有商品信息
    public List<Clothes> getClothesAll(int pageSize,int page);
    // 添加商品
    public boolean addClothes(Clothes clothes);
    // 删除商品
    public boolean deleteClothes(int clotheID );
    // 修改商品
    public boolean updateclothes(Clothes clothes);
}