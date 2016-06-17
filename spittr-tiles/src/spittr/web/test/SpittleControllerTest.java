package spittr.web.test;

import static org.hamcrest.Matchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import spittr.Spittle;
import spittr.data.SpittleRepository;
import spittr.web.SpittleController;

public class SpittleControllerTest {

    @Test
    public void shouldShowRecentSpittles() throws Exception {
	List<Spittle> expectedSpittles = createSpittleList(50);
	SpittleRepository mockRep = mock(SpittleRepository.class);

	when(mockRep.findSpittles(238900, 50)).thenReturn(expectedSpittles);

	SpittleController ctlr = new SpittleController(mockRep);

	MockMvc mockMvc = standaloneSetup(ctlr).setSingleView(new InternalResourceView("WEB-INF/views/spittles.jsp"))
		.build();

	mockMvc.perform(get("/spittles?max=238900&count=50")).andExpect(view().name("spittles"))
		.andExpect(model().attributeExists("spittleList"))
		.andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));

    }

    @Test
    public void testSpittle() throws Exception {
	Spittle expectedSpittle = new Spittle("Hello", new Date());
	SpittleRepository mockRep = mock(SpittleRepository.class);
	when(mockRep.findOne(12345)).thenReturn(expectedSpittle);

	SpittleController ctlr = new SpittleController(mockRep);
	MockMvc mockMvc = standaloneSetup(ctlr).build();

	mockMvc.perform(get("/spittles/12345")).andExpect(view().name("spittle"))
		.andExpect(model().attributeExists("spittle")).andExpect(model().attribute("spittle", expectedSpittle));
    }

    private List<Spittle> createSpittleList(int count) {
	List<Spittle> spittles = new ArrayList<Spittle>();
	for (int i = 0; i < count; i++) {
	    spittles.add(new Spittle("Spittle " + i, new Date()));
	}
	return spittles;
    }
}
