package utils;

import com.github.javafaker.Faker;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class TestDataRegistrationPage {
    Faker faker = new Faker(new Locale("en-GB"));
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmail = faker.internet().emailAddress();
    public String streetAddress = faker.address().streetAddress();
    public String userPhone = faker.numerify("##########");
    public String userGender = faker.options().option("Male","Female","Other");
    public String[] dateBirth = getRandomBirthDate();
    public String subjects = faker.options().option("Hindi","English","Maths","Physics", "Chemistry","Biology","Computer Science","Commerce",
            "Accounting","Economics","Arts","Social Studies","History","Civics");
    public String hobbies = faker.options().option("Sports", "Reading","Music");
    public String attachedfile = faker.options().option("HaroldPain.png");
    public String userState =faker.options().option("NCR","Uttar Pradesh","Haryana","Rajasthan");
    public String userCity =getCityByState(userState);

    private String[] getRandomBirthDate(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy MMMM dd").withLocale(Locale.ENGLISH);
        Instant instant = faker.date().birthday().toInstant();
        LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        return dateTimeFormatter.format(localDate).split(" ");
    }
    private String getCityByState(String state){
        switch (state){
            case "NCR":
                return faker.options().option("Delhi","Gurgaon Pradesh","Noida");
            case "Uttar Pradesh":
                return faker.options().option("Agra","Lucknow","Merrut");
            case "Haryana":
                return faker.options().option("Karnal","Panipat");
            case "Rajasthan":
                return faker.options().option("Jaipur","Jaiselmer");
        }
        return "";
    }
}
