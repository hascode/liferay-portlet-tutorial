package com.hascode.tutorial.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class UserBean {
	public String[] getUserNames() {
		return new String[]{"adam", "barry", "douglas", "ethan"};
	}
}
