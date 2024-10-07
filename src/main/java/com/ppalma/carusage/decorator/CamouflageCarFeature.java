package com.ppalma.carusage.decorator;

import com.ppalma.carusage.strategy.CarUsage;

public class CamouflageCarFeature extends CarDecorator {

  public CamouflageCarFeature(CarUsage wrappedCarUsage) {
    super(wrappedCarUsage);
  }

  @Override
  public String use() {
    return super.use() + " and camouflage is activated";
  }
}
