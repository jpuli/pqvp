package com.qualapps.ka.controller;

import com.qualapps.ka.data.UserProfileData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
  @GetMapping("/home")
  public String home(HttpSession session, ModelMap modelMap) {
    UserProfileData user = (UserProfileData) session.getAttribute("user");
    modelMap.put("user", user);
    return "home";
  }
}
