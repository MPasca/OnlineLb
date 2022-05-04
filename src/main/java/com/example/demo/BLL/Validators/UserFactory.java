package com.example.demo.BLL.Validators;

import com.example.demo.Model.Admin;
import com.example.demo.Model.Reader;
import com.example.demo.Model.User;

/**
 * The type User factory.
 */
public class UserFactory {
    /**
     * Create user user.
     *
     * @param userType  the user type
     * @param firstName the first name
     * @param lastName  the last name
     * @param password  the password
     * @param email     the email
     * @param address   the address
     * @param telephone the telephone
     * @return the user
     * @throws Exception the exception
     */
    public User createUser(UserType userType, String firstName, String lastName, String password, String email, String address, String telephone) throws Exception {
        switch(userType){
            case READER:
                return new Reader(email, password, firstName, lastName, address, telephone);

            case ADMIN:
                return new Admin(email, password, firstName, lastName);
        }

        throw new Exception("User Type not found");
    }
}
