import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();
        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Sort by Name");
            System.out.println("4. Search by ID");
            System.out.println("5. Update Student");
            System.out.println("6. Delete Student");
            System.out.println("7. Search by Name");
            System.out.println("8. Sort by Age");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Course: ");
                    String course = sc.nextLine();
                    service.addStudent(new Student(id, name, age, course));
                    break;
                case 2:
                    service.viewStudents();
                    break;
                case 3:
                    service.sortByName();
                    service.viewStudents();
                    break;

                case 4:
                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();
                    service.searchById(searchId);
                    break;
                case 5:
                    System.out.print("Enter ID to Update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Name: ");
                    String n = sc.nextLine();
                    System.out.print("New Age: ");
                    int a = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Course: ");
                    String c = sc.nextLine();
                    service.updateStudent(uid, n, a, c);
                    break;
                case 6:
                    System.out.print("Enter ID to Delete: ");
                    int did = sc.nextInt();
                    service.deleteStudent(did);
                    break;
                case 7:
                    System.out.print("Enter Name: ");
                    String sname = sc.nextLine();
                    service.searchByName(sname);
                    break;
                case 8:
                    service.sortByAge();
                    break;
                case 9:
                    System.out.println("Goodbye!");
                    System.exit(0);
            }
        }
    }
}
