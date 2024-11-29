import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Student {
    private String firstName;
    private String lastName;
    private String recordBookNumber;
    private double averageGrade;

    public Student(String firstName, String lastName, String recordBookNumber, double averageGrade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.recordBookNumber = recordBookNumber;
        this.averageGrade = averageGrade;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + recordBookNumber + "), Avg Grade: " + averageGrade;
    }
}

class Faculty {
    private String name;
    private List<Student> students;

    public Faculty(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }
}

class Institute {
    private String name;
    private List<Faculty> faculties;

    public Institute(String name) {
        this.name = name;
        this.faculties = new ArrayList<>();
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }
}

public class Main {
    public static void main(String[] args) {
        // Створення студентів
        Student s1 = new Student("Saget", "Hishikigi", "12345", 97.5);
        Student s2 = new Student("Tian", "Tod", "67890", 89.0);
        Student s3 = new Student("Anna", "Yanagi", "11223", 95.0);
        Student s4 = new Student("JailBeard", "Reivencroft", "44556", 100.0);
        Student s5 = new Student("Gomba", "Nimune", "446666", 99.0);

        // Створення факультетів
        Faculty faculty1 = new Faculty("Computer Science");
        faculty1.addStudent(s1);
        faculty1.addStudent(s2);
        faculty1.addStudent(s5);


        Faculty faculty2 = new Faculty("Mathematics");
        faculty2.addStudent(s3);
        faculty2.addStudent(s4);

        // Створення інституту
        Institute institute = new Institute("National University");
        institute.addFaculty(faculty1);
        institute.addFaculty(faculty2);

        // 1) Загальна кількість студентів (типізований ітератор)
        int totalStudents = 0;
        for (Faculty faculty : institute.getFaculties()) {
            totalStudents += faculty.getStudents().size();
        }
        System.out.println("Total number of students: " + totalStudents);

        // 2) Факультет з найбільшою кількістю студентів (нетипізований ітератор)
        Faculty maxFaculty = null;
        int maxStudents = 0;
        Iterator facultiesIterator = institute.getFaculties().iterator(); // нетипізований ітератор
        while (facultiesIterator.hasNext()) {
            Faculty faculty = (Faculty) facultiesIterator.next();
            if (faculty.getStudents().size() > maxStudents) {
                maxStudents = faculty.getStudents().size();
                maxFaculty = faculty;
            }
        }
        if (maxFaculty != null) {
            System.out.println("Faculty with the most students: " + maxFaculty.getName() + " (" + maxStudents + " students)");
        }

        // 3) Список студентів із середнім балом у діапазоні 95..100 (типізований цикл for-each)
        List<Student> topStudents = new ArrayList<>();
        for (Faculty faculty : institute.getFaculties()) {
            for (Student student : faculty.getStudents()) {
                if (student.getAverageGrade() >= 95 && student.getAverageGrade() <= 100) {
                    topStudents.add(student);
                }
            }
        }

        System.out.println("Students with an average grade between 95 and 100:");
        for (Student student : topStudents) {
            System.out.println(student);
        }
    }
}
