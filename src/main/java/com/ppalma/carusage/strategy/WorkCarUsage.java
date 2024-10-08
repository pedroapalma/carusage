package com.ppalma.carusage.strategy;

import com.ppalma.carusage.utils.CarUsageUtils;
import com.ppalma.carusage.utils.DrawUtils;

public class WorkCarUsage implements CarUsage {

  @Override
  public String use() {
    return CarUsageUtils.WORK_CAR_DETAIL + "\n\n" + DrawUtils.drawWorkCar();
  }
}
