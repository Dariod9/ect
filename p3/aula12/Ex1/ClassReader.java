package aula12.Ex1;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassReader {
	
	static Scanner sc=new Scanner(System.in);
	private String targetClass;
	
	ClassReader(String targetClass) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		Class<?> c=Class.forName("aula12.Ex1."+targetClass);
		
		System.out.println("Caraceterísticas:");
		
		System.out.println("\nInterfaces:");
		Class<?>[] interfaces = c.getInterfaces();
		for(Class<?> inter : interfaces) {
			System.out.println(inter.getSimpleName());
		}
		
		System.out.println("\nSuperclass:");
		System.out.println(c.getSuperclass().getSimpleName());
		
		System.out.println("\nConstrutores");
		Constructor<?>[] cons= c.getConstructors();
		for(Constructor<?> consT : cons) {
			System.out.println("\n"+consT.getName());
			Class[] parametros = consT.getParameterTypes();
			for (int i = 0;i<parametros.length;i++) {
				System.out.print(parametros[i].getSimpleName());
				if(i<parametros.length-1)
					System.out.print(" , ");
			}
		}
		
		
		System.out.println("\nMétodos:");
		Method[] methods=c.getMethods();
		for(Method m :methods) {
			System.out.println(m.getName());
		}
		
		System.out.println("\nAtributos:");
		Field[] fields=c.getDeclaredFields();
		for(Field f : fields) {
			System.out.println(f.getName());
		}

		
		System.out.println("Criar um objeto:");
		Constructor<?>[] cons2= c.getConstructors();
		
		for(Constructor<?> consT : cons) {
			
			System.out.println("\n"+consT.getName());
			Class[] parametros = consT.getParameterTypes();
			
			for (int i = 0;i<parametros.length;i++) {
				System.out.print(parametros[i].getSimpleName());
				if(i<parametros.length-1)
					System.out.print(" , ");
				
			}
		}
		
		
		System.out.println("Construtor (int):");
		int e=sc.nextInt();
		double lado=0;
		double x,y=0;
			
		switch(e) {
		
		case 1: lado=sc.nextDouble(); 
	
		Class<?>[] paramTypes = {Double.TYPE };
		Constructor<?> tmp = c.getConstructor(paramTypes);
		Object o=tmp.newInstance(lado);
		System.out.println(o.toString());
		
				break;
				
		case 2: x=sc.nextDouble();
				y=sc.nextDouble();
				lado=sc.nextDouble();
				

				Class<?>[] paramTypes2 = {Double.TYPE, Double.TYPE, Double.TYPE };
				Constructor<?> tmp2 = c.getConstructor(paramTypes2);
				Object o2=tmp2.newInstance(x,y,lado);
				System.out.println(o2.toString());
				
				break;
		case 3:x=sc.nextDouble();
				y=sc.nextDouble();
				lado=sc.nextDouble();
				Ponto p=new Ponto(x,y);

				Class<?>[] paramTypes3 = {Double.TYPE};
				Constructor<?> tmp3 = c.getConstructor(paramTypes3);
				Object o3=tmp3.newInstance(lado);
				System.out.println(o3.toString());
				
				break;
		} 
		
	}
}
