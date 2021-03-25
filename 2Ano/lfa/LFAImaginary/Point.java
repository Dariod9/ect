public class Point{

    private double real;
    private Imaginary img;

    public Point(){
        this.real=0;
        this.img= new Imaginary(0);
    }

    public Point(double real, Imaginary img){
        this.img=img;
        this.real=real;
    }

    public double real(){ return real;}
    public Imaginary img() { return img;}

    public void setReal(double r){ this.real=r; }
    public void setImg(Imaginary i){ this.img=i;}

    public void print(){
        System.out.println("( " +real+ " , "+img.toString()+" )");
    }

    public Point sum (Point p){
        return new Point(this.real+p.real(),new Imaginary(this.img().value()+p.img().value()));
    }

    public Point sum (String s){
        return new Point(this.real()+Double.parseDouble(s),this.img());
    }

    public Point sub (Point p){
        return new Point(this.real-p.real(),new Imaginary(this.img().value()-p.img().value()));
    }
    
    public Point sub (String s){
        return new Point(this.real()-Double.parseDouble(s),this.img());
    }

    public Point mult (String s){
        return new Point(this.real()*Double.parseDouble(s),new Imaginary(this.img().value()*Double.parseDouble(s)));
    }
    public Point div (String s) {
        return new Point(this.real()/Double.parseDouble(s),new Imaginary(this.img().value()/Double.parseDouble(s)));
    }   
    
}