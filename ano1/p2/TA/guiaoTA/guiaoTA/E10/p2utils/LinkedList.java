package p2utils;

import static java.lang.System.*;

public class LinkedList<E> {

  private Node<E> first = null;
  private Node<E> last = null;
  private int size = 0;

  /**
   * {@code LinkedList} constructor, empty so far.
   */
  public LinkedList() { }

  /** Returns the number of elements in the list.
   * @return Number of elements in the list
   */
  public int size() { return size; }

  /** Checks if the list is empty.
   * @return  {@code true} if list empty, otherwise {@code false}.
   */
  public boolean isEmpty() { return size == 0; }

  /** Returns the first element in the list.
   * @return  First element in the list
   */
  public E first() {
    assert !isEmpty(): "empty!";

    return first.elem;
  }

  /** Returns the last element in the list.
   * @return Last element in the list
   */
  public E last() {
    assert !isEmpty(): "empty!";

    return last.elem;
  }

  /** Adds the given element to the start of the list.
   * @param e the element to add
   */
  public void addFirst(E e) {
    first = new Node<>(e, first);
    if (isEmpty())
      last = first;
    size++;

    assert !isEmpty(): "empty!";
    assert first().equals(e) : "wrong element";
  }

  /** Adds the given element to the end of the list.
   * @param e the element to add
   */
  public void addLast(E e) {
    Node<E> newest = new Node<>(e);
    if (isEmpty())
      first = newest;
    else
      last.next = newest;
    last = newest;
    size++;

    assert !isEmpty(): "empty!";
    assert last().equals(e) : "wrong element";
  }

  /** Removes the first element in the list.
   */
  public void removeFirst() {
    assert !isEmpty(): "empty!";
    first = first.next;
    size--;
    if (isEmpty())
      last = null;
  }

  /** Removes all elements.
   */
  public void clear() {
    first = last = null;
    size = 0;
  }

  /** Returns a string representing the list contents.
   * @return A string representing the list contents
   */
  public String toString() {
    String sep = "";
    String s = "";
    for (Node<E> n = first; n != null; n = n.next) {
      s += sep + n.elem;
      sep = ", ";
    }
    return "[" + s + "]";
  }

  // funcoes adicionais pedidas no guião...

	public int count(E e){
		
		return count(first,0,e);
	
		}
		
	public int count (Node<E> n, int cont, E e){
		assert n!=null;
		
		//if(n.elem!=null){
			if(n.elem==e){
				
				cont=cont+1;
				if(n!=last) count(n.next,cont,e);
				return cont;
				}
			
			else{
				if(n!=last)	count(n.next,cont,e);
				return cont;
		
		
		//}
		}
		//else return cont;
	}
		
		
	public int indexOf (E e){
		
		return indexOf(first,e,0);
		
		}

	public int indexOf (Node<E> n,E e, int ordem){
		
		if(n.elem==e) return ordem;
		
		else{
			ordem++;
			//return null;
			if(n!=last) return indexOf(n.next,e,ordem);
			else return ordem;
			}
		
		}
		
		
		
	public LinkedList<E> cloneReplace(E e1, E e2){
		
		return cloneReplace(first,e1,e2);
		
		}
		
		
	public LinkedList<E> cloneReplace(Node<E> n, E e1, E e2){
		
		assert e1!=null && e2!=null;
		
		if(n==null) return new LinkedList<E>();
		
		/*if(n.e1em==e1){
			LinkedList<E> e= cloneReplace(n.next,e1,e2);
			e.addFirst(e2);
			return e;
				}
		else{
			LinkedList<E> e= cloneReplace(n.next,e1,e2);
			e.addFirst(e1); 
			return e;
				}*/
			
			
		LinkedList<E> e= cloneReplace(n.next,e1,e2);
		if(n.elem==e1) e.addFirst(e2);
		else e.addFirst(e1);
		
		return e;
			
			
			}
		
		
		
		
	public LinkedList<E> cloneSublist (int start, int end){
		
		return cloneSublist(first, start, end, 0);
		
		}
		
	public LinkedList<E> cloneSublist (Node<E> n, int start, int end, int p){
		
		if(n==null) return new LinkedList<E>();
		
		LinkedList<E> f=cloneSublist(n.next,start,end,p+1);
		if(p>=start && p<=end-1) f.addFirst(n.elem);
		return f;
		
		}
		
		
		
		
	public LinkedList<E> cloneExceptSublist (int start, int end){
		
		return cloneExceptSublist(first, start, end, 0);
		
		}
		
	public LinkedList<E> cloneExceptSublist (Node<E> n, int start, int end, int p){
		
		if(n==null) return new LinkedList<E>();
		
		LinkedList<E> f=cloneExceptSublist(n.next,start,end,p+1);
		if(p<start || p>end-1) f.addFirst(n.elem);
		return f;
		
		}
		
		
		
	
	public LinkedList<E> removeSublist (int start, int end){
		
		return removeSublist(first, start, end, 0);
		
		}
		
	public LinkedList<E> removeSublist (Node<E> n, int start, int end, int p){
		
		if(n==null) return new LinkedList<E>();
		
		LinkedList<E> f=cloneSublist(n.next,start,end,p+1);
		if(p<start || p>end-1) f.addFirst(n.elem);
		return f;
	
		}

}
