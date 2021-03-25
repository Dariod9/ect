package Gramatica;
public class Variable<T>{
    private String type;
    private T value;

    public Variable(String type, T value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return this.type;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}