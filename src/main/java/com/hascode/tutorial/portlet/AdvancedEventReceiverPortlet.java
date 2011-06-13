package com.hascode.tutorial.portlet;

import java.io.IOException;

import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class AdvancedEventReceiverPortlet extends GenericPortlet {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.portlet.GenericPortlet#processEvent(javax.portlet.EventRequest,
	 * javax.portlet.EventResponse)
	 */
	@Override
	public void processEvent(EventRequest req, EventResponse res) throws PortletException, IOException {
		final CustomPortletMessage message = (CustomPortletMessage) req.getEvent().getValue();
		res.setRenderParameter("message", message.getText());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.portlet.GenericPortlet#render(javax.portlet.RenderRequest,
	 * javax.portlet.RenderResponse)
	 */
	@Override
	public void render(RenderRequest req, RenderResponse res) throws PortletException, IOException {
		final String message = req.getParameter("message");
		res.getWriter().println("Message received from event: " + message);
	}

}
