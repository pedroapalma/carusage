package com.ppalma.carusage.strategy;

import com.ppalma.carusage.utils.DrawUtils;

public class WorkCarUsage implements CarUsage {

  @Override
  public String use() {
    return "Car using to go to work\n\n" + DrawUtils.drawWorkCar();
  }
}
