package com.ppalma.carusage.strategy;

import com.ppalma.carusage.utils.CarUsageUtils;
import com.ppalma.carusage.utils.DrawUtils;

public class SecretAgentCarUsage implements CarUsage {

  @Override
  public String use() {
    return CarUsageUtils.SECRET_AGENT_CAR_DETAIL + "\n\n" + DrawUtils.drawSecretAgentCar();
  }
}
