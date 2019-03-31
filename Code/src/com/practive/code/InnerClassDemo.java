package com.practive.code;

interface Inter{
    void show1();
    void show2();
}

class Outer{
    public void method(){
        Inter in = new Inter(){
            public void show1(){
                System.out.println("...show1...." );
            }
            public void show2(){
                System.out.println("...show2...." );
            }
        };
        in.show1();
        in.show2();
    }
}

class InnerClassDemo{
    public static void main(String[] args){
        new Outer().method();
    }
}