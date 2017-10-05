package sbt.lessos10;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;


public class Streams <T> {

    private Collection <T> steamColl;

    public Streams(Collection<T> someColl) {

        this.steamColl = someColl;

    }

    public static <T> Streams <T> of(Collection <T> someColl) {

        Streams stream = new Streams <T> (someColl);

        return stream;
    }

    public Streams<T> filter(Predicate<T> p) {

        this.steamColl.removeIf(p.negate());

        return this;
    }


    public<R> Streams<R> transform(Function<? super T, ? extends R> f) {
        List<R> newSteamColl = new ArrayList<>();


        this.steamColl.forEach(p-> {
            newSteamColl.add(f.apply(p));
        });

        return Streams.of(newSteamColl);
    }

    public <E, B> Map toMap (Function<? super T, ? extends E> key, Function<? super T, ? extends B> value) {
        Map<E,B> finalCol = new HashMap<>();
        this.steamColl.forEach(elem -> {
            finalCol.put(key.apply(elem), value.apply(elem));
        });
        return finalCol;
    }

}


































//public class Streams <T> {
//
//
//    private Collection<T> collection;
//
//    private Streams(Collection<T> collection) {
//        this.collection = collection;
//    }
//
//    public static <T> Streams<T> of(Collection<T> collection) {
//        return new Streams<T>(collection);
//    }
//
//    public Streams<T> filter(Predicate<T> predicate) {
//        collection.removeIf(predicate.negate());
//        return this;
//    }
//
//    public<R> Streams<R> transform(Function<? super T, ? extends R> function) {
//        ArrayList<R> result = new ArrayList<>();
//        collection.forEach(p-> {
//            result.add(function.apply(p));
//        });
//        return Streams.of(result);
//    }

//    public <K, V> Map toMap (Function<? super T, ? extends K> key, Function<? super T, ? extends V> value) {
//        Map<K,V> result = new HashMap<>();
//        collection.forEach(item -> {
//            result.put(key.apply(item), value.apply(item));
//        });
//        return result;
//    }
//
//}
