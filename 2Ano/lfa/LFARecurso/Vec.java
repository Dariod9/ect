import java.util.ArrayList;

public class Vec{

    private int size;
    private ArrayList<Double> numbers;
    
    public Vec(){
        this.size=0;
        this.numbers=new ArrayList<>();
    }

    private Vec(int size, ArrayList<Double> numbers){
        this.size=size;
        this.numbers=numbers;
    }

    public int size(){ return this.size;}
    public ArrayList<Double> numbers(){ return this.numbers; }

    public void print(){
        System.out.print("[ ");
        for(int i=0;i<size;i++){
            System.out.print(numbers.get(i));
            if(i!=size-1) System.out.print(" , ");
        }
        System.out.print(" ]\n");

    }

    public void add(String elem){
        this.size++;
        numbers.add(Double.parseDouble(elem));
    }

    public Vec sum(Vec v2){
        if(this.size() != v2.size()){
            System.out.println("Dimensoes inválidas");
            return null;
        }
    
        else{
            ArrayList<Double> tmp= new ArrayList<>();
            for(int i=0;i<this.size();i++){
                tmp.add(this.numbers().get(i)+v2.numbers().get(i));
            }

            return new Vec(this.size(),tmp);
        }

    }

    public Vec sub(Vec v2){
        if(this.size() != v2.size()){
            System.out.println("Dimensoes inválidas");
            return null;
        }
    
        else{
            ArrayList<Double> tmp= new ArrayList<>();
            for(int i=0;i<this.size();i++){
                tmp.add(this.numbers().get(i)-v2.numbers().get(i));
            }

            return new Vec(this.size(),tmp);
        }

    }

    public Vec mult(Vec v2){
        if(this.size() != v2.size()){
            System.out.println("Dimensoes inválidas");
            return null;
        }
    
        else{
            ArrayList<Double> tmp= new ArrayList<>();
            for(int i=0;i<this.size();i++){
                tmp.add(this.numbers().get(i)+v2.numbers().get(i));
            }

            return new Vec(this.size(),tmp);
        }

    }

    public Vec mult(double a){
        if(a<1){
            System.out.println("Dimensoes inválidas");
            return null;
        }
    
        else{
            ArrayList<Double> tmp= new ArrayList<>();
            for(int i=0;i<this.size();i++){
                tmp.add(this.numbers().get(i)*a);
            }

            return new Vec(this.size(),tmp);
        }

    }

    public Vec div(Vec v2){
        if(this.size() != v2.size()){
            System.out.println("Dimensoes inválidas");
            return null;
        }
    
        else{
            ArrayList<Double> tmp= new ArrayList<>();
            for(int i=0;i<this.size();i++){
                tmp.add(this.numbers().get(i)+v2.numbers().get(i));
            }

            return new Vec(this.size(),tmp);
        }

    }

    public Vec div(double a){
        if(a<1){
            System.out.println("Dimensoes inválidas");
            return null;
        }
    
        else{
            ArrayList<Double> tmp= new ArrayList<>();
            for(int i=0;i<this.size();i++){
                tmp.add(this.numbers().get(i)/a);
            }

            return new Vec(this.size(),tmp);
        }

    }

}