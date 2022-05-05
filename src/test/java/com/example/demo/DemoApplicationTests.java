package com.example.demo;

import com.example.demo.BLL.UserFactory;
import com.example.demo.BLL.UserType;
import com.example.demo.Model.Admin;
import com.example.demo.Model.Reader;
import com.example.demo.Model.User;
import com.example.demo.Repos.BookRepository;
import com.example.demo.Service.IAdminService;
import com.example.demo.Service.IBookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        UserFactory userFactory = UserFactory.getInstance();
        try {
            User basicUser = userFactory.createUser(UserType.READER, "Jane", "Doe", "abcd", "janedoe@email.com", "abcnfaoef", "0712345678");
            User expectedResult = new Reader("abcd", "Jane", "Doe", "janedoe@email.com", "abcnfaoef", "0712345678");
            User falseResult1 = new Reader("1234", "John", "Doe", "janedoe@email.com", "abcnfaoef", "0712345678");

            User falseResult2 = new Admin("abcd", "Jane", "Doe", "janedoe@email.com");

            Assertions.assertEquals(basicUser, expectedResult);
            Assertions.assertNotEquals(basicUser, falseResult1);
            Assertions.assertNotEquals(basicUser, falseResult2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private IAdminService adminService;

    @Test
    void checkUserRepo(){
        UserFactory userFactory = UserFactory.getInstance();
        try {
            User admin = userFactory.createUser(UserType.ADMIN, "John", "Doe", "abcd", "john.doe@email.com", "", "");
            User falseResult = userFactory.createUser(UserType.READER, "John", "Doe", "abcd", "john.doe@email.com", "", "");
            Admin result = adminService.saveAdmin((Admin) admin);
            ((Admin) admin).setId(result.getId());

            Assertions.assertEquals(admin, result);
            Assertions.assertNotEquals(result, falseResult);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
