package com.ppalma.carusage.decorator;

import com.ppalma.carusage.strategy.CarUsage;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class CarDecorator implements CarUsage {

  protected final CarUsage wrappedCarUsage;

  @Override
  public String use() {
    return this.wrappedCarUsage.use();
  }
}
