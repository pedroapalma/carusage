package com.ppalma.carusage.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ppalma.carusage.service.CarUsagesFactory;
import com.ppalma.carusage.service.CarUsagesService;
import java.time.DayOfWeek;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class InternalServerErrorIntegrationTest {

  public static final String CAR_USAGE_URI = "/car-usage/%s";

  @SpyBean
  private CarUsagesService carUsagesService;

  @MockBean
  private CarUsagesFactory carUsagesFactory;

  @Autowired
  private MockMvc mockMvc;

  @Test
  void returnInternalServerErrorWhenFailsCreatingCarUsage() throws Exception {
    when(this.carUsagesFactory.createCarUsage(DayOfWeek.MONDAY)).thenThrow(RuntimeException.class);

    this.mockMvc.perform(get(String.format(CAR_USAGE_URI, DayOfWeek.MONDAY))
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isInternalServerError());
  }


}