package com.example.demo.Controllers;

import com.example.demo.BLL.UserFactory;
import com.example.demo.BLL.UserType;
import com.example.demo.Model.Admin;
import com.example.demo.Model.Reader;
import com.example.demo.Model.User;
import com.example.demo.Service.IAdminService;
import com.example.demo.Service.IReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * The type Create controller.
 */
public class CreateController {
    @Autowired
    private IAdminService adminService;

    @Autowired
    private IReaderService readerService;

    /**
     * Create user user.
     *
     * @param type the type
     * @param data the data
     * @return the user
     */
    @PostMapping("/create/{type}")
    public User createUser(@PathVariable("type") String type, @RequestBody String[] data){
        System.out.println(type);
        switch(type){
            case "admin":
                try {
                    Admin newAdmin = (Admin) UserFactory.getInstance().createUser(UserType.ADMIN, data[0], data[1], data[2], data[3], "", "");
                    return newAdmin;

                } catch (Exception e) {
                    e.printStackTrace();
                }
            case "reader":
                try {
                    Reader newReader = (Reader) UserFactory.getInstance().createUser(UserType.READER, data[0], data[1], data[2], data[3], data[4], data[5]);
                    return readerService.saveReader(newReader);
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        return null;
    }
}
