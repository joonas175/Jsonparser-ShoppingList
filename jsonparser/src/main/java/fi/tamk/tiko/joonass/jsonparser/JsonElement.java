package fi.tamk.tiko.joonass.jsonparser;

public abstract class JsonElement<T>{

    T value;

    public JsonElement(){
        this.value = null;
    }

    public JsonElement(T value){
        this.value = value;
    }

    public T getValue(){
        return value;
    }

    public void setValue(T value){
        this.value = value;
    }

    public abstract String toString();
}
