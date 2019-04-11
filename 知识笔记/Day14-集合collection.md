一、Date

1. 获取当时间

   ```java
   //获取当前时间
   Date date = new Date();
   System.out.println("当前时间"+date);
   		
   long time = System.currentTimeMillis();
   System.out.println("系统时间"+time);
   ```

2. 日期转换

   * Format

   ```java
   //系统默认
   DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT);
   String date3 = dateFormat.format(date);
   ```

   * DateFormat

   ```java
   //⚠️重要 自定义
   SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
   String date4 = simpleDateFormat.format(date);
   ```

   

二、Math

1. Math.random().  // [0,1)

2. Random类 

   ```java
   new random().nextInt(10)
   ```

   

三、常用修饰符

1. 修饰词范围

   * protected：只能修饰方法（含构造方法）、成员变量。

   * public：只能修饰类、方法（含构造方法）、成员。
   * 默认修饰符（friendly）：只能修饰类、方法（含构造方法）、成员变量。
   * private：只能修饰方法（含构造方法）、成员变量。

2. 注意点

   * 在子类中，可继承不同包内父类的protected方法和属性，也只能在该子类中访问（除非重写方法或属性）



四、集合（重点）

1. 集合和数组的区别

   * 数组：可以存储不同类型的多个数据,数据类型可以是简单数据类型也可以引用数据类型。创建的是一个定值,只能存储固定长度的数据,一旦存满了,就不能再继续存储.

   * 集合： 可以存储不同类型的多个数据,但是**只能存储引用数据类型**。存储空间会随着存储数据的增大而增大,所以可以更加合理的利用内存空间。

   * 集合不能存放如int、long、float、double等基础类型的数据。可以通过包装类把基本类型转为对象类型，存放引用就可以解决这个问题。更方便的，由于有了自动拆箱和装箱功能。系统会自动将数值装箱为Integer类型的对象然后再存入set集合中

     ```java
     Collection collection1 = new ArrayList<>();
     collection1.add("python");
     collection1.add(1);
     
     //注意:判断两个集合相等,不仅元素要相同,元素的顺序也要一致
     System.out.println(collection2.equals(collection3));
     //获取集合中对象的个数
     System.out.println(collection1.size());
     ```

     

2. 分类

   * Collection 接口

     * collection的添加、删除、判断、获取：

     * 迭代器iterator

       直接再次使用第一次的iterator进行遍历,遍历失败.因为当前的指针已经指向了集合的最后.	

     * 集合变数组

       ```java
       public class ListIteratorDemo {
           public static void main(String[] args) {
               // 创建List集合对象
               List list = new ArrayList();
               // 添加元素
               list.add("hello");
               list.add("world");
               list.add("java");
       
               // 方式1：迭代器迭代元素，迭代器修改元素
               // 而Iterator迭代器却没有添加功能，所以我们使用其子接口ListIterator
               ListIterator lit = list.listIterator();
               while (lit.hasNext()) {
                   String s = (String) lit.next();
                   if ("world".equals(s)) {
                       lit.add("javaee");
                   }
               }
       
               // 方式2：集合遍历元素，集合修改元素(普通for)
               for (int x = 0; x < list.size(); x++) {
                   String s = (String) list.get(x);
                   if ("world".equals(s)) {
                       list.add("javaee");
                   }
               }
       
               System.out.println("list:" + list);
           }
       }
       ```

       

     * List 接口：存储的顺序有序，可以重复
       * ArrayList：底层是数组，线程不安全；查找快，增加删除慢（遍历使用迭代器）
       * Vector：底层是数组，线程安全；查找快，增加删除慢（遍历使用的是枚举）
       * LInkedList：底层是链表，线程不安全；查找速度慢，添加删除快

       ```Java
       //List：特有方法，可以操作下标
       List list = new ArrayList<>();
       list.add(0, "html");
       //又返回值
       System.out.println(list.remove(0));
       String string = (String)list.set(0, "iOS");
       
       List<E> subList(int fromIndex, int toIndex)     获取list中 部分元素
       E get(int index)   获取指定下标的元素
       ```

       ```java
       //注意点
       while (iterator.hasNext()) {
         String value = (String)iterator.next();
         System.out.println("value:"+value);
       
         //删除ios
         if (value.equals("iOS")) {
           //在使用迭代器期间,使用list的删除方法直接删除元素,有可能发生错误,所以不要这样做
           //list.remove("iOS");
           //用迭代器提供的方法,注意:remove,add,set不要同时使用
           iterator.remove();
       //	iterator.set("haha");
       //	iterator.add("ok");
         }
       }
       ```

       ```java
       LinkedList linkedList = new LinkedList<>();
       addFirst()//始终在首位添加
       addLast()//始终在末尾添加
       
       peekFirst()//获取的对象不存在会返回null
       peekLast()
       
       pollFirst()//删除的对象不存在会返回null
       pollLast()
       ```

       

     * Set 接口： 无序，且唯一
       * HashSet
       * TreeSet

   * Map 接口     ——键值对 

     * HashMap
     * TreeMap





### 作业

1. 有某个字符串集合，长度为5，给定字母a，统计集合中的字符串元素包含字母a的个数。

   ```java
   public class Demo2 {	
   	public static void main(String[] args) {
   		ArrayList<String> list = new ArrayList<>();
   		list.add("abc");
   		list.add("acd");
   		list.add("jack");
   		int count = 0;
   		for (Object string : list) {
   			if (string.toString().contains("a")) { 
           //引用型的String获取字符串的值
   				count++;
   			}
   		}
   		System.out.println(count);
   	}
   
   }
   ```

2. 随机生成20个整数，范围为10-30，存入到集合中，将所有元素加和后输出。

   ```Java
   public static void main(String[] args) {
   		Random random = new Random();
   		List list = new ArrayList<>();
   		int sum = 0;
   		for (int i = 0; i < 20; i++) {
   			int number = 10 + random.nextInt(20);
   			list.add(number);
   			sum += number;
   			System.out.println(number);
   		}
   		System.out.println("加和为:" + sum);
   	}
   
   ```

   