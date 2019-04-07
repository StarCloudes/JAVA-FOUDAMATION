package com.qianfeng.sort;

class Fu{
    Fu(){
        //super();
        //调用的是子类的show方法，此时其成员变量num还未进行显示初始化
        show();
        //return;
    }
    void show(){
        System.out.println("fu show" );
    }
}
class Zi extends Fu{
    int num = 8;
    Zi(){
        //super();
        //通过super初始化父类内容时，子类的成员变量并未显示初始化，等super()父类初始化完毕后，才进行子类的成员变量显示初始化
        //return;
    }
    void show(){
        System.out.println("zi show..." + num);
    }
}
class ExtendDemo{
    public static void main(String[] args){
        Zi z = new Zi();
        z.show();
    }
}
