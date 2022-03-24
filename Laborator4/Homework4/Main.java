import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.jgrapht.*;


public class Main {
    public static void main(String[] args) {

        Faker faker = new Faker();


        var nodes = IntStream.rangeClosed(0, 9)
                .mapToObj(i -> new Intersection("v" + i))
                .toArray(Intersection[]::new);


        City city = new City();

        Street s1 = new Street(faker.address().streetName(), 1, Arrays.asList(nodes[1], nodes[2]));
        Street s2 = new Street(faker.address().streetName(), 1, Arrays.asList(nodes[1], nodes[7]));
        Street s3 = new Street(faker.address().streetName(), 3, Arrays.asList(nodes[7], nodes[6]));
        Street s4 = new Street(faker.address().streetName(), 2, Arrays.asList(nodes[5], nodes[6]));
        Street s5 = new Street(faker.address().streetName(), 2, Arrays.asList(nodes[5], nodes[4]));
        Street s6 = new Street(faker.address().streetName(), 3, Arrays.asList(nodes[4], nodes[3]));
        Street s7 = new Street(faker.address().streetName(), 3, Arrays.asList(nodes[3], nodes[2]));
        Street s8 = new Street(faker.address().streetName(), 2, Arrays.asList(nodes[7], nodes[2]));
        Street s9 = new Street(faker.address().streetName(), 1, Arrays.asList(nodes[9], nodes[2]));
        Street s10 = new Street(faker.address().streetName(), 2, Arrays.asList(nodes[8], nodes[9]));
        Street s11 = new Street(faker.address().streetName(), 2, Arrays.asList(nodes[5], nodes[8]));
        Street s12 = new Street(faker.address().streetName(), 1, Arrays.asList(nodes[9], nodes[1]));
        Street s13 = new Street(faker.address().streetName(), 2, Arrays.asList(nodes[8], nodes[6]));
        Street s14 = new Street(faker.address().streetName(), 1, Arrays.asList(nodes[4], nodes[8]));
        Street s15 = new Street(faker.address().streetName(), 1, Arrays.asList(nodes[3], nodes[7]));
        Street s16 = new Street(faker.address().streetName(), 2, Arrays.asList(nodes[8], nodes[3]));

        Collections.addAll(city.edges, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16);


        nodes[1].setStreets(s1, s2, s12);
        nodes[2].setStreets(s1, s8, s7, s9);
        nodes[3].setStreets(s7, s15, s16, s6);
        nodes[4].setStreets(s6, s14, s5);
        nodes[5].setStreets(s5, s11, s4);
        nodes[6].setStreets(s4, s13, s3);
        nodes[7].setStreets(s3, s15, s8, s2);
        nodes[8].setStreets(s13, s11, s14, s16, s10);
        nodes[9].setStreets(s9, s12, s10);



        int specifiedValue = 2;  //2 de exemplu..

        city.edges.stream()
                .filter(s -> s.getLength() > specifiedValue )
                .filter(s -> s.joinsThree(s.intersections))
                .forEach(System.out::println);    //s.getClass().getName()   :(



        //city.Greedy(s1,nodes[1]);   // Algoritmul Greedy din clasa City


    }
}
