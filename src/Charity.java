public class Charity {
    private String name;
    private String description;
    public Charity(String name, String description) {
        this.name = name;
        this.description = description;}
    public String getName() {
        return name;}
    public String getDescription() {
        return description;}
    public void showInfo() {
        System.out.println("Charity name: " + name);
        System.out.println("Description: " + description);
    }
}
