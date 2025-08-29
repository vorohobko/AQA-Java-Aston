package Task6;
import java.util.*;

public class Student {
    private String name;
    private String group;
    private int course;
    private List<Integer> grades;
    
    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }
    
	public String getName() { return name; }
    public String getGroup() { return group; }
    public int getCourse() { return course; }
    public List<Integer> getGrades() { return grades; }
    
    public void setCourse(int course) { this.course = course; }
    
    public double getAverageGrade() {
        if (grades.isEmpty()) return 0;
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }
    
    @Override
    public String toString() {
        return name + " (Группа: " + group + ", Курс: " + course + 
               ", Средний балл: " + String.format("%.2f", getAverageGrade()) + ")";
    }
    
    public static void removeBadStudents(Set<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getAverageGrade() < 3.0) {
                System.out.println("Удаляем студента: " + student.getName());
                iterator.remove();
            }
        }
    }
    
    // Метод для перевода студентов на следующий курс
    public static void promoteStudents(Set<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3.0) {
                int currentCourse = student.getCourse();
                student.setCourse(currentCourse + 1);
                System.out.println(student.getName() + " переведен на " + (currentCourse + 1) + " курс");
            }
        }
    }
    
    // Метод для печати студентов определенного курса
    public static void printStudents(Set<Student> students, int course) {
        System.out.println("\nСтуденты " + course + " курса:");
        boolean found = false;
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println("- " + student.getName() + " (Группа: " + student.getGroup() + ")");
                found = true;
            }
        }
        if (!found) {
            System.out.println("На " + course + " курсе нет студентов");
        }
    }
}