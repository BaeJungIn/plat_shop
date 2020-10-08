package admCtr;

import admCtr.AdminIndexAction;
import admCtr.AdminLoginAction;
import admCtr.AdminLogoutAction;
import admCtr.FindZipNumAction;

public class AdminActionFactory {
	
	private static AdminActionFactory instance = new AdminActionFactory();
	 private AdminActionFactory() {
		    super();
		  }
		  public static AdminActionFactory getInstance() {
		    return instance;
		  }

		 /* public AdminAction getAction(String command, String shopname) {*/
		  public AdminAction getAction(String command, String category) {
		    AdminAction action = null;
		    System.out.println("ActionFactory  :" + command);
		  
		    
		    
		    //admin
		 
		    if (command.equals("index")) {
		      action = new AdminIndexAction();
		    } else if (command.equals("admin_login_form")) {
		      action = new AdminLoginFormAction();
			} else if (command.equals("admin_join")) {
			  action = new AdminJoinAction();
			} else if (command.equals("admin_join_form")) {
		      action = new AdminJoinFormAction();
		    } else if (command.equals("admin_login")) {
			  action = new AdminLoginAction();
		    } else if (command.equals("admin_logout")) {
		      action = new AdminLogoutAction();
		    } else if (command.equals("admin_shop")) {
			  action = new AdminShopAction();
		    } else if (command.equals("id_check_form")) {
			  action = new IdCheckAdminAction();
		    } else if (command.equals("admin_main_update")) {
			  action = new MainUpdateAction();
		    } else if (command.equals("admin_update_form")) {
			  action = new UpdateFormAction();
		    } else if (command.equals("admin_createTable")) {
			  action = new CreateTableAction();
		    } else if (command.equals("admin_insertCusmem")) {
			  action = new AdminInsertAction();
		    } else if (command.equals("find_zip_num")) {
			  action = new FindZipNumAction();
	        } else if (command.equals("CategoryForm")) {
				action = new CategoryFormAction();
			} else if (command.equals("InsertCategory")) {
				action = new InsertCategoryAction();
			} else if (command.equals("admin_qna_list")) {
				action = new AdminQnaListAction();
			} else if (command.equals("admin_qna_detail")) {
				action = new AdminQnaDetailAction();
			} else if (command.equals("admin_qna_repsave")) {
				action = new AdminQnaResaveAction();
			} else if (command.equals("admin_intro")) {
				action = new IntroAction();
			} else if (command.equals("admin_outadm")) {
				action = new AdminOutAction();
			} else if (command.equals("admin_cusList")) {
				action = new AdminCusListAction();
			} else if (command.equals("admin_order_list")) {
				action = new AdminOrderListAction();
			} else if ((command+category).equals("admin_prod_index"+category)) {
				action = new AdmProIndexAction(category);
			} else if ((command+category).equals("admin_prod_updateform"+category)) {
				action = new ProductUpdateFormAction(category);
			} else if ((command+category).equals("admin_prod_update"+category)) {
				action = new ProductUpdateAction(category);
			} else if ((command+category).equals("admin_prod_delete"+category)) {
			    action = new ProductDeleteAction(category);
			} else if (command.equals("admin_product_write_form")) {
			    action = new AdminProductWriteFormAction();
		    } else if (command.equals("admin_product_write")) {
			    action = new AdminProductWriteAction();
		    }
		    
		    
		    return action;
		  }
		}
