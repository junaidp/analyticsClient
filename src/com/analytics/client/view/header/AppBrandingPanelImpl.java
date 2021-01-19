package com.analytics.client.view.header;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;


public class AppBrandingPanelImpl implements IsWidget, AppBrandingPanel
{

	private final static String logo_File = "images/hyphenlogo.png";
	@Override
	public Widget asWidget()
	{
		HorizontalPanel hpnl = new HorizontalPanel();
		Image img = new Image(logo_File);
		hpnl.setSize("150px", "50px");
		hpnl.add(img);
		return hpnl;
	}

	@Override
	public Image getLogo()
	{
		return new Image(logo_File);
	}
}
