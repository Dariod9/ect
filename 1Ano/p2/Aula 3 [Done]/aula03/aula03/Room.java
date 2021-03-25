import java.util.*;

public class Room {

		public String nome;
		public Point c1, c2;
		
	public Room(Point c1, Point c2, String nome){
		
		nome=nome;
		c1=c1;
		c2=c2;
		
		
		}
	
	public String roomType(){ return nome;}
	public Point bottomLeft() { return c1 ;}
	public Point topRigth()	{return c2;}

	public Point geomCenter() {
		
		Point c3=  c1.halfWayTo(c2);
		
		return c3;
		
		}
		
	public double area(){
		
		double area=0;
		
		if(c2!=null && c1!=null) area=(c2.x()-c1.x())*(c2.y()-c2.y());
		
		return area;
		
		
		}
	
}

