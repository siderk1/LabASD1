package kpi.fict.it03;

public class Node<T> {
	public T value;
	
	public Node(T value) {
		this.value = value;
	}
	
	public Node<T> next;
	public Node<T> prev;
}
