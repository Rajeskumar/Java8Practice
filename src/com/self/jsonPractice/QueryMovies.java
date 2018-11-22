/**
 * 
 */
package com.self.jsonPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Rajeshkumar
 *
 */
public class QueryMovies {
	
	public static String srchStr = "";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		srchStr = in.nextLine();
		ArrayList<String> output = new ArrayList<>();
		
		String result = queryMovie(srchStr, 1);
		JSONObject jsobj;
		int totalPages = 0;
		try {
			jsobj = new JSONObject(result);
			totalPages = jsobj.getInt("total_pages");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		processMovieResult(result,output);
		
		for(int j=2;j<=totalPages;j++) {
			processMovieResult(queryMovie(srchStr, j), output);
		}

		Collections.sort(output);
		output.forEach(str -> System.out.println(str));
	}
	
	/**
	 * Method to process movie result json fetched from REST call.
	 * @param result
	 * @param output 
	 */
	private static void processMovieResult(String result, ArrayList<String> output) {
		
		
		//Convert to Json object
		try {
			JSONObject jsobj = new JSONObject(result);
			
			JSONArray data = jsobj.getJSONArray("data");
			
			for(int i=0;i<data.length();i++) {
				JSONObject movieObject = data.getJSONObject(i);
				output.add(movieObject.getString("Title"));
			}
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * Method to query the movie database with REST call and get the Json result string.
	 * @param srchStr
	 * @param pageNo
	 * @return
	 */
	public static String queryMovie(String srchStr, int pageNo) {
		
		
		StringBuilder sb = new StringBuilder();
		
		try {
			String restUrl = "https://jsonmock.hackerrank.com/api/movies/search/?Title="+URLEncoder.encode(srchStr, "UTF-8")
			+"&page="+pageNo;
			URL url = new URL(restUrl);
			
			URLConnection conn = url.openConnection();
			
			InputStream in = conn.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));
			
		    int cp;
		    while ((cp = rd.read()) != -1) {
		      sb.append((char) cp);
		    }
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sb.toString();
	}

}
