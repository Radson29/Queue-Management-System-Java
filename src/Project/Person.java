package Project;

import java.util.Objects;

public class Person {
    private String name;
    private String surname;
    private int counter;

    private String id;
    private Boolean isVip;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
    public Person(String name, String surname, int counter, Boolean isVip) {
        this.name = name;
        this.surname = surname;
        this.counter = counter;
        this.isVip = isVip;
        this.id =generateId();
    }

    public Person(String name, String surname, int counter) {
     this(name,surname,counter,false);
    }



    private String generateId() {
        return this.isVip ? String.format("%s_%s_%s_VIP", name, surname, counter)
                : String.format("%s_%s_%s", name, surname, counter);
    }


    @Override
    public String toString() {
        return id;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
