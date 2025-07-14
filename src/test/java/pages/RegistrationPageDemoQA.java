package pages;

import pages.components.*;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPageDemoQA {
    public RegistrationPageDemoQA openPage(String page){
        open(page);
        executeJavaScript("$('footer').remove()");
        return this;
    }
    public RegistrationPageDemoQA setFirstName(String value){
        $("#firstName").setValue(value);
        return this;
    }
    public RegistrationPageDemoQA setLastName(String value){
        $("#lastName").setValue(value);
        return this;
    }
    public RegistrationPageDemoQA setUserEmail(String value){
        $("#userEmail").setValue(value);
        return this;
    }
    public RegistrationPageDemoQA setGender(String value){
        $("#genterWrapper").$(byText(value)).click();
        return this;
    }
    public RegistrationPageDemoQA setPhone(String value){
        $("#userNumber").setValue(value);
        return this;
    }
    public RegistrationPageDemoQA setDate(String year, String month, String day){
        CalendarComponent calendar = new CalendarComponent();
        $("#dateOfBirthInput").click();
        calendar.setDate(year,month,day);
        return this;
    }
    public RegistrationPageDemoQA addSubject(String value){
        $("#subjectsInput").setValue(value).pressEnter();
        return this;
    }
    public RegistrationPageDemoQA addHobbies(String value){
        $("#hobbiesWrapper").$(byText(value)).click();
        return this;
    }
    public RegistrationPageDemoQA uploadFile(String fileName){
        $("#uploadPicture").uploadFromClasspath(fileName);
        return this;
    }
    public RegistrationPageDemoQA setCurrentAddress(String value){
        //actions().scrollToElement($("#currentAddress")).perform();
        $("#currentAddress").scrollIntoView(true).setValue(value);
        return this;
    }
    public RegistrationPageDemoQA setState(String value){
        //actions().scrollToElement($("#state")).perform();
        //$("#state").click();
        $("#state").scrollIntoView(true).click();
        $("#stateCity-wrapper").$(byText(value)).click();
        return this;
    }
    public RegistrationPageDemoQA setCity(String value){
        //actions().moveToElement($("#city")).perform();
        //$("#city").click();
        $("#city").scrollIntoView(true).click();
        $("#stateCity-wrapper").$(byText(value)).click();
        return this;
    }
    public void submitRegistration() {
        $("#submit").scrollIntoView(true).click();
    }
}
