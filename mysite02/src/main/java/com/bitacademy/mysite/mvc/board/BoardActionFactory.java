package com.bitacademy.mysite.mvc.board;
import com.bitacademy.web.mvc.Action;
import com.bitacademy.web.mvc.ActionFactory;

public class BoardActionFactory extends ActionFactory{

		@Override
		public Action getAction(String actionName) {
			Action action = null;
			
			if("hello".equals(actionName)) {
				
			} else if("view".equals(actionName)){
				action = new ViewAction();
			} else if("modify".equals(actionName)){
				action = new ModifyAction();
			} else if("modifyform".equals(actionName)){
				action = new ModifyFormAction();
			}else if("writeform".equals(actionName)){
				action = new WriteFormAction();
			} else if("write".equals(actionName)){
				action = new WriteAction();
			} else if("deleteform".equals(actionName)){
				action = new DeleteFormAction();
			} else if("delete".equals(actionName)){
				action = new DeleteAction();
			}else if("replyform".equals(actionName)){
				action = new ReplyformAction();
			} else if("reply".equals(actionName)){
				action = new ReplyAction();
			} else if("good".equals(actionName)){
				action = new GoodAction();
			} else if("bad".equals(actionName)){
				action = new BadAction();
			} else if("search".equals(actionName)){
				action = new SearchAction();
			}else {
				// 리스트를 보여준다
				action = new ListAction();
			}
			
			return action;
		}

	}
