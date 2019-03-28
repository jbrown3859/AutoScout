// import javax.json.JsonReader; //https://docs.oracle.com/javaee/7/api/javax/json/package-summary.html
import javax.json.*;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.*;
public class scouter /*implements 2019Scouting*/ {
	
	/* FIELDS */
	private final String USER_AGENT = "Mozilla/5.0";
	private int matchNum = 1;
	private String eventCode = "CALA";
	private String authCode = "amJyb3duMzg1OTpCMjJDQUUzQy0xNkNGLTQwMzEtOTk3NC0wRDYwNEJGOEVBRTc=";
	private String urls="https://frc-api.firstinspires.org";
	private URL url;
	private URLBuilder build=new URLBuilder();
	private int responseCode=0;
	private JsonObject MATCH;
	/* END FIELDS */
	
	// DONT TOUCH //
	public static void main(String[] args) throws Exception {scouter scout=new scouter();scout.begin();}
	//////////////////

	// Can now access non-static fields //
	public void begin() throws Exception {
		build.addDiv(eventCode).addParam("tournamentLevel","Qualification").addParam("matchNumber",matchNum);
		url=build.getURLType();
		//url=new URL("https://frc-api.firstinspires.org");
		GET();
	}


	// Send the GET Request //
	public void GET(int m) throws Exception {
		
		// Opening CONNECTION //
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		
		// Setting HEADERS //
		setHeader(connection,"Accept","application/json");
		setHeader(connection,"Authorization","Basic "+authCode);
		
		responseCode = connection.getResponseCode();
		System.out.println(responseCode);

		/* For getting string version
		*/
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(connection.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		/* Making response
		*/
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		// System.out.println(response);
		// RESPONSE is stringified JSON

		JsonReader jsonReader = Json.createReader(new StringReader(response.toString()));
		JsonObject obj = jsonReader.readObject();
		jsonReader.close();
		System.out.println(obj);

		MATCH=obj;
		/*
{
	"Matches":[{"actualStartTime":"2019-03-22T02:12:51.4666667",
		    "description":"Qualification 1",
		    "tournamentLevel":"Qualification",
		    "matchNumber":1,"scoreRedFinal":44,
		    "scoreRedFoul":0,
		    "scoreRedAuto":6,
		    "scoreBlueFinal":51,
		    "scoreBlueFoul":3,
		    "scoreBlueAuto":6,
		    "postResultTime":"2019-03-22T02:15:59.3266667",
		    "teams":[
			     {"teamNumber":5107,"station":"Red1","dq":false},
			     {"teamNumber":968,"station":"Red2","dq":false},
			     {"teamNumber":3309,"station":"Red3","dq":false},
			     {"teamNumber":589,"station":"Blue1","dq":false},
			     {"teamNumber":5634,"station":"Blue2","dq":false},
			     {"teamNumber":330,"station":"Blue3","dq":false}
			    ]}
		 ]
}

*/
	}public void GET() throws Exception {this.GET(matchNum);}//auxiliary
	
	
	// Ease of access // 
	private void setHeader(HttpURLConnection con, String name, String val) {con.setRequestProperty(name,val);}

	// SET Methods //
	public void setMatch(int m) {matchNum=m;}
	public void setEventCode(String code) {eventCode=code.toUpperCase();}
	public void setAuth(String code) {authCode=code;}
	
	// Accessor Methods //
	public int getResponseCode() {return responseCode;}
	public int getMatchNumber() {return matchNum;}
	public String getEventCode() {return eventCode;}
	public String getURL() {return urls;}
	public URL getURLType() {return url;}

	// ACCESSING JSON VALUES //
	//public int get


}