import java.time.LocalDate;
import java.util.Objects;

public class Donation {
    private Donor donor;
    private Charity charity;
    private double amount;
    private LocalDate date;

    public Donation(Donor donor, Charity charity, double amount, LocalDate date) {
        this.donor = donor;
        this.charity = charity;
        this.amount = amount;
        this.date = date;
    }

    public Donor getDonor() {
        return donor;
    }

    public Charity getCharity() {
        return charity;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format(
                "Donor: %-6s | Charity: %-15s | Amount: %8.2f | Date: %s",
                donor.getName(),
                charity.getName(),
                amount,
                date
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Donation)) return false;
        Donation donation = (Donation) o;
        return Double.compare(donation.amount, amount) == 0 &&
                Objects.equals(donor, donation.donor) &&
                Objects.equals(charity, donation.charity) &&
                Objects.equals(date, donation.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(donor, charity, amount, date);
    }
}
