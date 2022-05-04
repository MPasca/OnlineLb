package com.example.demo;

import com.example.demo.BLL.Validators.UserFactory;
import com.example.demo.BLL.Validators.UserType;
import com.example.demo.Model.Admin;
import com.example.demo.Model.Reader;
import com.example.demo.Model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        UserFactory userFactory = new UserFactory();
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
}
