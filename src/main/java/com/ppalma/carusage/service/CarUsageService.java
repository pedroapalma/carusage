package com.ppalma.carusage.service;

import com.ppalma.carusage.strategy.CarUsage;
import java.time.DayOfWeek;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarUsageService {

  private final CarUsageFactory carUsageFactory;

  public String carUsageByDayOfWeek(DayOfWeek dayOfWeek) {
    CarUsage carUsage = this.carUsageFactory.createCarUsage(dayOfWeek);
    return carUsage.use();
  }
}
