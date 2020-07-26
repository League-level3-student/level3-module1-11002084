package _01_IntroToArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
	public static void main(String[] args) {
		//1. Create an array list of Strings
		//   Don't forget to import the ArrayList class
		ArrayList<String> stringArr = new ArrayList<String>();

		//2. Add five Strings to your list
		stringArr.add("Fred");
		stringArr.add("John");
		stringArr.add("Devin");
		stringArr.add("Dewey");
		stringArr.add("Roger");
		
		//3. Print all the Strings using a standard for-loop
		for(int i=0; i<stringArr.size(); i++) {
			System.out.println(stringArr.get(i));
		}
		System.out.println("\n");
		
		//4. Print all the Strings using a for-each loop
		for(String name : stringArr) {
			System.out.println(name);
		}
		System.out.println("\n");
		
		//5. Print only the even numbered elements in the list.
		for(int i=0; i<stringArr.size(); i++) {
			if(i%2 == 0) {
				System.out.println(stringArr.get(i));
			}
		}
		System.out.println("\n");
		
		//6. Print all the Strings in reverse order.
		for(int i=stringArr.size()-1; i>=0; i--) {
			System.out.println(stringArr.get(i));
		}
		System.out.println("\n");
		
		//7. Print only the Strings that have the letter 'e' in them.
		CharSequence charSequence = "e";
		
		for(String name : stringArr) {
			if(name.contains(charSequence)) {
				System.out.println(name);
			}
		}
	}
}
