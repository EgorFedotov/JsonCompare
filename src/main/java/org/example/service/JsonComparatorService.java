package org.example.service;

import io.qameta.allure.Step;
import org.example.dto.JsonDto;

import java.util.List;
import java.util.stream.Collectors;

public class JsonComparatorService {
    @Step("Сравниваем по очереди параметры: имя, возраст, хобби отсортированные по алфавиту")
    public static boolean areJsonDtoEqual(JsonDto dto1, JsonDto dto2) {
        if (!dto1.getName().equals(dto2.getName()))
            return false;
        if (dto1.getAge() != dto2.getAge())
            return false;

        List<String> sortedHobbies1 = dto1.getHobbies().stream().sorted().collect(Collectors.toList());
        List<String> sortedHobbies2 = dto2.getHobbies().stream().sorted().collect(Collectors.toList());

        return sortedHobbies1.equals(sortedHobbies2);
    }
}
