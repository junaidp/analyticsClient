package com.analytics.client.view.menus.queries;

import com.analytics.client.view.menus.queries.PanelTabItemConfig.TabItemId;
import com.analytics.client.view.menus.queries.steps.DefaultStep1;
import com.analytics.client.view.menus.queries.steps.DefaultStep2;
import com.google.gwt.event.logical.shared.BeforeSelectionEvent;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.event.HideEvent;
import com.sencha.gxt.widget.core.client.event.ShowEvent;

public class QueriesDefaultView extends TabViewImpl{

	@Override
	public Widget getStep1() {
		
		return new DefaultStep1();
	}

	@Override
	protected void onTabStep1(SelectionEvent<Widget> event, TabItemId tabItemId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onHide(HideEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onShow(ShowEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onBeforeSelection(BeforeSelectionEvent<Widget> event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Widget getStep2() {
		return new DefaultStep2();
	}


	
}
