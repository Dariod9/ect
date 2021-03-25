
public class Queue<E> {

  private LinkedList<E> list = new LinkedList<E>();
  private int size=0;

  /** Adds a new untitledelement to the queue.
   */
  public void in(E element) { 
	  
	  if(list.isFull()){
			
		list.removeFirst();
		 
		  }
	  list.addLast(element); }

  /** @return  First element in the queue.
   */
   
  public void shift(Node<E> n){
	  
	  while(n!= last){
	  list.n.next=list.n;
	  shift(n.next);
		}
	  }
   
  public E peek() { return list.first(); }

  /** Removes the first element in the queue.
   */
  public void out() { list.removeFirst(); }

  /** @return Number of elements in the queue.
   */
  public int size() { return list.size(); }

  /** Checks if the queue is empty.
   * @return  {@code true} if queue empty, otherwise {@code false}.
   */
  public boolean isEmpty() { return list.isEmpty(); }

  public String toString() { return list.toString(); }

}
