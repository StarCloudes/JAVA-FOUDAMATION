package com.classroom.homework14;
import java.util.*;;

//狗狗
public class ListDemo {
    public static void main(String[] args) {
    	//1.增：
		//void add(int index, E element) 
		//boolean addAll(int index, Collection<? extends E> c) 
        List list = new ArrayList<>();
        // 添加元素
        list.add("hello");
        list.add("world");
        list.add("java");
		//2.删
		//E remove(int index) 

		//3.改
	    //E set(int index, E element)

		//4.查
	     //ListIterator<E> listIterator() 
	     //返回此列表元素的列表迭代器（按适当顺序）。 
	     //ListIterator<E> listIterator(int index) 
	     //List<E> subList(int fromIndex, int toIndex) 
	     //E get(int index)
        
        ListIterator lit = list.listIterator();
        while (lit.hasNext()) {
            String s = (String) lit.next();
            if ("world".equals(s)) {
                lit.add("javaee");
            }
            
            if ("java".equals(s)) {
                lit.remove();
            }
        }
        
        System.out.println("list:" + list);
        
    }
        
}
