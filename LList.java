package kpi.fict.it03;

public class LList<T> implements CustomCollection<T>{
	private Node<T> begin;
	private Node<T> end;
	private int size = 0;
	public void append(T value) {
		Node<T> new_node = new Node<T>(value);
		if(begin != null) {
			end.next = new_node;
			end = new_node;
		} else {
			begin = end = new_node;
		}
		size++;
		
	}
	
	public int size() {
		return this.size;
	}
	public void insert(T value, int index) {
		Node<T> current = begin;
		Node<T> prev = null;
		Node<T> new_node = new Node<T>(value);
		for (int i = 0; i < index; i++) {
			if(i == index-1) {
				prev = current;
			}
			current = current.next;
		}
		if (index == 0) {
			new_node.next = current;
			begin = new_node;
			
		} else {
			new_node.next = current;
			prev.next = new_node;
		}
		
		size++;
	}
	
	public Node<T> get(int index) {
		Node<T> current = begin;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current;
	}
	
	public void set(T value, int index) {
		get(index).value = value;
	}
	
	public void set(T value, Node<T> item) {
		item.value = value;
		
	}
	public void remove(int index) {
		Node<T> current = begin;
		Node<T> prev = null;
		for (int i = 0; i < index; i++) {
			if(i == index-1) {
				prev = current;
			}
			current = current.next;
		}
		if (index == 0) {
			begin = current.next;
			current = null;
		} else {
			prev.next = current.next;
			current = null;
		}
		
		size--;
	}
	
	public int summ() {
		
		if(begin.value instanceof Integer) {
			int result = 0;
			for (int i = 0; i<this.size; i++) {
				result += (int) get(i).value;
			}
			return result;
		}
		return 0;
	}
	
	public int getIndex(T value) {
		Node<T> current = begin;
		int index = 0;
		while(!current.value.equals(value)) {
			index++;
			current = current.next;
		}
		if(index == 0) {
			return 0;
		}
		return index;
	}
	
	
}
