package com.ppalma.carusage.service;

import com.ppalma.carusage.strategy.CarUsage;
import java.time.DayOfWeek;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarUsagesService {

  private final CarUsagesFactory carUsagesFactory;

  public String getCarByDayOfWeek(DayOfWeek dayOfWeek) {
    CarUsage carUsage = this.carUsagesFactory.createCarUsage(dayOfWeek);
    return carUsage.use();
  }
}
