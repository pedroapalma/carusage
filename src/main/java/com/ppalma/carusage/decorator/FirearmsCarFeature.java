package com.ppalma.carusage.decorator;

import com.ppalma.carusage.strategy.CarUsage;

public class FirearmsCarFeature extends CarFeature {

  public FirearmsCarFeature(CarUsage wrappedCarUsage) {
    super(wrappedCarUsage);
  }

  @Override
  public String use() {
    return super.use() + "\nThe use of firearms is permitted";
  }
}
