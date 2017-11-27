package queue;


public class SLLQueue<E> implements Queue<E> {

	private Node<E> first, last;   
	private int size; 
	
	public SLLQueue() {           // initializes instance as empty queue
		first = last = null; 
		size = 0; 
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public E first() {
		if (isEmpty()) return null;
		return first.getElement(); 
	}
	public E dequeue() {
		if (isEmpty()) return null;	
		Node<E> tmp = first;
		if (size==1){
			last = null;
		}
		first = tmp.getNext();
		size--;
		return tmp.getElement();
		
	}
	public void enqueue(E e) {
		if (size == 0) 
			first = last = new Node<>(e, null); 
		else { 
			Node<E> tmp = new Node<E>(e, null);
			last.setNext(tmp);
			last = tmp;
		}
		size++; 
	}


	@Override
	public void showReverse() { 
	    if (size == 0)
		   System.out.println("Queue is empty."); 
		else
		   recSR(first);
    } 
    private void recSR(Node<E> f) { 
		if (f != null) { 
		   recSR(f.getNext()); 
		   System.out.println(f.getElement()); 
	     } 
    } 
    
    private class Node<E>{
    		private E element;
    		private Node<E> next;
    		
    		public Node(E e, Node<E> n) {
    			element = e;
    			next = n;
    		}
    		
    		public E getElement() {
    			return element;
    		}
    		
    		public Node<E> getNext() {
    			return next;
    		}
    		
    		public void setElement(E e) {
    			element = e;
    		}
    		
    		public void setNext(Node<E> n) {
    			next = n;
    		}
    		
    		
    		
    	
    }

}
