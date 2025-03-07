package tests;

import org.example.dto.JsonDto;
import org.example.service.JsonComparatorService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JsonParseTest {

    @Test
    void testEqualJsonDto() {
        JsonDto dto1 = new JsonDto("Иван", 30, Arrays.asList("programming", "reading"));
        JsonDto dto2 = new JsonDto("Иван", 30, Arrays.asList("reading", "programming"));
        assertTrue(JsonComparatorService.areJsonDtoEqual(dto1, dto2));
    }

    @Test
    void testDifferenceName() {
        JsonDto dto1 = new JsonDto("Иван", 30, Arrays.asList("programming", "reading"));
        JsonDto dto2 = new JsonDto("Петр", 30, Arrays.asList("programming", "reading"));
        assertFalse(JsonComparatorService.areJsonDtoEqual(dto1, dto2));
    }

    @Test
    void testDifferenceAge() {
        JsonDto dto1 = new JsonDto("Иван", 30, Arrays.asList("programming", "reading"));
        JsonDto dto2 = new JsonDto("Иван", 25, Arrays.asList("programming", "reading"));
        assertFalse(JsonComparatorService.areJsonDtoEqual(dto1, dto2));
    }

    @Test
    void testDifferenceHobbies() {
        JsonDto dto1 = new JsonDto("Иван", 30, Arrays.asList("programming", "reading"));
        JsonDto dto2 = new JsonDto("Иван", 30, Arrays.asList("music", "reading"));
        assertFalse(JsonComparatorService.areJsonDtoEqual(dto1, dto2));
    }

    @Test
    void testEmptyHobbies() {
        JsonDto dto1 = new JsonDto("Иван", 30, Collections.emptyList());
        JsonDto dto2 = new JsonDto("Иван", 30, Collections.emptyList());
        assertTrue(JsonComparatorService.areJsonDtoEqual(dto1, dto2));
    }
}
