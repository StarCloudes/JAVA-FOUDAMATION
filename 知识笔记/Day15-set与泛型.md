一、 set 无序且唯一

1. HashSet：底层哈希表，线程不安全

   * add方法内部实现了去重的方法，默认重写了hashCode和equals方法
   * 可以去重，但不可以进行排序，因为不能比较大小

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

   

2. TreeSet：底层二叉树，线程不安全

   * 可以实现排序（字典升序）和去重（compareTo方法）

   ```java
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
   ```

   * 比较器comparator：

     * 使用实现了Comparator接口的compare()方法的比较器对象进行比较
     * 作为函数的参数，制定比较字符串长度规则

   ```java
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
   }
   ```

二、泛型

1. 泛型的基础：使用范型不需要容错处理，简化代码；编译阶段检查，提高了代码的安全性。

2. 泛型应用于类、接口、方法

   * 类
   * 接口 2种
   * 方法 3种

3. 泛型的限制上限，限制下线



三、map

1. Map基础
2. HashMap
3. TreeMap