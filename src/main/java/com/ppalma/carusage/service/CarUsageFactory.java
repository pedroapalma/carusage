package com.ppalma.carusage.service;

import com.ppalma.carusage.decorator.CamouflageCarFeature;
import com.ppalma.carusage.decorator.FirearmsCarFeature;
import com.ppalma.carusage.strategy.CarUsage;
import com.ppalma.carusage.strategy.OffRoadCarUsage;
import com.ppalma.carusage.strategy.RacingCircuitCarUsage;
import com.ppalma.carusage.strategy.SecretAgentCarUsage;
import com.ppalma.carusage.strategy.WorkCarUsage;
import java.time.DayOfWeek;
import org.springframework.stereotype.Component;

@Component
public class CarUsageFactory {

  public static CarUsage createCarUsage(DayOfWeek dayOfWeek) {
    return switch (dayOfWeek) {
      case MONDAY -> new WorkCarUsage();
      case TUESDAY -> new RacingCircuitCarUsage();
      case WEDNESDAY, THURSDAY -> new OffRoadCarUsage();
      case FRIDAY -> {
        CarUsage secretAgentCarUsage = new SecretAgentCarUsage();
        yield new FirearmsCarFeature(new CamouflageCarFeature(secretAgentCarUsage));
      }
      default -> throw new IllegalArgumentException(String.format(
          "The day %s is invalid, the valid days are: [MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY]",
          dayOfWeek));
    };
  }
}
