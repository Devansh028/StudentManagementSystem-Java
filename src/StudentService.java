import java.util.*;

public class StudentService {

    private List<Student> students;

    public StudentService() {
        students = FileHandler.load();
    }

    public void addStudent(Student s) {
        if (!isValidStudent(s))
            return;
        students.add(s);
        FileHandler.save(students);
        System.out.println("Student added!");
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.printf("%-5s %-15s %-5s %-15s%n", "ID", "Name", "Age", "Course");
        System.out.println("-------------------------------------------");

        for (Student s : students) {
            System.out.printf("%-5d %-15s %-5d %-15s%n",
                    s.getId(), s.getName(), s.getAge(), s.getCourse());
        }
    }

    public void sortByName() {
        students.sort(Comparator.comparing(Student::getName));
        FileHandler.save(students);
        System.out.println("Students sorted by name.");
    }

    public void searchById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println("\nStudent Found:");
                System.out.println("ID: " + s.getId());
                System.out.println("Name: " + s.getName());
                System.out.println("Age: " + s.getAge());
                System.out.println("Course: " + s.getCourse());
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void updateStudent(int id, String name, int age, String course) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(name);
                s.setAge(age);
                s.setCourse(course);
                FileHandler.save(students);
                System.out.println("Student updated!");
                return;
            }
        }
        System.out.println("Student ID not found!");
    }

    public void deleteStudent(int id) {
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.remove();
                FileHandler.save(students);
                System.out.println("Student deleted!");
                return;
            }
        }
        System.out.println("Student ID not found!");
    }

    public void searchByName(String name) {
        students.stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .forEach(System.out::println);
    }

    public void sortByAge() {
        students.sort(Comparator.comparingInt(Student::getAge));
        viewStudents();
        FileHandler.save(students);
    }

    private boolean isValidStudent(Student s) {
        if (s.getId() <= 0) {
            System.out.println(" ID must be positive.");
            return false;
        }
        if (s.getName() == null || s.getName().trim().isEmpty()) {
            System.out.println(" Name cannot be empty.");
            return false;
        }
        if (s.getAge() <= 0) {
            System.out.println(" Age must be greater than 0.");
            return false;
        }
        if (s.getCourse() == null || s.getCourse().trim().isEmpty()) {
            System.out.println("Course cannot be empty.");
            return false;
        }
        for (Student st : students) {
            if (st.getId() == s.getId()) {
                System.out.println(" Student ID already exists.");
                return false;
            }
        }
        return true;
    }

}
