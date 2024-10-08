package com.ppalma.carusage.decorator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.ppalma.carusage.strategy.CarUsage;
import com.ppalma.carusage.utils.CarUsageUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FirearmsCarFeatureTest {

  @InjectMocks
  FirearmsCarFeature firearmsCarFeature;

  @Mock
  CarUsage mockCarUsage;

  @Test
  void useFirearmsFeature() {
    // Given
    when(this.mockCarUsage.use()).thenReturn(CarUsageUtils.SECRET_AGENT_CAR_DETAIL);

    // When
    String result = this.firearmsCarFeature.use();

    // Then
    assertThat(result).contains(CarUsageUtils.SECRET_AGENT_CAR_DETAIL)
        .contains(CarUsageUtils.FIREARMS_CAR_FEATURE);
  }
}
