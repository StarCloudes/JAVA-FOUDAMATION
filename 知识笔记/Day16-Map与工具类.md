#### 一、Map

1. 与set比较      

2. Map接口

   * 增删改

   ```java
   Map<String, String> map = new HashMap<>();
   map.put("01", "java");
   map.put("02", "php");
   
   System.out.println(map.put("01", "ios"));
   System.out.println(map);
   
   //map.clear();
   System.out.println(map.get("01"));
   System.out.println(map.size());
   System.out.println(map.isEmpty());
   ```

   * 遍历— 重点

   ```java
   //遍历1 keySet
   Set<String> set = map.keySet();
   Iterator<String> iterator = set.iterator();
   while (iterator.hasNext()) {
       String key = (String) iterator.next();
       System.out.println("key:"+key+"    value:"+map.get(key));
   }
   
   //遍历2 entrySet
   Set<Map.Entry<String, String>> set2 = map.entrySet();
   Iterator<Map.Entry<String, String>> iterator2 = set2.iterator();
   while (iterator2.hasNext()) {
       Map.Entry<String,String> entry =        iterator2.next();
       System.out.println("key: " + entry.getKey()+ "  value:" + entry.getValue());
   }
   
   for(String user: map.keySet()) {
   			System.out.println("UserName: "+user+"  Email Address: "+map.get(user));
   		}
   ```

   * 介绍Map接口的方法

   ```java
   //
   //1.增加
   V put(K key,V value)  增加一个键值对
   void putAll(Map<? extends K,? extends V> map)  增加多个
   //2.删除
   V remove(Object key)  根据key删除元素
   void clear()  删除全部
   //3.获取
   V get(Object key)  根据key查找元素
   int size()  获取键值对的个数
   Set<K> keySet()   遍历方法一 复制
   Set<Map.Entry<K,V>> entrySet() 遍历方法二  映射 通过setValue会改变原始值
   //4.常用的判断
   boolean isEmpty()  //空map!=null
   boolean containsKey(K key) 是否包含当前的key
   boolean containsValue(V value) 是否包含当前的value                 
   ```

3. HashMap的底层实现

   原理：HashMap 在底层将 key-value 当成一个整体进行处理，这个整体就是一个 Entry 对象。HashMap 底层采用一个 Entry[] 数组来保存所有的 key-value 对，当需要存储一个 Entry 对象时，会根据hash算法来决定其在数组中的存储位置，在根据equals方法决定其在该数组位置上的链表中的存储位置；当需要取出一个Entry时，也会根据hash算法找到其在数组中的存储位置，再根据equals方法从该位置上的链表中取出该Entry。

   ```java
   public V put(K key, V value) {
       //当key为null，调用putForNullKey方法，保存null与table第一个位置中，这是HashMap允许为null的原因
       if (key == null)
           return putForNullKey(value);
       //计算key的hash值
       int hash = hash(key.hashCode());                  //------(1)
       //计算key hash 值在 table 数组中的位置
       int i = indexFor(hash, table.length);             //------(2)
       //从i出开始迭代 e,找到 key 保存的位置
       for (Entry<K, V> e = table[i]; e != null; e = e.next) {
           Object k;
           //判断该条链上是否存在相同的key值
           //若存在相同，则直接覆盖value，返回旧value
           if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
               V oldValue = e.value;    //旧值 = 新值
                 e.value = value;
               e.recordAccess(this);
               return oldValue;     //返回旧值
           }
       }
       //修改次数增加1
       modCount++;
       //将key、value添加至i位置处
       addEntry(hash, key, value, i);
       return null;
   }
   
   static int hash(int h) {
       h ^= (h >>> 20) ^ (h >>> 12);
       return h ^ (h >>> 7) ^ (h >>> 4);
   }
   
   static int indexFor(int h, int length) {
       return h & (length-1);
   }
   
   void addEntry(int hash, K key, V value, int bucketIndex) {
       //获取bucketIndex处的Entry
       Entry<K, V> e = table[bucketIndex];
       //将新创建的 Entry 放入 bucketIndex 索引处，并让新的 Entry 指向原来的 Entry 
       table[bucketIndex] = new Entry<K, V>(hash, key, value, e);
       //若HashMap中元素的个数超过极限了，则容量扩大两倍
       if (size++ >= threshold)
           resize(2 * table.length);
   }
   
   public V get(Object key) {
       // 若为null，调用getForNullKey方法返回相对应的value
       if (key == null)
           return getForNullKey();
       // 根据该 key 的 hashCode 值计算它的 hash 码  
       int hash = hash(key.hashCode());
       // 取出 table 数组中指定索引处的值
       for (Entry<K, V> e = table[indexFor(hash, table.length)]; e != null; e = e.next) {
           Object k;
           //若搜索的key与查找的key相同，则返回相对应的value
           if (e.hash == hash && ((k = e.key) == key || key.equals(k)))
               return e.value;
       }
       return null;
   }
   ```



