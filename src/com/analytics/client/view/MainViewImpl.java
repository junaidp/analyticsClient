package com.analytics.client.view;

import com.analytics.client.Presenter;
import com.analytics.client.view.header.HeaderPanel;
import com.analytics.client.view.header.HeaderPanelImpl;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.dom.ScrollSupport;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;

public class MainViewImpl implements MainView
{

	private HeaderPanel headerPanel;
	private Presenter presenter;
	private VerticalLayoutContainer centerContainer = new VerticalLayoutContainer();

	public Widget layout()
	{
		VerticalLayoutContainer container = new VerticalLayoutContainer();
		container.add( (IsWidget) getHeader() );
		container.add(centerContainer);
		centerContainer.setScrollMode(ScrollSupport.ScrollMode.AUTO);
		//TODO: NEED TO FIND A BETTER WAY, may be BorderLayoutContianer can help
		centerContainer.setHeight(Window.getClientHeight()-90);
		Window.addResizeHandler(Event -> onResize());
		return container;
	}

	private void onResize() {
		centerContainer.setHeight(Window.getClientHeight()-160);
	}

	public HeaderPanel getHeader()
	{
		if (headerPanel == null)
		{
			headerPanel = new HeaderPanelImpl(centerContainer);
		}
		return headerPanel;
	}

	@Override
	public void go( HasWidgets container )
	{
		//view = new AppViewImpl();// Here we can change app main view as per any condition for example which user logginIn or something else.for now the one view is appView
		//view.go(container);
		container.clear();
		container.add( layout() );
	}

	@Override
	public Presenter getPresenter()
	{
		return presenter;
	}

	@Override
	public void setPresenter( Presenter presenter )
	{
		this.presenter = presenter;
	}

	public VerticalLayoutContainer getCenterContainer()
	{
		return centerContainer;
	}



}
