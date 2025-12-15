public class Donation {
    private Donor donor;
    private Charity charity;
    private double amount;
    private String date;
    public Donation(Donor donor, Charity charity, double amount, String date) {
        this.donor = donor;
        this.charity = charity;
        this.amount = amount;
        this.date = date;}
    public double getAmount() {return amount;
    }
    public String getDate() {
        return date;
    }

    public void doninfo() {
        System.out.println("Donor: " + donor.getName());
        System.out.println("Charity: " + charity.getName());
        System.out.println("Amount: " + amount);
        System.out.println("Date: " + date);
    }

    public void showDonationInfo() {
        System.out.println("Donation information");
    }
}
