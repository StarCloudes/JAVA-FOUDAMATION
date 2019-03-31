package com.qianfeng.zyHomework;

public interface Operation {
	
	// 添加联系人
	public abstract LinkMan[] addLinkMan(LinkMan linkMan, LinkMan[] linkMans);
	// 按姓名删除联系人
	public abstract LinkMan[] deleteLinkManByName(String name, LinkMan[] linkMans);
	// 按联系号码删除联系人
	public abstract LinkMan[] deleteLinkManByNumber(String Num, LinkMan[] linkMans);
	// 按姓名修改联系人号码
	public abstract LinkMan[] setLinkMan(String name, String number, LinkMan[] linkMans);
	// 按姓名查询联系人
	public abstract LinkMan searchLinkMan(String name, LinkMan[] linkMans);
	// 查询所有联系人
	public abstract void searchAll(LinkMan[] linkMans);

}

