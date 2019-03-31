package com.qianfeng.zyHomework;

/// 电话本操作实现类
public class OperationImpl implements Operation {

	@Override
	public LinkMan[] addLinkMan(LinkMan linkMan, LinkMan[] linkMans) {
		if (linkMan != null && linkMans != null) {
			for (int i = 0; i < linkMans.length; i++) {
				if(linkMans[i] == null) {
					linkMans[i] = linkMan;
					System.out.println(linkMans[i].toString());
					break;
				}
			}
		}
		return linkMans;
	}

	@Override
	public LinkMan[] deleteLinkManByName(String name, LinkMan[] linkMans) {
		if (name != null && linkMans != null) {
			boolean isFind = false;
			for (int i = 0; i < linkMans.length; i++) {
				if(linkMans[i] == null)
					break;
				if (name.equals(linkMans[i].getName())) {
					isFind = true;
				}
				if (isFind) {
					linkMans[i] = linkMans[i + 1];
				}
			}
		}
		return linkMans;
	}

	@Override
	public LinkMan[] deleteLinkManByNumber(String Num, LinkMan[] linkMans) {
		if (Num != null && linkMans != null) {
			boolean isFind = false;
			for (int i = 0; i < linkMans.length; i++) {
				if(linkMans[i] == null)
					break;
				if (Num.equals(linkMans[i].getPhoneNum())) {
					isFind = true;
				}
				if (isFind) {
					linkMans[i] = linkMans[i + 1];
				}
			}
		}
		return linkMans;
	}

	@Override
	public LinkMan[] setLinkMan(String name, String number, LinkMan[] linkMans) {
		if (name != null && number != null && linkMans != null) {
			for (int i = 0; i < linkMans.length; i++) {
				if(linkMans[i] == null)
					break;
				if (name.equals(linkMans[i].getName())) {
					linkMans[i].setPhoneNum(number);
					System.out.println(linkMans[i].toString());
					break;
				}
			}
		}
		return linkMans;
	}

	@Override
	public LinkMan searchLinkMan(String name, LinkMan[] linkMans) {
		if (name != null && linkMans != null) {
			for (int i = 0; i < linkMans.length; i++) {
				if(linkMans[i] == null)
					break;
				if (name.equals(linkMans[i].getName())) {
					System.out.println(linkMans[i].toString());
					return linkMans[i];
				}
			}
		}
		return null;
	}

	@Override
	public void searchAll(LinkMan[] linkMans) {
		if (linkMans != null) {
			for (int i = 0; i < linkMans.length; i++) {
				if (linkMans[i] == null) {
					break;
				}
				System.out.println(linkMans[i].toString());
			}
		}
	}

}
