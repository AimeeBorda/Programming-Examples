package CakeThief;


public class Pair<T,K> {

    T first;
    K second;

    public Pair(T first, K second){
        this.first = first;
        this.second = second;
    }


    @Override
    public String toString(){
        return "("+first.toString() +","+second.toString()+")";
    }
}
