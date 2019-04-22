package com.callback.persentation;

//这样做的好处是什么呢？最显著的一点即是分离方法与具体实现，让调用者与被调者解耦合。
public interface Callback {  // 回调方法
	public void backResult(String result);
}

//假设总经理出差前交了件事情给我去办，不巧……副总经理也要给我件事去办，更可怕的是……主管也发任务过来了，
//都要求说做完就打电话通知他们……这时我们就要定义更多类，什么总经理类啦、副经理类啦、主管类啦、杂七杂八的类，
//但是这些大大们都要求做完事情就电话通知，每个类都会有一个类似phoneCall的方法作为回调方法，这时，
//我们利用面向对象的思想来看，是不是可以把这个回调方法抽象出来作为一个独立的抽象类或接口呢？
//借由多态思想，使用JAVA接口，我们就可以定义一个名为CallBack的接口作为回调接口，再在该接口下
//定义一个名为backResult的抽象方法作为回调方法，让那些总经理类啦、经理类啦、主管类啦、什么的都去实现该接口