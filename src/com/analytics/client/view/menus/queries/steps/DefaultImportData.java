package com.analytics.client.view.menus.queries.steps;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.box.MessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutPack;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FileUploadField;
import com.sencha.gxt.widget.core.client.form.FormPanel;
import com.sencha.gxt.widget.core.client.form.FormPanel.Encoding;
import com.sencha.gxt.widget.core.client.form.FormPanel.Method;
import com.sencha.gxt.widget.core.client.info.Info;

public class DefaultImportData extends TabImpl implements Tab{
	
	  private FramedPanel panel;
	  private FormPanel form;
	  protected static final int MAX_HEIGHT = 170;
	  protected static final int MAX_WIDHT = 500;
	  protected static final int MIN_HEIGHT = 150;
	  protected static final int MIN_WIDTH = 350;
	  
	  public DefaultImportData() {
		  add(fileUploadView());
	  }
	  
	  private Widget fileUploadView() {
		  final FileUploadField file = new FileUploadField();
	      file.addChangeHandler(new ChangeHandler() {
	        @Override
	        public void onChange(ChangeEvent event) {
	          Info.display("File Changed", "You selected " + file.getValue());
	        }
	      });
	      file.setName("uploadedfile");
	      file.setAllowBlank(false);

//	      StockProperties properties = GWT.create(StockProperties.class);
//	      ListStore<Stock> store = new ListStore<Stock>(properties.key());
//	      store.addAll(TestData.getStocks());

	      TextButton resetButton = new TextButton("Reset");
	      resetButton.addSelectHandler(new SelectHandler() {
	        @Override
	        public void onSelect(SelectEvent event) {
	          form.reset();
	          file.reset();
	        }
	      });

	      form = new FormPanel();
	      form.setAction("myurl");
	      form.setEncoding(Encoding.MULTIPART);
	      form.setMethod(Method.POST);
	      form.add(new FieldLabel(file, "File"), new MarginData(10));

	      TextButton submitButton = new TextButton("Submit");
	      submitButton.addSelectHandler(new SelectHandler() {
	        @Override
	        public void onSelect(SelectEvent event) {
	          if (!form.isValid()) {
	            return;
	          }
	          // we would normally want to submit the form here
	          // for this example, no server is set up to handle the post
	          // form.submit();
	          MessageBox box = new MessageBox("File Upload Example", "Your file was uploaded.");
	          box.setIcon(MessageBox.ICONS.info());
	          box.show();
	        }
	      });

	      panel = new FramedPanel();
	      panel.setHeading("File Upload");
	      panel.setButtonAlign(BoxLayoutPack.CENTER);
	      panel.add(form);
	      panel.addButton(resetButton);
	      panel.addButton(submitButton);
	      panel.setSize(MAX_WIDHT+"px", MAX_HEIGHT+"px");
	      return panel;
	  }

	@Override
	public void loadModel() {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void onModuleLoad() {
//	    new DefaultImportData(this)
//        .setHeight(MAX_HEIGHT)
//        .setMaxWidth(MAX_WIDHT)
//        .setMinHeight(MIN_HEIGHT)
//        .setMinWidth(MIN_WIDTH)
//        .doStandalone();
//	}

}
