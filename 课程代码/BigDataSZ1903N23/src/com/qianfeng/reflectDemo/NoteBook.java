package com.qianfeng.reflectDemo;

public class NoteBook {
	public void run() {
		System.out.println("运行笔记本");
	}
	public void useMouse(USB mouse) {//多态
		mouse.startUse();
		mouse.endUse();
	}
}
