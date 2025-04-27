package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.*;

public class RegistrationPageDemoQATest extends RegistrationPageDemoQA {
    @BeforeAll
    static void setupConfiguration(){
        Configuration.pageLoadStrategy= "eager";
        Configuration.baseUrl="https://demoqa.com";
        Configuration.browserSize="1920x1080";
    }
    @Test
    void successfulSearchTestAllFields() {
        RegistrationPageDemoQA registrationPage = new RegistrationPageDemoQA();
        SubmitRegistrationFormDemoQA submitPage = new SubmitRegistrationFormDemoQA();

        registrationPage.openPage("/automation-practice-form")
                .setFirstName("AnasTasiiA")
                .setLastName("LadyZhets")
                .setUserEmail("myteatemail@qwert.com")
                .setGender("Female")
                .setPhone("1234567890")
                .setDate("2000","February","13")

                .addSubject("English")
                .addSubject("Social Studies")
                .addSubject("Computer Science")

                .addHobbies("Sports")
                .addHobbies("Reading")

                .uploadFile("HaroldPain.png")

                .setCurrentAddress("stree Rasmus 123 building 10")
                .setState("Uttar Pradesh")
                .setCity("Lucknow")

                .submitRegistration();

        submitPage.checkHeader("Thanks for submitting the form")
                .checkName("AnasTasiiA LadyZhets")
                .checkEmail("myteatemail@qwert.com")
                .checkGender("Female")
                .checkPhone("1234567890")
                .checkDate("13 February,2000")
                .checkSubjects("English, Social Studies, Computer Science")
                .checkHobbies("Sports, Reading")
                .checkUploadedFile("HaroldPain.png")
                .checkAddress("stree Rasmus 123 building 10")
                .checkLocation("Uttar Pradesh Lucknow");
    }

    @Test
    void successfulSearchTestRequiredFieldsOnly() {
        RegistrationPageDemoQA registrationPage = new RegistrationPageDemoQA();
        SubmitRegistrationFormDemoQA submitPage = new SubmitRegistrationFormDemoQA();

        registrationPage.openPage("/automation-practice-form")
                .setFirstName("AnasTasiiA")
                .setLastName("LadyZhets")
                .setGender("Female")
                .setPhone("1234567890")

                .submitRegistration();

        submitPage.checkHeader("Thanks for submitting the form")
                .checkName("AnasTasiiA LadyZhets")
                .checkGender("Female")
                .checkPhone("1234567890")
                .checkEmail("")
                .checkDate("")
                .checkSubjects("")
                .checkHobbies("")
                .checkUploadedFile("")
                .checkAddress("")
                .checkLocation("");
    }

    @Test
    void unsuccessfulSearchRequiredFieldsEmpty() {
        RegistrationPageDemoQA registrationPage = new RegistrationPageDemoQA();
        SubmitRegistrationFormDemoQA submitPage = new SubmitRegistrationFormDemoQA();

        registrationPage.openPage("/automation-practice-form")
                .setUserEmail("myteatemail@qwert.com")
                .setDate("2000","February","13")

                .addSubject("English")
                .addSubject("Social Studies")
                .addSubject("Computer Science")

                .addHobbies("Sports")
                .addHobbies("Reading")

                .uploadFile("HaroldPain.png")

                .setCurrentAddress("stree Rasmus 123 building 10")
                .setState("Uttar Pradesh")
                .setCity("Lucknow")

                .submitRegistration();

        submitPage.checkHeader("");
    }

}
