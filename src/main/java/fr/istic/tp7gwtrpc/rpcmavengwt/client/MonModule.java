package fr.istic.tp7gwtrpc.rpcmavengwt.client;

import fr.istic.tp7gwtrpc.rpcmavengwt.server.ElectricDeviceImplService;
import fr.istic.tp7gwtrpc.rpcmavengwt.shared.ElectricDevice;
import fr.istic.tp7gwtrpc.rpcmavengwt.shared.FieldVerifier;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MonModule implements EntryPoint {
  
  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
    final Button list = new Button(  );
  

    // We can add style names to widgets
  list.addStyleName("Afficher la Liste");

    // Add the nameField and sendButton to the RootPanel
  RootPanel.get().add(list);
 
  list.addClickHandler(new ClickHandler() {
	
	public void onClick(ClickEvent arg0) 
	{
		// TODO Auto-generated method stub
		
		RequestBuilder b=new RequestBuilder(RequestBuilder.GET, GWT.getHostPageBaseURL()+" rest/electricedevice/");
		
		b.setCallback(new RequestCallback() {

			
		
			public void onError(Request arg0, Throwable except) {
				// TODO Auto-generated method stub
				Window.alert(except.getMessage());
			}
			public void onResponseReceived(Request  req, Response response) {
				// TODO Auto-generated method stub
				if (200 == response.getStatusCode()) 
				{
					
					 FlexTable t = new FlexTable();
					
					t.setTitle("ElecticDevices");
				
					t.setText(0, 0, "Id");
					
					t.setText(0, 1, "Consommation");
		
					ElectricDeviceImplService electr=new ElectricDeviceImplService();
					int i=0;
					for(ElectricDevice c:electr.get_devices())
					{
						t.setText(i+1, 0, new Long(c.getId()).toString());
						t.setText(i+1, 1, c.getCons());
						
					}
					RootPanel.get().add(t);

				}
			}
			
		
	
});
   
}
	
  }	
		  );

  }
}