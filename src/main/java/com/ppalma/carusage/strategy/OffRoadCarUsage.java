package com.ppalma.carusage.strategy;

import com.ppalma.carusage.utils.DrawUtils;

public class OffRoadCarUsage implements CarUsage {

  @Override
  public String use() {
    return "Car using to go off road\n\n" + DrawUtils.drawOffRoadCar();
  }
}
