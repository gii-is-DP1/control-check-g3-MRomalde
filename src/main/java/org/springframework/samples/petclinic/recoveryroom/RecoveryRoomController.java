package org.springframework.samples.petclinic.recoveryroom;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/recoveryroom")
public class RecoveryRoomController {
    @Autowired
	RecoveryRoomService recoveryRoomService;

@GetMapping("/create")
public String getMethodName(ModelMap modelMap) {
    RecoveryRoom recoveryRoom= new RecoveryRoom();
    modelMap.put("recoveryRoom", recoveryRoom);
    return "redirect:/create";
}
@PostMapping("/new")
	public String newUser(@Valid RecoveryRoom recoveryRoom,BindingResult result, ModelMap model,RedirectAttributes redirect) throws DataAccessException, DuplicatedUserEmailException {
		if(result.hasErrors()) {
			return "redirect:/create";
		} else {
			recoveryRoomService.save(recoveryRoom);
			redirect.addFlashAttribute("message", "Recovery room created");
			return "redirect:/recoveryroom";
		}
	}



}
