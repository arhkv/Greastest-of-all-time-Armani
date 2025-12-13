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

    public Donation(Donor donor, Charity charity, double amount) {
        this.donor = donor;
        this.charity = charity;
        this.amount = amount;
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

    public void displayInfo() {
        System.out.println(donor.getName() + " donated $" + amount + " to " + charity.getCharityName());
    }
}

public class donationplatform {
    public static void main(String[] args) {
        Donor donor1 = new Donor("Arman", "arman@email.com");
        Donor donor2 = new Donor("Alex", "alex@email.com");

        Charity charity1 = new Charity("Helping Hands", "Healthcare");
        Charity charity2 = new Charity("Bright Future", "Education");

        Donation donation1 = new Donation(donor1, charity1, 100.0);
        Donation donation2 = new Donation(donor2, charity2, 150.0);

        donor1.displayInfo();
        donor2.displayInfo();

        charity1.displayInfo();
        charity2.displayInfo();

        donation1.displayInfo();
        donation2.displayInfo();

        if (donation1.getAmount() > donation2.getAmount()) {
            System.out.println("First donation is larger.");
        } else {
            System.out.println("Second donation is larger.");
        }
    }
}