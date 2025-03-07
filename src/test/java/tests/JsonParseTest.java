package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.example.dto.JsonDto;
import org.example.service.JsonComparatorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@Epic("Json parsing")
public class JsonParseTest {


    @Description("Тест сравнивает Json без учета порядка элементов в массиве hobbies")
    @DisplayName("Позитивный тест сравнения json")
    @Test
    void testEqualJsonDto() {
        JsonDto dto1 = new JsonDto("Иван", 30, Arrays.asList("programming", "reading"));
        JsonDto dto2 = new JsonDto("Иван", 30, Arrays.asList("reading", "programming"));
        assertTrue(JsonComparatorService.areJsonDtoEqual(dto1, dto2));
    }

    @Description("Тест сравнивает Json с разными именами")
    @DisplayName("Негативный тест сравнения имен в json")
    @Test
    void testDifferenceName() {
        JsonDto dto1 = new JsonDto("Иван", 30, Arrays.asList("programming", "reading"));
        JsonDto dto2 = new JsonDto("Петр", 30, Arrays.asList("programming", "reading"));
        assertFalse(JsonComparatorService.areJsonDtoEqual(dto1, dto2));
    }

    @Description("Тест сравнивает Json с разным возрастом")
    @DisplayName("Негативный тест сравнения возраста в json")
    @Test
    void testDifferenceAge() {
        JsonDto dto1 = new JsonDto("Иван", 30, Arrays.asList("programming", "reading"));
        JsonDto dto2 = new JsonDto("Иван", 25, Arrays.asList("programming", "reading"));
        assertFalse(JsonComparatorService.areJsonDtoEqual(dto1, dto2));
    }

    @Description("Тест сравнивает Json с разными элементами в массиве hobbies")
    @DisplayName("Негативный тест сравнения массива в json")
    @Test
    void testDifferenceHobbies() {
        JsonDto dto1 = new JsonDto("Иван", 30, Arrays.asList("programming", "reading"));
        JsonDto dto2 = new JsonDto("Иван", 30, Arrays.asList("music", "reading"));
        assertFalse(JsonComparatorService.areJsonDtoEqual(dto1, dto2));
    }

    @Description("Тест сравнивает Json с пустым массивом")
    @DisplayName("Позитивный тест сравнения json с пустым массивом")
    @Test
    void testEmptyHobbies() {
        JsonDto dto1 = new JsonDto("Иван", 30, Collections.emptyList());
        JsonDto dto2 = new JsonDto("Иван", 30, Collections.emptyList());
        assertTrue(JsonComparatorService.areJsonDtoEqual(dto1, dto2));
    }
}
