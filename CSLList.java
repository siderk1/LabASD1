package kpi.fict.it03;

public class CSLList<T> implements CustomCollection<T> {
	private Node<T> begin;
	private Node<T> end;
	private int size = 0;
	
	public void append(T value) {
		Node<T> new_node = new Node<T>(value);
		if(begin != null) {
			new_node.prev = end;
			end.next = new_node;
			end = new_node;
			
			new_node.next = begin;
			begin.prev = new_node;
			
		} else {
			begin = end = new_node;
		}
		size++;
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

	
	public Node<T> get(int index) {
		Node<T> current = begin;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current;
	}
	
	public int getIndex(T value) {
		Node<T> current = begin;
		int index = 0;
		while(!current.value.equals(value)) {
			current = current.next;
			index++;
		}
		if(index == 0) {
			return 0;
		}
		return index-1;
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
			current.prev = new_node;
			new_node.prev = end;
			end.next = new_node;
			begin = new_node;
			
		} else {
			new_node.next = current;
			current.prev = new_node;
			prev.next = new_node;
			new_node.prev = prev;
		}
		size++;
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
		Node<T> next = current.next;
		if(current.equals(end)) {
			end = current.prev;
		}
		if (current.equals(begin)) {
			begin = current.next;
		}
		prev.next = next;
		next.prev = prev;
		current = null;
		
		size--;
	}

	
	public void set(T value, int index) {
		get(index).value = value;
		
	}

	public void set(T value, Node<T> item) {
		item.value = value;
		
	}
	
	public int size() {
		return this.size;
	}
	
	
}