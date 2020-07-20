package sait.sll.manager;

import sait.sll.problemdomain.Node; // note there were three different Node to import
import sait.sll.problemdomain.User;
import sait.sll.utility.LinkedListADT;

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
		// TODO Auto-generated method stub

	}

	@Override
	public void replace(Object data, int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(Object data) {
		// TODO Auto-generated method stub
		return false;
	}

	public void print() { // not required method
		for (Node temp = head; temp != null; temp = temp.getNext()) {
			System.out.println(temp.getElement().toString());
		}
	}

}
