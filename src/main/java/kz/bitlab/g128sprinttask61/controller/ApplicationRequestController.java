package kz.bitlab.g128sprinttask61.controller;

import java.util.List;
import kz.bitlab.g128sprinttask61.entity.ApplicationRequest;
import kz.bitlab.g128sprinttask61.service.ApplicationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationRequestController {

  @Autowired
  private ApplicationRequestService applicationRequestService;

  @GetMapping("/")
  public String homePage(Model model) {
    List<ApplicationRequest> requests = applicationRequestService.findAll();
    model.addAttribute("requests", requests);
    return "home";
  }
}
