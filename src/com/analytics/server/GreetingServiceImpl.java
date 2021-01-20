package com.analytics.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import com.analytics.client.AnalyticService;

import com.analytics.shared.FieldVerifier;
import com.analytics.shared.dtos.QueriesDTO;
import com.google.gson.Gson;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements AnalyticService {

	public String readExcel(String input) throws IllegalArgumentException {
		  String json = null;
		try {
		
		 InputStream is = new URL("").openStream();

	     BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	   
		
			json = readAll(rd);
			  Gson gson = new Gson();
			     QueriesDTO queriesDTO = gson.fromJson( json, QueriesDTO.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return json;
	}
	
	 private static String readAll(Reader rd) throws IOException {
	        StringBuilder sb = new StringBuilder();
	        int cp;
	        while ((cp = rd.read()) != -1) {
	            sb.append((char) cp);
	        }
	        return sb.toString();
	    }

}
