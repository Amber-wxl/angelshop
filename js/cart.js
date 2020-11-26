function addToCart(clotheID,clotheName){ 	
    var cookies=document.cookie;
    if (cookies.length>0 ){       
       var startPos=cookies.indexOf('account=');
       if(startPos!=-1){
        window.open('http://localhost:8080/angelshop/addToCart.do?clotheID='+clotheID+'&clotheName='+clotheName);
       }
   }else{
         location.href="http://localhost:8080/angelshop/login.html";
   }
}

function listCart(){ 	
    var cookies=document.cookie;
    if (cookies.length>0 ){       
       var startPos=cookies.indexOf('account=');
       if(startPos!=-1){
        window.open('http://localhost:8080/angelshop/listCart.do');
       }
   }else{
         location.href="http://localhost:8080/angelshop/login.html";
   }
}
