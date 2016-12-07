import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by alex on 07.12.16.
 */
public class CollectionUtilsTest {
    public static void main(String[] args) {
        List<Integer> testList = Arrays.asList(0,1,2,3,4,5);
        List<Integer> testList2 = Arrays.asList(5,6,7,8,9);
        List<Integer> testList3 = Arrays.asList(5,5,6,7,7,7,8,8,9);

        System.out.println(CollectionUtils.filter(testList,e -> e > 2));
        System.out.println(CollectionUtils.anyMatch(testList,e -> e < 4));
        System.out.println(CollectionUtils.anyMatch(testList2,e -> e < 4));

        System.out.println(CollectionUtils.noneMatch(testList,e -> e > 20));
        System.out.println(CollectionUtils.noneMatch(testList2,e -> e < 20));

        System.out.println(CollectionUtils.allMatch(testList,e -> e <= 5));
        System.out.println(CollectionUtils.allMatch(testList,e -> e > 5));

        System.out.println(CollectionUtils.map(testList,e -> e*10));

        System.out.println(CollectionUtils.max(testList, Integer::compareTo));
        System.out.println(CollectionUtils.min(testList, Integer::compareTo));

        System.out.println(CollectionUtils.distinct(testList3));

        CollectionUtils.forEach(testList2,System.out::println);

        System.out.println(CollectionUtils.reduce(testList, (a,b) -> a+b));

        System.out.println(CollectionUtils.reduce(10, testList, (a,b) -> a+b));

        System.out.println(CollectionUtils.partitionBy(testList, e -> e%2 == 0));

        System.out.println(CollectionUtils.groupBy(testList2, e -> e > 7));


        List<String> str = Arrays.asList("Alex","Burt","Bob","Rob","Musa","Li","Velazquez");
        System.out.println(CollectionUtils.toMap(str, s -> s.length(), s -> s.toUpperCase(), (result, s) -> result+" " + s));


    }
}
