package Task6;
import java.util.*;

public class PhoneList {
    private Map<String, List<String>> contacts;
    
    public PhoneList() {
        contacts = new HashMap<>();
    }
    
    // Метод для добавления записи
    public void add(String lastName, String phoneNumber) {
        if (!contacts.containsKey(lastName)) {
            contacts.put(lastName, new ArrayList<>());
        }
        contacts.get(lastName).add(phoneNumber);
        System.out.println("Добавлен: " + lastName + " - " + phoneNumber);
    }
    
    public List<String> get(String lastName) {
        if (contacts.containsKey(lastName)) {
            return contacts.get(lastName);
        }
        return new ArrayList<>(); 
    }
    
    // Метод для печати всего справочника
    public void printAll() {
        System.out.println("\nТелефонный справочник:");
        for (Map.Entry<String, List<String>> entry : contacts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}