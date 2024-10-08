package com.ppalma.carusage.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.ppalma.carusage.decorator.FirearmsCarFeature;
import com.ppalma.carusage.strategy.CarUsage;
import com.ppalma.carusage.strategy.OffRoadCarUsage;
import com.ppalma.carusage.strategy.RacingCircuitCarUsage;
import com.ppalma.carusage.strategy.WorkCarUsage;
import java.time.DayOfWeek;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarUsagesFactoryTest {

  private CarUsagesFactory carUsagesFactory;

  @BeforeEach
  void setUp() {
    this.carUsagesFactory = new CarUsagesFactory();
  }

  @Test
  void createCarUsageWhenDayOfWeekIsMonday() {
    CarUsage carUsage = this.carUsagesFactory.createCarUsage(DayOfWeek.MONDAY);

    assertThat(carUsage).isInstanceOf(WorkCarUsage.class);
  }

  @Test
  void createCarUsageWhenDayOfWeekIsTuesday() {
    // When
    CarUsage carUsage = this.carUsagesFactory.createCarUsage(DayOfWeek.TUESDAY);

    // Then
    assertThat(carUsage).isInstanceOf(RacingCircuitCarUsage.class);
  }

  @Test
  void createCarUsageWhenDayOfWeekIsWednesday() {
    // When
    CarUsage carUsage = this.carUsagesFactory.createCarUsage(DayOfWeek.WEDNESDAY);

    // Then
    assertThat(carUsage).isInstanceOf(OffRoadCarUsage.class);
  }

  @Test
  void createCarUsageWhenDayOfWeekIsThursday() {
    // When
    CarUsage carUsage = this.carUsagesFactory.createCarUsage(DayOfWeek.THURSDAY);

    // Then
    assertThat(carUsage).isInstanceOf(OffRoadCarUsage.class);
  }

  @Test
  void createCarUsageWhenDayOfWeekIsFriday() {
    // When
    CarUsage carUsage = this.carUsagesFactory.createCarUsage(DayOfWeek.FRIDAY);

    // Then
    assertThat(carUsage).isInstanceOf(FirearmsCarFeature.class);
  }

  @Test
  void createCarUsageWhenDayOfWeekIsUnsupportedDay() {
    // When & Then
    assertThatThrownBy(() -> this.carUsagesFactory.createCarUsage(DayOfWeek.SATURDAY))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("The car for the day SATURDAY has not yet been implemented");
  }
}
