import java.util.Objects;

public class Donor extends Person {

    public Donor(String name, String email) {
        super(name, email);
    }

    @Override
    public void showInfo() {
        System.out.println("Donor name: " + name);
        System.out.println("Email: " + email);
    }

    @Override
    public String toString() {
        return "Donor{name='" + name + "', email='" + email + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Donor)) return false;
        Donor donor = (Donor) o;
        return Objects.equals(email, donor.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}