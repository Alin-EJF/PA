import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {
    public static void main( String[] args ){


        var nodes = IntStream.rangeClosed(0, 9)
                .mapToObj(i -> new Intersection("v" + i) )
                .toArray(Intersection[]::new);


        List<Intersection> nodeList = new ArrayList<>();

        nodeList.addAll( Arrays.asList(nodes) );

        List<Street> edges= new LinkedList<>( IntStream.rangeClosed(0, 9)
                .mapToObj(i -> new Street("street: " + i , 1 ))
                .toList());

        edges.sort(Street::compareTo);

        Set<Intersection> setIntersections = new HashSet<>(Arrays.stream(nodes).toList());

        setIntersections.add(new Intersection("v5"));  //verific sa nu permita duplicate
        System.out.println(setIntersections);
    }
}
