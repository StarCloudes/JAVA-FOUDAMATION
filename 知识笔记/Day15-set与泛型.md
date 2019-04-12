一、 set 无序且唯一

1. 使用List实现去重

   工作原理: 当添加元素时,会让当前的元素与集合中已有的元素通过equels方法进行一一比较.过程中只要有一次返回true,停止比较.让整个的contains方法返回true.只有所有的比较都返回false,最终 才会返回false。重写equals方法可以对list对象去重。

   ```java
   //使用List存储数据,但是数据不能重复----利用Contains
   //让他去存储去重后的数据
   ArrayList list1 = new ArrayList<>();
   //获取第一个list的迭代器
   Iterator iterator = list.iterator();
   while (iterator.hasNext()) {
     Object object = (Object) iterator.next();
     if (!list1.contains(object)) {
   				list1.add(object);
   			}
   }
   ```

2. HashSet：底层哈希表，线程不安全

    原理:是通过调用元素的hashCode和equals方法实现去重,首先调用hashCode方法,拿到当前对象的哈希码值,去让两个对象的哈希码值进行比较,如果不同,直接认为是两个对象,不再去调用equals,如果相同,再继续调用equals方法,返回true认为是 一个对象,返回false认为是两个对象

   * add方法内部实现了去重的方法，默认重写了hashCode和equals方法
   * 可以去重，**但不可以进行排序，因为不能比较大小**

   ```java
   	//重写equals方法
   	@Override
   	public boolean equals(Object obj) {
   		//自己制定比较规则:根据年龄和姓名比较
   		//容错处理
   		if (!(obj instanceof Person1)) {
   			throw new ClassCastException("当前的对象不是Person1类型的");
   		}
   		
   		//向下转型
   		Person1 person = (Person1)obj;
   		return this.name.equals(person.name)  && this.age==person.age;
   	}
   	
   	//重写hashCode方法
   	@Override
   	public int hashCode() {
   		return name.hashCode()+age*1000;
   	}
   ```

   

3. TreeSet：底层二叉树，线程不安全

   * TreeSet的add方法实现的排序（字典升序）,去重。
   * 通过调用元素的compareTo方法

   ```java
   class Person2 implements Comparable{
   
     public int compareTo(Object o) {
     //根据自己制定的规则比较
     //根据年龄和姓名比较
     //容错处理
     if (!(o instanceof Person2)) {
       throw new ClassCastException("当前的对象不是Person2的对象");
     }
     //向下转型
     Person2 person2 = (Person2)o;
     //先比较年龄
     int num = age-person2.age;
     //再比较姓名
     return num == 0?name.compareTo(person2.name) : num;
   }
   }
   ```

   * 比较器comparator：

     * 使用实现了Comparator接口的compare()方法的比较器对象进行比较
     * 作为函数的参数，制定比较字符串长度规则

   ```java
   //2.创建比较器对象
   ComWithLength comWithLength = new ComWithLength();
   //3.通过参数交给TreeSet
   Set set = new TreeSet<>(comWithLength);
   //1.创建一个比较器
   //按照字符串的长度比较
   class ComWithLength implements Comparator{
   
   	public int compare(Object o1, Object o2) {
   		if (!(o1 instanceof String)) {
   			throw new ClassCastException("当前的对象不是String的对象");
   		}
   		if (!(o2 instanceof String)) {
   			throw new ClassCastException("当前的对象不是String的对象");
   		}
   		//向下转型
   		String s1 = (String)o1;
   		String s2 = (String)o2;
   		
   		int num = s1.length()-s2.length();
   		return num==0?s1.compareTo(s2):num;
   }
   //自定义的比较规则,按照姓名和年龄比较
   class ComWithPerson implements Comparator{
   	
   	public int compare(Object o1, Object o2) {
   		if (!(o1 instanceof Person2)) {
   			throw new ClassCastException("当前的对象不是Person2的对象");
   		}
   		if (!(o2 instanceof Person2)) {
   			throw new ClassCastException("当前的对象不是Person2的对象");
   		}
   		//向下转型
   		Person2 p1 = (Person2)o1;
   		Person2 p2 = (Person2)o2;
   		
   		int num = p1.age-p2.age;
   		return num==0?p1.name.compareTo(p2.name) : num;
   	}
   }
   ```

二、泛型

1. 泛型的基础：使用范型不需要容错处理，简化代码；编译阶段检查，提高了代码的安全性。

   ```java
   //让作用域迭代器的泛型与对应的集合保持一致
   Iterator<String> iterator = list.iterator();
   //使用泛型后
   while (iterator.hasNext()) {
     String string = iterator.next();
     System.out.println(string);
   }
   ```

   

2. 泛型应用于类、接口、方法

   * 类
   * 接口 2种
   * 方法 3种

3. 泛型的限制上限，限制下线



三、map

1. Map基础
2. HashMap
3. TreeMap