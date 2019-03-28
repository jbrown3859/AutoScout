import javax.json.*; //https://docs.oracle.com/javaee/7/api/javax/json/package-summary.html

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class scouter /*implements 2019Scouting*/ {
	

	private final String USER_AGENT = "Mozilla/5.0";
	private int matchNum = 0;
	private String eventCode = "CAAV";
	private String authCode = "amJyb3duMzg1OTpCMjJDQUUzQy0xNkNGLTQwMzEtOTk3NC0wRDYwNEJGOEVBRTc=";
	private URL url="https://frc-api.firstinspires.org";
	private URLBuilder build=new URLBuilder();
	private JsonObject

	public static void main(String[] args) {
		build.addDiv(eventCode).addParam("matchNumber",matchNum);
		url=build.getURLType();
	}
	public void GET(int m) throws Exception {
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	}public void GET() throws Exception {this.GET(matchNum);}






	public void setMatch(int m) {matchNum=m;}
	public void setEventCode(String code) {eventCode=code;}
	public void setAuth(String code) {authCode=code;}






}