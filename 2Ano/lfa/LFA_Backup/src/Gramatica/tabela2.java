
package Gramatica;
import java.util.*;
import java.io.*;

public class tabela2<T>{
	
	private Map<String,String> columnType;
	private Map<String, ArrayList<T>> tab;
	private List<String> rowKeys;
    private String nome;

	public tabela2(String name){
		tab = new LinkedHashMap<String, ArrayList<T>>();
		rowKeys= new ArrayList<String>();
		columnType = new HashMap<>();
        this.nome=name;
	}
    public tabela2(String name, String firstColumn, String type){
        tab = new LinkedHashMap<String, ArrayList<T>>();
        columnType= new HashMap<>();
        rowKeys= new ArrayList<String>();
        this.nome=name;   
        addColumn(firstColumn,type);
        columnType.put(firstColumn,type);
        
    }
    //Imprimir a tabela
    public void print(){
        System.out.println(this.nome+":");

        //Imprimir a lista a lista
		System.out.print("               ");
		Iterator<String> tabIte= tab.keySet().iterator();                   
        while (tabIte.hasNext()){
			String temp=tabIte.next();
			System.out.print(temp);
			for(int i=temp.length(); i<=15; i++){
				System.out.print(" ");
			}
			
		}
		System.out.println();
		for(int i=0; i<rowKeys.size();i++){
			System.out.print(rowKeys.get(i));
			for(int j=rowKeys.get(i).length(); j<=15; j++){
				System.out.print(" ");
			}
			
			tabIte= tab.keySet().iterator();         
			          
			while (tabIte.hasNext()){
				try{
					ArrayList<T> temp=tab.get(tabIte.next());
					if(temp.get(i)==null){
						System.out.print("               ");
					}else{
						String str= temp.get(i).toString();
						System.out.print(str);
						for(int j=str.length(); j<=15; j++){
							System.out.print(" ");
						}
					}
				}catch(NullPointerException e){}
				
			}
			System.out.println();
		}
		System.out.println();

    }

    //Insere na posição (x,y) um elemento do tipo que a Tabela aceita
    public void setData(String row, String column, T elem){

		tab.get(column).set(rowKeys.indexOf(row), elem);

/*
		if(!rowKeys.contains(row) || !tab.containsKey(column)){
			System.out.println("Nao existe a posicao que resulta do cruzamento da linha "+row+" e da coluna "+column);

		}
		else{
			if(elem==null){
				tab.get(column).set(rowKeys.indexOf(row), elem);

			}
			else if(columnType.get(column).equalsIgnoreCase("String")){

				try{
					tab.get(column).set(rowKeys.indexOf(row), (T)elem.toString());

					
				}catch(Exception e){
					System.out.println("Elemento deve ser do tipo String!");
				}
			}
			else if(columnType.get(column).equalsIgnoreCase("Integer")){

				try{
						String st= elem.toString();
						int temp=Integer.parseInt(st);
						tab.get(column).set(rowKeys.indexOf(row),elem);


				}catch(Exception e){
					System.out.println("Elemento deve ser do tipo Integer!");
				}
			}
			else if(columnType.get(column).equalsIgnoreCase("double")){

				try{
					String st= elem.toString();
					double temp= Double.parseDouble(st);
					tab.get(column).set(rowKeys.indexOf(row),elem);

				}catch(Exception e){
					System.out.println("Elemento deve ser do tipo double!");
				}
			}
		}*/
    }
    
    
    public T getElem(String row, String column){
		
		/*if(!rowKeys.contains(row) || !tab.containsKey(column)){
			System.out.println("Nao existe a posicao que resulta do cruzamento da linha "+row+" e da coluna "+column);
			return null;
		}*/
		//System.out.println(rowKeys.indexOf(row));
		//System.out.println(tab.get());
		// System.out.println(tab.get(column).get(rowKeys.indexOf(row)));

		System.out.println(tab.get(column).get(rowKeys.indexOf(row)));

		return tab.get(column).get(rowKeys.indexOf(row));
		
	}
	
    public T getT(T t){
		return t;
	}

