package com.ppalma.carusage.decorator;

import com.ppalma.carusage.strategy.CarUsage;
import com.ppalma.carusage.utils.CarUsageUtils;

public class CamouflageCarFeature extends CarFeature {

  public CamouflageCarFeature(CarUsage wrappedCarUsage) {
    super(wrappedCarUsage);
  }

  @Override
  public String use() {
    return super.use() + "\n" + CarUsageUtils.CAMOUFLAGE_CAR_FEATURE;
  }
}
