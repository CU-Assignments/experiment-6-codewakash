import java.util.*;
import java.util.stream.Collectors;

class Student {
    String name;
    double marks;

    Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class StudentFilter {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 78),
            new Student("Bob", 65),
            new Student("Charlie", 85)
        );

        students.stream()
            .filter(s -> s.marks > 75)
            .sorted(Comparator.comparing(s -> -s.marks))
            .map(s -> s.name)
            .forEach(System.out::println);
    }
}
