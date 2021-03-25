import java.util.*;


public class House {
	
		public String tipo;
		public int dv,add;
		public Room[] div;//=new Room[8];//= new String[8];
		public Room[] div2;//=new Room[8+add];

	public House (String tipo){
		
		this(tipo,8,4);			
				}
		
	public House(String tipo, int dv, int add){
		
		tipo=tipo;
		dv=dv;
		add=add;	
		}
		
	public void addRoom(Room a){
		
				if(div[7]==null){
					
				for(int i=0;i<8;i++){
					if(div[i]==null) div[i]=a;
					}
					
				}
				
				else if(div[7]!=null){
									
					for(int i=0;i<8;i++){div2[i]=div[i];}
					
					div=div2;
					}
					
					for(int i=0;i<div2.length;i++){
						if(div2[i]==null) div2[i]=a;
						
						}
			}
			
	public int size(){
		
		int count=0;
		
		if(div[7]==null){
			for(int i=0;i<div.length;i++){
				if(div[i]!=null) count++;
				}
			}		
		
		else if(div[7]!=null){
		
			count=8;
		
			for(int i=8;i<div2.length;i++){
				if(div2[i]!=null) count++;
				}
		}	
		
		return count;

	}
	
	
	public int maxSize(){
		
		int size=8;
		
		if(div2[7]!=null) size=8+add;
		
		return size;
		}
		
	
	public Room room(int a){
		
		if(div2[a]!=null){ return div2[a]; }
		
		else return div[a];
		}

	
	public double area(){
		
		double ar=0;
		
		if(div2[7]!=null){
			for(int i=0;i<div2.length;i++){
				ar+=div2[i].area();
				}
			}
			
		else {
			for(int i=0;i<=div.length;i++){
				ar+=div[i].area();
				}
			}
			
		return ar;
		
		}


}
