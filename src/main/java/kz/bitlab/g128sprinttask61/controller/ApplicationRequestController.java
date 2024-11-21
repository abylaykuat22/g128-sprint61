package kz.bitlab.g128sprinttask61.controller;

import java.util.List;
import kz.bitlab.g128sprinttask61.entity.ApplicationRequest;
import kz.bitlab.g128sprinttask61.entity.Course;
import kz.bitlab.g128sprinttask61.service.ApplicationRequestService;
import kz.bitlab.g128sprinttask61.service.CourseService;
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
  @Autowired
  private CourseService courseService;

  @GetMapping("/")
  public String homePage(Model model) {
    List<ApplicationRequest> requests = applicationRequestService.findAll();
    model.addAttribute("requests", requests);
    return "home";
  }

  @GetMapping("/application-request")
  public String applicationRequestCreatePage(Model model) {
    List<Course> courses = courseService.findAll();
    model.addAttribute("kursy", courses);
    return "application-request";
  }

  @PostMapping("/application-request/create")
  public String applicationRequestCreate(ApplicationRequest applicationRequest) {
    applicationRequestService.create(applicationRequest);
    return "redirect:/";
  }

  @GetMapping("/application-request/search")
  public String applicationRequestSearch(Model model, @RequestParam String text) {
    List<ApplicationRequest> requests = applicationRequestService.search(text);
    model.addAttribute("requests", requests);
    return "home";
  }
}
