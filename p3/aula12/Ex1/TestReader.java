package aula12.Ex1;

import java.lang.reflect.InvocationTargetException;

public class TestReader {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		new ClassReader("Quadrado");
	}
}
