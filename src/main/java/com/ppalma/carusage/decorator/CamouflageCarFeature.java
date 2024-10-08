package com.ppalma.carusage.decorator;

import com.ppalma.carusage.strategy.CarUsage;

public class CamouflageCarFeature extends CarFeature {

  public CamouflageCarFeature(CarUsage wrappedCarUsage) {
    super(wrappedCarUsage);
  }

  @Override
  public String use() {
    return super.use() + "\nCamouflage is activated";
  }
}
