package com.exam.homework22;

public class Demo7 {
    public static void main(String[] args){
        C c=new C();
        A1 a1=new A1(c);
        B1 b1=new B1(c);
        a1.start();
        b1.start();
    }
}

class A1 extends Thread{
    C c;

    public A1(C c) {
        super();
        this.c = c;
    }

    public A1() {
        super();
    }
    
    public void run() {
        synchronized (c) {
            for(int i=1;i<11;i++){
                if(c.flag==true){
                    try {
                        c.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                c.print(i);
                c.flag=true;
                c.notify();
            }
        }

    }

}
class B1 extends Thread{
    C c;

    public B1(C c) {
        super();
        this.c = c;
    }

    public B1() {
        super();
    }
    
    public void run() {
        synchronized (c) {
            for(int i=10;i>0;i--){
                if(c.flag==false){
                    try {
                        c.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                c.print(i);
                c.flag=false;
                c.notify();
            }

        }

    }
}
class C {
    boolean flag=false;

    public void print(int i){
        System.out.print(i+",");
    }
}
