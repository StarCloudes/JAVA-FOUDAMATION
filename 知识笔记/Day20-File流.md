1. 标准输入流,输出流----in,out

   * 输入源:可以发送数据的设备  ————————输出源:可以接收数据的设备
   * 1.当前的流已经打开并关联了输入源--键盘
   * 2.如果不想让键盘充当输入源,可以通过setIn进行更换

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

   * InputStreamReader:输入转换流

   * OutputStreamWriter:输出转换流

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

5. ```
  //创建文件
  //创建文件目录
  //判断是否是文件、文件夹、是否隐藏
  //获取文件最后的修改时间 long lastModified()
  //获取当前主机的根目录 File[] listRoots()
  //获取指定目录下的文件或文件夹 String[] list()
  //获取指定目录下的路径 File[] listFiles()
  ```

  ```
  递归实现目录下所有的文件
  
  ```

  * file 递归

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

   