
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Zadanie3 {

    public static long wstawNaPoczatek(List l) {
        long s = System.currentTimeMillis();
        for (int i = 0; i < 400000; i++) {
            l.add(Integer.toString(i));
        }
        return System.currentTimeMillis() - s;
    }

    public static long wstawDoSrodka(List l) {
        long s = System.currentTimeMillis();
        int srodek=l.size()/2;
        for (int i = 0; i < 1000; i++) {
            l.add(srodek,Integer.toString(i));
        }
        return System.currentTimeMillis() - s;
    }

    public static long wstawNaKoniec(List l) {
        long s = System.currentTimeMillis();
        int koniec=l.size()-1;
        for (int i = 0; i < 10000; i++) {
            l.add(koniec,Integer.toString(i));
        }
        return System.currentTimeMillis() - s;
    }

    public static long usunZPoczatku(List l) {
        long s = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            l.remove(0);
        }
        return System.currentTimeMillis() - s;
    }

    public static long usunZSrodka(List l) {
        int srodek=l.size()/2;
        long s = System.currentTimeMillis();
        for (int i = 0; i < 2000; i++) {
            l.remove(srodek);
        }
        return System.currentTimeMillis() - s;
    }

    public static long usunZKonca(List l) {
        int koniec=l.size()-1;
        long s = System.currentTimeMillis();
        for (int i = 0; i < 300000; i++) {
            l.remove(koniec);
            koniec--;
        }
        return System.currentTimeMillis() - s;
    }

    public static long zwrocZPoczatku(List l) {
        String te;
        long s = System.currentTimeMillis();
        te=(String)l.get(1);
        for (int i = 0; i < 150000; i++) {
            te=(String)l.get(0);
        }
        
        return System.currentTimeMillis() - s;
    }

    public static long zwrocZSrodka(List l) {
        long s = System.currentTimeMillis();
        String te;
        int srodek=l.size()/2;
        for (int i = 0; i < 3000; i++) {
            te=(String)l.get(srodek);
        }
        return System.currentTimeMillis() - s;
    }

    public static long zwrocZKonca(List l) {
        String te;
        int koniec=l.size()-1;
        long s = System.currentTimeMillis();
        for (int i = 0; i < 300000; i++) {
            te=(String)l.get(koniec);
        }
        return System.currentTimeMillis() - s;
    }

    public static void main(String[] args) {
        List<String> listaArray = new ArrayList<String>();
        List<String> listaLinked = new LinkedList<String>();

        
        System.out.println("Wstaw na poczatek listaArray: " + wstawNaPoczatek(listaArray));
        System.out.println("Wstaw na poczatek listaLinked: " + wstawNaPoczatek(listaLinked));
        System.out.println("Wstaw do srodka listaArray: " + wstawDoSrodka(listaArray));
        System.out.println("Wstaw do srodka listaLinked: " + wstawDoSrodka(listaLinked));
        System.out.println("Wstaw na koniec listaArray: " + wstawNaKoniec(listaArray));
        System.out.println("Wstaw na koniec listaArray: " + wstawNaKoniec(listaLinked));
        
        System.out.println("\nZwroc wartosc z poczatku listaArray: " + zwrocZPoczatku(listaArray));
        System.out.println("Zwroc wartosc z poczatku listaLinked: " + zwrocZPoczatku(listaLinked));
        System.out.println("Zwroc wartosc z srodka listaArray: " + zwrocZSrodka(listaArray));
        System.out.println("Zwroc wartosc z srodka listaLinked: " + zwrocZSrodka(listaLinked));
        System.out.println("Zwroc wartosc z konca listaArray: " + zwrocZKonca(listaArray));
        System.out.println("Zwroc wartosc z konca listaArray: " + zwrocZKonca(listaLinked));
        
        System.out.println("\nUsun z poczatku listaArray: " + usunZPoczatku(listaArray));
        System.out.println("Usun z poczatku listaLinked: " + usunZPoczatku(listaLinked));
        System.out.println("Usun z srodka listaArray: " + usunZSrodka(listaArray));
        System.out.println("Usun z srodka listaLinked: " + usunZSrodka(listaLinked));
        System.out.println("Usun z konca listaArray: " + usunZKonca(listaArray));
        System.out.println("Usun z konca listaArray: " + usunZKonca(listaLinked));


    }

}
