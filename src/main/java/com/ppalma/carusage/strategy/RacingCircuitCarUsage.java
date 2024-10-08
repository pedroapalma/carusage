package com.ppalma.carusage.strategy;

import com.ppalma.carusage.utils.DrawUtils;

public class RacingCircuitCarUsage implements CarUsage {

  @Override
  public String use() {
    return "Car using to racing on the circuit\n\n" + DrawUtils.drawRacingCar();
  }
}
