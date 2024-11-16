package kz.bitlab.g128sprinttask61.controller;

import java.io.Reader;
import java.util.List;
import kz.bitlab.g128sprinttask61.entity.ApplicationRequest;
import kz.bitlab.g128sprinttask61.service.ApplicationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

  @GetMapping("/application-request")
  public String applicationRequestCreatePage() {
    return "application-request";
  }

  @PostMapping("/application-request/create")
  public String applicationRequestCreate(@RequestParam String userName,
      @RequestParam String courseName, @RequestParam String phone,
      @RequestParam String commentary) {
    ApplicationRequest applicationRequest = new ApplicationRequest();
    applicationRequest.setUserName(userName);
    applicationRequest.setCourseName(courseName);
    applicationRequest.setPhone(phone);
    applicationRequest.setCommentary(commentary);
    applicationRequestService.create(applicationRequest);
    return "redirect:/";
  }
}
