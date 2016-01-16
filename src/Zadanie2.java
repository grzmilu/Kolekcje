
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Zadanie2 {

    public static void main(String[] args) {
        List<Person> ludzie = new ArrayList<Person>();
        ludzie.add(new Person("Slask", "Myslowice", "Katowicka", "3"));
        ludzie.add(new Person("Slask", "Katowice", "Korfantego", "15"));
        ludzie.add(new Person("Slask", "Sosnowiec", "Bedzinska", "7"));
        ludzie.add(new Person("Mazowieckie", "Warszawa", "Mokotow", "22"));
        
        Collections.sort(ludzie);
        for(Person person : ludzie){
            System.out.println(person.getAdres());
        }

    }

}
