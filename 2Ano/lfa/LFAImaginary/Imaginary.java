public class Imaginary{
    
    private double value;

    public Imaginary(){
        this.value=0;
    }

    public Imaginary(double d){
        this.value=d;
    }

    public double value(){ return value;}
    public void setValue(double d){ this.value=d;}

    @Override
    public String toString(){ return value+"i";}
}