package com.qianfeng.exer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetInformation{
	private String s;
	private  String port = "80";
	public void setUrl(String s) {
		this.s = s;
	}
	public void ifWebSite() {
		String regex = "^(((http|https)://)|(www\\.))+[a-zA-Z0-9\\._-]+\\.([a-zA-Z]{2,6})((:[0-9]{2,5})?/[a-zA-Z0-9\\&%_\\./-~-]*)?$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		boolean r = m.find();
		if(r == true) {
			System.out.println("=========网址输入正确==========");
			getPort();
			getSearch();
		}else {
			System.out.println("===========你输入的不是一个网址========");
		}
	}
	public void getPort() {
//		int i = 0;
//		
//		i = s.indexOf(":");
//		if(i != -1) {
//			String[] str = s.substring(i+1).split("/");
//			port= str[1];
//			System.out.println("该网站端口号为："+port);
//		}else {
//			System.out.println("默认端口号为："+port);
//		}
		char[] c = s.toCharArray();
		String str = "";
		boolean flag = false;
		for(int i = 0;i<c.length;i++) {
			if(c[i] == ':') {
				if(Character.isDigit(c[i+1])) {
					flag = true;
					for(int j = i+1;j < c.length;j++) {
						if(Character.isDigit(c[j])) {
							str += c[j];
						}else {
							break;
						}
					}
				}
			}
		}
		if(flag == true) {
			System.out.println("该网站端口号为："+str);
		}else {
			System.out.println("默认端口号为："+port);
		}
		
	}
	public void getSearch() {
		if(s.contains("?")) {
			String[] str = s.split("\\?")[1].split("&");
			for(int i = 0;i<str.length;i++) {
				System.out.println("第"+(i+1)+"条查询条件:"+str[i]);
			}
		}else {
			System.out.println("没找到查询条件！！！");
		}
	}
}

