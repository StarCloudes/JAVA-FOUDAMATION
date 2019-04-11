一、字符串（重点）

1. 字符串基础

   * String类，表示方法""

2. 不可变字符串String

   * 内存示意图（栈、堆、常量区）
   * 保存在常量区，一个字符串常量在常量区只允许储存一个

   ```java
   String s1 = new String(“hello”);
   String s2 = “hello”;有什么区别？
   //前者创建了2个或1个对象，后者创建了1个或0个对象。
   ```

   * ⚠️注意字符串的比较

   ```java
   String s1 = "1000";
   String s2 = "1000";
   String s3 = new String("1000");
   String s4 = new String("1000");
       	
   System.out.println(s1 == s2); //true
   System.out.println(s1 == s3); //false
   System.out.println(s3 == s4); //false
   
   //String重写了equals的方法，重新制定了比较规则,变成了让s1与s3属性的地址比较
   System.out.println(s3.equals(s4));   //true
   System.out.println(s1.contains(s3));  //true
   
   String s5 = “hello”;    String s6 = “world”;   String s7 = “helloworld”;
   
   //字符串如果是变量相加，先开空间，再拼接。
   //字符串如果是常量相加，是先加，然后到字符串常量池中找，如果有就直接返回，否则就创建。
   S7 == s5 + s6 ; //fale      
   s7 == “hello” + ”world”; //true
   ```

3. String方法

   * 判断

     ```java
     //判断是否包含一个子字符串
     boolean contains(CharSequence s) 
     //判断两个字符串的内容是否相同
     boolean equals(Object anObject) 
     //忽略大小写判断两个字符串的内容是否相同
     boolean equalsIgnoreCase(String anotherString) 
     //判断是否以某字符串开头
     boolean startsWith(String prefix)
     //判断是否以某字符串结尾
     boolean endsWith(String suffix) 
     ```

   * 转换

     ```java
     //转换：将字符数组转换成字符串
     //1:使用构造方法
     String(char[] value) 
     String(char[] value, int offset, int count) 
     //2:使用静态方法
     static String copyValueOf(char[] data) 
     static String copyValueOf(char[] data, int offset, int count) 
     
     //⚠️将字符串转成字符数组
     char[] toCharArray() 
     //将字节数组转成字符串
     String(byte[] bytes) 
     String(byte[] bytes, int offset, int length)
     String(byte[] bytes, String charsetName)//使用指定的编码将字节数组转换成字符成
     //将字符串转成字节数组
     byte[] getBytes() 
     //将基本数据类型转换成字符串
     String.valueOf()
     ```

   * 替换

     ```java
     String replace(char oldChar, char newChar) 
     //子串:
     String substring(int beginIndex)  
     //⚠️包含起始位置，不包含结束位置，到结束位置的前一位
     String substring(int beginIndex, int endIndex)
     //转换，去除空格，比较:
     //大小写转换
     String toLowerCase() 
     String toUpperCase()
     //将字符串两端的⚠️空格去掉
     String trim()  
     //按字典(ASCII)顺序比较⚠️两个字符串 前-后
     int compareTo(String anotherString)
     ```

   * 切割

     ```java
     //切割:
     String[] split(String)
       
     char cha = s1.charAt(0);
     ```

     

4. 可变字符串 StringBuilder / StringBuffer

   * 字符串缓冲区

   * StringBuffer考虑线程安全，效率低；StringBuilder不考虑线程安全，效率高。

   * 存储

     ```java
     StringBuffer append(boolean b)   //从最后插入
     StringBuffer insert(int offset, boolean b)   //从指定位置插入
     ```

   * 删除

     ```java
     StringBuffer delete(int start, int end) 
     StringBuffer deleteCharAt(int index)
     ```

   * 修改

     ```java
     StringBuffer replace(int start, int end, String str)  //替换指定的子字符串
     void setCharAt(int index, char ch) //修改一个字符
     ```

   * 获取

     ```java
     char charAt(int index) 
     举🌰 int chr = str.charAt(i);
     int indexOf(String str) //从左到右查找指定的字符串
     int indexOf(String str, int fromIndex)
     int lastIndexOf(String str) 
     //返回指定子字符串(从右边开始计数)在此字符串第一次出现时的索引
     int lastIndexOf(String str, int fromIndex) 
     //返回指定子字符串(从右边开始计数,范围:当前指定的位置-0)在此字符串第一次出现时的索引 
     int length() 
     //返回长度（字符数）。
     ```

   * 反转

     ```java
     StringBuffer reverse()
     ```

   5. **对于三者使用的总结：**

      * 操作少量的数据: 适用String

      * 单线程操作字符串缓冲区下操作大量数据: 适用StringBuilder

      * 多线程操作字符串缓冲区下操作大量数据: 适用StringBuffer



二、网络

1. 客户端与服务器
2. 网址的构成





### 作业

1. 模拟一个trim方法，去除字符串两端的空格

```java
public static void main(String[] args) 
  {
    String str="   abcd  efg   ";
    String t=trim(str);
    System.out.println(t);
  }
  public static String trim(String str)
  {
    int start=0;
    int end=str.length()-1;
    while (str.charAt(start)==' ')
    {
      start++;
    }
    while(str.charAt(end)==' ')
    {
      end--;
    }
    return str.substring(start,end+1);
  }
```

2. 反转字符串

```java
public String test1() {
		String string = "hello world";
		StringBuffer sBuffer = new StringBuffer(string);
		for (int i = 0,j = sBuffer.length()-1; i < j; i++,j--) {
			char a = sBuffer.charAt(i);
			char b = sBuffer.charAt(j);
			sBuffer.setCharAt(i, b);
			sBuffer.setCharAt(j, a);
		}
		
		String string2 = sBuffer.toString();
		return string2;
}
	
public String test2() {
		String string = "hello world";
		char[] arr = string.toCharArray();
		for (int i = 0,j=arr.length-1; i < j; i++,j--) {
			//这里是强转
			arr[i] ^=  arr[j];
			arr[j] = (char)(arr[i] ^ arr[j]);
			arr[i] = (char)(arr[i] ^ arr[j]);
		}
		return new String(arr);
}
```

