package com.hascode.tutorial.portlet;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CustomPortletMessage implements Serializable {
	private static final long	serialVersionUID	= 1L;

	private String				text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
