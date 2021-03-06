package spittr.web;

import java.io.IOException;

import javax.servlet.http.Part;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import spittr.Spitter;
import spittr.data.SpitterRepository;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

    private SpitterRepository spitterRepository;

    public SpitterController() {

    }

    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
	this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
	model.addAttribute(new Spitter());
	return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(@RequestPart("profilePicture") Part profilePicture, @Valid Spitter spitter,
	    RedirectAttributes model, Errors errors) {
	if (errors.hasErrors()) {
	    return "registerForm";
	}

	spitterRepository.save(spitter);
	model.addAttribute("username", spitter.getUsername());
	//model.addAttribute("spitterId", spitter.getId());
	model.addFlashAttribute("spitter", spitter);
	try {
	    profilePicture.write("/data/spittr/" + profilePicture.getName());
	} catch (IOException ex) {
	    return "error/image";
	}
	return "redirect:/spitter/{username}";
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model) {
	if(!model.containsAttribute("spitter")) {
	    model.addAttribute(spitterRepository.findByUserId(username));
	}
	return "profile";
    }
}
