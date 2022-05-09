package com.example.demo.BLL;

import com.example.demo.BLL.Validators.MaterialsValidators.ISBNValidator;
import com.example.demo.BLL.Validators.UserValidators.EmailValidator;
import com.example.demo.BLL.Validators.UserValidators.TelephoneValidator;
import com.example.demo.BLL.Validators.Validator;
import com.example.demo.Model.Admin;
import com.example.demo.Model.Reader;
import com.example.demo.Model.User;
import com.example.demo.Service.IAdminService;
import com.example.demo.Service.IReaderService;
import org.springframework.beans.factory.annotation.Autowired;


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

    @Autowired
    private IAdminService adminService;

    @Autowired
    private IReaderService readerService;

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
                EmailValidator.getInstance().validate(email);
                TelephoneValidator.getInstance().validate(telephone);


                return readerService.saveReader(new Reader(email, password, firstName, lastName, address, telephone));

            case ADMIN:
                EmailValidator.getInstance().validate(email);

                return adminService.saveAdmin(new Admin(email, password, firstName, lastName));
        }

        throw new Exception("User Type not found");
    }
}
