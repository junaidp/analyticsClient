package com.analytics.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.logging.client.SimpleRemoteLogHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.container.VBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class MenuBase implements IsWidget   {
    VBoxLayoutContainer vlc = new VBoxLayoutContainer( VBoxLayoutContainer.VBoxLayoutAlign.STRETCH);

    protected  HTML heading = new HTML();
    protected VerticalLayoutContainer container = new VerticalLayoutContainer();
    public SimpleRemoteLogHandler remoteLog = new SimpleRemoteLogHandler();
    protected AsyncCallback<String> asyncCallback;

    public MenuBase() {


    }

    @Override
    public Widget asWidget() {

        return layout();
    }

    private Widget layout() {

        container.getElement().getStyle().setPadding( 10, Style.Unit.PX );
        container.add( heading );
        return container;
    }

    public void logInfo(String message)
    {
        GWT.log(message);
        remoteLog.publish(new LogRecord( Level.INFO, message));

    }

    public void logWarning(String message)
    {
        GWT.log(message);
        remoteLog.publish(new LogRecord( Level.WARNING, message));

    }

    public void logError(String message)
    {
        GWT.log(message);
        remoteLog.publish(new LogRecord( Level.SEVERE, message));

    }

   
}