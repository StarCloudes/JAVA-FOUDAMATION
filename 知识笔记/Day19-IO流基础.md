1. IO流

   * 设备：磁盘、、内存、键盘、文件、网络控制台

   * 分类：字节流和字符流

   ```
   * 分类:
   * 根据操作的方式:输入流和输出流
   * 根据数据的类型:字节流和字符流
   * 
   * 字节流:传输的是字节,可以操作任意类型的数据     ------音频,视频,文件,图片等
   * 字符流:传输的是字节,不同点是在传输过程中加入了编码的操作,让我们的操作更方便------文本
   
   * 因内存为参考
   * 字节流:
   * 字节输入流:InputStream
   * 字节输出流:OutputStream
   * 
   * 字符流的两个父类:
   * 字符读入流(将数据输入内存):Reader
   * 字符写出流(将数据从内存取出):Writer
   ```

   ```java
   //1.创建FileWriter的对象并关联对应的文件
   //注意点:
   //一:如果只写文件的名字,不写具体路径,默认路径是当前的工程
   //二:对于关联的文件,如果之前不存在,程序会自动创建一个,如果存在,会将原来的内容覆盖
   //三:可以自己指定路径,但是必须保证路径是真实存在的,否则报异常---FileNotFountException(系统找不到指定的路径。)
   FileWriter fileWriter = new FileWriter("test1.txt");
   //调用写入方法
   //四:在执行write方法时,数据被临时放到了流对象的内部数组中,这个数组是一个字节数组,会默认去查编码表
   fileWriter.write("晨晨");
   //刷新---将临时数组中的数据放入磁盘
   //fileWriter.flush();
   //4.关闭流--两个功能:a:关闭流  b:刷新
   //第五个注意点:流对象使用完后必须关闭
   fileWriter.close();
   //第六个注意点:当流对象关闭之后,不能再进行操作,否则会报异常:Stream closed
   //fileWriter.write("haha");
   ```

   

2. 写操作

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

3. 读操作

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

4. 文档复制

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

5. 字符缓冲流（字符缓冲区）

   * 本身没有读写的功能，但可以提高读写效率
   * 装饰设计模式：原有功能的基础上提供增强的功能
   * readLine源码？？？

   ```java
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("text4copy.txt"));
    BufferedReader bufferedReader = new BufferedReader(new FileReader("text4.txt"));
   
    String data = null;
   //注意点:不会将当前的换行符返回 ;返回值就是我们读到的内容.如果读完了,返回null
    while ((data = bufferedReader.readLine()) != null) {
       bufferedWriter.write(data);
       bufferedWriter.newLine();  //跨平台换行
   }
   
    bufferedWriter.close();
    bufferedReader.close();
   ```

   * LineNumberReader:

     是BufferedReader的子类,不能读.但是可以提高效率,特有功能:设置行号,获取行号

   ​    

   ```java
   LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("Demo1.java"));
   //设置行号,默认从0开始,从1开始打印
   lineNumberReader.setLineNumber(10);
   String data = null;
   while ((data = lineNumberReader.readLine()) != null) {
     System.out.print(lineNumberReader.getLineNumber());//获取行号
     System.out.print(data);
     System.out.println();
   }
   lineNumberReader.close();
   ```

   

6. 适配器模式

   * 中间类实现所有接口，子类继承中间类，重写父类方法

7. 字节缓冲流

   ```java
   public static void write() throws IOException {
     FileOutputStream fileOutputStream = new FileOutputStream("test5.txt");
     fileOutputStream.write("bingbing".getBytes());//这里只能写字节,这里使用的默认编码
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

   

