1. 标准输入流,输出流----in,out

   * 输入源:可以发送数据的设备  ————————输出源:可以接收数据的设备
   * 当前的流已经打开并关联了输入源--键盘
   * 如果不想让键盘充当输入源,可以通过setIn进行更换

   ```java
   public static void main(String[] args) throws IOException {
   		InputStream iStream = System.in;
        	myReadLine(iStream);
   	}
   	
   public static void myReadLine(InputStream iStream) throws IOException {
   		StringBuffer sBuffer = new StringBuffer();
   		while(true) {
   			int num = iStream.read(); //阻塞
   			if(num == '\n') {
   				System.out.println(sBuffer.toString());
   				//结束程序
   				if(sBuffer.toString().equals("over")) {
   					break;
   				}
   				//将上一次的输入值清除
   				sBuffer.delete(0, sBuffer.length());
   			}else {
   				sBuffer.append((char)num);
   			}
   		}
   	}
   ```

2. 转换流

   * 由于字节流操作中文不是特别方便，所以，java就提供了转换流。字符流=字节流+编码表。I
   * 编码与解码

   * inputStreamReader:输入转换流

   * OutputStreamWriter:输出转换流

   ```java
   String s = "你好";
   byte[] bys = s.getBytes(); // [-60, -29, -70, -61]
   System.out.println(Arrays.toString(bys));
   ```

   ```java
   BufferedReader bReader =  new BufferedReader(new InputStreamReader(System.in));//由标准输入流得到字符缓冲读入流
   BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));//由标准输出流得到字符缓冲写出流
   
   String data = null;
   while((data = bReader.readLine()) != null) {
     bWriter.write(data);
     bWriter.newLine();
     bWriter.flush();
   }
   
   bReader.close();
   bWriter.close();
   ```

   * 多种输入源和输出源的组合

    

3. 更换输入源,输出源

   ```java
   System.setIn(new FileInputStream("text.txt"));   //从键盘接收数据更替成从文件接收数据
   System.setOut(new PrintStream("text.txt"));		//从输出到控制台更替成输出到文件
   ```

   

4. File

   * File 的基础

