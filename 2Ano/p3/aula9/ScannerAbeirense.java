package aula9;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Scanner;

public class ScannerAbeirense implements Iterator<String>, Closeable {
	
	private Scanner sc;

	public ScannerAbeirense(File f) throws FileNotFoundException {
		sc=new Scanner(f);
	}
	
	public ScannerAbeirense(InputStream is) {
		sc=new Scanner(is);
	}
	
	@Override
	public void close() throws IOException {
		sc.close();
		}

	@Override
	public boolean hasNext() {
		return sc.hasNext();
	}

	@Override
	public String next() {
		String s=sc.next();
		s=s.replace("v","b");
		s=s.replace("V","B");
		return s;
	}
	
	public String nextLine() {
		String s=sc.nextLine();
		s=s.replace("v","b");
		s=s.replace("V","B");
		return s;
	}
	
	
}
