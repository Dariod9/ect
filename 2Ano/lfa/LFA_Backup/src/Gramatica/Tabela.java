package Gramatica;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Tabela<T> {

    private List<ArrayList<T>> tab;
    private String nome;
    private int maxLinhas,maxColunas;

    public Tabela(String name){
        tab=new ArrayList<>();
        this.nome=name;
        this.maxColunas=6;
        this.maxLinhas=6;

        for(int i=0;i<maxColunas;i++)
            tab.add(new ArrayList<>(Collections.nCopies( maxLinhas,null )));

    }

    public Tabela(String name, int maxC, int maxL){
        tab=new ArrayList<>();
        this.nome=name;
        this.maxLinhas=maxL;
        this.maxColunas=maxC;

        for(int i=0;i<maxC;i++)
            tab.add(new ArrayList<>(Collections.nCopies( maxL, null )));
    }



    public int getMaxLinhas(){ return maxLinhas;}
    public int getMaxColunas() { return maxColunas;}

    //Devolve a Lista (obtida a partir das colunas) por um determinado índice
    public ArrayList<T> getLista(int index){

        int size=maxColunas;
        ArrayList<T> lista= new ArrayList<>();
        for(int i=0;i<this.tab.size();i++){
            lista.add(this.tab.get(i).get(index-1));
        }
        return lista;
    }

    //Imprimir a tabela
    public void print(){
        System.out.println(this.nome+":");

        //Imprimir a lista a lista

        int i=1;

        ArrayList<T> tmp;

        do{
            tmp=getLista(i);

            for(int k=0;k<this.nome.length();k++) System.out.print(" ");

            for(int j=0;j<maxColunas;j++){
                if(tmp.get(j)!=null) System.out.print(tmp.get(j)+"\t|\t");

                else System.out.print("    "+"\t|\t");
            }

        i++;
        System.out.println();
        System.out.println();

        }while(i<maxLinhas);
    }

    //Insere na posição (x,y) um elemento do tipo que a Tabela aceita
    public void add(int x, int y, T elem){
        if(x>0 && x<=this.maxLinhas && y>0 && y<=maxColunas){
            this.tab.get(x-1).set(y-1,elem);
        }
        else System.out.println("Dimensoes nao suportadas!");
    }


    public void delete(int x,int y){
        if(x>0 && x<=this.maxLinhas && y>0 && y<=maxColunas){
            this.tab.get(x-1).set(y-1,null);
        }
        else System.out.println("Dimensoes nao suportadas!");
    }


    public T get(int x, int y){

        T elem=null;

        if(x>0 && x<=this.maxLinhas && y>0 && y<=maxColunas){

            if(this.tab.get(x-1).get(y-1)!=null) return this.tab.get(x-1).get(y-1);
            else System.out.println("Espaço Vazio");

        }
        else System.out.println("Dimensoes nao suportadas!");

        return elem;

    }

    //public subtract();

    //public intersect();

    //Cria uma nova fila com valores "null"
    public void addRow(){
        this.maxLinhas++;
        for(int i=0;i<maxColunas;i++){
            tab.get(i).add(tab.get(i).size(),null);
        }
    }

    public void addRow(int a){
        this.maxLinhas++;

        if(a<1 || a>maxLinhas) System.out.println("Dimensões inválidas");

        else {
            for (int i = 0; i < a; i++) {
                tab.get(i).add(a, null);
            }
        }
    }

    public void deleteRow(int a){

        if(a<1 || a>maxLinhas) System.out.println("Dimensões inválidas");

        else {
            for (int i = 0; i <= a; i++) {
                this.tab.get(i).set(a-1, null);
            }
        }

    }


    public void fillRow(ArrayList<T> list, int a){
        if(a<1 || a>maxLinhas) System.out.println("Dimensões inválidas");


        for(int i=0;i<a;i++){
            if(list.get(i)!=null)
            tab.get(i).add(a,list.get(i));
        }

    }

    //Cria uma nova coluna com valores "null"
    public void addColumn(){
        this.maxColunas++;
        tab.add(new ArrayList<>(Collections.nCopies( maxLinhas, null )));
    }

    public void addColumn(int a){

        if(a<1 || a>maxColunas) System.out.println("Dimensões inválidas");

        else {
            this.maxColunas++;
            tab.add(a, new ArrayList<>(Collections.nCopies(maxLinhas, null)));
        }
    }



    public void deleteColumn(int a){

        if(a<1 || a>maxLinhas) System.out.println("Dimensões inválidas");

        else {
			this.tab.set(a-1, new ArrayList<>(Collections.nCopies( maxLinhas, null )));
        }

    }

    public void fillColumn(ArrayList<T> lista, int a){

        if(a<1 || a>maxColunas) System.out.println("Dimensões inválidas");

        else
        tab.add(a,lista);
    }


    public void printRow(int a){
        if(a<1 || a>maxLinhas) System.out.println("Dimensões inválidas");

        else {
            for (int i = 0; i <maxColunas; i++) {
               if(tab.get(i).get(a-1)==null) System.out.print(" -- "+"\t");
                else System.out.print(" -- "+tab.get(i).get(a-1));
            }
            System.out.println("\n");
        }
    }



    public void printColumn(int a){
        if(a<1 || a>maxColunas) System.out.println("Dimensões inválidas");

        else {
            for(int i=0;i<this.tab.get(a-1).size();i++){
                if(this.tab.get(a-1).get(i)==null) System.out.print(" -- "+"\t");
                else System.out.print(" -- "+this.tab.get(a-1).get(i));
            }
            System.out.println("\n");
        }
    }


    public void extractToCSV(String s){

        File f = new File(s);

        try {
            File outputFile = new File(s);

            FileWriter out = new FileWriter(outputFile);

            for (int i = 1; i <= this.getMaxLinhas(); i++) {
                for (int j = 1; j <= this.getMaxColunas(); j++) {
                    out.write(this.get(j, i) + ";");
                }
                out.write("\n");

            }
            out.close();
            System.out.println("Concluido");
        } catch (IOException e) {
            System.out.print("Ficheiro não existente");
        }

    }

	public void delete(){
		for(int i = 0; i< maxColunas; i++){
			this.tab.set(i, new ArrayList<>(Collections.nCopies( maxLinhas, null )));
		}
    }

    public void readFromCSV(String s){
        Tabela t=null;
        //throw IOException;
        int maxL=0;
        int maxC=0;

        try {
            File in = new File(s);

            Scanner sc= new Scanner(in);

            while(sc.hasNextLine()){
                String[] array= sc.nextLine().split(";");
                if(array.length>maxC) maxC=array.length;
                maxL++;
            }

            sc.close();


            this.delete();

            Scanner sc2 = new Scanner(in);

            int linha=1;

            while (sc2.hasNextLine()){
                String[] array= sc2.nextLine().split(";");
                for(int i=1;i<=array.length;i++) this.add(i,linha,(T)array[i-1]);

                linha++;

            }

            sc2.close();

        }
        catch (IOException e) {
            System.out.print("Ficheiro não existente");
        }

    }

    public String getNome(){ return nome;}

    //Devolve a coluna de índice "index" sob a forma de ArrayList
    public ArrayList<T> getColumn(int index){
        return tab.get(index-1);
    }

    //Devolve a lista de índice "index" sob a forma de ArrayList
    public ArrayList<T> getRow(int index){

        ArrayList<T> ret= new ArrayList<>();

        for(int i=0;i<tab.size();i++)
            ret.add(tab.get(i).get(index-1));

        return ret;
    }

}
