1. 设备：磁盘、、内存、键盘、文件、网络控制台



2. 分类：字节流和字符流



3. 写操作

   ```java
   //文件的续写 
    FileWriter fWriter2 = null;
   
    try {
      fWriter2 = new FileWriter("test1.txt",true);
      fWriter2.write(" dada");
    } catch (IOException e) {			
      e.printStackTrace();
    } finally {
      if(fWriter2 != null) {
        try {
          fWriter2.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }			
    }
   ```



4. 读操作

   * 一次读取一个

   ```java
    FileReader fReader = new FileReader("test2.txt");
    //每次去读一个字符，返回int型，且每读完一次指针往后移动一位，读完后返回-1
    int value ;	  
    while((value = fReader.read()) != -1) {
      System.out.println((char)value);
    }
    fReader.close();
   ```

   ```java
    //一次读取多个
    FileReader fReader2 = new FileReader("test2.txt");
    char[] c = new char[2];
    int num ;  
    while ((num = fReader2.read(c)) != -1) {
      System.out.println(new String(c,0,num) + "   num:" + num);
    }
    fReader2.close();
   ```

   

5. 文档复制

   ```java
    FileReader fReader = new FileReader("test2.txt");
    FileWriter fWriter = new FileWriter("test3.txt",true);
   
    char[] c = new char[2];
    int num ;  
    while ((num = fReader.read(c)) != -1) {
        fWriter.write(c,0,num);     	   
    }
    fWriter.close(); 
    fReader.close();
   ```



6. 字符缓冲流（字符缓冲区）

   * 本身没有读写的功能，但可以提高读写效率
   * 装饰设计模式：原有功能的基础上提供增强的功能

   ```java
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("text4copy.txt"));
    BufferedReader bufferedReader = new BufferedReader(new FileReader("text4.txt"));
   
    String data = null;
    while ((data = bufferedReader.readLine()) != null) {
       bufferedWriter.write(data);
       bufferedWriter.newLine();  //跨平台换行
   }
   
    bufferedWriter.close();
    bufferedReader.close();
   ```

   

7. 适配器模式

   * 中间类实现所有接口，子类继承中间类，重写父类方法

8. 字节缓冲流

   ```java
   public static void write() throws IOException {
     FileOutputStream fileOutputStream = new FileOutputStream("test5.txt");
     fileOutputStream.write("bingbing".getBytes());
     fileOutputStream.close();
   }
   
   //one byte
   public static void read1() throws IOException {
     FileInputStream fileInputStream = new FileInputStream("test5.txt");
     int num = 0;
     while((num = fileInputStream.read()) != -1) {
       System.out.println((char)num);
     }
     fileInputStream.close();
   
   }
   
   //sevearl bytes
   public static void read2() throws IOException {
     FileInputStream fileInputStream = new FileInputStream("test5.txt");
     byte[] arr = new byte[3];
     int num = 0;
     while((num = fileInputStream.read(arr)) != -1) {
       System.out.print(new String(arr,0,num));
     }
     fileInputStream.close();
   }
   
   //all bytes
   public static void read3() throws IOException {
     FileInputStream fileInputStream = new FileInputStream("test5.txt");
     int value = fileInputStream.available(); //获取总字节数
     byte[] arr = new byte[value];
     fileInputStream.read(arr);
     System.out.println(new String(arr));
     fileInputStream.close();
   }
   ```

   