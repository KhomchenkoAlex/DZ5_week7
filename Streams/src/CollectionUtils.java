/**
 * Created by alex on 06.12.16.
 */

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class CollectionUtils {

    private CollectionUtils() {
    }


    public static <E> List<E> filter(List<E> elements, Predicate<E> filter) {
        List<E> result=new ArrayList<>();
        for(E element:elements) {
            if (filter.equals(element))
                result.add(element);
        }
        return result;
    }


    public static <E> boolean anyMatch(List<E> elements, Predicate<E> predicate) {
        for(E element:elements){
            if(predicate.equals(element))
                return true;
        }
        return false;
    }


    public static <E> boolean allMatch(List<E> elements, Predicate<E> predicate) {
        for(E element:elements){
            if(!predicate.equals(element))
                return false;
        }
        return true;
    }


    public static <E> boolean noneMatch(List<E> elements, Predicate<E> predicate) {
        for(E element:elements){
            if(predicate.equals(element))
                return false;
        }
        return true;
    }


    public static <T, R> List<R> map(List<T> elements, Function<T, R> mappingFunction) {
        List<R> result = new ArrayList<R>();
        for(T element:elements){
           result.add(mappingFunction.apply(element));
        }
        return result;
    }


    public static <E> Optional<E> max(List<E> elements, Comparator<E> comparator) {
        E max = elements.get(0);
        int i = 1;
        while (i < elements.size()){
            max = comparator.compare(max,elements.get(i)) > 0 ? max:elements.get(i);
            i++;
        }
        return Optional.of(max);
    }


    public static <E> Optional<E> min(List<E> elements, Comparator<E> comparator) {
        E min = elements.get(0);
        int i = 1;
        while (i < elements.size()){
            min = comparator.compare(min,elements.get(i)) < 0 ? min:elements.get(i);
            i++;
        }
        return Optional.of(min);

    }


    public static <E> List<E> distinct(List<E> elements) {
        List<E> result = new ArrayList<E>();
        for(E element:elements){
            if(!result.contains(element))
                result.add(element);
        }
        return result;
    }


    public static <E> void forEach(List<E> elements, Consumer<E> consumer) {
        for(E element:elements){
            consumer.accept(element);
        }
    }


    public static <E> Optional<E> reduce(List<E> elements, BinaryOperator<E> accumulator) {
        E result = elements.get(0);
        int i = 1;
        while (i < elements.size()){
            result = accumulator.apply(result, elements.get(i));
            i++;
        }
        return Optional.of(result);
    }


    public static <E> E reduce(E seed, List<E> elements, BinaryOperator<E> accumulator) {
        E result = seed;
        int i = 0;
        while(i < elements.size()){
            result = accumulator.apply(result,elements.get(i));
            i++;
        }
        return result;
    }


    public static <E> Map<Boolean, List<E>> partitionBy(List<E> elements, Predicate<E> predicate) {
        Map <Boolean, List<E>> result = new HashMap<>();
        List<E> trueList = new ArrayList<E>();
        List<E> falseList = new ArrayList<E>();
        for(E element: elements) {
            if (predicate.test(element))
                trueList.add(element);
            else
                falseList.add(element);
        }
        result.put(true, trueList);
        result.put(false, falseList);

        return result;
    }


    public static <T, K> Map<K, List<T>> groupBy(List<T> elements, Function<T, K> classifier) {
        Map <K, List<T>> result = new HashMap<>();
        for(T element: elements){
            K key = classifier.apply(element);
            if (result.containsKey(key))
                result.get(key).add(element)
                else {
                List<T> list = new ArrayList<T>();
                list.add(element);
                result.put(key, list);
            }
        }
        return result;
    }


    public static <T, K, U> Map<K, U> toMap(List<T> elements,
                                            Function<T, K> keyFunction,
                                            Function<T, U> valueFunction,
                                            BinaryOperator<U> mergeFunction) {

        return null;
    }

}
