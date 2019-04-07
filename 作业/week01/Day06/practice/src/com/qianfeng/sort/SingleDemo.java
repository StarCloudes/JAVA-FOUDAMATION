package com.qianfeng.sort;

class Single{
    //类加载进来，没有对象，只有调用了getInstance方法时，才会创建对象
    //延迟加载形式
    private static Single s = null;
    private Single(){}
    public static Single getInstance(){
        if(s == null)
            s = new Single();
        return s ;
    }
}

class SingleDemo{
    public static void main(String[] args){
        Single s1 = Single.getInstance();
        Single s2 = Single. getInstance();
        System.out.println(s1 == s2);
        

    }
}
