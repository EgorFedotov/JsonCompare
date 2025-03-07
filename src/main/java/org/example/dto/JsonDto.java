package org.example.dto;

import java.util.List;
import java.util.Objects;

public class JsonDto {
    private final String name;
    private final int age;
    private final List<String> hobbies;

    public JsonDto(String name, int age, List<String> hobbies) {
        this.hobbies = hobbies;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        JsonDto jsonDTO = (JsonDto) o;
        return age == jsonDTO.age && Objects.equals(name, jsonDTO.name) && Objects.equals(hobbies, jsonDTO.hobbies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, hobbies);
    }

    @Override
    public String toString() {
        return "JsonDTO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobbies=" + hobbies +
                '}';
    }
}
