package com.example.demo;

import com.example.demo.BLL.UserFactory;
import com.example.demo.BLL.UserType;
import com.example.demo.BLL.Validators.UserValidators.EmailValidator;
import com.example.demo.BLL.Validators.UserValidators.TelephoneValidator;
import com.example.demo.BLL.Validators.Validator;
import com.example.demo.Model.Admin;
import com.example.demo.Model.Reader;
import com.example.demo.Model.User;
import com.example.demo.Service.IAdminService;
import com.example.demo.Service.IReaderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
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

    @Test
    void testTelephoneValidator(){
        Validator telephoneValidator = TelephoneValidator.getInstance();

        String correctTelephone1 = "+40786605730";
        String correctTelephone2 = "0733282283";

        String incorrectTelephone1 = "++0733282283";
        String incorrectTelephone2 = "1234567890";
        String incorrectTelephone3 = "07123456789";
        String incorrectTelephone4 = "+073328a2283";

        Assertions.assertTrue(telephoneValidator.validate(correctTelephone1));
        Assertions.assertTrue(telephoneValidator.validate(correctTelephone2));

        Assertions.assertFalse(telephoneValidator.validate(incorrectTelephone1));
        Assertions.assertFalse(telephoneValidator.validate(incorrectTelephone2));
        Assertions.assertFalse(telephoneValidator.validate(incorrectTelephone3));
        Assertions.assertFalse(telephoneValidator.validate(incorrectTelephone4));
    }

    @Test
    void testEmailValidator(){
        Validator emailValidator = new EmailValidator().getInstance();

        String correctEmail1 = "john.doe@email.com";
        String correctEmail2 = "johndoe@email.com";
        String correctEmail3 = "john_doe13@email.com";

        String incorrectEmail1 = "johndoe@em123il.com";
        String incorrectEmail2 = "john@doe@email.com";
        String incorrectEmail3 = "12johndoe@email.com";
        String incorrectEmail4 = "1234@email.com";
        String incorrectEmail5 = "johndoe@email";
        String incorrectEmail6 = "johndoe.com";

        Assertions.assertTrue(emailValidator.validate(correctEmail1));
        Assertions.assertTrue(emailValidator.validate(correctEmail2));
        Assertions.assertTrue(emailValidator.validate(correctEmail3));

        Assertions.assertFalse(emailValidator.validate(incorrectEmail1));
        Assertions.assertFalse(emailValidator.validate(incorrectEmail2));
        Assertions.assertFalse(emailValidator.validate(incorrectEmail3));
        Assertions.assertFalse(emailValidator.validate(incorrectEmail4));
        Assertions.assertFalse(emailValidator.validate(incorrectEmail5));
        Assertions.assertFalse(emailValidator.validate(incorrectEmail6));
    }

    @Mock
    public IAdminService adminServiceMock;

    @Test
    void checkAdminRepo(){
        UserFactory userFactory = UserFactory.getInstance();
        try {
            User admin = userFactory.createUser(UserType.ADMIN, "John", "Doe", "abcd", "john.doe@email.com", "", "");
            User falseResult = userFactory.createUser(UserType.READER, "John", "Doe", "abcd", "john.doe@email.com", "", "");
            Admin result = adminServiceMock.saveAdmin((Admin) admin);
            ((Admin) admin).setId(result.getId());

            Assertions.assertEquals(admin, result);
            Assertions.assertNotEquals(result, falseResult);

            adminServiceMock.deleteAdminById(result.getId());
            Assertions.assertNull(adminServiceMock.findAdminById(result.getId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Mock
    private IReaderService readerServiceMock;

    @Test
    void checkReaderRepo(){
        UserFactory userFactory = UserFactory.getInstance();
        try {
            User reader = userFactory.createUser(UserType.READER, "John", "Doe", "abcd", "john.doe@email.com", "uidna", "+40712345678");
            User falseResult = userFactory.createUser(UserType.ADMIN, "John", "Doe", "abcd", "john.doe@email.com", "", "");
            Reader result = readerServiceMock.saveReader((Reader) reader);
            ((Reader) reader).setId(result.getId());

            Assertions.assertEquals(reader, result);
            Assertions.assertNotEquals(result, falseResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
