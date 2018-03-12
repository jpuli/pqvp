package com.qualapps.pqvp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
  @RequestMapping("/")
  public String index(Model model, @RequestParam(value="name", required=false, defaultValue="John Appleseed") String name) {
    model.addAttribute("name", name);
    return "index";
  }
}
