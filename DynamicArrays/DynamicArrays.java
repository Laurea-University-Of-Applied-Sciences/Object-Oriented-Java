// Source code for DynamicArrays workshop exercises
package DynamicArrays;
import java.util.ArrayList;  // 2. You need to import this required package

public class DynamicArrays {

	public static void main(String[] args) {
		
		// 2. Declaring the ArrayList
		ArrayList<String> classmates = new ArrayList<String>();
		
		// 3. Adding elements to the array
		classmates.add("Meija");
		classmates.add("Pekka");
		classmates.add("Antonius");
		classmates.add("Juuso");
		classmates.add("Kaisa");
		
		// 3. Printing elements. It is enough to pass the name of the ArrayList as a parameter to println
		System.out.println("3. Classmates are: " + classmates);
		
		// 4. Adding a new element into a given position. Remember that indexes start from "0"!
		classmates.add(1, "Piia");
		System.out.println("4. Classmates are: " + classmates);
		
		// 5. Removing an item by "value"
		classmates.remove("Meija");
		System.out.println("5. Classmates are: " + classmates);
		
		// 6. Removing an item by "index"
		classmates.remove(0);
		System.out.println("6. Classmates are: " + classmates);
		
		// 7. Changing the value of an item
		classmates.set(2, "Kiia");
		System.out.println("7. Classmates are: " + classmates);
		
		// 8. Finding out the index of a given item
		int index = classmates.indexOf("Kiia");
		System.out.println("8. Index of Kiia is: " + index);
		
		// 9. Finding out the size of the ArrayList
		System.out.println("9. The number of items is: " + classmates.size());
		
		// 10. Getting the last item in the ArrayList
		String last = classmates.get(classmates.size()-1);
		System.out.println("10. The last item is: " + last);
		
		// 11. Searching for a given value
		System.out.println("11. Is Tiina in the list? " + (classmates.contains("Tiina") ? "yes" : "no"));
		
		// 12. Clearing the ArrayList
		classmates.clear();
		System.out.println("12. Cleared: " + classmates);
	}
}
