package com.qualapps.ka.controller;

import com.qualapps.ka.common.PqvpException;
import com.qualapps.ka.common.Utils;
import com.qualapps.ka.data.UserProfileData;
import com.qualapps.ka.display.User;
import com.qualapps.ka.service.EmailService;
import com.qualapps.ka.service.UserProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {
  private final EmailService emailService;
  private final UserProfileService service;
  private Utils utils = new Utils();

  @Autowired
  public LoginController(UserProfileService service, EmailService emailService) {
    this.service = service;
    this.emailService = emailService;
  }

  @GetMapping("/")
  public String index(Model model, HttpSession session,HttpServletRequest request) {
	  Boolean selectUserError = false;
	  
	  String errorStr = request.getParameter("selectUserError");
	  
	  if(errorStr!=null && errorStr.equalsIgnoreCase("true") )
	  {
		  selectUserError = Boolean.TRUE;
	  }

    model.addAttribute("version", utils.getVersion());
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
    model.addAttribute("version", utils.getVersion());
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
      StringBuilder body = new StringBuilder();
      body.append("New Sign-in to Daas Application By ");
      body.append(user.getName());
      body.append("\nhttp://daas.qualapps.com/");
      emailService.sendTextEmail("qualapps.jira.read@gmail.com","info@qualapps.com", null, "New Sign-in to Daas Application By ["+user.getName()+"]", body.toString());
      return "redirect:home";
    } catch (PqvpException e) {
      e.printStackTrace();
      return "redirect:/?selectUserError=true";
    }
  }
  
  @RequestMapping("/testError")
  public void handleRequest() {
      throw new RuntimeException("test exception");
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
