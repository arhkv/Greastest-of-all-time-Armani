class Donor {
    private String name;
    private String email;
    public Donor(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void displayInfo() {
        System.out.println("Donor: " + name + ", Email: " + email);
    }
}
class Charity {
    private String charityName;
    private String category;
    public Charity(String charityName, String category) {
        this.charityName = charityName;
        this.category = category;
    }
    public String getCharityName() {
        return charityName;
    }
    public void setCharityName(String charityName) {
        this.charityName = charityName;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void displayInfo() {
        System.out.println("Charity: " + charityName + ", Category: " + category);
    }
}
class Donation {
    private Donor donor;
    private Charity charity;
    private double amount;
    private static int donationCount = 0;
    private static double totalAmount = 0;
    public Donation(Donor donor, Charity charity, double amount) {
        this.donor = donor;
        this.charity = charity;
        this.amount = amount;
        donationCount++;
        totalAmount += amount;
    }
    public Donor getDonor() {
        return donor;
    }
    public void setDonor(Donor donor) {
        this.donor = donor;
    }
    public Charity getCharity() {
        return charity;
    }
    public void setCharity(Charity charity) {
        this.charity = charity;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public static int getDonationCount() {
        return donationCount;
    }
    public static double getTotalAmount() {
        return totalAmount;
    }
    public void displayInfo() {
        System.out.println(donor.getName() + " donated $" + amount + " to " + charity.getCharityName());
    }
}

public class donationplatform {
    public static void main(String[] args) {
        Donor donor1 = new Donor("BigBoss", "BigBossgoat@email.com");
        Donor donor2 = new Donor("TheBestArman", "TheBestArman@email.com");
        Charity charity1 = new Charity("Helping Hands", "Healthcare");
        Charity charity2 = new Charity("Bright Future", "Education");
        Donation donation1 = new Donation(donor1, charity1, 100);
        Donation donation2 = new Donation(donor2, charity2, 150000);
        donor1.displayInfo();
        donor2.displayInfo();
        charity1.displayInfo();
        charity2.displayInfo();
        donation1.displayInfo();
        donation2.displayInfo();
        System.out.println("Total number of donations: " + Donation.getDonationCount());
        System.out.println("Total amount of donations: " + Donation.getTotalAmount());
    }
}