5. ```Java
  // 删除功能：我要删除a.txt这个文件
  File file = new File("a.txt");
  System.out.println("delete:" + file.delete());
  
  // 删除功能：我要删除ccc这个文件夹
  File file2 = new File("aaa\\bbb\\ccc");
  System.out.println("delete:" + file2.delete());
  
  //创建文件目录
  File file3 = new File("e:\\aaa\\bbb\\ccc\\ddd");
  System.out.println("mkdirs:" + file3.mkdirs());
  
  //判断是否是文件、文件夹、是否隐藏
  public boolean isDirectory():判断是否是目录 
  public boolean isFile():判断是否是文件 
  public boolean exists():判断是否存在 
  public boolean canRead():判断是否可读 
  public boolean canWrite():判断是否可写 
  public boolean isHidden():判断是否隐藏 
  
  //重命名功能:
  public boolean renameTo(File dest)
    
  //获取文件
  public String getAbsolutePath()：获取绝对路径
  public String getPath():获取相对路径
  public String getName():获取名称
  public long length():获取长度。字节数
  public long lastModified():获取最后一次的修改时间，毫秒值
  // 高级获取功能：
  public String[] list():获取指定目录下的所有文件或者文件夹的名称数组
  public File[] listFiles():获取指定目录下的所有文件或者文件夹的File数组
  //获取当前主机的根目录 
  public File[] listRoots()
  ```

  ```java
  /*
   * 判断E盘目录下是否有后缀名为.jpg的文件，如果有，就输出此文件名称
   * A:先获取所有的，然后遍历的时候，依次判断，如果满足条件就输出。
   * B:获取的时候就已经是满足条件的了，然后输出即可。
   * 
   * 要想实现这个效果，就必须学习一个接口：文件名称过滤器
   * public String[] list(FilenameFilter filter)
   * public File[] listFiles(FilenameFilter filter)
   */
  public class FileDemo2 {
      public static void main(String[] args) {
          // 封装e判断目录
          File file = new File("e:\\");
  
          // 获取该目录下所有文件或者文件夹的String数组
          // public String[] list(FilenameFilter filter)
          String[] strArray = file.list(new FilenameFilter() {
              @Override
              public boolean accept(File dir, String name) {
                  return new File(dir, name).isFile() && name.endsWith(".jpg");
              }
          });
  
          // 遍历
          for (String s : strArray) {
              System.out.println(s);
          }
      }
  }
  ```

  ```java
  /*
   * 需求：把E:\JavaSE目录下所有的java结尾的文件的绝对路径给输出在控制台。
   * 
   * 分析：
   *         A:封装目录
   *         B:获取该目录下所有的文件或者文件夹的File数组
   *         C:遍历该File数组，得到每一个File对象
   *         D:判断该File对象是否是文件夹
   *             是：回到B
   *             否：继续判断是否以.java结尾
   *                 是：就输出该文件的绝对路径
   *                 否：不搭理它
   */
  public class FilePathDemo {
      public static void main(String[] args) {
          // 封装目录
          File srcFolder = new File("E:\\JavaSE");
  
          // 递归功能实现
          getAllJavaFilePaths(srcFolder);
      }
  
      private static void getAllJavaFilePaths(File srcFolder) {
          // 获取该目录下所有的文件或者文件夹的File数组
          File[] fileArray = srcFolder.listFiles();
  
          // 遍历该File数组，得到每一个File对象
          for (File file : fileArray) {
              // 判断该File对象是否是文件夹
              if (file.isDirectory()) {
                  getAllJavaFilePaths(file);
              } else {
                  // 继续判断是否以.java结尾
                  if (file.getName().endsWith(".java")) {
                      // 就输出该文件的绝对路径
                      System.out.println(file.getAbsolutePath());
                  }
              }
          }
      }
  }
  ```

  ```java
  //文件管理器
  public class DocumentManager {
      public static void main(String[] args) throws Exception {
          Scanner sc = new Scanner(System.in);
          System.out.println("--1:指定关键字检索文件  2:指定后缀名检索文件  " + "3:复制文件/目录  4:退出--");
          while (true) {
              System.out.print("请输入指令：");
              int command = sc.nextInt();
              switch (command) {
              case 1:
                  searchByKeyWorld();// 指定关键字检索文件
                  break;
              case 2:
                  searchBySuffix();// 指定后缀名检索文件
                  break;
              case 3:
                  copyDirectory();// 复制文件/目录
                  break;
              case 4:
                  exit();// 退出
                  break;
              default:
                  System.out.println("您输入的指令错误！");
                  break;
              }
          }
      }
  
      // *********1.指定关键字检索文件*********
      private static void searchByKeyWorld() {
          Scanner sc = new Scanner(System.in);
          System.out.print("请输入要检索的目录位置：");
          String path = sc.next();// 从控制台获取路径
          File file = new File(path);
          if (!file.exists() || !file.isDirectory()) {// 判断目录是否存在，是否是目录
              System.out.println(path + " (不是有效目录)");
              return;
          }
          System.out.print("请输入搜索关键字：");
          String key = sc.next();// 获取关键字
          // 在输入目录下获取所有包含关键字的文件路径
          ArrayList<String> list = FileUtils.listFiles(file, key);
          for (Object obj : list) {
              System.out.println(obj);// 将路径打印到控制台
          }
      }
  
      // *********2.指定后缀名检索文件********//
      private static void searchBySuffix() {
          Scanner sc = new Scanner(System.in);
          System.out.print("请输入要检索的目录位置：");
          String path = sc.next();// 从控制台获取路径
          File file = new File(path);
          if (!file.exists() || !file.isDirectory()) {// 判断目录是否存在，是否是目录
              System.out.println(path + " (不是有效目录)");
              return;
          }
          System.out.print("请输入搜索后缀：");
          String suffix = sc.next();
          String[] suffixArray = suffix.split(",");// 获取后缀字符串
          // 在输入目录下获取所有指定后缀名的文件路径
          ArrayList<String> list = FileUtils.listFiles(file, suffixArray);
          for (Object obj : list) {
              System.out.println(obj);// 将路径打印到控制台
          }
      }
  
      // *********3.复制文件/目录**********//
      private static void copyDirectory() throws Exception {
          Scanner sc = new Scanner(System.in);
          System.out.print("请输入源目录：");
          String srcDirectory = sc.next();// 从控制台获取源路径
          File srcFile = new File(srcDirectory);
          if (!srcFile.exists() || !srcFile.isDirectory()) {// 判断目录是否存在，是否是目录
              System.out.println("无效目录！");
              return;
          }
          System.out.print("请输入目标位置：");
          String destDirectory = sc.next();// 从控制台获取目标路径
          File destFile = new File(destDirectory);
          if (!destFile.exists() || !destFile.isDirectory()) {// 判断目录是否存在，是否是目录
              System.out.println("无效位置！");
              return;
          }
          // 将源路径中的内容复制到目标路径下
          FileUtils.copySrcPathToDestPath(srcFile, destFile);
      }
  
      // *********4.退出**********//
      private static void exit() {
          System.out.println("您已退出系统，谢谢使用！");
          System.exit(0);
      }
  }
  ```

  ```java
  //File工具类
  public class FileUtils {
      /**
       * 指定关键字检索文件
       * @param file   File对象
       * @param key    关键字
       * @return 包含关键字的文件路径
       */
      public static ArrayList<String> listFiles(File file, final String key) {
          FilenameFilter filter = new FilenameFilter() { // 创建过滤器对象
              public boolean accept(File dir, String name) {// 实现accept()方法
                  File currFile = new File(dir, name);
                  // 如果文件名包含关键字返回true，否则返回false
                  if (currFile.isFile() && name.contains(key)) {
                      return true;
                  }
                  return false;
              }
          };
          // 递归方式获取规定的路径
          ArrayList<String> arraylist = fileDir(file, filter);
          return arraylist;
      }
  
      /**
       * 指定后缀名检索文件
       * @param file   File对象
       * @param suffixArray   后缀名数组
       * @return 指定后缀名的文件路径
       */
      public static ArrayList<String> listFiles(File file,
              final String[] suffixArray) {
          FilenameFilter filter = new FilenameFilter() { // 创建过滤器对象
              public boolean accept(File dir, String name) {// 实现accept()方法
                  File currFile = new File(dir, name);
                  if (currFile.isFile()) {// 如果文件名以指定后缀名结尾返回true，否则返回false
                      for (String suffix : suffixArray) {
                          if (name.endsWith("." + suffix)) {
                              return true;
                          }
                      }
                  }
                  return false;
              }
          };
          // 递归方式获取规定的路径
          ArrayList<String> arraylist = fileDir(file, filter);
          return arraylist;
      }
  
      /**
       * 递归方式获取规定的路径
       * @param dir   File对象
       * @param filter   过滤器
       * @return 过滤器过滤后的文件路径
       */
      public static ArrayList<String> fileDir(File dir, FilenameFilter filter) {
          ArrayList<String> arraylist = new ArrayList<String>();
          File[] lists = dir.listFiles(filter); // 获得过滤后的所有文件数组
          for (File list : lists) {
              // 将文件的绝对路径放到集合中
              arraylist.add(list.getAbsolutePath());
          }
          File[] files = dir.listFiles(); // 获得当前目录下所有文件的数组
          for (File file : files) { // 遍历所有的子目录和文件
              if (file.isDirectory()) {
                  // 如果是目录，递归调用fileDir()
                  ArrayList<String> every = fileDir(file, filter);
                  arraylist.addAll(every);// 将文件夹下的文件路径添加到集合中
              }
          }// 此时的集合中有当前目录下的文件路径，和当前目录的子目录下的文件路径
          return arraylist;
      }
  
      /**
       * 复制文件/目录
       * @param srcFile   源目录
       * @param destFile  目标目录
       */
      public static void copySrcPathToDestPath(File srcDir, File destDir)
              throws Exception {
          File[] files = srcDir.listFiles();// 子文件目录
          for (int i = 0; i < files.length; i++) {
              File copiedFile = new File(destDir, files[i].getName());// 创建指定目录的文件
              if (files[i].isDirectory()) {// 如果是目录
                  if (!copiedFile.mkdirs()) {// 创建文件夹
                      System.out.println("无法创建：" + copiedFile);
                      return;
                  }
                  // 调用递归，获取子文件夹下的文件路径
                  copySrcPathToDestPath(files[i], copiedFile);
              } else {// 复制文件
                  FileInputStream input = new FileInputStream(files[i]);// 获取输入流
                  FileOutputStream output = new FileOutputStream(copiedFile);// 获取输出流
                  byte[] buffer = new byte[1024];// 创建缓冲区
                  int n = 0;
                  // 循环读取字节
                  while ((n = input.read(buffer)) != -1) {
                      output.write(buffer, 0, n);
                  }
                  input.close();// 关闭输入流
                  output.close();// 关闭输出流
              }
          }
      }
  }
  ```

  

6. 打印流

   * 字节打印流:  PrintStream, 除了拥有输出流的特点之外,还有打印的功能
   * 字符打印流:  PrintWriter

   ```java
   printStream.write(97);//00000000 0000000 00000000 01100001   a  打印时将前面三个字节砍掉了
   printStream.write(353);//00000000 00000000 00000001 01100001    a
   printStream4.print(353);//相当于内部进行了自用的转化
   //先将353转成字符串,再转成字节数组
   printStream.write(String.valueOf(353).getBytes());
   
   ```

   