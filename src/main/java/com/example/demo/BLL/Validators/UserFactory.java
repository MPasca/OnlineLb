package com.example.demo.BLL.Validators;

import com.example.demo.Model.Admin;
import com.example.demo.Model.Reader;
import com.example.demo.Model.User;

public class UserFactory {
    public User createUser(UserType userType, String firstName, String lastName, String password, String email, String address, String telephone) throws Exception {
        switch(userType){
            case READER:
                Reader reader = new Reader(password, firstName, lastName, email, address, telephone);

                //reader.setAddress("1st st, no 15");
                //reader.setTelephone("07123456");

                return reader;

            case ADMIN:
                Admin admin = new Admin(password, firstName, lastName, email);
                admin.setFirstName(firstName);
                admin.setLastName(lastName);
                admin.setPassword(password);
                admin.setEmail(email);

                return admin;
        }

        throw new Exception("User Type not found");
    }
}
