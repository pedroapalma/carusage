package com.ppalma.carusage.strategy;

public class SecretAgentCar implements CarUsage {

  @Override
  public String use() {
    return "Using to be secret agent";
  }
}
