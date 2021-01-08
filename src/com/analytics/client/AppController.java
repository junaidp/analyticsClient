package com.analytics.client;


import com.analytics.client.event.MainEvent;
import com.analytics.client.event.MainEventHandler;
import com.analytics.client.view.MainPresenterImpl;
import com.analytics.client.view.MainView;
import com.analytics.client.view.MainViewImpl;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

public class AppController implements Presenter, ValueChangeHandler<String>
{
	private final HandlerManager eventBus;

	private final AnalyticServiceAsync rpcService;
	private HasWidgets container;
	private HasWidgets mainContainer, headerContainer;
	Presenter presenter = null;

	public AppController( AnalyticServiceAsync rpcService, HandlerManager eventBus )
	{
		this.eventBus = eventBus;
		this.rpcService = rpcService;

		bind();
	}

	private void bind()
	{
		History.addValueChangeHandler( this );

		eventBus.addHandler( MainEvent.TYPE,
				new MainEventHandler()
				{
					public void onMain( MainEvent event )
					{
						History.newItem( "main" );
					}

				} );

	}

	public void go( final HasWidgets container, HasWidgets headerContainer )
	{
		this.container = container;
		this.mainContainer = container;
		this.headerContainer = headerContainer;

		if ("".equals( History.getToken()) || "index".equals(History.getToken()))
		{
			History.newItem( "main" );
		}
		else
		{
			History.fireCurrentHistoryState();
		}
	}

	public void onValueChange( ValueChangeEvent<String> event )
	{
		String token = event.getValue();

		if (token != null)
		{
			presenter = null;

				if (token.equals( "main" ))
			{
				presenter = new MainPresenterImpl( rpcService, eventBus );
				MainView mainView = new MainViewImpl();
				mainView.setPresenter( presenter );
				mainView.go( container );

			}
		}
	}
}
