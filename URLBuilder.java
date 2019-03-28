import javax.json.*; //https://docs.oracle.com/javaee/7/api/javax/json/package-summary.html

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLBuilder {
	private String url  ="";
	private int paramNum = 0;

	public URLBuilder(String base) {
		url+=base;
	}
	public URLBuilder() {
		this("https://frc-api.firstinspires.org/v2.0/2019/matches");
	}
	public String getURL() {
		return url;
	}
	public URL getURLType() {
		return new URL(url);
	}
	public URLBuilder addDiv(String div) {
		url+="/"+div;
		return this;
	}
	public URLBuilder addParam(String paramName, String val) {
		paramNum++;
		url+=(paramNum==0) ? ("?"+paramName+"="+val) : ("&"+paramName+"="+val);
		return this;
	}






}