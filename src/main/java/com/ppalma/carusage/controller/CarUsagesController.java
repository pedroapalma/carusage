package com.ppalma.carusage.controller;

import com.ppalma.carusage.service.CarUsageService;
import java.time.DayOfWeek;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("car-usage")
public class CarUsagesController {

  private final CarUsageService carUsageService;

  @GetMapping("/{dayOfWeek}")
  public String carUsageByDayOfWeek(@PathVariable DayOfWeek dayOfWeek) {
    return this.carUsageService.carUsageByDayOfWeek(dayOfWeek);
  }

}
