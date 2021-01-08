package com.analytics.client.view.header;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;


public class AppBrandingPanelImpl implements IsWidget, AppBrandingPanel
{

	private final static String logo_File = "images/LOGO.png";
	@Override
	public Widget asWidget()
	{
		Image img = new Image(logo_File);
		return img;
	}

	@Override
	public Image getLogo()
	{
		return new Image(logo_File);
	}
}
