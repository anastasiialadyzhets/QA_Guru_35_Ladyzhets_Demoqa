package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.*;
import pages.components.SubmitRegistrationTableComponent;

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
        SubmitRegistrationTableComponent submitPage = new SubmitRegistrationTableComponent();

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
                .checkTableResult("Student Name","AnasTasiiA LadyZhets")
                .checkTableResult("Student Email","myteatemail@qwert.com")
                .checkTableResult("Gender","Female")
                .checkTableResult("Mobile","1234567890")
                .checkTableResult("Date of Birth","13 February,2000")
                .checkTableResult("Subjects","English, Social Studies, Computer Science")
                .checkTableResult("Hobbies","Sports, Reading")
                .checkTableResult("Picture","HaroldPain.png")
                .checkTableResult("Address","stree Rasmus 123 building 10")
                .checkTableResult("State and City","Uttar Pradesh Lucknow");
    }

    @Test
    void successfulSearchTestRequiredFieldsOnly() {
        RegistrationPageDemoQA registrationPage = new RegistrationPageDemoQA();
        SubmitRegistrationTableComponent submitPage = new SubmitRegistrationTableComponent();

        registrationPage.openPage("/automation-practice-form")
                .setFirstName("AnasTasiiA")
                .setLastName("LadyZhets")
                .setGender("Female")
                .setPhone("1234567890")

                .submitRegistration();

        submitPage.checkHeader("Thanks for submitting the form")
                .checkTableResult("Student Name","AnasTasiiA LadyZhets")
                .checkTableResult("Gender","Female")
                .checkTableResult("Mobile","1234567890")
                .checkTableResult("Student Email","")
                .checkTableResult("Date of Birth","")
                .checkTableResult("Subjects","")
                .checkTableResult("Hobbies","")
                .checkTableResult("Picture","")
                .checkTableResult("Address","")
                .checkTableResult("State and City","");
    }

    @Test
    void unsuccessfulSearchRequiredFieldsEmpty() {
        RegistrationPageDemoQA registrationPage = new RegistrationPageDemoQA();
        SubmitRegistrationTableComponent submitPage = new SubmitRegistrationTableComponent();

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
