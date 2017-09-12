package com.dbe.urlvalidator.core;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dbe.urlvalidator.entity.Services;

public class URLValidatorMain {

	public static void main(String[] args) { //throws Exception {
		// TODO Auto-generated method stub
		//testURL();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		System.out.println("INÍCIO: " + dateFormat.format(date)); //2016/11/16 12:08:43
		
		System.out.println("main");
		try {
			new URLValidatorMain().URLTest();
			date = new Date();
			System.out.println("FIM: " + dateFormat.format(date)); //2016/11/16 12:08:43
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void URLTest() throws Exception {
		//String strUrl = "https://stackoverflow.com/tour"; 
	    		//"http://stackoverflow.com/about";
		String strUrl, printStr;
		Services srv;
		List<Services> lista = new ArrayList<>();
			
    	lista.add(new Services("TEST","TEST Validation","https://stackoverflow.com/tour"));
    	//PORTAL
    	lista.add(new Services("PORTAL","PORTAL DEV","http://ggportald.gerdau.net"));
    	lista.add(new Services("PORTAL","PORTAL QAS","https://ggportalq.gerdau.net/startPage"));
    	lista.add(new Services("PORTAL","PORTAL PRD","https://ggportal.gerdau.net/startPage"));
    	
    	//SMP
    	lista.add(new Services("SMP","SMP 45","http://ebsgerp45.gerdau.net/"));
    	lista.add(new Services("SMP","SMP 111","http://ebsgerp111.gerdau.net:8080/"));
    	lista.add(new Services("SMP","SMP 111","http://ebsgerp112.gerdau.net:8080/"));
    	
    	//FIORI
    	lista.add(new Services("FIORI","FIORI.com QAS","https://fioriq.gerdau.com/"));
    	lista.add(new Services("FIORI","FIORI.com PRD","https://fiori.gerdau.com/"));
    	lista.add(new Services("FIORI","FIORI.net QAS","https://fioriq.gerdau.net/"));
    	lista.add(new Services("FIORI","FIORI.net PRD","https://fiori.gerdau.net/"));

    	//CE
    	lista.add(new Services("CE","CE DEV","http://ced.gerdau.net/"));
    	lista.add(new Services("CE","CE QAS","https://ceq.gerdau.net/"));
    	lista.add(new Services("CE","CE PRD","https://ce.gerdau.net/"));
    	    	
    	for (int i = 0; i < lista.size(); i++) {
    		srv = lista.get(i);
    		//System.out.println(lista.get(i));
    		strUrl = srv.getServiceURL();
    		printStr = "URL " + strUrl; 
    	    try {
    	    	int httpCode = URLTestValidation(strUrl);
    	        
    	        if (httpCode == HttpURLConnection.HTTP_OK) {
    	        	System.out.println( printStr + " OK");
    	        } else {
    	        	System.err.println( printStr + " ERROR " + httpCode );
    	        }
    	        	
    	    } catch (IOException e) {
    	        System.err.println( printStr + "Error creating HTTP connection");
    	        System.err.println(e.getMessage());
    	        //e.printStackTrace();
    	        //throw e;
    	    } catch (AssertionError e1) {
    	    	System.err.println( printStr + "Assert Exception: Error creating HTTP connection");
    	    	System.err.println(e1.getMessage());
     	    }
    	    catch (Exception e2) {
    			// TODO: handle exception
    	    	System.err.println( printStr + "Exception: Error creating HTTP connection");
    	    	System.err.println(e2.getMessage());
    		}
    		
    	}

	}
	
	public int URLTestValidation(String strUrl) throws Exception {
		
		
		try {
			//System.out.println("Inicio");
			URL url = new URL(strUrl);
			HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
			urlConn.connect();

			// System.out.println("urlConn.getResponseCode():"+urlConn.getResponseCode());
			//assertEquals(HttpURLConnection.HTTP_OK, urlConn.getResponseCode());
			//if (urlConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
			//	System.out.println("URL " + url + " OK");
			//}
			return urlConn.getResponseCode();
/*		} catch (IOException e) {
			System.err.println("Error creating HTTP connection");
			e.printStackTrace();
			throw e;
		} catch (AssertionError e1) {
			System.err.println("Assert Exception: Error creating HTTP connection");
			System.err.println(e1.getMessage());
*/		} catch (Exception e2) {
			// TODO: handle exception
			//System.err.println("Exception: Error creating HTTP connection");
			//System.err.println(e2.getMessage());
			throw e2;
		}
		//return 0;

	}

}
