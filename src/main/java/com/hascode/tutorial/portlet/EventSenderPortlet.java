package com.hascode.tutorial.portlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.xml.namespace.QName;

public class EventSenderPortlet extends GenericPortlet {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.portlet.GenericPortlet#processAction(javax.portlet.ActionRequest,
	 * javax.portlet.ActionResponse)
	 */
	@Override
	public void processAction(ActionRequest req, ActionResponse res) throws PortletException, IOException {
		final String message = req.getParameter("message");
		if (message != null && !message.isEmpty()) {
			res.setEvent(new QName("http://www.hascode.com/portlet", "message"), message);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.portlet.GenericPortlet#render(javax.portlet.RenderRequest,
	 * javax.portlet.RenderResponse)
	 */
	@Override
	public void render(RenderRequest req, RenderResponse res) throws PortletException, IOException {
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		PortletURL actionUrl = res.createActionURL();
		final String output = String.format("<form action=\"%s\" method=\"post\"><label>Enter a message</label><input type=\"text\" name=\"message\"/><br/><input type=\"submit\"/></form>", actionUrl);
		writer.println(output);

	}

}
