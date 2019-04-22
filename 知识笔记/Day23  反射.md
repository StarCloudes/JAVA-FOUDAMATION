## Day23  反射
1. 对象创建的四种方式：new、反射、克隆、逆序列化
2. 目的：跳过new创建对象
3. 定义：**动态**获取类的字节码文件，并对成员进行抽象。通过字节码文件直接创建对象。
4. 过程:
1.获取字节码文件对象     
2.通过字节码文件对象获取对应的实例对象  
3.给属性赋值(通过从属性中提取出来的类—Field)
4.调用方法(通过从方法中提取出来的类—Method)
5. 获取字节码文件对象（Class类）的3种方法
```java
public static void fun1() {
	Person person = new Person();  //首先必须有个对象
	Class<?> _class1_ = person.getClass();				
}

public static void fun2() {
	Class<?> class2 = Person.class; //当前类必须是可见的，对类的依赖性太强
	System.out.println(class2);
}

public static void fun3() throws ClassNotFoundException {  //Class类它提供forName方法，包名➕类名
	Class<?> class3 = Class.forName("com.classroom.homework23.Person");
//可以通过一个字符串直接得到一个字节码文件
	System.out.println(class3);
}
```

6. 通过字节码文件对象获取对应的实例对象
```java
//1.利用无参构造方法创建对象
public static void fun1(Class<?> class1) throws InstantiationException, IllegalAccessException {
	//创建实例对象
	//这里相当于在newInstance内部调用了无参的构造方法
	Object object = class1.newInstance();
	Person person = (Person)object;
	person.setName("bing");
	String _myname_ = person.getName();
	System.out.println(person.getName());
}
//2.利用有参构造方法创建对象
public static void fun2(Class<?> class1) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
	//得到有参构造方法
	//得到的是:Person(String name, _int_ age)
  //这里的参数是实际的构造方法的参数的字节码文件
  //注意点:简单数据类型也有字节码文件  ,获取字节码文件的方式都可以通过.class实现
	 Class<?> class2 = Class.forName("java.lang.String");
	 Constructor<?> constructor =  class1.getConstructor(class2,int.class);
	 //调用构造方法创建对象
	 Person person = (Person) constructor.newInstance("bing",20);
	 System.out.println(person);
}
```

7. 给属性赋值
```java
//1.得到字节码文件
Class<?> class1 = Class.forName("com.qianfeng.test.Person");

//2.调用Filed相关方法得到属性
//参数就是哪个实际的属性
//Field field = class1.getField("name");
//忽略权限
Field field = class1.getDeclaredField("name");
//解释:当属性是私有的,我们要通过反射进行访问,可以做的方法:
//首先使用getDeclaredField()   ,然后再调用setAccessible(),并将参数设置成true.
field.setAccessible(true);

//3.通过字节码文件创建Person类型的实例对象
Object per = class1.newInstance();

//4.将field属性指定给当前的实例对象并完成赋值
//第一个参数:绑定的具体的实例对象   第二个参数:给他赋的值
field.set(per, "冰冰");//per.name = "冰冰"
//打印值
System.out.println(field.get(per));
```

8. 调用普通方法
```java
//第一个参数是创建的方法的方法名   第二个:实例方法参数的字节码文件对象
Method method = class1.getMethod("callPhone",String.class);

//创建实例对象
Constructor<?> constructor = class1.getConstructor(String.class,int.class);
Object per = constructor.newInstance("bingbing",20);

//实现方法的调用
//第一个参数:方法所属的对象   第二个:方法参数
method.invoke(per,"12345");
```
```java
//静态方法
//第一个参数是创建的方法的方法名   第二个:实例方法参数的字节码文件对象
Method method = class1.getMethod("run",int.class);
//实现方法的调用
//第一个参数:方法所属的对象   第二个:方法参数
method.invoke(null,30);
```














#code/Java