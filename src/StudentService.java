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
        students.forEach(s -> System.out.println(s.toString()));
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
    }
}
