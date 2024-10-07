package com.ppalma.carusage.decorator;

import com.ppalma.carusage.strategy.CarUsage;

public class FirearmsCarFeature extends CarDecorator {

  public FirearmsCarFeature(CarUsage wrappedCarUsage) {
    super(wrappedCarUsage);
  }

  @Override
  public String use() {
    return super.use() + " and the use of firearms is permitted";
  }
}
