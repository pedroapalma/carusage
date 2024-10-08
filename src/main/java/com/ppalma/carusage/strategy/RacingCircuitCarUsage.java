package com.ppalma.carusage.strategy;

import com.ppalma.carusage.utils.CarUsageUtils;
import com.ppalma.carusage.utils.DrawUtils;

public class RacingCircuitCarUsage implements CarUsage {

  @Override
  public String use() {
    return CarUsageUtils.RACING_CIRCUIT_CAR_DETAIL + "\n\n" + DrawUtils.drawRacingCircuitCar();
  }
}
