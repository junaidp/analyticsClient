package com.analytics.client.view.menus.queries;

import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.TabItemConfig;

public class PanelTabItemConfig extends TabItemConfig
{
	public enum TabItemId
	{
		STEP1, STEP2;
	}

	private TabItemId tabItemId = null;
	private Widget widget = null;

	public PanelTabItemConfig(TabItemId tabItemId, String text, Widget widget)
	{
		super(text);
		setTabItemId(tabItemId);
		setWidget(widget);
	}

	public PanelTabItemConfig(TabItemId tabItemId, String text, Widget widget, boolean close)
	{
		super(text, close);
		setTabItemId(tabItemId);
		setWidget(widget);
	}

	public PanelTabItemConfig(TabItemId tabItemId, Widget widget)
	{
		super();
		setTabItemId(tabItemId);
		setWidget(widget);
	}

	public TabItemId getTabItemId()
	{
		return tabItemId;
	}

	private void setTabItemId(TabItemId tabItemId)
	{
		this.tabItemId = tabItemId;
	}

	public Widget getWidget()
	{
		return widget;
	}

	private void setWidget(Widget widget)
	{
		this.widget = widget;
	}
}
