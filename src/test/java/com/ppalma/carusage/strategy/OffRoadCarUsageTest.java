package com.ppalma.carusage.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import com.ppalma.carusage.utils.CarUsageUtils;
import com.ppalma.carusage.utils.DrawUtils;
import org.junit.jupiter.api.Test;

class OffRoadCarUsageTest {

  @Test
  void returnOffRoadCarUsageDetail() {
    // Given
    OffRoadCarUsage offRoadCarUsage = new OffRoadCarUsage();
    String expectedDetail = CarUsageUtils.OFF_ROAD_CAR_DETAIL;
    String expectedDrawing = DrawUtils.drawOffRoadCar();

    // When
    String result = offRoadCarUsage.use();

    // Then
    assertThat(result).contains(expectedDetail)
        .contains(expectedDrawing);
  }
}
