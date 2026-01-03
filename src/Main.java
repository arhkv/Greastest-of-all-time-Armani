import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Donor donor1 = new Donor("Amir", "amir@gmail.com");
        Donor donor2 = new Donor("Arman", "arman@gmail.com");

        Charity charity = new Charity(
                "Save Animals",
                "Helping homeless animals"
        );

        List<Donation> donations = new ArrayList<>();

        donations.add(new Donation(donor1, charity, 10000, LocalDate.of(2024, 8, 22)));
        donations.add(new Donation(donor2, charity, 500, LocalDate.of(2025, 12, 15)));
        donations.add(new Donation(donor1, charity, 2000, LocalDate.of(2025, 1, 10)));

        System.out.println("DONATIONS ABOVE 1000");
        System.out.println("-----------------------------------------------");
        donations.stream()
                .filter(d -> d.getAmount() > 1000)
                .forEach(System.out::println);

        System.out.println("\nSORTED BY AMOUNT");
        System.out.println("-----------------------------------------------");
        donations.stream()
                .sorted(Comparator.comparingDouble(Donation::getAmount))
                .forEach(System.out::println);

        System.out.println("\nDONATIONS BY AMIR");
        System.out.println("-----------------------------------------------");
        donations.stream()
                .filter(d -> d.getDonor().getName().equals("Amir"))
                .forEach(System.out::println);

        System.out.println("\nDONOR INFO");
        System.out.println("-----------------------------------------------");
        Person person = donor1;
        person.showInfo();
    }
}
