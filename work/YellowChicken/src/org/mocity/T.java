package org.mocity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class T {
    public static void main(String[] ath){

    	StringBuffer document = new StringBuffer();
		try{
			URL url = new URL("http://api.simsimi.com/request.p?key=8928e596-02d8-4029-a765-d64795072da4&lc=ch&ft=1.0&text=你好");//远程url
			URLConnection conn = url.openConnection();
		    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		    String line = null;
		    while ((line = reader.readLine()) != null)
		       document.append(line + " ");
		    reader.close();
		}catch(MalformedURLException e) {
			e.printStackTrace(); 
		}catch(IOException e){
		    e.printStackTrace(); 
		}
		String xml = document.toString();//返回值
		System.out.println(xml);
    }
}
