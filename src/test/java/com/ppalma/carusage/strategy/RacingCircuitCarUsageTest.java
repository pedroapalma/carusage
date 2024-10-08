package com.ppalma.carusage.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import com.ppalma.carusage.utils.CarUsageUtils;
import com.ppalma.carusage.utils.DrawUtils;
import org.junit.jupiter.api.Test;

class RacingCircuitCarUsageTest {

  @Test
  void returnRacingCircuitCarUsageDetail() {
    // Given
    RacingCircuitCarUsage racingCircuitCarUsage = new RacingCircuitCarUsage();
    String expectedDetail = CarUsageUtils.RACING_CIRCUIT_CAR_DETAIL;
    String expectedDrawing = DrawUtils.drawRacingCircuitCar();

    // When
    String result = racingCircuitCarUsage.use();

    // Then
    assertThat(result).contains(expectedDetail)
        .contains(expectedDrawing);
  }
}
