####讲解练习

1. switch
   * 没有break时候的穿透性
   * default的执行顺序

```java
switch(int i){
    default
       i += 2;
    case 1
       i += 1;
    case 2
       i += 8;
}
```

2. 死循环
3. 自加



#### 排序

1. 冒泡排序

   ```java
   	//冒泡排序
   	public static void bubbleSort(int[] arr) {
   		for (int i = 0; i < arr.length-1; i++) {//确定的是整体的次数,比元素的个数少一
   			for (int j = 0; j < arr.length-i-1; j++) {//确定一个元素需要比较的次数
   				if (arr[j] > arr[j+1]) {//交换
   					arr[j] = arr[j] ^ arr[j+1];
   					arr[j+1] = arr[j] ^ arr[j+1];
   					arr[j] = arr[j] ^ arr[j+1];
   				}
   			}
   		}
   	}
   ```

2. 选择排序

   ```java
   	//冒泡排序
   	public static void bubbleSort(int[] arr) {
   		for (int i = 0; i < arr.length-1; i++) {//确定的是整体的次数,比元素的个数少一
   			for (int j = i; j < arr.length-1; j++) {//确定一个元素需要比较的次数
   				if (arr[i] > arr[j+1]) {//交换
   					arr[i] = arr[i] ^ arr[j+1];
   					arr[j+1] = arr[i] ^ arr[j+1];
   					arr[i] = arr[i] ^ arr[j+1];
   				}
   			}
   		}
   	}
   ```



#### 查找

1. 普通查找

   ```java
   public static int search(int[] arr,int key){
     for(int i = 0; i < arr.length - 1; i++){
        if(key == arr[i]){
          return i;
    
     }
     return -1;
   }
   ```

   

2. 二分查找(前提有序)

   ```java
   public static int binarySearch(int[] arr,int key){
     int l = 0;
     int h = arr.length - 1,m;
     
     while(l<=h){
        m = (l+h)/2;
        if(key == arr[m]){
          return m;
        }else if(key < arr[m]){
          h = m - 1;
        }else if(key > arr[m])
          h = m + 1;
     }
     return -1;
   }
   ```

#### 二维数组

```java
new + 数据类型 + [一维数组的个数] + [每个一维数组中的个数] 是估计值。

int[][] arr = new int[4][];
int[][] arr = {{2,3,5},{2.3,6}，{4,6,7}};
```



#### 面向对象初级

* 面向对象

​    是相对于面向过程而言，过程其实就是函数，对象是将函数和属性进行了封装。

1. 将复杂的事情简单化。

2. 面对对象将一切的过程中的执行者，变成了指挥者

3. 面向对象思想符合人们思考习惯的一种思想

   

* 对象

  接收消息的实体，一切皆为对象，对象都有属性和行为，对象都属于某个类，每个对象都是独一无二的

  

* 类

  创建对象的蓝图和模板

  * 类名：大写

  * 类的属性：数据抽象

  * 类的方法：行为抽象

    ```java
    class Dog(){
      double  weight;
      int age;
      String name;
      
      public void bark(){
        System.out.println(name+" is barking!");
      }
    }
    ```

    