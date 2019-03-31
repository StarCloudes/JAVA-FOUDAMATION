package com.practive.code;

interface Inter2{
    void show1();
    void show2();
}

/*
通常的使用场景之一：
当函数参数是接口类型时，而且接口中的方法不超过三个。
可以用匿名内部类作为实际参数进行传递。
*/
class InnerClassDemo2{
    public static void main(String[] args){
        show(new Inter2(){
            public void show1(){
                System.out.println("...show1..." );
            }
            public void show2(){
                System.out.println("...show2..." );
            }
        });
    }
    public static void show(Inter2 in){
        in.show1();
        in.show2();
    }
}