    //public subtract(); 
    public tabela2 intersect( tabela2 tab2){
        tabela2 merged = new tabela2("Intersecao "+nome+" com "+tab2.nome);
		
		Map<String, ArrayList<T>> tab2Map=tab2.getTab();
		List<String> rowKeys2=tab2.getRowKeys();
        Map<String,String> columnType2= tab2.getColumnTypes();
        
        Iterator<String> tabIte= tab.keySet().iterator();
		while(tabIte.hasNext()){
			String temp=tabIte.next();
			if(tab2Map.containsKey(temp)){
				merged.addColumn(temp,columnType2.get(temp));
			}
		}
		
        for(int i=0; i<rowKeys.size();i++){
			if(rowKeys2.contains(rowKeys.get(i))){
				merged.addRow(rowKeys.get(i));
			}
		}
		
		Iterator<String> tab2Ite= merged.getTab().keySet().iterator();
		List<String> rowKeysMerged= merged.getRowKeys();
		while(tab2Ite.hasNext()){
			String temp=tab2Ite.next();
			if(tab.containsKey(temp)){
				for(int i=0;i<rowKeys.size();i++){
					if(rowKeysMerged.contains(rowKeys.get(i))){
						ArrayList<T> tempList= (ArrayList<T>)merged.getTab().get(temp);
						if(tempList.get(rowKeysMerged.indexOf(rowKeys.get(i)))==null){
							merged.setData(rowKeys.get(i), temp, tab.get(temp).get(i));
						}
					}
				}
			}
			if(tab2Map.containsKey(temp)){
				for(int i=0;i<rowKeys2.size();i++){
					if(rowKeysMerged.contains(rowKeys2.get(i))){
						ArrayList<T> tempList1= (ArrayList<T>)tab2.getTab().get(temp);
						ArrayList<T> tempList2= (ArrayList<T>)merged.getTab().get(temp);
						if(tempList2.get(rowKeysMerged.indexOf(rowKeys2.get(i)))==null){
							merged.setData(rowKeys2.get(i), temp, tempList1.get(i));
						}
					}
				}
			}
		}
        return merged;
    }

    //Cria uma nova fila com valores "null"
    public void addRow(String key){
        rowKeys.add(key);
        Iterator<String> tabIte= tab.keySet().iterator();
        while (tabIte.hasNext()){
			ArrayList<T> list= tab.get(tabIte.next());
			list.add(null);
		}
		
    }
    public void addRowFrom(String key,tabela2 t2){
		
        if(!t2.getRowKeys().contains(key)){
			System.out.println(""+t2.getNome()+" nao contem a linha "+key+"!");
		} else if(rowKeys.contains(key)){
			System.out.println(""+nome+"ja contem a linha "+key+"!");
		}else {

			rowKeys.add(key);
			Map<String,List<T>> tab2= t2.getTab();
			Iterator<String> tabIte= tab.keySet().iterator();
			while (tabIte.hasNext()){
				String st=tabIte.next();
				ArrayList<T> list= tab.get(st);
				list.add(null);
				if(tab2.containsKey(st)){
					this.setData(key,st,(T)t2.getElem(key,st));
				}
			}
		}
	}
	public void addColumnFrom(String key, tabela2 t2){
		if(!t2.getTab().containsKey(key)){
			System.out.println(""+t2.getNome()+" nao contem a coluna "+key+"!");
		} else if(tab.containsKey(key)){
			System.out.println(""+nome+"ja contem a coluna "+key+"!");
		}else {
			
			columnType.put(key,(String)t2.getColumnTypes().get(key));
			ArrayList<T> list= new ArrayList<T>();
			for(int i=0; i<rowKeys.size();i++){
				list.add(null);
			}
			tab.put(key,list);
			
			List<String> rowkeys2= t2.getRowKeys();
			for(int i=0;i<rowkeys2.size();i++){
				if(rowKeys.contains(rowkeys2.get(i))){
					this.setData(rowkeys2.get(i),key,(T)t2.getElem(rowkeys2.get(i),key));
				}
			}
		}
	}

