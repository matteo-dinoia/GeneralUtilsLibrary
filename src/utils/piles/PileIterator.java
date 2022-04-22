package utils.piles;

public class PileIterator <T>{
	private PileLinkedElement<T> next;

	public PileIterator(PileLinkedElement<T> first){
		this.next=first;
	}

	public boolean hasNext(){
		return next!=null;		
	}

	public T next(){
		if(!hasNext()) return null;

		T ris=(T) next.getElement();
		next=next.next;
		return ris;
	}
}
