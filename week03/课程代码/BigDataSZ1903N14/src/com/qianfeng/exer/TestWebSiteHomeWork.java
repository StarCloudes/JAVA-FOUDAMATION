package com.qianfeng.exer;



public class TestWebSiteHomeWork {
	public static void main(String[] args) {
		String string = "http://www.163.com:6/fd/ds/fds?name=bingbing&sex=boy&age=33";
		GetInformation g = new GetInformation();
		g.setUrl(string);
		g.ifWebSite();
		
	}
	
}


