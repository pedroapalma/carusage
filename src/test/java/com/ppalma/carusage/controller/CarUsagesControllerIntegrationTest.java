package com.ppalma.carusage.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ppalma.carusage.service.CarUsagesFactory;
import com.ppalma.carusage.service.CarUsagesService;
import com.ppalma.carusage.utils.CarUsageUtils;
import java.time.DayOfWeek;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class CarUsagesControllerIntegrationTest {

  public static final String CAR_USAGE_URI = "/car-usage/%s";

  @SpyBean
  private CarUsagesService carUsagesService;

  @SpyBean
  private CarUsagesFactory carUsagesFactory;

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void returnOkAndWorkCarWhenDayOfWeekMonday() throws Exception {
    this.mockMvc.perform(get(String.format(CAR_USAGE_URI, DayOfWeek.MONDAY))
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(CarUsageUtils.WORK_CAR_DETAIL)));
  }

  @Test
  public void returnOkAndRacingCircuitCarWhenDayOfWeekTuesday() throws Exception {
    this.mockMvc.perform(get(String.format(CAR_USAGE_URI, DayOfWeek.TUESDAY))
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(CarUsageUtils.RACING_CIRCUIT_CAR_DETAIL)));
  }

  @Test
  public void returnOkAndOffRoadCarWhenDayOfWeekWednesday() throws Exception {
    this.mockMvc.perform(get(String.format(CAR_USAGE_URI, DayOfWeek.WEDNESDAY))
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(CarUsageUtils.OFF_ROAD_CAR_DETAIL)));
  }

  @Test
  public void returnOkAndOffRoadCarWhenDayOfWeekThursday() throws Exception {
    this.mockMvc.perform(get(String.format(CAR_USAGE_URI, DayOfWeek.THURSDAY))
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(CarUsageUtils.OFF_ROAD_CAR_DETAIL)));
  }

  @Test
  public void returnOkAndSecretAgentCarWhenDayOfWeekFriday() throws Exception {
    this.mockMvc.perform(get(String.format(CAR_USAGE_URI, DayOfWeek.FRIDAY))
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(CarUsageUtils.SECRET_AGENT_CAR_DETAIL)));
  }

  @Test
  void returnServiceUnavailableWhenDayIsSaturday() throws Exception {
    this.mockMvc.perform(get(String.format(CAR_USAGE_URI, DayOfWeek.SATURDAY))
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isServiceUnavailable());
  }

  @Test
  void returnBadRequestWhenInputIsNotValid() throws Exception {
    this.mockMvc.perform(get(String.format(CAR_USAGE_URI, "WrongDayOfWeek"))
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest());
  }


}