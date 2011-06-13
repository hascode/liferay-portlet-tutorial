package com.hascode.tutorial.portlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class SimplePreferencesReadingPortlet extends GenericPortlet {

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

		PortletPreferences prefs = req.getPreferences();
		String[] tags = prefs.getValues("tags", null);
		writer.println("<b>Tags:</b><br/><ul>");
		for (String tag : tags) {
			writer.println("<li>" + tag + "</li>");
		}
		writer.println("</ul>");
	}

}
