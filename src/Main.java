
public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static void main(String[] args) {
        Donor donor1 = new Donor("Amir", "Amir@gmail.com");
        Donor donor2 = new Donor("Arman", "arman@gmail.com");
        Charity charity1 = new Charity(
                "Save Animals",
                "Organization that helps homeless animals"
        );
        Donation donation1 = new Donation(
                donor1,
                charity1,
                10000,
                "2024-08-22"
        );
        Donation donation2 = new Donation(
                donor2,
                charity1,
                500.0,
                "2025-12-15"
        );
        System.out.println(ANSI_GREEN + "Donors information" + ANSI_RESET);
        donor1.showInfo();
        donor2.showInfo();
        System.out.println(ANSI_GREEN + "Charity's information" + ANSI_RESET);
        charity1.showInfo();
        System.out.println(ANSI_GREEN + "Donations information" + ANSI_RESET);
        donation1.doninfo();
        donation2.doninfo();
    }
}
