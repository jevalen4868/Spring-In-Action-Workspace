package spittr.web.test;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import spittr.data.Spitter;
import spittr.data.SpitterRepository;
import spittr.web.SpitterController;

public class SpitterControllerTest {

    @Test
    public void shouldShowRegistration() throws Exception {
	SpitterController controller = new SpitterController();
	MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	mockMvc.perform(MockMvcRequestBuilders.get("/spitter/register"))
		.andExpect(MockMvcResultMatchers.view().name("registerForm"));
    }

    @Test
    public void shouldProcessRegistration() throws Exception {
	SpitterRepository mockRepository = Mockito.mock(SpitterRepository.class);
	Spitter unsaved = new Spitter("jbauer", "24hours", "Jack", "Bauer");
	Spitter saved = new Spitter(24L, "jbauer", "24hours", "Jack", "Bauer");
	Mockito.when(mockRepository.save(unsaved)).thenReturn(saved);

	SpitterController controller = new SpitterController(mockRepository);
	MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

	mockMvc.perform(MockMvcRequestBuilders.post("/spitter/register").param("username", "jbauer")
		.param("password", "24hours").param("firstName", "Jack").param("lastName", "Bauer"))
		.andExpect(MockMvcResultMatchers.redirectedUrl("/spitter/jbauer"));

	Mockito.verify(mockRepository, Mockito.atLeastOnce()).save(unsaved);
    }
}
