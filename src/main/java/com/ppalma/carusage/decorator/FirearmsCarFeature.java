package com.ppalma.carusage.decorator;

import com.ppalma.carusage.strategy.CarUsage;
import com.ppalma.carusage.utils.CarUsageUtils;

public class FirearmsCarFeature extends CarFeature {

  public FirearmsCarFeature(CarUsage wrappedCarUsage) {
    super(wrappedCarUsage);
  }

  @Override
  public String use() {
    return super.use() + "\n" + CarUsageUtils.FIREARMS_CAR_FEATURE;
  }
}
