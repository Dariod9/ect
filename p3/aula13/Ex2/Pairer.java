package aula13.Ex2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



public class Pairer {

	public static void main(String[] args) throws IOException {
		
		String end="";
		
		Map<String, Map<String, Integer>> map = new HashMap<>();

		Charset	charset	=	Charset.forName("UTF-8");
		
		String[] palavras= Arrays.stream(Files.readAllLines(Paths.get("src\\\\aula13\\\\Ex2\\\\Policarpo.txt")).stream().collect(Collectors.joining(" "))
				.split("[-|\t|\n| |.|,|:|'|,|;|?|!|*|{|}|=|+|&|/|(|)|[|]|\"|'|“|”|‘|’]")) 
				.filter(x -> x.length() > 2)
				.map(x -> x.toLowerCase()) //Converts every word to lower case
				.collect(Collectors.toList()).toArray(new String[0]);
		

		for(int i = 0, j=1;i<palavras.length-1;i++,j++) {
			
			if(!map.containsKey(palavras[i])) map.put(palavras[i], new HashMap<>());
			
			
			Map<String, Integer> map2 = map.get(palavras[i]);
			if(!map2.containsKey(palavras[j])) map2.put(palavras[j], 0);
		
			map2.put(palavras[j], map2.get(palavras[j]) +1);
		}
		
		List<String> sortedMap = new ArrayList<String>(map.keySet());
		Collections.sort(sortedMap);
		
		for(int i = 0;i<sortedMap.size();i++) {
		
			String s1 = sortedMap.get(i);
			end += s1 + "={";
			
			System.out.print(s1 + "={");
			
			String [] sArray =  map.get(s1).keySet().toArray(new String[map.get(s1).keySet().size()]);
			
			for(int j = 0;j<sArray.length;j++) {
				end +=sArray[j] + "=" + map.get(s1).get(sArray[j]) ;
				
				System.out.print(sArray[j] + "=" + map.get(s1).get(sArray[j]));
				
				if(j!=sArray.length-1) {
					end +=", ";
					System.out.print(", ");
				}
			}
			end +=  "}\n";
			System.out.print("}\n");
		}
		
		
		
		System.out.print(end);	
		Path fileDest =Paths.get("src\\\\aula13\\\\Ex2\\\\resultado.txt");
		try	(BufferedWriter	wr	=	Files.newBufferedWriter(fileDest, charset))	{
			wr.write("Merry Christmas :)");
			wr.write(end,	0,	end.length());
			
		}
		catch	(IOException	x)	{
			System.err.format("IOException:	%s\n",	x);
		}

	}

}