package com.hascode.tutorial.portlet;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class SimpleAnnotatedPortlet extends GenericPortlet {

	@RenderMode(name = "view")
	public void showMeSomeText(RenderRequest req, RenderResponse res) throws IOException {
		String theTime = req.getParameter("thetime");
		PortletURL actionUrl = res.createActionURL();
		actionUrl.setParameter(ActionRequest.ACTION_NAME, "mySpecialAction");
		res.getWriter().println("The time is: " + theTime + "<br/><small><a href=\"" + actionUrl + "\">Update time</a></small>");
	}

	@ProcessAction(name = "mySpecialAction")
	public void timeLookup(ActionRequest req, ActionResponse res) {
		res.setRenderParameter("thetime", new Date().toString());
	}
}
