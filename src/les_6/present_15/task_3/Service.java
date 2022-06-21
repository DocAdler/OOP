package les_6.present_15.task_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Service <K extends Person, V extends List<Animal>> implements ZooClubInter{

    ZooClub<K, V> club = new ZooClub<>();
    Scanner input = new Scanner(System.in);

    @Override
    public void mainMenu() {
        System.out.println("""
                ---- @Главное меню ZooClub@ ----
                
                Выберите номер следующего действия:
                1. Добавить учасника клуба;
                2. Добавить питомца для участника;
                3. Исключить участника клуба;
                4. Исключить питомца из клуба;
                5. Список участников и их питомцев;
                6. Выйти из программы.
                """);
        Scanner menu = new Scanner(System.in);

        switch (menu.nextInt()) {
            case 1 -> addPerson();
            case 2 -> addAnimal();
            case 3 -> removePerson();
            case 4 -> removeAnimal();
            case 5 -> showClub();
            case 6 -> end();
        }
    }

    @Override
    public void addPerson() {

        System.out.println("""
                У нового участника есть питомец?
                1. Да.
                2. Нет.""");

        if (input.nextInt() == 1) {

            club.addPerson(makePerson(), (V) new ArrayList<>(Collections.singleton(makeAnimal())));

            System.out.println("""
                Новый участник и его питомец добавлены!
                ---------------------------------------""");

        } else {
            club.addPerson(makePerson());

            System.out.println("""
                Новый участник добавлен!
                ---------------------------------------""");
        }
        mainMenu();
    }

    @Override
    public K makePerson() {
        System.out.println("""
                    Введите имя участника:""");
        String personName = input.next();

        System.out.println("""
                    Введите его возраст:""");
        Integer personAge = input.nextInt();

        return (K) new Person(personName,personAge);
    }

    @Override
    public void addAnimal() {
        System.out.println("""
                Участник клуба уже зарегистрирован?
                1. Да;
                2. Нет.""");
        if (input.nextInt() == 1) {


            club.addAnimal(makePerson(), makeAnimal());

            System.out.println("""
                Новый участник и его питомец добавлены!
                ---------------------------------------""");

            mainMenu();

        } else {
            addPerson();
        }
    }

    @Override
    public Animal makeAnimal() {
        System.out.println("""
                    Введите тип питомца:""");
        String animalType = input.next();

        System.out.println("""
                    Введите имя питомца:""");
        String animalName = input.next();

        return new Animal(animalType, animalName);
    }

    @Override
    public void removePerson() {

        club.removePerson(makePerson());

        System.out.println("""
                Участник и его питомцы исключены из Клуба.
                ---------------------------------------""");
        mainMenu();
    }

    @Override
    public void removeAnimal() {
        club.removeAnimal(makePerson(), makeAnimal());
        System.out.println("""
                Питомец участника исключен из Клуба.
                ---------------------------------------""");
        mainMenu();
    }

    @Override
    public void showClub() {
        club.showClub();
        System.out.println("---------------------------------------");
        mainMenu();
    }

    @Override
    public void end() {
        System.out.println("--- Завершение программы ---");
    }
}