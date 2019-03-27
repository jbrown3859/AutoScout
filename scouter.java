import javax.json.*; //https://docs.oracle.com/javaee/7/api/javax/json/package-summary.html

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class scouter /*implements 2019Scouting*/ {
	

	private final String USER_AGENT = "Mozilla/5.0";
	private matchNum = 0;
	private eventCode = "CAAV";
	private String authCode = "amJyb3duMzg1OTpCMjJDQUUzQy0xNkNGLTQwMzEtOTk3NC0wRDYwNEJGOEVBRTc=";

	public static void main(String[] args) {
	
	}
	public void setMatch(int m) {
		matchNum=m;
	}
	public void setEventCode(String code) {
		eventCode=code;
	}
	public void setAuth(String code) {
		authCode=code;
	}






}