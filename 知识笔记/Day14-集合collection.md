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



三、常用修饰符

1. 修饰词范围private default protected public
2. 注意点



四、集合（重点）

1. 集合和数组的区别

   * 数组：可以存储不同类型的多个数据,数据类型可以是简单数据类型也可以引用数据类型。创建的是一个定值,只能存储固定长度的数据,一旦存满了,就不能再继续存储.

   * 集合： 可以存储不同类型的多个数据,但是只能存储引用数据类型。存储空间会随着存储数据的增大而增大,所以可以更加合理的利用内存空间。

2. 分类

   * Collection 接口

     * collection的添加、删除、判断、**获取：迭代器iterator**、集合变数组

       ```java
       public class ListIteratorDemo {
           public static void main(String[] args) {
               // 创建List集合对象
               List list = new ArrayList();
               // 添加元素
               list.add("hello");
               list.add("world");
               list.add("java");
       
               // 迭代器遍历
               // Iterator it = list.iterator();
               // while (it.hasNext()) {
               // String s = (String) it.next();
               // if ("world".equals(s)) {
               // list.add("javaee");
               // }
               // }
       
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
     * Set 接口： 无序，且唯一
       * HashSet
       * TreeSet

   * Map 接口     ——键值对 

     * HashMap
     * TreeMap