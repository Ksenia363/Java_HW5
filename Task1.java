// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами, их необходимо считать, 
// как одного человека с разными телефонами. 
// Вывод должен быть отсортирован по убыванию числа телефонов.

import java.util.*;

public class Task1 {
    public static void Telephone_book() {
        Map<String, Set<String>> phoneBook = new HashMap<>();

        addContact(phoneBook, "Svetlana", "+79276814256");
        addContact(phoneBook, "Ivan", "+79324526365");
        addContact(phoneBook, "Oleg", "+79451415265");
        addContact(phoneBook, "Oleg", "+79865431214");
        addContact(phoneBook, "Ivan", "+7932452689");
        addContact(phoneBook, "Ivan", "+7932452852");


        List<Map.Entry<String, Set<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        sortedEntries.sort((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()));

        for (Map.Entry<String, Set<String>> entry : sortedEntries) {
            String name = entry.getKey();
            Set<String> phoneNumbers = entry.getValue();

            System.out.println(name + ": " + phoneNumbers);
        }
    }

    public static void addContact(Map<String, Set<String>> phoneBook, String name, String phoneNumber) {

        if (phoneBook.containsKey(name)) {
            Set<String> phoneNumbers = phoneBook.get(name);
            phoneNumbers.add(phoneNumber);
        } else {

            Set<String> phoneNumbers = new HashSet<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }
}