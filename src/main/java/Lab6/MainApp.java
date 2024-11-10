package Lab6;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class MainApp {
    public static List<Angajat> citire() {
        try {
            File file = new File("C:\\Users\\Aquiris\\IdeaProjects\\Laborator6\\src\\main\\resources\\angajati.json");
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            List<Angajat> persoane = (List) mapper.readValue(file, new TypeReference<List<Angajat>>() {
            });
            return persoane;
        } catch (IOException var3) {
            IOException e = var3;
            e.printStackTrace();
            return List.of();
        }
    }

    public static void main(String[] args) {
        int opt;

        do {
            List<Angajat> listaAngajati = citire();


            Scanner scanner = new Scanner(System.in);
            opt = scanner.nextInt();
            switch (opt) {
                case 1:
                    Iterator var2 = listaAngajati.iterator();
                    while (var2.hasNext()) {
                        Angajat a = (Angajat) var2.next();
                        System.out.println(a);
                    }
                    break;
                    case 2:
                        List<Angajat> angajatiCuSalariuPeste2500 = listaAngajati.stream().filter(angajat -> angajat.getSalariu() > 2500).collect(Collectors.toList());
                        angajatiCuSalariuPeste2500.forEach(System.out::println);
                        break;
                    case 3:
                        int anulTrecut = LocalDate.now().getYear() - 1;
                        List<Angajat> a=listaAngajati.stream().filter(angajat-> angajat.getPostare().contains("sef") ||angajat.getPostare().contains("director")).filter(angajat -> angajat.getDataAngajarii().getYear() == anulTrecut).filter(angajat -> angajat.getDataAngajarii().getMonth() == Month.APRIL).collect(Collectors.toList());
                        a.forEach(System.out::println);
                        break;
                    case 4:
                        List<Angajat> b=listaAngajati.stream().filter(angajat ->! angajat.getPostare().contains("sef") && !angajat.getPostare().contains("director")).sorted(Comparator.comparingDouble(Angajat::getSalariu).reversed()).collect(Collectors.toList());
                        b.forEach(System.out::println);
                        break;
                        case 5:
                        List<String> numeMaj=listaAngajati.stream().map(angajat-> angajat.getNume().toUpperCase()).collect(Collectors.toList());
                        numeMaj.forEach(System.out::println);
                            break;
                case 6:
                    List<Float> salaraii=listaAngajati.stream().map(Angajat::getSalariu).filter(salariu -> salariu < 3000).collect(Collectors.toList());
                    salaraii.forEach(System.out::println);
                    break;
                    case 7:
                        Optional<Angajat> primulAngajat = listaAngajati.stream().min((a1, a2) -> a1.getDataAngajarii().compareTo(a2.getDataAngajarii()));
                        if (primulAngajat.isPresent()) {
                            System.out.println("Primul angajat al firmei: " + primulAngajat.get());
                        }
                        else {
                            System.out.println("Nu există angajați în firmă.");
                        }
                        break;
                case 8:
                    DoubleSummaryStatistics salar=listaAngajati.stream().collect(Collectors.summarizingDouble(Angajat::getSalariu));
                    System.out.println("Salar mediu: "+salar.getAverage());
                    System.out.println("Salar minim: "+salar.getMin());
                    System.out.println("Salar maxim:"+salar.getMax());
                    break;
                    case 9:
                        Optional<Angajat> angajatIon=listaAngajati.stream().filter(angajat-> angajat.getNume().contains("Ion")).findAny();
                        angajatIon.ifPresentOrElse(angajat -> System.out.println("Firma are cel puțin un Ion angajat"),
                                () -> System.out.println("Firma nu are nici un Ion angajat"));

                        break;
                        case 10:
                            int anulTrecut2 = LocalDate.now().getYear() - 1;
                            long nrAngajati=listaAngajati.stream().filter(angajat-> angajat.getDataAngajarii().getYear()==anulTrecut2).filter(angajat -> angajat.getDataAngajarii().getMonth()==Month.AUGUST || angajat.getDataAngajarii().getMonth()==Month.JULY || angajat.getDataAngajarii().getMonth()==Month.JUNE).count();
                            System.out.println(nrAngajati);
                            break;
            }

        } while (opt != 0) ;

    }
}
