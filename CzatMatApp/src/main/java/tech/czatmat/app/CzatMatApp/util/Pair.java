package tech.czatmat.app.CzatMatApp.util;

public class Pair<T, T1> {

    public final T first;
    public final T1 second;


    private Pair(T first, T1 second){
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T1 getSecond() {
        return second;
    }

    public static <T, T1> Pair <T, T1> of(T a, T1 b) {
        return new Pair<>(a, b);
    }

}


