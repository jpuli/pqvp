package com.qualapps.pqvp;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
  @GetMapping("/")
  public String index(Model model, @RequestParam(value="name", required=false, defaultValue="John Appleseed") String name) {
    model.addAttribute("name", name);
    String[] userNames = new String[]{"JohnAppleseed", "JanePublic"};
    model.addAttribute("userNames", userNames);
    return "index";
  }

  @PostMapping("/login")
  public String login(Model model, HttpSession session, @RequestParam("userName") String userName) {
    model.addAttribute("userName", userName);
    session.setAttribute("userName", userName);
    return "redirect:home";
  }
}
