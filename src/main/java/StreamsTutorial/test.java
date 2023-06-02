/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package StreamsTutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author lgutierrez
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //regular();
        //streamFilter();
        //streamMap();
        streamCollect();
    }
    
    @Test
    public static void regular() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Abhijeet");
        names.add("Don");
        names.add("Antonia");
        names.add("Rodrigo");
        names.add("Luis");

        int count = 0;

        for (int i = 0; i < names.size(); i++) {
            String actual = names.get(i);
            if (actual.startsWith("A")) {
                count++;
            }
        }

        System.out.println(count);
    }
    
    @Test
    public static void streamFilter(){
        ArrayList<String> names = new ArrayList<String>();
        names.add("Abhijeet");
        names.add("Don");
        names.add("Antonia");
        names.add("Rodrigo");
        names.add("Luis");
        //There is no life for intermediate op if there is no terminal op
        //terminal operation will execute only if inter op (filter) returns true
        //We can create stream
        //how to use filter in stream API
        
        Long c = names.stream().filter(s ->s.startsWith("A")).count();
        System.out.println(c);
        
        long d = Stream.of("Abhijeet", "Don","Antonia","Rodrigo","Luis").filter(s->
        {
            s.startsWith("A");
            return true;
        }).count();
        System.out.println(d);
        
        //print all the names of ArrayList
        
        //names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
        names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
    }

    
    @Test
    public static void streamMap(){
        ArrayList<String> names = new ArrayList<String>();
        names.add("man");
        names.add("Don");
        names.add("women");
        
        //print names which have last letter as "a" with Uppearcase
        Stream.of("Abhijeet", "Don","Antonia","Rodriga","Luis").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
        
        //print names which have first letter as a with upperccase and sorted
        List<String> names1 = Arrays.asList("Azbhijeet", "Don","Antonia","Rodrigo","ALuis");
        names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
        
        //Merging 2 different lists
        Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
        //newStream.sorted().forEach(s-> System.out.print(s));
        
        boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("ALuis"));
        System.out.println(flag);
        Assert.assertTrue(flag);
        
    }
    
    @Test
    public static void streamCollect(){
        List<String> ls = Stream.of("Abhijeet", "Don","Alekhya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).collect(Collectors.toList());
        System.out.println(ls.get(0));
        
        List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);
        //Print unique number from this array
        //sort the array  - 3rd index -1,2,3,5,7,9
        //values.stream().distinct().forEach(s-> System.out.println(s));
        List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(li.get(2));
        
        
    }
}
