package com.mycompany.a2;

public interface IIterator {
	
	public boolean hasNext();
	public Object getNext();
	public void remove();
	public void remove(GameObject obj);
	
}
 