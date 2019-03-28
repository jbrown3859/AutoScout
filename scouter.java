import javax.json.*; //https://docs.oracle.com/javaee/7/api/javax/json/package-summary.html

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class scouter /*implements 2019Scouting*/ {
	
	/* FIELDS */
	private final String USER_AGENT = "Mozilla/5.0";
	private int matchNum = 0;
	private String eventCode = "CAAV";
	private String authCode = "amJyb3duMzg1OTpCMjJDQUUzQy0xNkNGLTQwMzEtOTk3NC0wRDYwNEJGOEVBRTc=";
	private URL url="https://frc-api.firstinspires.org";
	private URLBuilder build=new URLBuilder();
	private int responseCode=0;
	/* END FIELDS */
	
	
	public static void main(String[] args) {
		build.addDiv(eventCode).addParam("matchNumber",matchNum);
		url=build.getURLType();
	}
	
	// Send the GET Request //
	public void GET(int m) throws Exception {
		
		// Opening CONNECTION //
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		
		// Setting HEADERS //
		setHeader(connection,"Accept","application/json");
		setHeader(connection,"Authorization",authCode);
		setHeader(connection,"User-Agent",USER_AGENT);
		
		responseCode = connection.getResponseCode();

	}public void GET() throws Exception {this.GET(matchNum);}//auxiliary
	
	
	// Ease of access // 
	private void setHeader(HttpURLConnection con, String name, String val) {con.setRequestProperty(name,val);}

	// SET Methods //
	public void setMatch(int m) {matchNum=m;}
	public void setEventCode(String code) {eventCode=code;}
	public void setAuth(String code) {authCode=code;}
	
	// Accessor Methods //
	public int getResponseCode() {return responseCode;}
	public int getMatchNumber() {return matchNum;}
	public String getEventCode() {return eventCode;}
	public String getURL() {return url;}
	public URL getURLType() {return new URL(url);}


}