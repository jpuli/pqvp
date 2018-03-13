package com.qualapps.ka.controller;

import com.qualapps.ka.common.PqvpException;
import com.qualapps.ka.common.Utils;
import com.qualapps.ka.data.UserProfileData;
import com.qualapps.ka.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
  private final UserProfileService service;
  private Utils utils = new Utils();

  @Autowired
  public LoginController(UserProfileService service) { this.service = service; }

  @GetMapping("/")
  public String index(Model model, @RequestParam(value="name", required=false, defaultValue="John Appleseed") String name) {
    model.addAttribute("name", name);
    String[] userNames = new String[]{"JohnAppleseed", "JanePublic"};
    model.addAttribute("userNames", userNames);
    return "index";
  }

  @PostMapping("/login")
  public String login(HttpSession session, @RequestParam("userName") String userName) {
    try {
      UserProfileData user = service.getUserByName(userName);
      session.setAttribute("user", user);
      return "redirect:home";
    } catch (PqvpException e) {
      e.printStackTrace();
      return "redirect:index";
    }
  }
}
