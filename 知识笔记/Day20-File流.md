1. 标准输入流,输出流----in,out

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

   ```java
   BufferedReader bReader =  new BufferedReader(new InputStreamReader(System.in));
   BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));
   
   String data = null;
   while((data = bReader.readLine()) != null) {
     bWriter.write(data);
     bWriter.newLine();
     bWriter.flush();
   }
   
   bReader.close();
   bWriter.close();
   ```

2. 多种输入源和输出源的组合

   

3. 更换输入源,输出源

   ```
   System.setIn();
   System.setOut();
   ```

   

4. File

   * File 的基础

   * ```
     //创建文件
     //创建文件目录
     //判断是否是文件、文件夹、是否隐藏
     //获取文件最后的修改时间 long
     //获取当前主机的根目录 File[] listRoots
     //获取指定目录下的文件或文件夹 String[] list
     //获取指定目录下的路径 File[] listFiles
     ```

     ```
     递归实现目录下所有的文件
     
     ```

   * file 递归

6. 打印流

   ```
   PrintStream
   PrintWriter
   ```

   

7. Properties

8. 序列流,数据类,内存流介绍

9. 流的序列化