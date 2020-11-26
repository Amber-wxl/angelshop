window.addEventListener('load',setReturnUrl);
function setReturnUrl(){     
      var returnUrl=document.getElementsByName("returnUrl")[0];	 
	  returnUrl.value=document.referrer; 
}