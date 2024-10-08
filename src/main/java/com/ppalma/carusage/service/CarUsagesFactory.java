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
public class CarUsagesFactory {

  public CarUsage createCarUsage(DayOfWeek dayOfWeek) {
    return switch (dayOfWeek) {
      case MONDAY -> new WorkCarUsage();
      case TUESDAY -> new RacingCircuitCarUsage();
      case WEDNESDAY, THURSDAY -> new OffRoadCarUsage();
      case FRIDAY -> {
        CarUsage secretAgentCarUsage = new SecretAgentCarUsage();
        yield new FirearmsCarFeature(new CamouflageCarFeature(secretAgentCarUsage));
      }
      default -> throw new IllegalArgumentException(String.format(
          "The car for the day %s has not yet been implemented, enter the following days: [monday, tuesday, wednesday, thursday, friday]",
          dayOfWeek));
    };
  }
}
