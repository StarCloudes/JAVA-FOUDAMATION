package com.classroom.homework17;
//多线程的实现方案二：实现Runnable接口
//1、定义类实现Runnable接口。
class MyThread implements Runnable {
  // 2、覆盖接口中的run方法，将线程的任务代码封装到run方法中。
  public void run() {
      show();
  }

  public void show() {
      for (int x = 0; x < 5; x++) {
          System.out.println(Thread.currentThread().getName() + "..." + x);
      }
  }
}

class Demo2 {
  public static void main(String[] args) {
      MyThread d = new MyThread();
      // 3、通过Thread类创建线程对象，并将Runnable接口的子类对象作为Thread类的构造函数的参数进行传递。
      Thread t1 = new Thread(d);
      Thread t2 = new Thread(d);
      // 4、调用线程对象的start方法开启线程。
      t1.start();
      t2.start();
  }
}