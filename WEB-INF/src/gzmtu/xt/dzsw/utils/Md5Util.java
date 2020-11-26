package gzmtu.xt.dzsw.utils;
import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
public class Md5Util{
   public static String md5(String source){
      StringBuilder sb=new StringBuilder();	
      try{
	MessageDigest md = MessageDigest.getInstance("MD5");
	byte[] result = md.digest(source.getBytes()); 	//System.out.println(Arrays.toString(result));
	for (byte b:result){	
		sb.append(String.format("%02x", b));
	//%02x 格式化符号:以十六进制输出,2为指定的输出字段的宽度.如果位数小于2,则左端补0
	}			
	//}catch (NoSuchAlgorithmException e){e.printStackTrace();}
	}catch (Exception e){e.printStackTrace();}
	return sb.toString().toLowerCase();
   }
}
