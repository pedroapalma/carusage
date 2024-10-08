package com.ppalma.carusage.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import com.ppalma.carusage.utils.CarUsageUtils;
import com.ppalma.carusage.utils.DrawUtils;
import org.junit.jupiter.api.Test;

class SecretAgentCarUsageTest {

  @Test
  void returnSecretAgentCarUsageDetail() {
    // Given
    SecretAgentCarUsage secretAgentCarUsage = new SecretAgentCarUsage();
    String expectedDetail = CarUsageUtils.SECRET_AGENT_CAR_DETAIL;
    String expectedDrawing = DrawUtils.drawSecretAgentCar();

    // When
    String result = secretAgentCarUsage.use();

    // Then
    assertThat(result).contains(expectedDetail)
        .contains(expectedDrawing);
  }
}
