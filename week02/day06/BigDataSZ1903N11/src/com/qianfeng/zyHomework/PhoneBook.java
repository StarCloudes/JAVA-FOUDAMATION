package com.qianfeng.zyHomework;

public class PhoneBook {
	// 单例定义
	private static final PhoneBook phoneBookIns = new PhoneBook();

	private PhoneBook() {}

	public static PhoneBook getInstance() {
		return phoneBookIns;
	}

	/*
	 * 以下是方法区
	 */
	
	// 联系人列表
	private LinkMan[] linkMans;
	// 电话本的功能实现
	private Operation phoneBook;

	public LinkMan[] getLinkMans() {
		return linkMans;
	}

	public void setLinkMans(LinkMan[] linkMans) {
		this.linkMans = linkMans;
	}

	public Operation getPhoneBook() {
		return phoneBook;
	}

	public void setPhoneBook(Operation phoneBook) {
		this.phoneBook = phoneBook;
	}

	// 添加联系人
	public static LinkMan[] addLinkMan(LinkMan linkMan) {
		PhoneBook ins = getInstance();
		LinkMan[] lm = ins.phoneBook.addLinkMan(linkMan, ins.linkMans);
		ins.linkMans = lm;
		return lm;
	}

	// 按姓名删除联系人
	public static LinkMan[] deleteLinkManByName(String name) {
		PhoneBook ins = getInstance();
		LinkMan[] lm = ins.phoneBook.deleteLinkManByName(name, ins.linkMans);
		ins.linkMans = lm;
		return lm;
	};

	// 按联系号码删除联系人
	public static LinkMan[] deleteLinkManByNumber(String Num) {
		PhoneBook ins = getInstance();
		LinkMan[] lm = ins.phoneBook.deleteLinkManByNumber(Num, ins.linkMans);
		ins.linkMans = lm;
		return lm;
	}

	// 按姓名修改联系人号码
	public static LinkMan[] setLinkMan(String name, String number) {
		PhoneBook ins = getInstance();
		LinkMan[] lm = ins.phoneBook.setLinkMan(name, number, ins.linkMans);
		ins.linkMans = lm;
		return lm;
	};

	// 按姓名查询联系人
	public static LinkMan searchLinkMan(String name) {
		PhoneBook ins = getInstance();
		LinkMan lm = ins.phoneBook.searchLinkMan(name, ins.linkMans);
		return lm;
	};

	// 查询所有联系人
	public static void searchAll() {
		PhoneBook ins = getInstance();
		ins.phoneBook.searchAll(ins.linkMans);
	};

}
