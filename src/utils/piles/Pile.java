package utils.piles;

public class Pile<E>{
	private PileLinkedElement<E> first=null;
	private PileLinkedElement<E> last=null;
	
	//MANAGMENT FIFO LIFO ---------------------------------------
	 //First IN first OUT (else Last IN Fist OUT
	private boolean isFifo;
	public Pile(boolean isFifo) {
		this.isFifo=isFifo;
	}
	/**Default type is FIFO*/
	public Pile() {
		this(true);
	}
	
	private int size=0;
	public void push(E element) {
		if(element==null) return;
		
		PileLinkedElement<E> el=new PileLinkedElement<>(element);
		if(this.first==null) {
			this.first=el;
			this.last=el;
		}
		else {
			el.next=first;
			first.previous=el;
		}
		
		//SIZE and element
		this.first=el;
		this.size++;
	}
	public E pop() {
		if(isFifo) return popLast();
		else return popFirst();
	}
	private E popLast() {
		if(this.last==null) return null;
		
		E ris=this.last.getElement();
		this.removeLast();
		
		if(this.size>0) this.size--;
		return ris;
	}
	private E popFirst() {
		if(this.first==null) return null;
		
		E ris=this.first.getElement();
		this.removeFirst();
		
		if(this.size>0) this.size--;
		return ris;
	}
	
	
	
	//UTILS  ----------------------------------------------------
	public E getFirst() {
		return first.getElement();
	}
	public void removeLast() {
		if(this.last==null) return;
		
		
		this.last=this.last.previous;
		if(this.last!=null)  this.last.next=null;
	}
	public void removeFirst() {
		if(this.first==null) return;
		
		
		this.first=this.first.next;
		if(this.first!=null)   this.first.previous=null;
	}
	public int getSize() {
		return size;
	}

}
