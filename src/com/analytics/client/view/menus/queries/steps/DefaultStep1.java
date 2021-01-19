
package com.analytics.client.view.menus.queries.steps;

import com.analytics.client.view.BasicDndExample;
import com.analytics.client.view.FilterTreeExample;
import com.analytics.client.view.widgets.HeadingLabel;
import com.analytics.client.view.widgets.QueryCard;
import com.analytics.client.view.widgets.WizardFieldLabel;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;

public class DefaultStep1 extends TabImpl implements Tab{
	TextField text = new TextField();
	public DefaultStep1() {
//		add(new HTML("DefaultStep 1"));		
//		add(new WizardFieldLabel(text, "First Field"));
		HorizontalLayoutContainer hlc = new HorizontalLayoutContainer();
		hlc.add(queriesCards(), new HorizontalLayoutData(350, 1, new Margins(1,0,0,0)));
//		hlc.add(queriesCardsProduceView());
		hlc.add(new BasicDndExample(), new HorizontalLayoutData(500, 1, new Margins(1,0,0,2)));
		hlc.add(new FilterTreeExample(), new HorizontalLayoutData(500, 1, new Margins(1,0,0,2)));
//		hlc.add(filtersView(), new HorizontalLayoutData(400, 1, new Margins(1,0,0,0)));
//		hlc.add(fiedsView(), new HorizontalLayoutData(300, 1, new Margins(1,0,0,0)));
		add(hlc);
	}
	
	private Widget queriesCardsProduceView(){
		HorizontalPanel hpnl = new HorizontalPanel();
		hpnl.add(queriesCards());
//		hpnl.add(procedureView());
//		hpnl.add(new BasicDndExample());
		return hpnl;
	}
	
	private Widget fiedsView() {
		VerticalPanel vpnl = new VerticalPanel();
		vpnl.add(new FilterTreeExample());
		vpnl.addStyleName("w3-border w3-panel w3-container");
//		vpnl.setWidth("300px");
		return vpnl;
	}
	
	private Widget filtersView() {
		ContentPanel cpnl = new ContentPanel();
		cpnl.setHeading("Filters");
//		HeadingLabel lblFields= new HeadingLabel();
//		lblFields.setContent("Filters");
//		lblFields.getElement().getStyle().setFontWeight(FontWeight.BOLDER);
//		cpnl.add(lblFields);
//		vpnl.setWidth("300px");
		cpnl.add(new FilterTreeExample());
		cpnl.addStyleName("w3-border w3-panel w3-container");
		return cpnl;
	}
	
	private Widget queriesCards() {
		ContentPanel cpnl = new ContentPanel();
		VerticalPanel vpnl = new VerticalPanel();
		vpnl.add(new QueryCard("Duplicate"));
		vpnl.add(new QueryCard("Average exceeds threshold"));
		vpnl.add(new QueryCard("No Purchase order numbers"));
		vpnl.add(new QueryCard("Query 4"));
		vpnl.add(new QueryCard("Query 5"));
		vpnl.add(new QueryCard("Query 6"));
		vpnl.addStyleName("w3-border w3-panel w3-container");
		vpnl.setWidth("300px");
		cpnl.setHeading("Queries");
		cpnl.add(vpnl);
		return cpnl;
	}	
	
	private Widget procedureView() {
		VerticalPanel vpnl = new VerticalPanel();
		FieldLabel lblProcedure= new FieldLabel();
		lblProcedure.setContent("Procedure");
		lblProcedure.getElement().getStyle().setFontWeight(FontWeight.BOLDER);
		vpnl.add(lblProcedure);
		
		HTML htmlProcedure = new HTML("1. Import Database <br>"  + 
				"2. Perform mapping to link multiple resources <br>" + 
				"3. Select data range on which you want to perform query<br>" + 
				"4. Double click to Run the query ");
		vpnl.add(htmlProcedure);
		htmlProcedure.setWidth("220px");
		vpnl.setWidth("250px");
		vpnl.addStyleName("w3-border w3-panel w3-container");
		return vpnl;
	}
	
	@Override
	public void loadModel() {
		text.setText(quesriesDTO.getFirstField());
		
	}

	@Override
	public void saveModel() {
		quesriesDTO.setFirstField(text.getText());
		
		
	}


}
