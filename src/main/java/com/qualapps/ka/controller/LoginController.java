package com.qualapps.ka.controller;

import com.qualapps.ka.common.PqvpException;
import com.qualapps.ka.common.Utils;
import com.qualapps.ka.data.UserProfileData;
import com.qualapps.ka.display.User;
import com.qualapps.ka.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {
  private final UserProfileService service;
  private Utils utils = new Utils();

  @Autowired
  public LoginController(UserProfileService service) { this.service = service; }

  @GetMapping("/")
  public String index(Model model, HttpSession session, @RequestParam("selectUserError") boolean selectUserError) {
    Object user = session.getAttribute("user");
    if (user != null && user instanceof User) {
      return "redirect:home";
    } else {
      model.addAttribute("users", getListAllUsers());
      model.addAttribute("selectUserError", selectUserError);
      return "index";
    }
  }

  @GetMapping("/logout")
  public String logout(Model model, HttpSession session) {
    session.removeAttribute("user");
    model.addAttribute("users", getListAllUsers());
    model.addAttribute("logout", true);
    return "index";
  }

  @PostMapping("/login")
  public String login(HttpSession session, @RequestParam(name = "username", required = false) String userName) {
    try {
      UserProfileData userProfileData = service.getUserByName(userName);
      User user = new User();
      user.setName(userProfileData.getUsrName());
      user.setId(userProfileData.getUsrProfileId());
      user.setRole(userProfileData.getUsrRole());
      session.setAttribute("user", user);
      return "redirect:home";
    } catch (PqvpException e) {
      e.printStackTrace();
      return "redirect:/?selectUserError=true";
    }
  }

  private List<User> getListAllUsers() {
    List<User> users = new ArrayList<>();
    try {
      List<UserProfileData> userProfiles = service.getAllUsers();
      for(UserProfileData userProfileData : userProfiles) {
        User user = new User();
        user.setName(userProfileData.getUsrName());
        user.setId(userProfileData.getUsrProfileId());
        user.setRole(userProfileData.getUsrRole());
        users.add(user);
      }
    } catch (PqvpException e) {
      e.printStackTrace();
    }
    return users;
  }
}
