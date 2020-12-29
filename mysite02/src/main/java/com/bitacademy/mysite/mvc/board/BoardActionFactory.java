package com.bitacademy.mysite.mvc.board;
import com.bitacademy.web.mvc.Action;
import com.bitacademy.web.mvc.ActionFactory;

public class BoardActionFactory extends ActionFactory{

		@Override
		public Action getAction(String actionName) {
			Action action = null;
			
			if("write".equals(actionName)) {
				
			} else if("view".equals(actionName)){
				action = new ViewAction();
			} else if("modify".equals(actionName)){
				action = new WriteAction();
			} else if("write".equals(actionName)){
				action = new ModifyAction();
			} else {
				// 리스트를 보여준다
				action = new ListAction();
			}
			
			return action;
		}

	}
