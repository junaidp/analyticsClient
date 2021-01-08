package com.analytics.client.view.header;


import com.analytics.client.Constants;
import com.analytics.client.view.MenuBase;
import com.analytics.client.view.menus.MenuQueries;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.logging.client.SimpleRemoteLogHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.NorthSouthContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.menu.MenuBar;
import com.sencha.gxt.widget.core.client.menu.MenuItem;
import com.sencha.gxt.widget.core.client.menu.*;

public class HeaderPanelImpl extends VerticalLayoutContainer implements HeaderPanel
{

	 private AppBrandingPanel appBrandingPanel = new AppBrandingPanelImpl();
	 private AppInfoPanel appInfoPanel = new AppInfoPanelImpl();
	 private MenuBarItem home = null;
	 private MenuBarItem settings = null;
	 private MenuBarItem utilities = null;
	 private MenuBarItem help = null;
	 private Menu subMenuUtilities = null;
	 private VerticalLayoutContainer centerContainer;
	 private MenuBase menu = null;
	 private ContentPanel headerPanel = null;
	
	 private String selectedMenu = "";
	 private SimpleRemoteLogHandler remoteLog = new SimpleRemoteLogHandler();



	 private String url = GWT.getModuleBaseURL().substring( 0, GWT.getModuleBaseURL().length()-1);


	public HeaderPanelImpl( VerticalLayoutContainer centerContainer )
	{
		this.centerContainer = centerContainer;
		init();
	}

	 private void init()
	 {
		 add(layout());
		 display( getQueriesMenu() );
		
	 }

	 private MenuBase getQueriesMenu() {
		MenuQueries menuQueries = new MenuQueries();
		return menuQueries;
	}

	private void display( MenuBase menu)
	 {
	 	 centerContainer.clear();
		 centerContainer.add( menu );
	 }
	 private Widget layout()
	{
		url = url+".html";

		subMenuUtilities = new Menu();
		Menu subMenuItemHelp = new Menu();
		Menu subMenuItemSettings = new Menu();
		Menu subMenuItemLanguage = new Menu();
		Menu subMenuItemNone = new Menu();
		//subMenuItemNone.setVisible( false );

		MenuItem menuCRC = new MenuItem( "CRC Report" );
		MenuItem menuIfInError = new MenuItem( "Input Errors Report" );

		subMenuUtilities.add( menuCRC );

		subMenuUtilities.add( menuIfInError );
		subMenuUtilities.add( new MenuItem( Constants.CONNECTION_REPORT  ) );
		

		subMenuItemHelp.add( new MenuItem( Constants.MENU_MANUAL  ) );
		
		subMenuItemSettings.add( new MenuItem (Constants.MENU_CONNECT ) );
	

		home = new MenuBarItem( "home", subMenuItemNone);
		settings = new MenuBarItem( "settings" , subMenuItemSettings);
	
		MenuBarItem language = new MenuBarItem( "Language", subMenuItemLanguage );

		Menu subMenuCRC = new Menu();

		Menu subMenuCIfInError = new Menu();


		subMenuCRC.setId( Constants.CRC_ID);
	
		menuCRC.setSubMenu( subMenuCRC );
		menuIfInError.setSubMenu( subMenuCIfInError );

		MenuBar menuBar = new MenuBar();
		menuBar.add(home);
		menuBar.add( settings );
		

		VerticalLayoutContainer vc = new VerticalLayoutContainer();

		NorthSouthContainer northSouthContainer = new NorthSouthContainer();
		northSouthContainer.setNorthWidget( menuBar );

		headerPanel = new ContentPanel();
		headerPanel.setHeading(appInfoPanel.getAppInfo());
		headerPanel.add( northSouthContainer );
		activatePanel(true );
		HorizontalPanel hc = new HorizontalPanel();
		hc.setWidth( "100%" );
		HTML htmlLogoText = new HTML("Analytics");
		htmlLogoText.addStyleName( "logoText" );
		hc.add( htmlLogoText);

		VerticalPanel vCurrentIpAndServerHost = new VerticalPanel();
		vCurrentIpAndServerHost.setWidth( "100%" );
		vCurrentIpAndServerHost.setHorizontalAlignment( HasHorizontalAlignment.ALIGN_CENTER );
		
		hc.add( vCurrentIpAndServerHost );

		VerticalPanel vBrandingPanel = new VerticalPanel();
		vBrandingPanel.setWidth( "100%" );
		vBrandingPanel.setHorizontalAlignment( HasHorizontalAlignment.ALIGN_RIGHT );
		vBrandingPanel.add( appBrandingPanel.getLogo() );
		hc.add( vBrandingPanel );
		vc.add( hc );
		vc.add( headerPanel );

		SelectionHandler<Item> handler = new SelectionHandler<Item>() {

			@Override
			public void onSelection(SelectionEvent<Item> event) {
				if (event.getSelectedItem() instanceof MenuItem) {
					MenuItem item = (MenuItem) event.getSelectedItem();
					if( !item.getText().equalsIgnoreCase( Constants.MENU_MANUAL))
					{
						clearContainer();
						updateHeaderText( item.getText());
						selectedMenu = item.getText();
					}

					loadView( item.getText());

				}
			}
		};

		//Window.addResizeHandler( Event -> loadView(selectedMenu, true) );

		subMenuUtilities.addSelectionHandler(handler);
		subMenuItemSettings.addSelectionHandler( handler );
		subMenuItemLanguage.addSelectionHandler( handler );
		subMenuItemHelp.addSelectionHandler( handler );
		subMenuItemNone.addSelectionHandler( handler );

		return vc;

	}

	private void loadView( String selectedMenu)
	{
		switch(selectedMenu)
		{
		
		case Constants.MENU_MANUAL:
			Window.open( GWT.getHostPageBaseURL()+"some.htm", "", null );
			break;
		
		default:
				//DashboardUtils.logInfo("Unexpected selected Menu: " + selectedMenu);
		}
	}

	private void clearContainer()
	{
		centerContainer.clear();
	}


	private void updateHeaderText( String text)
	{
		if(text.isEmpty())
			appInfoPanel.setSelectedUtility("");
			else
		appInfoPanel.setSelectedUtility(" ("+ text+ ")");
		headerPanel.setHeading(appInfoPanel.getAppInfo());
	}

	@Override
	public void activatePanel( boolean activate )
	{
		home.setEnabled( activate );
		
	}



}
