package com.hascode.tutorial.jsf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.portlet.ActionResponse;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;

@ManagedBean
@SessionScoped
public class UserBean {
	private String				sortType	= "normal";

	private final List<String>	names		= new ArrayList<String>();
	{
		names.add("adam");
		names.add("barry");
		names.add("douglas");
		names.add("ethan");
	}

	public List<String> getUserNames() {
		if ("reverse".equals(sortType)) {
			Collections.reverse(names);
			return names;
		}

		Collections.sort(names);
		return names;
	}

	public void save() throws PortletModeException {
		// Switch the portlet mode back to VIEW.
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		ActionResponse actionResponse = (ActionResponse) externalContext.getResponse();
		actionResponse.setPortletMode(PortletMode.VIEW);
	}

	public String getSortType() {
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
	}
}
