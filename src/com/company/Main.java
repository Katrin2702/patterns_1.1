package com.company;

public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();


        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();

        System.out.println("У " + mom + " есть сын - " + son);

        if (mom.hasAge()) {
            System.out.println("Возраст " + mom + ": " + mom.getAge());
            mom.happyBirthday();
            System.out.println("Возраст " + mom + " после дня рождения: " + mom.getAge());
        } else {
            System.out.println("Невозможно выполнить действие - возраст неизвестен");
        }

            System.out.println(mom + " проживает в: " + mom.getAddress());

        try {
            // Не хватает обязательных полей
            new PersonBuilder()
                    .setName("Петр")
                    .setAge(53)
                    .setAddress("Москва")
                    .build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder()
                    .setName("Петр")
                    .setSurname("Иванов")
                    .setAge(-100)
                    .setAddress("Москва")
                    .build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}