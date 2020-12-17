将angelshop目录放到D盘

在Tomcat安装目录下的conf/server.xml文件中<Host></Host>标签里添加以下语句：
<Context path="angelshop" docBase="d:/angelshop/" reloadable="true" workDir="d:/angelshop/work"/>

在mysql控制台执行sql文件的所有语句

在utils目录下文件JDBCUtil.java文件中将mysql的密码修改为自己电脑上mysql的密码，并重新编译

启动Tomcat服务器，访问http://localhost:8080/angelshop/index.html

布局到GitHub：
进入angelshop目录
git init
git add .
git commit -m "描述"
git config --global user.email "1242215748@qq.com"
git config --global user.name "Amber-wxl"
git remote add origin https://github.com/Amber-wxl/angelshop.git
git remote rm origin
git remote add origin https://github.com/Amber-wxl/angelshop.git
git push -u origin master


