package com.qianfeng.zyHomework;

import java.util.Scanner;

public class zy {

	public static void main(String[] args) {
		// 初始化数据
		OperationImpl phoneBook = new OperationImpl();
		PhoneBook.getInstance().setPhoneBook(phoneBook);
		PhoneBook.getInstance().setLinkMans(new LinkMan[20]);
		
		LinkMan linkMan1 = new LinkMan("mayun", 55, "male", "13800138000");
		LinkMan linkMan2 = new LinkMan("mahuateng", 48, "male", "1399999999");
		LinkMan linkMan3 = new LinkMan("chenglong", 66, "male", "13812345678");
		LinkMan linkMan4 = new LinkMan("bingbing", 37, "female", "13987654321");
		
		PhoneBook.addLinkMan(linkMan1);
		PhoneBook.addLinkMan(linkMan2);
		PhoneBook.addLinkMan(linkMan3);
		PhoneBook.addLinkMan(linkMan4);

		// 用户操作
		boolean flag = true;
		Scanner scanner = new Scanner(System.in);
		Scanner s = new Scanner(System.in);
		while (flag) {
			printInfo();
			if(scanner.hasNextInt()) {
				String name="", sex="", phone="";
				int age=0;
				int input = scanner.nextInt();
				switch (input) {
				case 1:
					System.out.print("输入名字：");
					name = s.nextLine();
					System.out.println("名字："+name);
					System.out.print("输入性别：");
					sex = s.nextLine();
					System.out.println("性别："+sex);
					System.out.print("输入年龄：");
					age = s.nextInt();
					s.nextLine();
					System.out.println("年龄："+age);
					System.out.print("输入手机号码：");
					phone = s.nextLine();
					LinkMan linkMan = new LinkMan(name, age, sex, phone);
					PhoneBook.addLinkMan(linkMan);
					break;
				case 2:
					System.out.println("输入名字：");
					name = s.nextLine();
					PhoneBook.deleteLinkManByName(name);
					break;
				case 3:
					System.out.println("输入联系号码：");
					name = s.nextLine();
					PhoneBook.deleteLinkManByNumber(name);
					break;
				case 4:
					System.out.println("输入名字：");
					name = s.nextLine();
					System.out.println("输入联系号码：");
					phone = s.nextLine();
					PhoneBook.setLinkMan(name, phone);
					break;
				case 5:
					System.out.println("输入名字：");
					name = s.nextLine();
					PhoneBook.searchLinkMan(name);
					break;
				case 6:
					PhoneBook.searchAll();
					break;
				default:
					flag = false;
					break;
				}
			}else {
				flag = false;
			}
		}
		s.close();
		scanner.close();
	}

	public static void printInfo() {
		System.out.println("-----------------");
		System.out.println("1、添加联系人");
		System.out.println("2、按姓名删除联系人");
		System.out.println("3、按联系号码删除联系人");
		System.out.println("4、按姓名修改联系人号码");
		System.out.println("5、按姓名查询联系人");
		System.out.println("6、查询所有联系人");
		System.out.println("7、退出");
		System.out.print("-->请输入：");
	}
	
	
}
