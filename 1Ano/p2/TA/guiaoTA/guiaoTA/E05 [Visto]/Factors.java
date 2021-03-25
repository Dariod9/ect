import static java.lang.System.*;

public class Factors {

  public static void main(String[] args) {
    for(int i = 0; i < args.length; i++)
      out.println(args[i]+" = "+factors(Integer.parseInt(args[i])));
  }

	
	public static String factors(int a){
		
		String s="";
		int n=0;
		//dividing(s,a,2);
		int [] b=new int[n];
		
		for(int i=2;i<=10;i++){
			if(a%i==0){
				n++;
				b[n-1]=i;		
				}
			}
			
		int[] t= new int[2*n];
		
		for(int i=0;i<n;i++){
			t[n]=b[n];
			}
		
		
		for(int i=n;i<2*n;i++){
			t[i]=a/b[2*n-i];			
			}
			
		
		for(int i=0;i<t.length;i++){
			s+=t[i]+" * ";
			}
		
		return s;
		
		}
		
		
	/*public static String dividing(String s,int g,int d){
		
		
		/*
		if(g%d==0){
			s+="d * ";
			if(d<10) dividing(s,g/d,d+1);
		}
		
		else{
			if(d<10) dividing(s,g,d+1);
		}
		
		return s;
		
		
		
		
		 int n=0;
		int[] b=new int[n];
		
		for(int i=2;i<=10;i++){
			
			if(a%i==0){
				n++
				b[n-1]=i;
				}
			
			}
		
		int [] fac= new int[n*2];
		
		for(int i 
		
		
		}*/


}

