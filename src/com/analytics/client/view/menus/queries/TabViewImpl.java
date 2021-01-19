package com.analytics.client.view.menus.queries;

import com.analytics.client.view.menus.queries.PanelTabItemConfig.TabItemId;
import com.analytics.client.view.menus.queries.steps.Tab;
import com.analytics.theme.client.base.tabs.Css3TabPanelBottomAppearance;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.BeforeSelectionEvent;
import com.google.gwt.event.logical.shared.BeforeSelectionHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.TabPanel.TabPanelAppearance;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.HideEvent.HideHandler;
import com.sencha.gxt.widget.core.client.event.ShowEvent.ShowHandler;

public abstract class TabViewImpl extends VerticalLayoutContainer implements HideHandler, ShowHandler, BeforeSelectionHandler<Widget>, SelectionHandler<Widget>
{
	TabPanel tabPanel = null;
	PanelTabItemConfig selectedConfig;
	public TabViewImpl()
	{
		tabPanel = new TabPanel(GWT.<TabPanelAppearance> create(Css3TabPanelBottomAppearance.class));
		PanelTabItemConfig step1Config = new PanelTabItemConfig(TabItemId.STEP1, "Step1", getStep1(), false);
		tabPanel.add( getStep1(), step1Config );
		PanelTabItemConfig step2Config = new PanelTabItemConfig(TabItemId.STEP2, "Step2", getStep1(), false);
		tabPanel.add( getStep2(), step2Config );
		add(tabPanel, new VerticalLayoutData(1, 0.5, new Margins(10, 0, 0, 0)));
		tabPanel.addStyleName("w3-display-bottom w3-padding");
		tabPanel.addSelectionHandler(this);
		tabPanel.addBeforeSelectionHandler(this);		
		tabPanel.setBorders(false);
		tabPanel.setCloseContextMenu(false);
		tabPanel.setAnimScroll(true);
		tabPanel.setTabScroll(true);
		tabPanel.setAllowTextSelection(false);
		tabPanel.setAutoSelect(false);
		tabPanel.forceLayout();
		
		tabPanel.addBeforeSelectionHandler(new BeforeSelectionHandler<Widget>() {
			
			@Override
			public void onBeforeSelection(BeforeSelectionEvent<Widget> event) {
				Widget selectedWidget = event.getItem();
				Tab t = (Tab) selectedWidget;
				t.saveModel();
			}
		});
	}
	
	
	@Override
	public void onSelection(SelectionEvent<Widget> event)
	{
		
		
		Widget widget = event.getSelectedItem();
		PanelTabItemConfig config = (PanelTabItemConfig) tabPanel.getConfig(widget);
		
		
		if (config.getTabItemId() == TabItemId.STEP1)
		{
			onTabStep1(event, config.getTabItemId());
		}
		selectedConfig = config;
		Tab t = (Tab) widget;
		t.loadModel();
		
	}
	
	

	@Override
	public void onBeforeSelection(BeforeSelectionEvent<Widget> event)
	{
		
	
	}
	
	

	

	protected PanelTabItemConfig getSelectedTab() {
		return selectedConfig;
	}

	protected abstract void onTabStep1(SelectionEvent<Widget> event, TabItemId tabItemId);

	protected abstract Widget getStep1();
	protected abstract Widget getStep2();

}
