package gzmtu.xt.dzsw.dao;
import gzmtu.xt.dzsw.entity.Clothes;
import java.util.List;
public interface IClothesDao{
    public int getRowsByType(String type);
    public int getRowsAll();
    public List<Clothes> getClothesByType(String type,int pageSize,int page);	
    public Clothes getClothesByID(int clotheID);
    public List<Clothes> getClothesAll(int pageSize,int page);
}