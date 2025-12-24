import java.util.Objects;

public class Charity {
    private String name;
    private String description;

    public Charity(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void showInfo() {
        System.out.println("Charity name: " + name);
        System.out.println("Description: " + description);
    }

    @Override
    public String toString() {
        return "Charity{name='" + name + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Charity)) return false;
        Charity charity = (Charity) o;
        return Objects.equals(name, charity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
