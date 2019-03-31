package com.practive.code;

class Fu{
    int num = 9;

    {
        System.out.println("Fu 0" );
    }

    Fu(){
        super();//Object
        //显示初始化
        //构造代码块初始化
        show();
    }
    void show(){
        System.out.println("fu show " + num);//被覆盖，运行子类的
    }
}

class Zi extends Fu{
    int num = 8;

    {
        System.out.println("Zi 1" );
    }

    Zi(){
        super();
        //显示初始化
        //构造代码块初始化
        show();
    }

    void show(){
        System.out.println("zi show " + num);
    }
}

public class BlcokCode{
    public static void main(String[] args){
        new Zi();
    }
}