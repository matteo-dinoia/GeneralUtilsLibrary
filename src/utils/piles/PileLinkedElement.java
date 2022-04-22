package utils.piles;

public class PileLinkedElement <E>{ //ALMOST ABSTRACT
	public PileLinkedElement<E> previous;
	public PileLinkedElement<E> next;
	

	E elementInPile;
	public E getElement() {
		return elementInPile;
	}
	public PileLinkedElement(E elementInPile) {
		this.elementInPile=elementInPile;
	}
}
