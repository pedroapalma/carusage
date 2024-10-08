package com.ppalma.carusage.strategy;

import com.ppalma.carusage.utils.CarUsageUtils;
import com.ppalma.carusage.utils.DrawUtils;

public class OffRoadCarUsage implements CarUsage {

  @Override
  public String use() {
    return CarUsageUtils.OFF_ROAD_CAR_DETAIL + "\n\n" + DrawUtils.drawOffRoadCar();
  }
}
