//ALICJA
//KOWALSKA
//39322
//lAB03
package lab03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author alicj
 */
public class Lab03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Zad.1
        System.out.println("Zad.1:");
        //Set<String> zbiorDni = new HashSet<>(); // HashSet - elementy nie są uporządkowane
        Set<String> zbiorDni = new TreeSet<>(); //TreeSet - elementy są uporządkowane (tutaj alfabetycznie)
        //nie były wymagane jakiekolwiek zmiany w kodzie poza miejscem tworzenia obiektu (new HashSet<>() / new TreeSet<>()) 
        //w tej sytuacji należy użyć klasy w zależności od tego co chcemy osiągnąć, czy chcemy uporządkowane dane (TreeSet)
        //czy nieuporządkowane (HashSet) tutaj będzie to obojętne, ponieważ dni tygodnia ułożone alfabetycznie i tak nie będą poprawnie uporządkowane
        zbiorDni.add("poniedziałek");
        zbiorDni.add("wtorek");
        zbiorDni.add("środa");
        zbiorDni.add("czwartek");
        zbiorDni.add("piątek");
        zbiorDni.add("sobota");
        zbiorDni.add("niedziela");

        System.out.println(zbiorDni);

        for (String dzien : zbiorDni) {
            System.out.println(dzien);
        }

        //Zad.2
        System.out.println("\nZad.2:");
        //Mapowanie nazwy przedmiotu na nauczyciela prowadzącego
        Map<String, List<Teacher>> przedmiot = new HashMap<>();

        List<Teacher> po = new ArrayList<>();
        po.add(new Teacher("Jan", "Nowak", "jn@zut.edu.pl", "Programowanie obiektowe"));

        List<Teacher> ptd = new ArrayList<>();
        ptd.add(new Teacher("Adam", "Mickiewicz", "am@zut.edu.pl", "Podstawy transmisji danych"));
        ptd.add(new Teacher("Juliusz", "Słowacki", "js@zut.edu.pl", "Podstawy transmisji danych"));

        przedmiot.put("Programowanie obiektowe", po);
        przedmiot.put("Podstawy transmisji danych", ptd);

        List<Teacher> sbj1 = przedmiot.get("Programowanie obiektowe");
        System.out.println("Programowanie obiektowe prowadzi: " + sbj1);

        List<Teacher> sbj2 = przedmiot.get("Podstawy transmisji danych");
        System.out.println("Podstawy transmisji danych prowadzi: " + sbj2);

        //mapowanie numeru grupy na studentów
        Map<Integer, List<Student>> grupy = new HashMap<>();

        List<Student> grupa31 = new ArrayList<>();
        grupa31.add(new Student("Krzysztof", "Krawczyk", "kk@zut.edu.pl", "31"));
        grupa31.add(new Student("Mariusz", "Pudzianowski", "mp@zut.edu.pl", "31"));
        grupa31.add(new Student("Krzysztof", "Ibisz", "ki@zut.edu.pl", "31"));

        List<Student> grupa32 = new ArrayList<>();
        grupa32.add(new Student("Zenon", "Martyniuk", "zm@zut.edu.pl", "32"));
        grupa32.add(new Student("Vladimir", "Putin", "vp@zut.edu.pl", "32"));
        grupa32.add(new Student("Maka", "Paka", "mp@zut.edu.pl", "32"));

        List<Student> grupa33 = new ArrayList<>();
        grupa33.add(new Student("Beata", "Kozidrak", "bk@zut.edu.pl", "33"));
        grupa33.add(new Student("Justin", "Bieber", "jb@zut.edu.pl", "33"));
        grupa33.add(new Student("Jan", "Matejko", "jm@zut.edu.pl", "33"));

        grupy.put(31, grupa31);
        grupy.put(32, grupa32);
        grupy.put(33, grupa33);

        List<Student> gr32 = grupy.get(32);
        System.out.println("Grupa 32: " + gr32);

        //Zad.3
        System.out.println("\nZad.3:");

        List<Product> products = new ArrayList<>();

        try (BufferedReader in = new BufferedReader(new FileReader("plik.txt"))) {

            String s = in.readLine();

            while (s != null) {
                //System.out.println(s);

                String[] pola = s.split(";");

                int a = Integer.parseInt(pola[0]);
                double b = Double.parseDouble(pola[3]);

                products.add(new Product(a, pola[1], pola[2], b));

                s = in.readLine();
            }

            for (Product pr : products) {
                System.out.println(pr);
            }

            System.out.println("\nID produktu zmapowane na obiekt Product:");

            Map<Integer, Product> idsearch = new HashMap<>();

            for (int i = 0; i < products.size(); i++) {
                idsearch.put(products.get(i).getId(), products.get(i));
            }

            System.out.println("Produkt 101: " + idsearch.get(101));
            System.out.println("Produkt 110: " + idsearch.get(110));
            System.out.println("Produkt 112: " + idsearch.get(112));

            System.out.println("\nNazwa kategorii zmapowana na listę produktów:");

            Map<String, List<Product>> searchCategory = new HashMap<>();

            for (int i = 0; i < products.size(); i++) {
                if (searchCategory.keySet().contains(products.get(i).getCategory())) {
                    searchCategory.get(products.get(i).getCategory()).add(products.get(i));
                } else {
                    List<Product> category = new ArrayList<>();
                    searchCategory.put(products.get(i).getCategory(), category);
                    category.add(products.get(i));
                }
            }
            System.out.println("Narzędzia: " + searchCategory.get("narzędzia"));
            System.out.println("Słodycze: " + searchCategory.get("słodycze"));
            System.out.println("Oprogramowanie: " + searchCategory.get("oprogramowanie"));
            System.out.println("Inne: " + searchCategory.get("inne"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
