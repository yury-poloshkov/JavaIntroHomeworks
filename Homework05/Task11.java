package Homework05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * task01
 * Реализуйте структуру телефонной книги с помощью HashMap.
 * Программа также должна учитывать, что во входной структуре будут повторяющиеся имена
 * с разными телефонами, их необходимо считать, как одного человека с разными телефонами. 
 * Вывод должен быть отсортирован по убыванию числа телефонов.
 */
public class Task11 {
    public static void main(String[] args) {
        final List<String> menu = new ArrayList<>(List.of(
            "--- Телефонный справочник v.2023.06.21 -----",
            "--- ГЛАВНОЕ МЕНЮ ---------------------------",
            "1. Распечатать справочник",
            "2. Создать новый контакт",
            "3. Добавить номер к существующему контакту",
            "4. Удалить контакт",
            "5. Удалить номер у существующего контакта",
            "0. Выход"));
        //LinkedHashMap<String, ArrayList<String>> phonebook = new LinkedHashMap<>();
        HashMap<String, ArrayList<String>> phonebook = new HashMap<>();
        initiatePhB(phonebook);
        int userChoice = -1;
        while (userChoice != 0) {
            userChoice = showMainMenu(menu);
            switch (userChoice) {
                case 1:
                    System.out.println(phonebook);
                    timeOut();               
                    break;
                case 2:
                    addNewContact(phonebook);
                    break;
                case 3:
                    addPhoneNumber(phonebook);
                    break;
                case 4, 5:
                    System.out.println("Функционал в разработке");
                    break;
                case 0:
                    System.out.println("--- Работа программы завершена ---");
                    break;
                default:
                    System.out.printf("Error: %s - unsupported operation!\n", userChoice);
                    timeOut();
                    break;
            }
        }
    }

    private static void addPhoneNumber(HashMap<String, ArrayList<String>> phonebook) {
        System.out.print("\033[H\033[J");
        System.out.println("--- Добавление номера существующему контакту ---");
        System.out.print("Введите маску поиска имени контакта: ");
        Scanner scn = new Scanner(System.in);
        String contact = scn.nextLine();
        contact = findContact(phonebook, contact);
        if (contact != null) {
            ArrayList<String> numbers = new ArrayList<>(phonebook.get(contact));
            System.out.printf("--- Добавление нового номера контакту %s ---\n", contact);
            System.out.print("Введите номер: ");
            numbers.add(scn.nextLine());
            phonebook.replace(contact, numbers);
        } else {
            System.out.println("По указанной маске контактов не обнаружено.");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public static String findContact(HashMap<String, ArrayList<String>> phonebook, String contact) {
        String foundContact = null;
        if (phonebook.containsKey(contact)){
            foundContact = contact;
        } else {
            ArrayList<String> contacts = new ArrayList<>();
            for (String item : phonebook.keySet()){
                if (item.contains(contact)){        
                    contacts.add(item);
                    System.out.printf("%d. %s\n", contacts.size(),item);
                }
            }
            System.out.print("Введите номер контакта, которому необходимо добавить номер (0 - если искомый контакт не на1йден): ");
            Scanner scn = new Scanner(System.in);
            int choice = Integer.parseInt(scn.nextLine());
            if (choice != 0){
                foundContact = contacts.get(choice-1);
            }
        }
        return foundContact;
    }

    private static void addNewContact(HashMap<String, ArrayList<String>> phonebook) {
        System.out.print("\033[H\033[J");
        System.out.println("--- Создание нового контакта ---");
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = scn.nextLine();
        if (phonebook.keySet().contains(name)){
            System.out.println("Контакт уже существует.\nВоспользуйтесь опцией добавления номера сущеcтвующему контакту.");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            ArrayList<String> numbers = new ArrayList<>();
            String inputNext = "y";
            while (inputNext.toLowerCase().equals("y")) {
                System.out.print("Введите номер: ");
                numbers.add(scn.nextLine());
                System.out.print("Хотите ввести еще один номер (y/n): ");
                inputNext = scn.nextLine();
            }
            phonebook.put(name, numbers);
        }
    }
    private static void initiatePhB(HashMap<String, ArrayList<String>> phonebook) {
        phonebook.put("Иванов Иван", new ArrayList<String>(List.of("+79154567891", "+79147894512")));
        phonebook.put("Асександров Петр", new ArrayList<String>(List.of("+79154544678")));
        phonebook.put("Сидоров Александр", new ArrayList<String>(List.of("+79154578945", "+79142365814", "+79647851234")));
        phonebook.put("Петров Иван", new ArrayList<String>(List.of("+79678954512")));
    }
    public static int showMainMenu(List<String> menu) {
        System.out.print("\033[H\033[J");
        for (String option : menu) {
            System.out.println(option);
        }
        System.out.print("Введите код операции: ");
        Scanner scn = new Scanner(System.in);
        int choice = Integer.parseInt(scn.next());
        if (choice == 0) scn.close();
        return choice;
    }
    private static void timeOut(){
        System.out.println("Press ENTER to continue");
        Scanner stopscn = new Scanner(System.in);
        stopscn.nextLine();
        //stopscn.close();
    }
}