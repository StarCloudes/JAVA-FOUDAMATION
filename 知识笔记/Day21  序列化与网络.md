# Day21  序列化与网络
#### 一、Properties
概念：存储属性的集合，键值都必须是字符串

1. 基础
```java
Properties properties = new Properties();
//不用泛型，默认String
properties.setProperty("01", "java");
properties.setProperty("02", "ios");
properties.setProperty("03", "html5");
properties.setProperty("03", "python"); //key唯一

System.out.println(properties);
System.out.println(properties.getProperty("01"));

//遍历
Set<String> keys = properties.stringPropertyNames();
Iterator<String> iterator = keys.iterator();
while (iterator.hasNext()) {
String key = (String) iterator.next();
   System.out.println(properties.getProperty(key));
}

//注意获取不存在的key可以加默认值
System.out.println(properties.getProperty("04", "js"));

```

2. 获取系统属性
```java
Properties properties = System.getProperties();
//遍历系统属性
Set<String> keys = properties.stringPropertyNames();
Iterator<String> iterator = keys.iterator();
while (iterator.hasNext()) {
String key = (String) iterator.next();
System.out.println(key+"   "+properties.getProperty(key));
}
//对properties对象进行修改
properties.setProperty("sun.jnu.encoding", "GBK");
System.out.println(properties.get("sun.jnu.encoding"));
```

3. 应用  
```java
// config.properties
Properties properties = new Properties();
properties.load(new FileReader("text.txt")); //加载读入流
for(String key: properties.stringPropertyNames()) {
	System.out.println(key+"   "+properties.getProperty(key));
}
properties.setProperty("chenchen", "handsome"); //修改属性值
properties.store(new FileWriter("text.txt"),"first edit");//加载写出流
```


#### 二、序列化与逆序列化
数据由短期存储实现长期存储

> 应用场景：例如，在web开发中，如果对象被保存在了Session中，tomcat在重启时要把Session对象序列化到硬盘，这个对象就必须实现Serializable接口。如果对象要经过::分布式系统进行网络传输::或通过rmi等远程调用，这就需要在网络上传输对象，被传输的对象就必须实现Serializable接口  

```java
public static void writeObjrct() throws FileNotFoundException, IOException{
        // 创建序列化流对象  
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("text2.txt"));  
        // 创建对象  
        Person p = new Person("林青霞", 27);  
        // public final void writeObject(Object _obj_)  
        oos.writeObject(p);  
        // 释放资源  
        oos.close();  
	}

public static void readObject() throws FileNotFoundException, IOException, ClassNotFoundException {
		// 创建反序列化对象  
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("text2.txt"));  
        // 还原对象  
        Object obj = ois.readObject();  
        // 释放资源  
        ois.close();  
        // 输出对象  
        System.out.println(obj); 
	}
```
```java
//类通过实现 java.io.Serializable 接口以启用其序列化功能。未实现此接口的类将无法使其任何状态序列化或反序列化。
//该接口居然没有任何方法，类似于这种没有方法的接口被称为标记接口。
class Person implements Serializable{
	private static final long serialVersionUID = -3935566927965170003L;
//每次修改java文件的内容的时候,class文件的id值都会发生改变。而读取文件的时候，会和class文件中的id值进行匹配。所以，就会出问题。让这个id值在java文件中是一个固定的值，这样，你修改文件的时候，这个id值就不会发生改变。
	String name;
	int age;
//使用transient关键字声明不需要序列化的成员变量 
	public Person() {
		super();
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}
```


#### 三、网络通信
1. IP、端口号、协议
	* IP：网络中唯一的标记一台主机。
	* 端口：区分一台主机上的多个服务器的，通信两端的端口号要一致。

2. 七层协议
![](Day21%20%20%E5%BA%8F%E5%88%97%E5%8C%96%E4%B8%8E%E7%BD%91%E7%BB%9C/20160825152622511.png)

3. InetAddress
```java
InetAddress inetAddress = InetAddress.getLocalHost();
System.out.println(inetAddress.getHostName());
System.out.println(inetAddress.getHostAddress());
```

4. URL
```java
URL url = new URL("https://www.baidu.com:80/a/b/c/s?name=bingbing&age=18");
System.out.println(url.getHost());
System.out.println(url.getQuery());
System.out.println(url.getPath());
System.out.println(url.getFile());
//System.out.println(url.getContent());

URL url2 = new URL("https://www.baidu.com/");
URLConnection urlConnection = url2.openConnection();
//获取内部的输入流
InputStream inputStream =urlConnection.getInputStream();

//读取数据
byte[] arr = new byte[1024];
inputStream.read(arr);
System.out.println(new String(arr));
```

