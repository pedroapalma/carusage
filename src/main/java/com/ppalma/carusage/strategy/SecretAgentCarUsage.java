package com.ppalma.carusage.strategy;

public class SecretAgentCarUsage implements CarUsage {

  @Override
  public String use() {
    return "Car using to be secret agent";
  }
}
