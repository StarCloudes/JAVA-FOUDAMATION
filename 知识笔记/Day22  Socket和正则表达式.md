# Day22  Socket和正则表达式
1. UDP
```java
//客户端：发送数据
/*
 * 1.创建UDP通信的对象-socket对象:对应的类是DatagramSocket.(用于UDP数据的发送与接收)
 * 2.数据的准备-封装包:DatagramPacket(数据包,包括相关的属性,数据)
 * 3.发送数据,通过send方法
 * 4.关闭socket对象
 */

public static void main(String[] args) throws IOException {
    DatagramSocket socket = new DatagramSocket();
    //byte[] _buf_ = "_bingbing_".getBytes();
	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	String data = bufferedReader.readLine();
	byte[] buf = data.getBytes();
    DatagramPacket packet = new DatagramPacket(buf, buf.length,InetAddress.getLocalHost(),6000);
    socket.send(packet);
    bufferedReader.close();
    socket.close();	    
}
```
```java
//服务器端:接收数据
/*
 * 1.创建socket对象,并绑定端口号---DatagramPacket
 * 2.创建包对象,创建空数组,准备接收传来的数据
 * 3.接收数据
 * 4.关闭相关的对象
 */
public static void main(String[] args) throws IOException {
	DatagramSocket socket = new DatagramSocket(6000);
	byte[] buf = new byte[100];
	DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);

	socket.receive(datagramPacket);// 让服务器一直处于监听状态
	byte[] arr = datagramPacket.getData();
	System.out.println(new String(arr));

	socket.close();
}
```

2. TCP
```java
//客户端
Socket socket = new Socket(InetAddress.getLocalHost(),20000);
//发送数据
//String data = "Big data";
BufferedReader bfReader = new BufferedReader(new InputStreamReader(System.in));
String data = bfReader.readLine();
OutputStream outputStream = socket.getOutputStream();
outputStream.write(data.getBytes());

//接受数据
InputStream inputStream = socket.getInputStream();
byte[] arr = new byte[100];
int num = 0;
num = inputStream.read(arr);
System.out.println(new String(arr,0,num));

socket.close();
```

```java
//服务器端
ServerSocket serverSocket = new ServerSocket(20000);
Socket socket = serverSocket.accept();//让服务器端监听

//读取数据
InputStream inputStream = socket.getInputStream();
byte[] arr = new byte[100];
int num = 0;
num = inputStream.read(arr);
System.out.println(new String(arr,0,num));
		
//发送数据
String data = new String(arr,0,num).toUpperCase();
OutputStream outputStream = socket.getOutputStream();
outputStream.write(data.getBytes());		

serverSocket.close();
```

3. 正则表达式
```java
//判断qq
String regex = "[1-9]\\d{4,12}";
boolean isQQ = qq.matches(regex);
```

```Java
// 要求:获取连续超过四个字母的子字符串
String s = "sjoiffs   sjfj   sdfgjj       sdjijs    djd    d    jwejfe";
String regex = "[a-zA-Z]{5,}";
// 相当于将正则表达式进行了简单的转化,但是Pattern本身不具有获取数据的能力
Pattern pattern = Pattern.compile(regex);

// 具有获取数据的能力
Matcher matcher = pattern.matcher(s);

//		matcher.find();//判断是否有符合当前表达式的内容
//		matcher.group();//是获取内容
while (matcher.find()) {
	String string = matcher.group();
	System.out.println(string);
}
```