    //Cria uma nova coluna com valores "null"
    public void addColumn(String id, String type){
		if(!type.equalsIgnoreCase("String") && !type.equalsIgnoreCase("int") && !type.equalsIgnoreCase("double")){
			System.out.println("Tipo deve ser String, int ou double!");
		}else{

			columnType.put(id,type);
			ArrayList<T> list= new ArrayList<T>();
			for(int i=0; i<rowKeys.size();i++){
				list.add(null);
			}
			tab.put(id,list);
		}
    }

    //Devolve a coluna de índice "index" sob a forma de ArrayList
    public ArrayList<T> getColumn(String column){
		if(!tab.containsKey(column)){
			System.out.println("A tabela "+nome+" nao tem uma coluna com nome "+column);
			return null;
		}
        return tab.get(column);
    }
    
    public ArrayList<T> getRow(String row){
		if(!rowKeys.contains(row)){
			System.out.println("A tabela "+nome+" nao tem uma linha com nome "+row);
			return null;
		}
		ArrayList<T> rowList= new ArrayList<>();
		
		Iterator<String> tabIte= tab.keySet().iterator();
		int i=0;
        while (tabIte.hasNext()){
			ArrayList<T> list= tab.get(tabIte.next());
			rowList.add(i++,list.get(rowKeys.indexOf(row)));
		}
		
		return rowList;
	}

	public Map<String, ArrayList<T>> tab(){ return this.tab;}

	public void printRow(String key){
		if(!rowKeys.contains(key)){
			System.out.println("A tabela "+nome+" nao tem uma linha com nome "+key);
		}else{
			List<T> list= this.getRow(key);
			System.out.print(key+":");
			for(int i=0; i< list.size();i++){
				System.out.print(list.get(i)+";");
			}
			System.out.println();
		}
		
	}
	public void printColumn(String key){
		if(!tab.containsKey(key)){
			System.out.println("A tabela "+nome+" nao tem uma coluna com nome "+key);
		}else{
			List<T> list= this.getColumn(key);
			System.out.print(key+":");
			for(int i=0; i< list.size();i++){
				System.out.print(list.get(i)+";");
			}
			System.out.println();
		}
	}
	
	public void sumRows(String keyTo,tabela2 t2,String keyFrom){
		
		if(!rowKeys.contains(keyTo)){
			System.out.println("A tabela "+nome+" nao tem uma linha com nome "+keyTo);
		}
		else if(!t2.getRowKeys().contains(keyFrom)){
			System.out.println("A tabela "+t2.getNome()+" nao tem uma linha com nome "+keyFrom);
		}else{
			ArrayList<T> rowList= new ArrayList<>();
			
			Iterator<String> tabIte= tab.keySet().iterator();
			int i=0;
			while (tabIte.hasNext()){
				String st=tabIte.next();
				
				if(t2.getTab().containsKey(st)){
					T t1Elem= (T)this.getElem(keyTo,st);
					T t2Elem= (T)t2.getElem(keyFrom,st);
					
					
					try{
						this.setData(keyTo,st, (T) new Double((Double)t1Elem + (Double)t2Elem));
					}catch(Exception e){}
					try{
						this.setData(keyTo,st,(T)new Integer((Integer)t1Elem + (Integer)t2Elem));
					}catch(Exception e){}
					if(t1Elem==null && t2Elem!=null){
						this.setData(keyTo,st,t2Elem);
					}
					
				}
			}
		}
	}
	public boolean sumColumns(String keyTo,tabela2 t2,String keyFrom){
		if(!tab.containsKey(keyTo)){
			System.out.println("A tabela "+nome+" nao tem uma coluna com nome "+keyTo);
			return false;
		}
		else if(!t2.getTab().containsKey(keyFrom)){
			System.out.println("A tabela "+t2.getNome()+" nao tem uma coluna com nome "+keyFrom);
			return false;
		}else{
			
			if(!columnType.get(keyTo).equalsIgnoreCase((String)t2.getColumnTypes().get(keyFrom))){
				System.out.println("As colunas nao sao do mesmo tipo!");
				return false;
			}
			
			for(int i=0;i< rowKeys.size();i++){
				if(t2.getRowKeys().contains(rowKeys.get(i))){
					T t1Elem= (T)this.getElem(rowKeys.get(i),keyTo);
					T t2Elem= (T)t2.getElem(rowKeys.get(i),keyFrom);
					
					
					try{
						this.setData(rowKeys.get(i),keyTo, (T) new Double((Double)t1Elem + (Double)t2Elem));
					}catch(Exception e){}
					try{
						this.setData(rowKeys.get(i),keyTo,(T)new Integer((Integer)t1Elem + (Integer)t2Elem));
					}catch(Exception e){}
					if(t1Elem==null && t2Elem!=null){
						this.setData(rowKeys.get(i),keyTo,t2Elem);
					}
				}
			}
			return true;
		}
	}
	
