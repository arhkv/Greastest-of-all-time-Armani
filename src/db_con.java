import java.sql.*;
import java.util.Scanner;

public class db_con {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connected to PostgreSQL!");

            boolean running = true;
            while (running) {
                // Главное меню — выбор таблицы
                System.out.println("\n=== Главное меню ===");
                System.out.println("1 → Работа с donor");
                System.out.println("2 → Работа с donation");
                System.out.println("3 → Работа с charity");
                System.out.println("0 → Выход");
                System.out.print("Выберите таблицу: ");

                int tableChoice = scanner.nextInt();
                scanner.nextLine();

                switch (tableChoice) {
                    case 1:
                        donorMenu(conn, scanner);
                        break;
                    case 2:
                        donationMenu(conn, scanner);
                        break;
                    case 3:
                        charityMenu(conn, scanner);
                        break;
                    case 0:
                        running = false;
                        System.out.println("Выход из программы.");
                        break;
                    default:
                        System.out.println("Неверная команда!");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ===== MENUS =====

    private static void donorMenu(Connection conn, Scanner scanner) throws SQLException {
        boolean running = true;
        while (running) {
            System.out.println("\n--- donor ---");
            System.out.println("1 → Показать всех доноров");
            System.out.println("2 → Добавить донора");
            System.out.println("3 → Обновить email донора");
            System.out.println("4 → Удалить донора");
            System.out.println("0 → Назад");
            System.out.print("Выберите команду: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    try (Statement stmt = conn.createStatement();
                         ResultSet rs = stmt.executeQuery("SELECT * FROM donor")) {
                        System.out.println("ID\tName\tEmail");
                        while (rs.next()) {
                            System.out.println(rs.getInt("id") + "\t" +
                                    rs.getString("name") + "\t" +
                                    rs.getString("email"));
                        }
                    }
                    break;
                case 2:
                    System.out.print("Введите имя: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите email: ");
                    String email = scanner.nextLine();
                    try (PreparedStatement ps = conn.prepareStatement("INSERT INTO donor (name, email) VALUES (?, ?)")) {
                        ps.setString(1, name);
                        ps.setString(2, email);
                        System.out.println("Добавлено доноров: " + ps.executeUpdate());
                    }
                    break;
                case 3:
                    System.out.print("Введите имя для обновления: ");
                    String uName = scanner.nextLine();
                    System.out.print("Введите новый email: ");
                    String newEmail = scanner.nextLine();
                    try (PreparedStatement ps = conn.prepareStatement("UPDATE donor SET email=? WHERE name=?")) {
                        ps.setString(1, newEmail);
                        ps.setString(2, uName);
                        System.out.println("Обновлено доноров: " + ps.executeUpdate());
                    }
                    break;
                case 4:
                    System.out.print("Введите имя для удаления: ");
                    String dName = scanner.nextLine();
                    try (PreparedStatement ps = conn.prepareStatement("DELETE FROM donor WHERE name=?")) {
                        ps.setString(1, dName);
                        System.out.println("Удалено доноров: " + ps.executeUpdate());
                    }
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверная команда!");
            }
        }
    }

    private static void donationMenu(Connection conn, Scanner scanner) throws SQLException {
        boolean running = true;
        while (running) {
            System.out.println("\n--- donation ---");
            System.out.println("1 → Показать все пожертвования");
            System.out.println("2 → Добавить пожертвование");
            System.out.println("3 → Обновить сумму пожертвования");
            System.out.println("4 → Удалить пожертвование по id");
            System.out.println("0 → Назад");
            System.out.print("Выберите команду: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    try (Statement stmt = conn.createStatement();
                         ResultSet rs = stmt.executeQuery("SELECT * FROM donation")) {
                        System.out.println("ID\tDonor_ID\tCharity\tAmount\tDate");
                        while (rs.next()) {
                            System.out.println(rs.getInt("id") + "\t" +
                                    rs.getInt("donor_id") + "\t" +
                                    rs.getString("charity") + "\t" +
                                    rs.getDouble("amount") + "\t" +
                                    rs.getDate("donation_date"));
                        }
                    }
                    break;
                case 2:
                    System.out.print("Введите donor_id: ");
                    int donorId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Введите название charity: ");
                    String charity = scanner.nextLine();
                    System.out.print("Введите сумму: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Введите дату (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    try (PreparedStatement ps = conn.prepareStatement(
                            "INSERT INTO donation (donor_id, charity, amount, donation_date) VALUES (?, ?, ?, ?)")) {
                        ps.setInt(1, donorId);
                        ps.setString(2, charity);
                        ps.setDouble(3, amount);
                        ps.setDate(4, Date.valueOf(date));
                        System.out.println("Добавлено пожертвований: " + ps.executeUpdate());
                    }
                    break;
                case 3:
                    System.out.print("Введите id пожертвования для обновления: ");
                    int idUpdate = scanner.nextInt();
                    System.out.print("Введите новую сумму: ");
                    double newAmount = scanner.nextDouble();
                    scanner.nextLine();
                    try (PreparedStatement ps = conn.prepareStatement("UPDATE donation SET amount=? WHERE id=?")) {
                        ps.setDouble(1, newAmount);
                        ps.setInt(2, idUpdate);
                        System.out.println("Обновлено пожертвований: " + ps.executeUpdate());
                    }
                    break;
                case 4:
                    System.out.print("Введите id пожертвования для удаления: ");
                    int idDelete = scanner.nextInt();
                    scanner.nextLine();
                    try (PreparedStatement ps = conn.prepareStatement("DELETE FROM donation WHERE id=?")) {
                        ps.setInt(1, idDelete);
                        System.out.println("Удалено пожертвований: " + ps.executeUpdate());
                    }
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверная команда!");
            }
        }
    }

    private static void charityMenu(Connection conn, Scanner scanner) throws SQLException {
        boolean running = true;
        while (running) {
            System.out.println("\n--- charity ---");
            System.out.println("1 → Показать все charity");
            System.out.println("2 → Добавить charity");
            System.out.println("3 → Обновить описание charity");
            System.out.println("4 → Удалить charity по id");
            System.out.println("0 → Назад");
            System.out.print("Выберите команду: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    try (Statement stmt = conn.createStatement();
                         ResultSet rs = stmt.executeQuery("SELECT * FROM charity")) {
                        System.out.println("ID\tName\tDescription");
                        while (rs.next()) {
                            System.out.println(rs.getInt("id") + "\t" +
                                    rs.getString("name") + "\t" +
                                    rs.getString("description"));
                        }
                    }
                    break;
                case 2:
                    System.out.print("Введите название: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите описание: ");
                    String desc = scanner.nextLine();
                    try (PreparedStatement ps = conn.prepareStatement("INSERT INTO charity (name, description) VALUES (?, ?)")) {
                        ps.setString(1, name);
                        ps.setString(2, desc);
                        System.out.println("Добавлено организаций: " + ps.executeUpdate());
                    }
                    break;
                case 3:
                    System.out.print("Введите id для обновления: ");
                    int idUpdate = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Введите новое описание: ");
                    String newDesc = scanner.nextLine();
                    try (PreparedStatement ps = conn.prepareStatement("UPDATE charity SET description=? WHERE id=?")) {
                        ps.setString(1, newDesc);
                        ps.setInt(2, idUpdate);
                        System.out.println("Обновлено организаций: " + ps.executeUpdate());
                    }
                    break;
                case 4:
                    System.out.print("Введите id для удаления: ");
                    int idDelete = scanner.nextInt();
                    scanner.nextLine();
                    try (PreparedStatement ps = conn.prepareStatement("DELETE FROM charity WHERE id=?")) {
                        ps.setInt(1, idDelete);
                        System.out.println("Удалено организаций: " + ps.executeUpdate());
                    }
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверная команда!");
            }
        }
    }
}
