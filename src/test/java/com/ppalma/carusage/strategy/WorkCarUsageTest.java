package com.ppalma.carusage.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import com.ppalma.carusage.utils.CarUsageUtils;
import com.ppalma.carusage.utils.DrawUtils;
import org.junit.jupiter.api.Test;

class WorkCarUsageTest {

  @Test
  void returnWorkCarUsageDetail() {
    // Given
    WorkCarUsage workCarUsage = new WorkCarUsage();
    String expectedDetail = CarUsageUtils.WORK_CAR_DETAIL;
    String expectedDrawing = DrawUtils.drawWorkCar();

    // When
    String result = workCarUsage.use();

    // Then
    assertThat(result).contains(expectedDetail)
        .contains(expectedDrawing);
  }
}
