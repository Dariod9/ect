package aula5.Ex3;

import java.io.*;
import java.util.ArrayList;

public interface ContactManage{
	
	public ArrayList<Contacto> read() throws FileNotFoundException;
	void SaveFile(ArrayList<Contacto> p, String type) throws IOException;
}