package com.dbe.urlvalidator.core;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.dbe.urlvalidator.entity.Services;
import com.dbe.urlvalidator.util.UrlValidatorUtil;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class URLValidatorMain {

	public static void main(String[] args) { //throws Exception {
		// TODO Auto-generated method stub
		//testURL();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		System.out.println("INÍCIO: " + dateFormat.format(date)); //2016/11/16 12:08:43
		long startTime = System.currentTimeMillis();

		System.out.println("main");
		try {
			new URLValidatorMain().URLTest();
			new URLValidatorMain().getUptimeApiData();
			// OK - new URLValidatorMain().ReadinTXTFile();
			Date dateFim = new Date();
			System.out.println("FIM: " + dateFormat.format(dateFim)); //2016/11/16 12:08:43
			long elapsed = System.currentTimeMillis() - startTime;
			//System.out.println("TEMPO GASTO: " + UrlValidatorUtil.convertSecondsToHMmSs(endTime - startTime));
			DateFormat df = new SimpleDateFormat("HH 'hours', mm 'mins,' ss 'seconds'");
			df.setTimeZone(TimeZone.getTimeZone("GMT+0"));
			System.out.println("TEMPO GASTO: " + df.format(new Date(elapsed)));
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

	public void getUptimeApiData() {
		
		OkHttpClient client = new OkHttpClient();
		 
		//MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		//MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded; charset=ISO-8859-1");
		//MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded; charset=windows-1251");
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
		//MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
		//MediaType mediaType = MediaType.parse("application/json; charset=ISO-8859-1");
		RequestBody body = RequestBody.create(mediaType, "api_key=u220363-f1c63a7c374556cf0d293a1b&format=json&logs=1");
		Request request = new Request.Builder()
		  .url("https://api.uptimerobot.com/v2/getMonitors")
		  .post(body)
		  .addHeader("content-type", mediaType.toString())
		  .addHeader("cache-control", "no-cache")
		  .build();

		//.addHeader("content-type", "application/x-www-form-urlencoded")
		try {
			Response response = client.newCall(request).execute();
			System.out.println("UPTIME - getMonitors:"+ response.toString() );
			//System.out.println("UPTIME - BODY:" + response.body().string() );
			//TODO : melhorar o response
			getJsonResponse(response.body().string());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void getJsonResponse(String str) {
		//String utString;
		JSONObject jObject;
		//Formatter fmt = new Formatter();
		String format = "|%1$-30s|%2$-10s|%3$-30s|\n";
		System.out.format(format,"NOME","STATUS","DURAÇÃO");
		try {
			jObject = new JSONObject(str);
			//JSONObject data = jObject.getJSONObject("data"); // get data object
			//String projectname = data.getString("name"); // get the name from data.
            JSONArray jsonPersonData = (JSONArray) jObject.get("monitors");
            for (int i=0; i<jsonPersonData.length(); i++) {
                JSONObject item = jsonPersonData.getJSONObject(i);
                String name = item.getString("friendly_name");
                Integer status = item.getInt("status");
                //System.out.println(name+ " /STATUS:" + UrlValidatorUtil.getUTStatus(status));
                //utString = name+ " /STATUS:" + UrlValidatorUtil.getUTStatus(status);
                //pegando tempo do status
                JSONArray jsonLogs = (JSONArray) item.get("logs");
                JSONObject itemLog = jsonLogs.getJSONObject(0);
                Integer logDuaration = itemLog.getInt("duration");
                //utString += " /Duração: " + UrlValidatorUtil.getLogDuration(logDuaration);
                //System.out.println(utString);
                System.out.format(format,name,UrlValidatorUtil.getUTStatus(status),UrlValidatorUtil.getLogDuration(logDuaration));
            }	            
	        
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Usando simple 
	 */
	/*public void ReadinTXTFile() {
		 	JSONObject monitor = null;
	        JSONParser parser = new JSONParser();

	        try {

	            Object obj = parser.parse(new FileReader("C:\\Users\\rhbisterco\\Downloads\\data.json"));

	            JSONObject jsonObject = (JSONObject) obj;
	            System.out.println(jsonObject);

	            // loop array
	            JSONArray msg = (JSONArray) jsonObject.get("monitors");
	            //Iterator<String> iterator = msg.iterator();
	            Iterator<Object> iterator = msg.iterator();
	            while (iterator.hasNext()) {
	                //System.out.println(iterator.next());
	            	monitor = (JSONObject) iterator.next();
	            	System.out.println(monitor.get("friendly_name")+ "/STATUS:" + monitor.get("status"));

	            }

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        //} catch (ParseException e) {
	        //    e.printStackTrace();
	        } catch (org.json.simple.parser.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    }
	*/
	
	
}
