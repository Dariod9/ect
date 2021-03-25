import static java.lang.System.*;

public class P3 {

  public static void main(String[] args) {

	out.print("\n"+args[0]+" is prefixed by "+args[1] +" -->"+isPrefix(args[0],args[1],0));
	
	if(args.length>2){
		for(int i=2;i<args.length/2+1;i++){
			out.print("\n"+args[2*i-2]+" is prefixed by "+args[2*i-1] +" -->"+isPrefix(args[2*i-2],args[2*i-1],0));
			}
		}

	}
	

	public static boolean isPrefix (String s, String p, int n){
		
		assert p!="" && s!="";
		
		if(n<p.length()){
			
			if(s.charAt(n)!=p.charAt(n)) return false;
			
			else return isPrefix(s,p,n+1);
			
			}

		/*for(int i=0;i<p.length();i++){
			if(s.charAt(i)!=p.charAt(i)) pre=false;
			}*/
		
		
		}


}

