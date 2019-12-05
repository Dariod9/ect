package aula11.Ex3;

import java.util.Arrays;

public class UtilCompare {
	
	public static <T> Comparable<T> findMax(Comparable<T>[] a){
		
		Comparable<T> b=a[0];
		
		for(int i=0;i<a.length;i++){
			if(a[i].compareTo( (T) b)>1) b=a[i];
		
		}
		
		return b;
	}
	
	public static <T> void sortArray(Comparable<T>[] a){
	        	    Arrays.sort(a); 
	   
	}
}
