//本工具类主要由servlet使用,用于从cookie获取account
package gzmtu.xt.dzsw.utils;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.Cookie;
 public class CookieUtil{
   public static String getAccount(HttpServletRequest request){
      String account=null;
      Cookie[] cookies=request.getCookies();	
      for(Cookie cookie:cookies){
			if("account".equals(cookie.getName())){
                  account=cookie.getValue();
                  break;
            }
      }
	  return account;
   }
 }
