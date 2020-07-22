package sait.sll.manager;

import sait.sll.problemdomain.Node; // note there were three different Node to import
import sait.sll.problemdomain.User;
import sait.sll.utility.LinkedListADT;
/**
 * 
 * @author Zennon Weleschuck and Joel Wood
 * @version 1.1 July 21 2020
 * This method implements the methods of the LinkedListADT interface to build a linked list object
 *
 */
public class SLL implements LinkedListADT {
	private Node head;
	private Node tail;
	private int length = 0;

	/**
	 * constructor of an empty SLL
	 */
	public SLL() {// since no head or tail it is a empty list
		head = tail = null;

	}
	/**
	 *  This method returns a boolean determining if the list is empty or not
	 * @return isEmpty Returns boolean if the list is empty or not
	 */
	@Override
	public boolean isEmpty() {
		return (head == null);
	}

	@Override
	public void clear() {
		head = null;
		length = 0;

	}

	@Override
	public void append(Object data) {
		if (!isEmpty()) {
			tail.setNext(new Node(data));
			tail = tail.getNext();
			length++;
		} else {
			head = tail = new Node(data);
			length++;
		}
	}

	@Override
	public void prepend(Object data) {
		// head = new Node(data, head);
		/**if (!isEmpty()) {
			head.setNext(new Node(data));
			head = head.getNext();
			length++;
		} else {
			head = tail = new Node(data);
			length++;
		}*/
		head = new Node(data, head);
		if (tail == null)
			tail = head;
		length++;

	}

	@Override
	public void insert(Object data, int index) throws IndexOutOfBoundsException {
		if(index >= 0 && index < size()) {
			Node newNode = new Node(data);
			if(index == 0) {
				newNode.setNext(head);
				head = newNode;
			}
			else {
				Node previous = head;
				int count = 0;
				while(count < index -1) {
					previous = previous.getNext();
					count ++;
				}
				Node current = previous.getNext();
				previous.setNext(newNode);
				newNode.setNext(current);
			}
			
		}
		else {
			System.out.print("Index must be positive and less than the size of the list");
		}

	}

	@Override
	public void replace(Object data, int index) throws IndexOutOfBoundsException {
		Node current = head;
		if(index > 0 && index < size() && data != null) {
			
			for(int i = 0; i < index; i++) {
				current = current.getNext();
			}
			current.setElement(data);
		}
		else {
			System.out.println("Index must be greater than 0 and less than the size of the list");
		}
	}
	

	@Override
	public int size() {
		return length;
	}

	@Override
	public void delete(int index) throws IndexOutOfBoundsException {
		Node first = head;
		Node second = head;
		for (int i = 0; i < index; i++) {
			if (second.getNext() == null) {
				if (i == index - 1) {
					--length;
					head = head.getNext();
				}
				return;
			}

			second = second.getNext();
		}
		while (second.getNext() != null) {
			first = first.getNext();
			second = second.getNext();
		}

		first = first.getNext().getNext();
		--length;
	}

	@Override
	public Object retrieve(int index) throws IndexOutOfBoundsException {
		if (isEmpty()) {
			return null;
		}

		Node current = head;
		Object temp = null;

		try {
			for (int i = 0; i < index; i++) {
				current = current.getNext();
				//System.out.println(current.getElement().toString());
			}
			
			temp = current.getElement();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("-1");
			e.printStackTrace();

		}
		return temp;
	}

	@Override
	public int indexOf(Object data) {
		if(isEmpty()) {
			System.out.println("The list is empty");
			return -1;
		}
		else {
			Node current = head;
			for(int i = 0; i < size(); i++) {
				if(data.equals(current.getElement())){
					return i;
				}
				current = current.getNext();
			}
		return -1;
		}
		
	}

	@Override
	public boolean contains(Object data) {
		if(isEmpty()) {
			System.out.println("The list is empty");
			return false;
		}
		else {
			Node current = head;
			int index = -1;
			for(int i = 0; i < size(); i++) {
				if(data.equals(current.getElement())){
					index = i;
				}
				current = current.getNext();
			}
			if (index >= 0) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	public void print() { // not required method
		for (Node temp = head; temp != null; temp = temp.getNext()) {
			System.out.println(temp.getElement().toString());
		}
	}

}