	public void clearRow(String row){
		if(!rowKeys.contains(row)){
			System.out.println("A tabela "+nome+" nao contem a linha "+row+"!");
		}else{
			Iterator<String> tabIte= tab.keySet().iterator();
			while (tabIte.hasNext()){
				this.setData(row,tabIte.next(),null);
			}
		}
	}
	public void clearColumn(String column){
		if(!tab.containsKey(column)){
			System.out.println("A tabela "+nome+" nao contem a coluna "+column+"!");
		}else{
			for(int i=0; i<rowKeys.size();i++){
				this.setData(rowKeys.get(i),column,null);
			}
		}
	}
	
    public int NumCol(){
        return tab.size();
    }
    public int NumRow(int index){  //Numero de elemntos da linha da posição "index"
        return tab.get(index).size(); 
    }

    public void delete(){
        tab.clear();
    }
    
    public Map<String, ArrayList<T>> getTab(){
		return tab;
	}
	public List<String> getRowKeys(){
		return rowKeys;
	}
	public String getNome(){
		return nome;	
	}
	public Map<String,String> getColumnTypes(){
		return columnType;
	}

    public void extractToCSV(String file) {
		String str="";
		try{
			PrintWriter pw = new PrintWriter(new File(file));
			str+="Row Key;";
			Iterator<String> tabIte= tab.keySet().iterator();                   
			while (tabIte.hasNext()){
				String temp=tabIte.next();
				str+=" "+temp+";";
			}
			pw.println(str);
			for(int i=0; i<rowKeys.size();i++){
				str="";
				str+=rowKeys.get(i)+";";
				
				tabIte= tab.keySet().iterator();         
						  
				while (tabIte.hasNext()){
					try{
						ArrayList<T> temp=tab.get(tabIte.next());
						
						String st;
							
						if(temp.get(i)==null){
							str+= " null;";
						}else{
							st= temp.get(i).toString();
							str+=" "+st+";";
						}
						
					}catch(NullPointerException e){}
					
				}
				pw.println(str);
			}
			pw.close();
			
		}catch(FileNotFoundException e){
			System.err.print("File not found!");
		}
        
    }
    
    public void readFromCSV(String file){
		
		try{
			BufferedReader br= new BufferedReader(new FileReader(new File(file)));
			String st;
			int count =0;
			ArrayList<String> columns= new ArrayList<>();
			while((st= br.readLine())!=null){
				
				String[] temp= st.split(";");
				
				
				if(count==0){
					for(int i=1; i< temp.length;i++){
						columns.add(temp[i].trim());
						addColumn(temp[i].trim(),"String");
					}
				}else{
				
					addRow(temp[0]);
					for(int i=1; i< temp.length;i++){
						if(temp[i].trim().equalsIgnoreCase("null")){
							setData(temp[0],columns.get(i-1),null);
						}
						else{
							
							try{
								Integer.parseInt(temp[i].trim());
								columnType.put(columns.get(i-1),"int");
							}catch(Exception e){}
							try{
								Double.parseDouble(temp[i].trim());
								columnType.put(columns.get(i-1),"double");
							}catch(Exception e){}
							try{
								columnType.put(columns.get(i-1),"String");
							}catch(Exception e){}
							setData(temp[0],columns.get(i-1),(T)temp[i].trim());
						}
					}
				}
				
				count++;
			}
		}catch(IOException e){
			System.err.println("File "+file+" not found ");
		}
	}

   
}
