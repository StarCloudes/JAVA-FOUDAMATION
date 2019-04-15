1. IO流

   * 大多数应用程序都需要实现与设备之间的数据传输，例如键盘可以输入数据，显示器可以显示程序的运行结果等。在Java中，将这种通过不同输入输出设备(键盘，内存，显示器，网络等)之间的数据传输抽象表述为“流”，程序允许通过流的方式与输入输出设备进行数据传输。Java中的“流”都位于java.io包中，称为IO(输入输出)流。
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
   //为了在finally里面能够看到该对象就必须定义到外面，为了访问不出问题，还必须给初始化值
    try {
      fWriter2 = new FileWriter("test1.txt",true);
      fWriter2.write(" dada");
    } catch (IOException e) {			
      e.printStackTrace();
    } finally {
      if(fWriter2 != null) {  // 如果fos不是null，才需要close()
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

   ```java
   /*
    * 需求：把e:\\a.mp4复制到当前项目目录下的b.mp4中
    *
    * 字节流四种方式复制文件：
    * 基本字节流一次读写一个字节：    共耗时：117235毫秒
    * 基本字节流一次读写一个字节数组： 共耗时：156毫秒
    * 高效字节流一次读写一个字节： 共耗时：1141毫秒
    * 高效字节流一次读写一个字节数组： 共耗时：47毫秒
    */
   public class CopyMp4Demo {
       public static void main(String[] args) throws IOException {
           long start = System.currentTimeMillis();
           // method1("e:\\a.mp4", "copy1.mp4");
           // method2("e:\\a.mp4", "copy2.mp4");
           // method3("e:\\a.mp4", "copy3.mp4");
           method4("e:\\a.mp4", "copy4.mp4");
           long end = System.currentTimeMillis();
           System.out.println("共耗时：" + (end - start) + "毫秒");
       }
   
       // 高效字节流一次读写一个字节数组：
       public static void method4(String srcString, String destString)
               throws IOException {
           BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
                   srcString));
           BufferedOutputStream bos = new BufferedOutputStream(
                   new FileOutputStream(destString));
   
           byte[] bys = new byte[1024];
           int len = 0;
           while ((len = bis.read(bys)) != -1) {
               bos.write(bys, 0, len);
           }
   
           bos.close();
           bis.close();
       }
   
       // 高效字节流一次读写一个字节：
       public static void method3(String srcString, String destString)
               throws IOException {
           BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
                   srcString));
           BufferedOutputStream bos = new BufferedOutputStream(
                   new FileOutputStream(destString));
   
           int by = 0;
           while ((by = bis.read()) != -1) {
               bos.write(by);
   
           }
   
           bos.close();
           bis.close();
       }
   
       // 基本字节流一次读写一个字节数组
       public static void method2(String srcString, String destString)
               throws IOException {
           FileInputStream fis = new FileInputStream(srcString);
           FileOutputStream fos = new FileOutputStream(destString);
   
           byte[] bys = new byte[1024];
           int len = 0;
           while ((len = fis.read(bys)) != -1) {
               fos.write(bys, 0, len);
           }
   
           fos.close();
           fis.close();
       }
   
       // 基本字节流一次读写一个字节
       public static void method1(String srcString, String destString)
               throws IOException {
           FileInputStream fis = new FileInputStream(srcString);
           FileOutputStream fos = new FileOutputStream(destString);
   
           int by = 0;
           while ((by = fis.read()) != -1) {
               fos.write(by);
           }
   
           fos.close();
           fis.close();
       }
   }
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

   ```java
   /**
    * 模拟记事本程序
    */
   public class Notepad {
       private static String filePath;
       private static String message = "";
       public static void main(String[] args) throws Exception {
           Scanner sc = new Scanner(System.in);
           System.out.println("--1:新建文件 2:打开文件  3:修改文件  4:保存 5:退出--");
           while (true) {
               System.out.print("请输入操作指令：");
               int command = sc.nextInt();
               switch (command) {
               case 1:
                   createFile();// 1:新建文件
                   break;
               case 2:
                   openFile();// 2:打开文件
                   break;
               case 3:
                   editFile();// 3:修改文件
                   break;
               case 4:
                   saveFile();// 4:保存
                   break;
               case 5:
                   exit();// 5:退出
                   break;
               default:
                   System.out.println("您输入的指令错误！");
                   break;
               }
           }
       }
       /**
        * 新建文件 从控制台获取内容
        */
       private static void createFile() {
           message = "";// 新建文件时，暂存文件内容清空
           Scanner sc = new Scanner(System.in);
           System.out.println("请输入内容，停止编写请输入\"stop\":");// 提示
           StringBuffer stb = new StringBuffer();// 用于后期输入内容的拼接
           String inputMessage = "";
           while (!inputMessage.equals("stop")) {// 当输入“stop”时，停止输入
               if (stb.length() > 0) {
                   stb.append("\r\n");// 追加换行符
               }
               stb.append(inputMessage);// 拼接输入信息
               inputMessage = sc.nextLine();// 获取输入信息
           }
           message = stb.toString();// 将输入内容暂存
       }
       /**
        * 打开文件
        */
       private static void openFile() throws Exception {
           message = "";// 打开文件时，将暂存内容清空
           Scanner sc = new Scanner(System.in);
           System.out.print("请输入打开文件的位置：");
           filePath = sc.next();// 获取打开文件的路径
           // 控制只能输入txt格式的文件路径
           if (filePath != null && !filePath.endsWith(".txt")) {
               System.out.print("请选择文本文件！");
               return;
           }
           FileReader in = new FileReader(filePath);// 实例化一个FileReader对象
           char[] charArray = new char[1024];// 缓冲数组
           int len = 0;
           StringBuffer sb = new StringBuffer();
           // 循环读取，一次读取一个字符数组
           while ((len = in.read(charArray)) != -1) {
               sb.append(charArray);
           }
           message = sb.toString();// 将打开文件内容暂存
           System.out.println("打开文件内容：" + "\r\n" + message);
           in.close();// 释放资源
       }
       /**
        * 修改文件内容 通过字符串替换的形式
        */
       private static void editFile() {
           if (message == "" && filePath == null) {
               System.out.println("请先新建文件或者打开文件");
               return;
           }
           Scanner sc = new Scanner(System.in);
           System.out.println("请输入要修改的内容（以 \"修改的目标文字:修改之后的文字\" 格式）,"
                   + "停止修改请输入\"stop\":");
           String inputMessage = "";
           while (!inputMessage.equals("stop")) {// 当输入stop时,停止修改
               inputMessage = sc.nextLine();
               if (inputMessage != null && inputMessage.length() > 0) {
                   // 将输入的文字根据“：”拆分成数组
                   String[] editMessage = inputMessage.split(":");
                   if (editMessage != null && editMessage.length > 1) {
                       // 根据输入的信息将文件中内容替换
                       message = message.replace(editMessage[0], editMessage[1]);
                   }
               }
           }
           System.out.println("修改后的内容:" + "\r\n" + message);
       }
       /**
        * 保存 新建文件存在用户输入的路径 打开的文件将原文件覆盖
        */
       private static void saveFile() throws IOException {
           Scanner sc = new Scanner(System.in);
           FileWriter out = null;
           if (filePath != null) {// 文件是由“打开”载入的
               out = new FileWriter(filePath);// 将原文件覆盖
           } else {// 新建的文件
               System.out.print("请输入文件保存的绝对路径：");
               String path = sc.next();// 获取文件保存的路径
               filePath = path;
               // 将输入路径中大写字母替换成小写字母后判断是不是文本格式
               if (!filePath.toLowerCase().endsWith(".txt")) {
                   filePath += ".txt";
               }
               out = new FileWriter(filePath);// 构造输出流
           }
           out.write(message);// 写入暂存的内容
           out.close();// 关闭输出流
           message = "";// 修改文件前现将写入内容置空
           filePath = null;// 将文件路径至null
       }
       /**
        * 退出
        */
       private static void exit() {
           System.out.println("您已退出系统，谢谢使用！");
           System.exit(0);
       }
   }
   
   ```

   

