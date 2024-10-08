package com.ppalma.carusage.strategy;

import com.ppalma.carusage.utils.DrawUtils;

public class SecretAgentCarUsage implements CarUsage {

  @Override
  public String use() {
    return "Car using to be secret agent\n\n" + DrawUtils.drawSecretAgentCar();
  }
}
