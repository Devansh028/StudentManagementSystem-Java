import java.util.*;

public class StudentService {

    private List<Student> students;

    public StudentService() {
        students = FileHandler.load();
    }

    public void addStudent(Student s) {
        students.add(s);
        FileHandler.save(students);
        System.out.println("Student added!");
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        students.forEach(System.out::println);
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
}
