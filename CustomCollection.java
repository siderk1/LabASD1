package kpi.fict.it03;

public interface CustomCollection<T> {
	
	public void append(T value); 
	public Node<T> get(int index);
	public void insert(T value, int index);
	public void remove(int index);
	public void set(T value, int index);
	public int size();
	public int getIndex(T value);
	public int summ();
}