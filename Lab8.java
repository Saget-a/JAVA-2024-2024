import java.util.*;

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
    private Set<Student> students;

    public Faculty(String name) {
        this.name = name;
        this.students = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }
}

class Institute {
    private String name;
    private Set<Faculty> faculties;

    public Institute(String name) {
        this.name = name;
        this.faculties = new HashSet<>();
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public Set<Faculty> getFaculties() {
        return faculties;
    }

    // New functionality: Map of faculties and their students
    public Map<String, Set<Student>> getFacultyStudentMap() {
        Map<String, Set<Student>> facultyStudentMap = new TreeMap<>();
        for (Faculty faculty : faculties) {
            facultyStudentMap.put(faculty.getName(), faculty.getStudents());
        }
        return facultyStudentMap;
    }
}

public class Lab8 {
    public static void main(String[] args) {
        // Create students
        Student s1 = new Student("Saget", "Hishikigi", "12345", 97.5);
        Student s2 = new Student("Tian", "Tod", "67890", 89.0);
        Student s3 = new Student("Anna", "Yanagi", "11223", 95.0);
        Student s4 = new Student("JailBird", "Reivencroft", "44556", 100.0);
        Student s5 = new Student("Gomba", "Nimune", "446666", 99.0);

        // Create faculties
        Faculty faculty1 = new Faculty("Computer Science");
        faculty1.addStudent(s1);
        faculty1.addStudent(s2);
        faculty1.addStudent(s5);

        Faculty faculty2 = new Faculty("Mathematics");
        faculty2.addStudent(s3);
        faculty2.addStudent(s4);

        // Create institute
        Institute institute = new Institute("National University");
        institute.addFaculty(faculty1);
        institute.addFaculty(faculty2);

        // 1) Total number of students (typed iterator)
        int totalStudents = 0;
        for (Faculty faculty : institute.getFaculties()) {
            totalStudents += faculty.getStudents().size();
        }
        System.out.println("Total number of students: " + totalStudents);
        System.out.println(); 

        // 2) Faculty with the most students (untyped iterator)
        Faculty maxFaculty = null;
        int maxStudents = 0;
        Iterator facultiesIterator = institute.getFaculties().iterator(); // untyped iterator
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
        System.out.println();

        // 3) List of students with an average grade between 95 and 100 (typed for-each loop)
        Set<Student> topStudents = new HashSet<>();
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
        System.out.println(); 

        // 4) Print all faculties and their students using Map
        Map<String, Set<Student>> facultyStudentMap = institute.getFacultyStudentMap();
        System.out.println("Faculties and their students:");
        for (Map.Entry<String, Set<Student>> entry : facultyStudentMap.entrySet()) {
            System.out.println("Faculty: " + entry.getKey());
            for (Student student : entry.getValue()) {
                System.out.println("  - " + student);
            }
            System.out.println(); 
        }
    }
}
