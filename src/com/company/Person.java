package com.company;

import java.util.Optional;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age;
    protected Optional <String> city;

    Person(PersonBuilder personBuilder) {
        this.name = personBuilder.name;
        this.surname = personBuilder.surname;
        this.age = personBuilder.age;
        this.city = personBuilder.city;
    }

    public boolean hasAge() {
        return age.isPresent();
    }

    public boolean hasAddress() {
        return city.isPresent();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age.getAsInt();
    }

    public String getAddress() {
        return city.orElse("нет данных");
    }

    public void setAddress(String city) {
        this.city = Optional.of(city);
    }

    public void happyBirthday() {
           this.age = this.age.of(age.getAsInt() + 1);
    }

    @Override
    public String toString() {
        return getName() + " " + getSurname();
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder son = new PersonBuilder()
                .setSurname(getName())
                .setAddress(getAddress());
        return son;
    }

}
