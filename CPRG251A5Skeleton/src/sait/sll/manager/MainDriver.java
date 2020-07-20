package sait.sll.manager;

import sait.sll.problemdomain.User;

public class MainDriver {

	public static void main(String[] args) {
		//for testing code
		User alice = new User(1234, "Alice", "email@gmail.com", "PaSsWord");
		User joel = new User(4321, "Joel", "JW@gmail.com", "wordPass");
		User zen = new User(69420, "zen", "BluntSmokinAnusDestroy@gmail.com", "drowssap");
		User ali = new User(9876, "Ali", "ALi@sait.ca", "password123");
		
		SLL sll = new SLL();
		sll.append(alice); // append works
		//sll.print();
		sll.append(joel);
		sll.prepend(ali); // prepend is  works 
		//sll.print();
		sll.append(zen);
		sll.print(); 
		System.out.println(sll.isEmpty()); //isempty works
		System.out.println(sll.size()); // size works
		//sll.clear(); // clear works)
		//System.out.println(sll.isEmpty());
		//System.out.println(sll.size());
		System.out.println(sll.retrieve(3)); // retrieve is working

		//sll.delete(1); // fairly sure this isnt working

	}

}
