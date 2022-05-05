package com.example.demo.BLL;

import com.example.demo.BLL.Validators.MaterialsValidators.ISBNValidator;
import com.example.demo.BLL.Validators.UserValidators.EmailValidator;
import com.example.demo.BLL.Validators.UserValidators.TelephoneValidator;
import com.example.demo.BLL.Validators.Validator;
import com.example.demo.Model.Admin;
import com.example.demo.Model.Reader;
import com.example.demo.Model.User;


/**
 * The type User factory.
 */

//@Singleton
public class UserFactory {
    private static final UserFactory userFactory = new UserFactory();
    public static UserFactory getInstance(){
        return userFactory;
    }

    private UserFactory(){}

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
     * @throws Exception - usertype not existing
     */
    public User createUser(UserType userType, String firstName, String lastName, String password, String email, String address, String telephone) throws Exception {
        switch(userType){
            case READER:
                Validator emailValidator = EmailValidator.getInstance();
                Validator telephoneValidator = TelephoneValidator.getInstance();

                emailValidator.validate(email);
                telephoneValidator.validate(telephone);
                return new Reader(email, password, firstName, lastName, address, telephone);

            case ADMIN:
                return new Admin(email, password, firstName, lastName);
        }

        throw new Exception("User Type not found");
    }
}
