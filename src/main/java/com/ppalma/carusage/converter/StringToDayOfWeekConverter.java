package com.ppalma.carusage.converter;

import java.time.DayOfWeek;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToDayOfWeekConverter implements Converter<String, DayOfWeek> {

  @Override
  public DayOfWeek convert(String source) {
    try {
      return DayOfWeek.valueOf(source.toUpperCase());
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("Invalid value for DayOfWeek: " + source);
    }
  }
}
