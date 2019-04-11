package com.hoemwork2.homework13;

public class Demo1 {
	public static void main(String[] args) {
	    Character c1 = new Character('A');
	    Character c2 = new Character('a');
	    
	    System.out.println(c1.equals(c2));
	    
	    c1 = Character.toUpperCase(c1);
	    c2 = Character.toUpperCase(c2);
	    
	    System.out.println(c1.equals(c2));
	    
	}

}
