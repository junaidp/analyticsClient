package com.analytics.client.view.menus;

import com.analytics.client.view.MenuBase;
import com.analytics.client.view.menus.queries.QueriesDefaultView;
import com.google.gwt.user.client.ui.HTML;



public class MenuQueries extends MenuBase {
	
	public MenuQueries() {
		
		//HERE we can add conditions to show different views under Tabs, for example if we want to see some thig different , use secondaryView
		
		container.add(new QueriesDefaultView());
		//container.add(new QueriesSecondaryView());
	}

}
