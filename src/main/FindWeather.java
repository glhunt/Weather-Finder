package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;




public class FindWeather {

	public String getWeather(String city) throws JSONException{
	String result = "";	
	try {

	    URL url = new URL(createURL(city));
	    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			 
            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
 
                InputStreamReader inputStreamReader =
                    new InputStreamReader(httpURLConnection.getInputStream());
                BufferedReader bufferedReader =
                    new BufferedReader(inputStreamReader, 8192);
                String line = null;
                while((line = bufferedReader.readLine()) != null){
                    result += line;
                }
                 
                bufferedReader.close();
                
		JSONObject main = new JSONObject(result);
			
		Double temp = main.getJSONObject("main").getDouble("temp");			
		
		return temp.toString();
            }
        } catch (IOException e) {

	    e.printStackTrace();

	}
	return result;
		
	}
	
	private String createURL (String city) throws MalformedURLException{
		//Remove anything other than letters from the city name
		city = city.replaceAll("[^\\p{Alpha}]","");
		return "http://api.openweathermap.org/data/2.5/weather?q="+ city + "&units=imperial&APPID=956f3adef63789decdb519880b98e6be";
	}
}
