package test;

import static org.junit.Assert.*;
import main.FindWeather;

import org.json.JSONException;
import org.junit.Test;

public class testWeather {

	@Test
	public void testGetWeather() throws JSONException{
		FindWeather testFindWeather = new FindWeather();
		assertTrue(testFindWeather.getWeather("Marion")!= null);
	}
	
	@Test
	public void testGetWeatherWithSpaceInCityName() throws JSONException{
		FindWeather testFindWeather = new FindWeather();
		assertTrue(testFindWeather.getWeather("Cedar Rapids")!= null);
	}
	
	@Test
	public void testGetWeatherWithNonLettersInCityName() throws JSONException{
		FindWeather testFindWeather = new FindWeather();
		assertTrue(testFindWeather.getWeather("Cedar678 Rapids")!= null);
	}
	@Test(expected=org.json.JSONException.class)
	public void testGetWeatherNoCityName() throws JSONException{
		FindWeather testFindWeather = new FindWeather();
		@SuppressWarnings("unused")
		String exception = testFindWeather.getWeather("");
	}
}