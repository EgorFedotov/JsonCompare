package org.example;

import org.example.dto.JsonDto;
import org.example.service.JsonComparatorService;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        JsonDto dto1 = new JsonDto("Иван", 30, Arrays.asList("programming", "reading"));
        JsonDto dto2 = new JsonDto("Иван", 30, Arrays.asList("reading", "programming"));
        System.out.println(JsonComparatorService.areJsonDtoEqual(dto1, dto2));
        JsonDto dto3 = new JsonDto("Иван", 31, Arrays.asList("programming", "reading"));
        JsonDto dto4 = new JsonDto("Иван", 30, Arrays.asList("reading", "programming"));
        System.out.println(JsonComparatorService.areJsonDtoEqual(dto3, dto4));
    }
}