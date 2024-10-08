package com.ppalma.carusage.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.ppalma.carusage.decorator.CamouflageCarFeature;
import com.ppalma.carusage.decorator.FirearmsCarFeature;
import com.ppalma.carusage.strategy.CarUsage;
import com.ppalma.carusage.strategy.OffRoadCarUsage;
import com.ppalma.carusage.strategy.RacingCircuitCarUsage;
import com.ppalma.carusage.strategy.SecretAgentCarUsage;
import com.ppalma.carusage.strategy.WorkCarUsage;
import com.ppalma.carusage.utils.CarUsageUtils;
import java.time.DayOfWeek;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CarUsagesServiceTest {

  @InjectMocks
  private CarUsagesService carUsagesService;

  @Mock
  private CarUsagesFactory carUsagesFactory;

  @Test
  void returnWorkCarWhenDayOfWeekMonday() {
    // Given
    CarUsage mockCarUsage = new WorkCarUsage();
    when(this.carUsagesFactory.createCarUsage(DayOfWeek.MONDAY)).thenReturn(mockCarUsage);

    // When
    String result = this.carUsagesService.getCarByDayOfWeek(DayOfWeek.MONDAY);

    // Then
    assertThat(result).contains(CarUsageUtils.WORK_CAR_DETAIL);
    verify(this.carUsagesFactory, times(1)).createCarUsage(DayOfWeek.MONDAY);
  }

  @Test
  void returnRacingCircuitCarWhenDayOfWeekIsTuesday() {
    // Given
    CarUsage mockCarUsage = new RacingCircuitCarUsage();
    when(this.carUsagesFactory.createCarUsage(DayOfWeek.TUESDAY)).thenReturn(mockCarUsage);

    // When
    String result = this.carUsagesService.getCarByDayOfWeek(DayOfWeek.TUESDAY);

    // Then
    assertThat(result).contains(CarUsageUtils.RACING_CIRCUIT_CAR_DETAIL);
    verify(this.carUsagesFactory, times(1)).createCarUsage(DayOfWeek.TUESDAY);

  }

  @Test
  void returnOffRoadCarWhenDayOfWeekIsWednesday() {
    // Given
    CarUsage mockCarUsage = new OffRoadCarUsage();
    when(this.carUsagesFactory.createCarUsage(DayOfWeek.WEDNESDAY)).thenReturn(mockCarUsage);

    // When
    String result = this.carUsagesService.getCarByDayOfWeek(DayOfWeek.WEDNESDAY);

    // Then
    assertThat(result).contains(CarUsageUtils.OFF_ROAD_CAR_DETAIL);
    verify(this.carUsagesFactory, times(1)).createCarUsage(DayOfWeek.WEDNESDAY);
  }

  @Test
  void returnOffRoadCarWhenDayOfWeekIsThursday() {
    // Given
    CarUsage mockCarUsage = new OffRoadCarUsage();
    when(this.carUsagesFactory.createCarUsage(DayOfWeek.THURSDAY)).thenReturn(mockCarUsage);

    // When
    String result = this.carUsagesService.getCarByDayOfWeek(DayOfWeek.THURSDAY);

    // Then
    assertThat(result).contains(CarUsageUtils.OFF_ROAD_CAR_DETAIL);
    verify(this.carUsagesFactory, times(1)).createCarUsage(DayOfWeek.THURSDAY);
  }

  @Test
  void returnSecretAgentCarWhenDayOfWeekIsFriday() {
    // Given
    CarUsage mockCarUsage = new FirearmsCarFeature(
        new CamouflageCarFeature(new SecretAgentCarUsage()));
    when(this.carUsagesFactory.createCarUsage(DayOfWeek.FRIDAY)).thenReturn(mockCarUsage);

    // When
    String result = this.carUsagesService.getCarByDayOfWeek(DayOfWeek.FRIDAY);

    // Then
    assertThat(result).contains(CarUsageUtils.SECRET_AGENT_CAR_DETAIL)
        .contains(CarUsageUtils.CAMOUFLAGE_CAR_FEATURE)
        .contains(CarUsageUtils.FIREARMS_CAR_FEATURE);
    verify(this.carUsagesFactory, times(1)).createCarUsage(DayOfWeek.FRIDAY);
  }
}
