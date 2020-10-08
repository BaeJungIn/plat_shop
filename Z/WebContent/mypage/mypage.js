

function go_cart() {
	/*alert( document.formm.cart_num.value + " CART_num ");
	alert( document.formm.prodid.value + " - ");
	alert( document.formm.contents.value  + " - ");*/
  if (document.formm.cart_num.value == "") {
    alert("수량을 입력하여 주세요......");
    document.formm.cart_num.focus();
  } else{
	  var cart_num = document.formm.cart_num.value;
	  var prodid = document.formm.prodid.value;
	  var contents = document.formm.contents.value;
	  var shopname = document.formm.shopname.value;
//    document.formm.action = "ShopServlet?command=cart_insert&shopname=happyshop&contents=&prodid=";
    document.formm.action = "ShopServlet?command=cart_insert&shopname="+shopname+"&contents=" + contents +"&prodid=" + prodid;
    document.formm.method = "POST";
    document.formm.submit();
  }
}

function go_order() {

	  if (document.formm.cart_num.value == "") {
	    alert("수량을 입력하여 주세요......");
	    document.formm.cart_num.focus();
	  } else{
		  var cart_num = document.formm.cart_num.value;
		  var prodid = document.formm.prodid.value;
		  var contents = document.formm.contents.value;
		  var shopname = document.formm.shopname.value;
//	    document.formm.action = "ShopServlet?command=cart_insert&shopname=happyshop&contents=&prodid=";
	    document.formm.action = "ShopServlet?command=order_insert&shopname="+shopname+"&contents="+contents+"&prodid="+prodid;
	    document.formm.method = "POST";
	    document.formm.submit();
	  }
		/*
	  document.formm.action = "ShopServlet?command=mypage&shopname=happyshop&contents=&prodid=";
	  document.formm.submit();*/
	}
function go_order_insert(shopname) {
	
	/*var cart_num = document.formm.cart_num.value;
	var shopname = document.formm.shopname.value;
	var prodid = document.formm.prodid.value;
	var contents = document.formm.contents.value;*/
	 document.formm.action = "ShopServlet?command=cart_order_insert&shopname="+shopname+"&contents=&prodid=";
		    document.formm.method = "POST";
		    document.formm.submit();
}

function go_cart_delete(adminid) {
  var count = 0;
  //var shopname = document.formm.shopname.value;
  if (document.formm.cart_id.length == undefined) {
    if (document.formm.cart_id.checked == true) {
      count++;
    }
  }

  for ( var i = 0; i < document.formm.cart_id.length; i++) {
   // alert("" + document.formm.cart_id[i].checked);
    if (document.formm.cart_id[i].checked == true) {
      count++;
      //alert("" + count);
    }
  }
  if (count == 0) {
    alert("삭제할 항목을 선택해 주세요.");
  } else {
	  document.formm.action = "ShopServlet?command=cart_delete&shopname="+adminid+"&contents=&prodid=";
	    document.formm.method = "POST";
	    document.formm.submit();
   // document.formm.action = "ShopServlet?command=cart_delete&shopname"+ ShopServlet.adminid +"&contents=&prodid=";
   // document.formm.submit();
  }
}


	
  /*document.formm.action = "ShopServlet?command=order_insert&shopname"+ ShopServlet.adminid +"&contents=&prodid=";
  document.formm.submit();*/


function go_order_delete(adminid) {
  var count = 0;
  //var shopname = document.formm.shopname.value;
  if (document.formm.order_id.length == undefined) {
    if (document.formm.order_id.checked == true) {
      count++;
    }
  }

  for ( var i = 0; i < document.formm.oder_id.length; i++) {
    if (document.formm.oseq[i].checked == true) {
      count++;
    }
  }
  if (count == 0) {
    alert("삭제할 항목을 선택해 주세요.");
  } else {
	  
    document.formm.action = "ShopServlet?command=order_delete&shopname="+adminid+"&contents=&prodid=";
    document.formm.submit();
  }
}

