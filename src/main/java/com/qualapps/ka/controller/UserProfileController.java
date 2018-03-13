package com.qualapps.ka.controller;

import com.qualapps.ka.common.PqvpException;
import com.qualapps.ka.common.PqvpResponse;
import com.qualapps.ka.common.Utils;
import com.qualapps.ka.data.UserProfileData;
import com.qualapps.ka.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * User Profile REST API
 */
@RestController
public class UserProfileController {

    private final UserProfileService svc;
    private Utils utils = new Utils();

    @Autowired
    public UserProfileController(UserProfileService svc) {
        this.svc = svc;
    }

    @RequestMapping(method = GET, path = "/api/users")
    public PqvpResponse getUser(
            @RequestParam String username) {
        PqvpResponse response = new PqvpResponse();
        try {
            UserProfileData usr = svc.getUserByName(username);
            response.setResult(usr);
            response.setError(null);

        } catch (PqvpException e) {
            response.setResult(null);
            response.setError(utils.buildPqvpError(e));
        }
        return response;
    }
}
