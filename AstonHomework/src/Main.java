import java.util.*;
import Task6.PhoneList;
import Task6.Student;

public class Main {
	  public static void main(String[] args) {
	        System.out.println("=== ЗАДАНИЕ 1: РАБОТА СО СТУДЕНТАМИ ===");
	   
	        Set<Student> students = new HashSet<>();
	        students.add(new Student("Иван Иванов", "19ИТ-1", 1, Arrays.asList(4, 5, 3, 4)));
	        students.add(new Student("Петр Петров", "19ИТ-3", 1, Arrays.asList(2, 3, 2, 2)));
	        students.add(new Student("Степан Степанов", "18ИТ-2", 2, Arrays.asList(5, 5, 5, 5)));
	        students.add(new Student("Павел Дуров", "18ИТ-1", 2, Arrays.asList(3, 4, 3, 4)));
	        students.add(new Student("Марк Цукерберг", "20ИТ-4", 1, Arrays.asList(2, 2, 2, 2)));
	    
	        System.out.println("Все студенты:");
	        for (Student student : students) {
	            System.out.println(student);
	        }
	  
	        System.out.println("\n=== УДАЛЕНИЕ СТУДЕНТОВ С ПЛОХИМИ ОЦЕНКАМИ ===");
	        Student.removeBadStudents(students);
	        
	        System.out.println("\n=== ПЕРЕВОД НА СЛЕДУЮЩИЙ КУРС ===");
	        Student.promoteStudents(students);
	        
	        Student.printStudents(students, 1);
	        Student.printStudents(students, 2);
	        Student.printStudents(students, 3);
	        
	        System.out.println("\n=== ЗАДАНИЕ 2: ТЕЛЕФОННЫЙ СПРАВОЧНИК ===");
	        
	        PhoneList phoneList = new PhoneList();
	        
	        // Добавление записи
	        phoneList.add("Анонимус", "+7-911-111-11-11");
	        phoneList.add("Дарт Вейдер", "+7-922-222-22-22");
	        phoneList.add("Томас Шелби", "+7-933-333-33-33"); 
	        phoneList.add("Масяня", "+7-944-444-44-44");
	        phoneList.add("Томас Шелби", "+7-955-555-55-55"); 
	        
	        // Поиск номера
	        System.out.println("\nПоиск номеров:");
	        System.out.println("Томас Шелби: " + phoneList.get("Томас Шелби"));
	        System.out.println("Анонимус: " + phoneList.get("Анонимус"));
	        System.out.println("Шелдон Купер: " + phoneList.get("Шелдон Купер"));
	        
	        // Печать справочника
	        phoneList.printAll();
	    }
	}