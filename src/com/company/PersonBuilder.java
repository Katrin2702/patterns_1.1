package com.company;

import java.util.Optional;
import java.util.OptionalInt;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected OptionalInt age = OptionalInt.empty();
    protected Optional <String> city = Optional.empty();

    public PersonBuilder setName(final String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(final String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int i) {
        this.age = this.age.of(i);
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.city = Optional.of(address);
        return this;
    }

    public Person build() throws IllegalStateException, IllegalArgumentException {
        Person person = new Person(this);
        if (person.name == null | person.surname == null) {
            throw new IllegalStateException("не указаны данные полей 'name' и/или 'surname'");
        }
        if (person.age.isPresent()) {
            if (person.age.getAsInt() < 0) {
                throw new IllegalArgumentException("возраст не может быть отрицательным числом");
            }
        }
        return person;
    }

}