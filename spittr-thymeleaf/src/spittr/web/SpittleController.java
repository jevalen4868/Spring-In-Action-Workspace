package spittr.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spittr.Spittle;
import spittr.data.SpittleRepository;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private static final String MAX_LONG_AS_STRING = "9223372036854775807";
    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository repository) {
	this.spittleRepository = repository;
    }

    // @RequestMapping(method = RequestMethod.GET)
    // public String spittles(Model model)
    // {
    // model.addAttribute( "spittleList",
    // spittleRepository.findSpittles(Long.MAX_VALUE, 20));
    // return "spittles";
    //
    // }

    /**
     * Value is returned into the model as spittlesList, and view is inferred
     * from the method name.
     * 
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(@RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
	    @RequestParam(value = "count", defaultValue = "20") int count) {
	return spittleRepository.findSpittles(max, count);
    }

    /**
     * Query parameters should NOT BE USED TO IDENTIFY A RESOURCE, GENERAL RULE
     * APPARENTLY. RPC OVER HTTP.
     * 
     * @param spittleId
     * @param model
     * @return
     */
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showSpittle(@RequestParam("spittle_id") long spittleId, Model model) {
	model.addAttribute(spittleRepository.findOne(spittleId));
	return "spittle";
    }

    // @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    // public String spittle(@PathVariable("spittleId") long spittleId, Model
    // model) {
    // model.addAttribute(spittleRepository.findOne(spittleId));
    // return "spittle";
    // }

    // Not needed to add spittleId to PathVariable so long as it matches, be
    // careful though!
    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String spittle(@PathVariable long spittleId, Model model) {
	model.addAttribute(spittleRepository.findOne(spittleId));
	return "spittle";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveSpittle(SpittleForm form, Model model) {
	spittleRepository
		.save(new Spittle(null, form.getMessage(), new Date(), form.getLongitude(), form.getLatitude()));
	return "redirect:/spittles";
    }
    
//    @ExceptionHandler(DuplicateSpittleException.class)
//    public String handleDuplicateSpittle() {
//	return "error/duplicate";
//    }
}
