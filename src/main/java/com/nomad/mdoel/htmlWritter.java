package com.nomad.mdoel;

public class htmlWritter {
	public static String StringInHtml(String body,String header,String title) {
		String resp = "",bodyList="";
		
		String form="<form action=/getMutualUser>\r\n" +  //getMutualUser//findMutual
				"  User1 id:<br>\r\n" + 
				"  <input type=\"text\" name=\"user1\" value=\"vikrant654\"><br>\r\n" + 
				"  User2 id:<br>\r\n" + 
				"  <input type=\"text\" name=\"user2\" value=\"avinashdaman\">\r\n" + 
				"<input type=\"submit\" value=\"Submit\">"+
				"</form>";
		for(String i : body.replace("[","").replace("]","").split(",")) {
			bodyList+="  <li>"+i+"</li>\r\n" ;
		}
		resp+="<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<title>"+title+"</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"\r\n" + 
				"<h1>"+header+"</h1>\r\n" + 
				"<p>"+
				form+
				"<ol>\r\n" + 
				bodyList+ 
				"</ol>"+"</p>\r\n" + 
				"\r\n" + 
				"</body>\r\n" + 
				"</html>";
	return resp;
	}
}
