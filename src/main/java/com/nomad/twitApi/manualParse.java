package com.nomad.twitApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.io.InputStream;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509ExtendedTrustManager;

import org.apache.tomcat.util.http.fileupload.IOUtils;

public class manualParse {
	public static void main( String [] args) throws IOException {
		 
         TrustManager[] trustAllCerts = new TrustManager[]{
             new X509ExtendedTrustManager() {
                 @Override
                 public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                     return null;
                 }

                 @Override
                 public void checkClientTrusted(X509Certificate[] certs, String authType) {
                 }

                 @Override
                 public void checkServerTrusted(X509Certificate[] certs, String authType) {
                 }

                 @Override
                 public void checkClientTrusted(X509Certificate[] xcs, String string, Socket socket) throws CertificateException {

                 }

                 @Override
                 public void checkServerTrusted(X509Certificate[] xcs, String string, Socket socket) throws CertificateException {

                 }

                 @Override
                 public void checkClientTrusted(X509Certificate[] xcs, String string, SSLEngine ssle) throws CertificateException {

                 }

                 @Override
                 public void checkServerTrusted(X509Certificate[] xcs, String string, SSLEngine ssle) throws CertificateException {

                 }

             }
         };

        SSLContext sc;
		try {
			sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
         

         // Create all-trusting host name verifier
         HostnameVerifier allHostsValid = new HostnameVerifier() {
             @Override
             public boolean verify(String hostname, SSLSession session) {
                 return true;
             }
         };
         // Install the all-trusting host verifier
         HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
         
		
		
		getFollowers("");
		System.out.println("ended!!!!!!!!!!!!");
	}
	public static void getFollowers(String username) throws IOException {
		URL url = new URL("https://twitter.com/elonmusk/followers");
        URLConnection con = url.openConnection();
        //Reader reader = new ImageStreamReader(con.getInputStream());

        InputStream is = new URL(url.toString()).openStream();
        Charset cs=Charset.forName("UTF-8");
        String res= convert(is,cs);
        System.out.println(res);
	}

public static String convert(InputStream inputStream, Charset charset) throws IOException {
 
	StringBuilder stringBuilder = new StringBuilder();
	String line = null;
	
	try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, charset))) {	
		while ((line = bufferedReader.readLine()) != null) {
			stringBuilder.append(line);
		}
	}
 
	return stringBuilder.toString();
}
}
