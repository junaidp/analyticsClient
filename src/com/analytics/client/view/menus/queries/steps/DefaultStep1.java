package com.analytics.client.view.menus.queries.steps;


import com.analytics.client.view.widgets.QueryCard;
import com.analytics.client.view.widgets.WizardFieldLabel;
import com.google.gwt.dom.client.Style.FontStyle;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.dom.client.Style.TextDecoration;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;

public class DefaultStep1 extends TabImpl implements Tab{
	TextField text = new TextField();
	public DefaultStep1() {
		add(new HTML("DefaultStep 1"));		
		add(new WizardFieldLabel(text, "First Field"));
		HorizontalLayoutContainer hlc = new HorizontalLayoutContainer();
//		hlc.add(queriesCardsProduceView(), new HorizontalLayoutData("600px", "100%", new Margins(5)));
		hlc.add(queriesCardsProduceView());
		hlc.add(filtersView());
		hlc.add(fieldsView());
		add(hlc);
	}
	
	private Widget queriesCardsProduceView(){
		HorizontalPanel hpnl = new HorizontalPanel();
		hpnl.add(queriesCards());
		hpnl.add(procedureView());
		return hpnl;
	}
	
	private Widget filtersView() {
		return null;
	}
	
	private Widget fieldsView() {
		return null;
	}
	
	private Widget queriesCards() {
		VerticalPanel vpnl = new VerticalPanel();
		vpnl.add(new QueryCard("Duplicate"));
		vpnl.add(new QueryCard("Average exceeds threshold"));
		vpnl.add(new QueryCard("No Purchase order numbers"));
		vpnl.add(new QueryCard("Query 4"));
		vpnl.add(new QueryCard("Query 5"));
		vpnl.add(new QueryCard("Query 6"));
		vpnl.addStyleName("w3-border w3-panel w3-container");
		return vpnl;
	}	
	
	private Widget procedureView() {
		VerticalPanel vpnl = new VerticalPanel();
		FieldLabel lblProcedure= new FieldLabel();
		lblProcedure.setContent("Procedure");
		lblProcedure.getElement().getStyle().setFontWeight(FontWeight.BOLDER);
		vpnl.add(lblProcedure);
		
		HTML htmlProcedure = new HTML("1- Import Database ");
		vpnl.add(htmlProcedure);
		
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
