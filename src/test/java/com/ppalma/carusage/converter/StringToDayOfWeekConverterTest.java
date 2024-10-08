package com.ppalma.carusage.converter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.time.DayOfWeek;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.converter.Converter;

class StringToDayOfWeekConverterTest {

  @Test
  void convertValidDayOfWeek() {
    // Given
    Converter<String, DayOfWeek> converter = new StringToDayOfWeekConverter();

    // When & Then
    assertThat(converter.convert("monday")).isEqualTo(DayOfWeek.MONDAY);
    assertThat(converter.convert("TUESDAY")).isEqualTo(DayOfWeek.TUESDAY);
    assertThat(converter.convert("WeDnEsDay")).isEqualTo(DayOfWeek.WEDNESDAY);
    assertThat(converter.convert("THURSDAY")).isEqualTo(DayOfWeek.THURSDAY);
    assertThat(converter.convert("friday")).isEqualTo(DayOfWeek.FRIDAY);
    assertThat(converter.convert("saturday")).isEqualTo(DayOfWeek.SATURDAY);
    assertThat(converter.convert("SUNDAY")).isEqualTo(DayOfWeek.SUNDAY);
  }

  @Test
  void convertInvalidDayOfWeek() {
    // Given
    Converter<String, DayOfWeek> converter = new StringToDayOfWeekConverter();

    // When & Then
    assertThatThrownBy(() -> converter.convert("noday"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("Invalid value for DayOfWeek: noday");
    assertThatThrownBy(() -> converter.convert("Funday"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("Invalid value for DayOfWeek: Funday");
  }
}
