package shopCtr;

//import admin.controller.action.AdminIndexAction;



public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();

	private ActionFactory() {
		super();
	}

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command, String shopname, String contents, String prodid) {
		Action action = null;
		System.out.println("ActionFactory  :" + command);
		System.out.println("shopname : " + shopname);
		System.out.println("contents : " + contents);
		System.out.println("prodid : "+prodid );

		if ((command+shopname).equals("shop_" + shopname)) {
			action = new IndexAction(shopname);
		}else if ((command+shopname+contents).equals("ProIndex"+shopname+""+contents)) {
			action = new ProIndexAction(contents);
		} else if ((command+shopname+contents+prodid).equals("ProDetail"+shopname+""+contents+""+prodid)) {
			action = new ProDetailAction(prodid);
		}else if ((command+shopname).equals("contract"+shopname)) {
			action = new ContractAction();
		} else if ((command+shopname).equals("join_form"+shopname)) {
			action = new JoinFormAction();
		} else if ((command+shopname).equals("id_check_form"+shopname)) {
			action = new IdCheckFormAction();
		} else if ((command+shopname).equals("find_zip_num"+shopname)) {
			action = new FindZipNumAction();
		} else if ((command+shopname).equals("join"+shopname)) {
			action = new JoinAction();
		} else if ((command+shopname).equals("login_form"+shopname)) {
			action = new LoginFormAction();
		} else if ((command+shopname).equals("login"+shopname)) {
			action = new LoginAction();
		} else if ((command+shopname).equals("logout"+shopname)) {
			action = new LogoutAction();
		} else if ((command+shopname).equals("mypage"+shopname)) {
			action = new MyPageAction();
		} else if ((command+shopname+contents+prodid).equals("cart_insert"+shopname+""+contents+""+prodid)){ 
			action = new CartInsertAction(); 
		} else if ((command+shopname).equals("cart_list"+shopname)) { 
			action = new CartListAction(); 
		} else if ((command+shopname).equals("cart_delete"+shopname)) {
		    action = new CartDeleteAction();
		} else if ((command+shopname+contents+prodid).equals("order_insert"+shopname+""+contents+""+prodid)) {
			action = new OrderInsertAction();
		} else if ((command+shopname).equals("order_list"+shopname)) { 
			action = new OrderListAction(); 
		} else if ((command+shopname).equals("cart_order_insert"+shopname)) { 
			action = new CartOrderInsertAction(); 
		} else if ((command+shopname).equals("mypage_detail"+shopname)) {
			action = new MypageDetailAction(); 
		} else if ((command+shopname).equals("update"+shopname)) {
            action = new UpdateAction();
        } else if ((command+shopname).equals("update_form"+shopname)) {
            action = new UpdateFormAction();
        } else if ((command+shopname).equals("userout"+shopname)){
        	action = new UserOutAction();
        }/* else if (command.equals("order_detail")) {
        }
		    action = new OrderDetailAction(); 
		} else if (command.equals("order_all")) {
			//action = new OrderAllAction(); 
		} */else if (command.equals("qna_list")) {
			action = new QnaListAction(); 
		} else if (command.equals("qna_write_form")) {
			action = new QnaWriteFormAction(); 
		} else if (command.equals("qna_write")) {
		    action = new QnaWriteAction(); 
		} else if (command.equals("qna_view")) { 
			action = new QnaViewAction(); }
		 
		// admin

		/*if ((command+shopname).equals("admin_login_form"+shopname)) {
			action = new AdminIndexAction();
		} else if ((command+shopname).equals("admin_login"+shopname)) {
			action = new AdminLoginAction();
		} else if ((command+shopname).equals("admin_logout"+shopname)) {
			action = new AdminLogoutAction();
		}*/
		
		
		
		/*
			 * else if (command.equals("admin_product_list")) { action = new
			 * AdminProductListAction(); } else if
			 * (command.equals("admin_product_write_form")) { action = new
			 * AdminProductWriteFormAction(); } else if
			 * (command.equals("admin_product_write")) { action = new
			 * AdminProductWriteAction(); } else if
			 * (command.equals("admin_product_detail")) { action = new
			 * AdminProductDetailAction(); } else if
			 * (command.equals("admin_product_update_form")) { action = new
			 * AdminProductUpdateFormAction(); } else if
			 * (command.equals("admin_product_update")) { action = new
			 * AdminProductUpdateAction(); } else if
			 * (command.equals("admin_order_list")) { action = new
			 * AdminOrderListAction(); } else if
			 * (command.equals("admin_order_save")) { action = new
			 * AdminOrderSaveAction(); } else if
			 * (command.equals("admin_member_list")) { action = new
			 * AdminMemberListAction(); } else if
			 * (command.equals("admin_qna_list")) { action = new
			 * AdminQnaListAction(); } else if
			 * (command.equals("admin_qna_detail")) { action = new
			 * AdminQnaDetailAction(); } else if
			 * (command.equals("admin_qna_repsave")) { action = new
			 * AdminQnaResaveAction(); }
			 */
		return action;
	}
}
