package com.qualapps.ka.service;

import com.qualapps.ka.common.PqvpException;
import com.qualapps.ka.data.PqvpDao;
import com.qualapps.ka.data.UserProfileData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserProfileService {
    private static final String USER_NOT_FOUND_EXCEPTION = "UserNotFoundException";

    @Autowired
    private PqvpDao pqvpdao;

    /**
     * Service to fetch a user
     * @param userName the User Name
     * @return user
     * @throws PqvpException - USer not found
     */
    public UserProfileData getUserByName(String userName) throws PqvpException{
        UserProfileData usr;
        try {
            usr = pqvpdao.getUserByUserName(userName);
        } catch (Exception e) {
            String[] params = new String[]{"UserName", userName};
            throw new PqvpException(USER_NOT_FOUND_EXCEPTION, params);
        }
        return usr;
    }
}

