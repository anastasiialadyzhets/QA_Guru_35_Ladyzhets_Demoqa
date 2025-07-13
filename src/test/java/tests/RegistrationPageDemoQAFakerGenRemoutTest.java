package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPageDemoQA;
import pages.components.SubmitRegistrationTableComponent;
import utils.TestDataRegistrationPage;

public class RegistrationPageDemoQAFakerGenRemoutTest {
    @BeforeAll
    static void setupConfiguration(){
        Configuration.pageLoadStrategy= "eager";
        Configuration.baseUrl="https://demoqa.com";
        Configuration.browserSize="1920x1080";
    }
    @Test
    @Tag("demoqa")
    @Tag("demoqa-positive")
    void successfulSearchTestAllFields() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        TestDataRegistrationPage testData = new TestDataRegistrationPage();
        RegistrationPageDemoQA registrationPage = new RegistrationPageDemoQA();
        SubmitRegistrationTableComponent submitPage = new SubmitRegistrationTableComponent();

        registrationPage.openPage("/automation-practice-form")
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.userEmail)
                .setGender(testData.userGender)
                .setPhone(testData.userPhone)
                .setDate(testData.dateBirth[0],testData.dateBirth[1],testData.dateBirth[2])
                .addSubject(testData.subjects)
                .addHobbies(testData.hobbies)
                .uploadFile(testData.attachedfile)
                .setCurrentAddress(testData.streetAddress)
                .setState(testData.userState)
                .setCity(testData.userCity)

                .submitRegistration();

        submitPage.checkHeader("Thanks for submitting the form")
                .checkTableResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkTableResult("Student Email", testData.userEmail)
                .checkTableResult("Gender",testData.userGender)
                .checkTableResult("Mobile",testData.userPhone)
                .checkTableResult("Date of Birth",testData.dateBirth[2]+" "+testData.dateBirth[1]+","+testData.dateBirth[0])//"13 February,2000")
                .checkTableResult("Subjects", testData.subjects)
                .checkTableResult("Hobbies", testData.hobbies)
                .checkTableResult("Picture", testData.attachedfile)
                .checkTableResult("Address",testData.streetAddress)
                .checkTableResult("State and City",testData.userState + " " + testData.userCity);
    }

    @Test
    @Tag("demoqa")
    @Tag("demoqa-positive")
    void successfulSearchTestRequiredFieldsOnly() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        TestDataRegistrationPage testData = new TestDataRegistrationPage();
        RegistrationPageDemoQA registrationPage = new RegistrationPageDemoQA();
        SubmitRegistrationTableComponent submitPage = new SubmitRegistrationTableComponent();

        registrationPage.openPage("/automation-practice-form")
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.userGender)
                .setPhone(testData.userPhone)
                .submitRegistration();

        submitPage.checkHeader("Thanks for submitting the form")
                .checkTableResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkTableResult("Gender",testData.userGender)
                .checkTableResult("Mobile",testData.userPhone)
                .checkTableResult("Student Email","")
                .checkTableResult("Date of Birth","")
                .checkTableResult("Subjects","")
                .checkTableResult("Hobbies","")
                .checkTableResult("Picture","")
                .checkTableResult("Address","")
                .checkTableResult("State and City","");
    }

    @Test
    @Tag("demoqa")
    @Tag("demoqa-negative")
    void unsuccessfulSearchRequiredFieldsEmpty() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        TestDataRegistrationPage testData = new TestDataRegistrationPage();
        RegistrationPageDemoQA registrationPage = new RegistrationPageDemoQA();
        SubmitRegistrationTableComponent submitPage = new SubmitRegistrationTableComponent();

        registrationPage.openPage("/automation-practice-form")
                .setUserEmail(testData.userEmail)
                .setDate(testData.dateBirth[0],testData.dateBirth[1],testData.dateBirth[2])
                .addSubject(testData.subjects)
                .addHobbies(testData.hobbies)
                .uploadFile(testData.attachedfile)
                .setCurrentAddress(testData.streetAddress)
                .setState(testData.userState)
                .setCity(testData.userCity)
                .submitRegistration();

        submitPage.checkHeader("");
    }

}
