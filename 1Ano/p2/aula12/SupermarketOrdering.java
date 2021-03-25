import static java.lang.System.*;
import p2utils.Queue;
import p2utils.HashTable;

public class SupermarketOrdering {
	
	SupermarketOrdering(){}
	
	public int numOrders(){
		return numOrders;
		}

	public void enterOrder(Order a) {
		assert a!=null;
		
		orders.in(a);
		numOrders++;
		
		if(!products.contains(a.prodName)){
			products.set(a.prodName, a.quantity);
			}
		else{
			int q=products.get(a.prodName);
			products.set(a.prodName,q+a.quantity);
			}
		}
		
	public Order serveOrder(){
		
		Order serve=orders.peek();
		
		products.set(serve.prodName, products.get(serve.prodName)-serve.quantity);
		
		orders.out();
		numOrders--;
		
		return serve;
		
		}
		
		
	public int query(String s){
		
		return products.get(s);
		
		}
	
	
	public void displayOrders(){
		
		Queue<Order> temp= orders;
		
		for(int i=0;i<temp.size()-1;i++){
			
			String pessoa=temp.peek().clientName;
			String pedido=temp.peek().prodName;
			
			out.printf("\n "+pessoa+" --> "+pedido);
			temp.out();
			
			}	
			
		
		String[] array=products.keys();
		
		for(int i=0;i<(array.length)-1;i++){
			out.printf("\n "+array[i]+" ---> "+products.get(array[i]));
			}	
			
		} 
		

	
	
	private int numOrders = 0;
	private Queue<Order> orders = new Queue<>();
	private HashTable<Integer> products = new HashTable<>(10);
		
}


