package user.controller;

import user.controller.action.LoginAction;

public class ActionFactory {
	
	private ActionFactory() {
		
	}
	private static ActionFactory instance = new ActionFactory();
	public static ActionFactory getIntance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		if(command.equals("login")) 
			action = new LoginAction();
		
		return action;
	}
}