3. HashMap与HashTable的区别

   - HashTable线程更加安全，代价就是因为它粗暴的添加了同步锁，所以会有性能损失。其实有更好的concurrentHashMap可以替代HashTable
   - HashTable：hash值对length取模，HashMap中则通过h&(length-1)的方法来代替取模
   - Hashtable不允许key或者value使用null值，而HashMap可以。
   - Hashtable扩容时，将容量变为原来的2倍加1，而HashMap扩容时，将容量变为原来的2倍。 
   - Hashtable计算hash值，直接用key的hashCode()，而HashMap重新计算了key的hash值

   

4. TreeMap的注意点

   * 什么类型的数据类型可以作为key?

   ​    a 实现了Comparable接口的compareTo()方法   b 实现了Comparator接口的compare()方法

   ​    可以的代表:String,包装类,自定义的实现了要求的类

   ​    不可以的代表:数组,ArrayList,LinkedList(如果给他们建立的比较器也可以比较,但是不建议使用)

   

二、可变参数

1. 构成：数据类型+ … 即数据类型[] 。
2. 特点：不需要传入具体对象
3. 注意点：可变参数需放在后面，优先调用固定参数
4. 作用：节省代码，简化操作



三、Arrays

1. 工具类，静态方法

2. 简单数据类型转字符串Arrays.toString(arr)

3. 数组转集合Arrays.asList(arr)。— 集合方法多

   * 简单数据类型数组作为一个元素。
   * 引用数据类型数组一个元素对应集合的一个元素。
   * 转集合后不能使用add方法，可以使用set方法。

   ```java
   //简单数据类型数组转字符串---方便我们对数组的内容进行查看
   int[] arr1 = {4,5,8,9};
   System.out.println(Arrays.toString(arr1));
   //数组转集合----因为集合的方法多
   //简单数据类型数组转集合
   List<int[]> list = Arrays.asList(arr1);
   System.out.println(list.size());//返回值: 1     将整个简单数据类型的数组作为了集合的一个元素
   //引用类型数组转集合
   String[] strings = {"java","php","ok"};
   List<String> list2 = Arrays.asList(strings);
   System.out.println(list2.size());//返回值: 3  //引用类型数组中的一个元素对应集合中的一个元素
   ```



四、Collections

1. 排序

   ```java
   List<String> list = new ArrayList<>();
   list.add("java");
   //第一种排序:默认按照字典进行排序
   //注意:要想list中的元素可以按照字典排序,元素必须实现Comparable接口
   Collections.sort(list);
   System.out.println("字典排序:"+list);
   
   //第二种:按照从短到长排序
   //自己创建比较器
   ComStringWithLength comStringWithLength = new ComStringWithLength();
   Collections.sort(list, comStringWithLength);
   System.out.println("按照从短到长排序:"+list);
   ```

2. 最大值

   ```java
   String value = Collections.max(list);
   System.out.println("字典顺序最大值:"+value);
   ```

   

五、多线程

1. 线程是工作的基本单元，真正工作的部分。多线程争抢cpu。
2. 主线程（main）和垃圾回收线程（finalize）
3. 线程与方法区





### 作业

1. 假如有以下email数据“aa@sohu.com,bb@163.com,cc@sina.com”现需要把email中的用户部分

​         和邮件地址部分分离，分离后以键值对应的方式放入HashMap？

```java
String[] emails = new String[3];
emails[0] = "aa@sohu.com";
emails[1] = "bb@sohu.com";
emails[2] = "cc@sohu.com";

Map<String, String> map = new HashMap<String, String>();

for(String email: emails) {			
  map.put(email.split("@")[0],email.split("@")[1]);
}

for(String user: map.keySet()) {
  System.out.println("UserName: "+user+"  Email Address: "+map.get(user));
}
```

2. 有两个班级，一班和二班，每个班级有若干学生，包含学号和姓名信息，要求能够完全保存班级和学生信息，遍历输出。

```java
Map<String, Map<String, String>> map = new HashMap<>();

Map<String, String> first = new HashMap<>();
first.put("001", "小明");
first.put("002", "李四");

Map<String, String> second = new HashMap<>();
second.put("001", "小张");
second.put("002", "小红");

map.put("01班级", first);
map.put("02班级", second);

for(String classname: map.keySet()) {
  System.out.println(classname);
  for(String num: map.get(classname).keySet()) {
    System.out.println(num + ":" + map.get(classname).get(num));
  }
}
```

3. 有长度为5的字符串数组，数组中的每个元素均为一个标准英文句子，要求借助Map集合统计每个单词出现的次数。

```java
String[] text = new String[5];
text[0] = "today is a good day";
text[1] = "how are you";
text[2] = "you are beautiful";
text[3] = "good weather";
text[4] = "day day up";

Map<String, Integer> map = new HashMap<>();

for(String line: text) {
  for(String word : line.split(" ")) {
    if(map.get(word) == null) {
      map.put(word, 1);
    }else {
      map.put(word, map.get(word) + 1);
    }
  }
}

for(String word: map.keySet()) {
  System.out.println("{word:" + word+ ", counts:" + map.get(word)+"}");
}
```

