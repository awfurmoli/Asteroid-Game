package com.mycompany.a2;

import java.util.ArrayList;
//import java.util.Iterator;

public class GameObjectCollection implements ICollection {
	private ArrayList<GameObject> collection  ; 
	
	//// Constructor////
	public GameObjectCollection() {
		collection  = new ArrayList<GameObject>(); 
	}
	
	@Override
	public IIterator getIterator() {
		
		return new GameObjectIterator();
	}
	
	@Override
	public void add(Object newObj) {
		collection.add((GameObject) newObj) ;
	}
	

	private class GameObjectIterator implements IIterator{
		
		private int curIndex ;
		/// Constructor/////
		 
		public GameObjectIterator() {
			curIndex=-1 ;
		}
		public boolean hasNext() {
			if (collection.size( ) <= 0)
				return false;
			if(curIndex==collection.size()-1)
				return false;
			return true;
		}
	
		public Object getNext() {
			curIndex++ ;
			return (collection.get(curIndex) );
		}
		public void remove() {
			
			collection.remove(this.curIndex);
			this.curIndex--;
		}
		public void remove(GameObject obj) {
			collection.remove(obj);
			this.curIndex--;
		}
		
	}



	
	
			
			




	
	
	
	
}
