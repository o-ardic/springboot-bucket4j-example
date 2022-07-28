package com.oardic.springbootbucket4j;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test class for {@link SampleController}.
 *
 * @author Okan ARDIC
 */
@SpringBootTest
@AutoConfigureMockMvc
public class SampleControllerTest {

	@Autowired
	protected MockMvc mockMvc;

	@RepeatedTest(3)
	public void whenGetFirstThenFirstCall200AndThen429(RepetitionInfo repetitionInfo) throws Exception {
		ResultMatcher result = repetitionInfo.getCurrentRepetition() == 1 ? status().isOk() :
			status().isTooManyRequests();
		mockMvc.perform(MockMvcRequestBuilders.get("/first"))
		       .andExpect(result);
	}

	@RepeatedTest(3)
	public void whenGetSecondThenTwoCalls200AndThen429(RepetitionInfo repetitionInfo) throws Exception {
		ResultMatcher result = repetitionInfo.getCurrentRepetition() <= 2 ? status().isOk() :
			status().isTooManyRequests();
		mockMvc.perform(MockMvcRequestBuilders.get("/second"))
		       .andExpect(result);
	}
}
