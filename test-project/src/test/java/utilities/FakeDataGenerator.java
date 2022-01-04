package utilities;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.company.CompanyProperties;
import io.codearte.jfairy.producer.person.PersonProperties;
import org.joda.time.LocalDate;

import java.text.DateFormatSymbols;

public class FakeDataGenerator {
    private final Fairy fairy;
    private LocalDate localDate;
    private String day;
    private String month;
    private String year;

    public FakeDataGenerator() {
        fairy = Fairy.create();
    }

    public String getFullName() {
        return fairy.person(PersonProperties.male()).getFullName();
    }

    public String getFemaleFirstName() {
        return fairy.person(PersonProperties.female()).getFirstName();
    }

    public String getPassword() {
        return fairy.person(PersonProperties.withUsername("Ahmed")).getPassword();
    }

    public String getMaleFirstName() {
        return fairy.person(PersonProperties.male()).getFirstName();
    }

    public String getMaleLastName() {
        return fairy.person(PersonProperties.male()).getLastName();
    }

    public String getRandomNumber() {
        return fairy.person(PersonProperties.female()).getNationalIdentityCardNumber();
    }

    public String getAge() {
        return String.valueOf(fairy.person(PersonProperties.minAge(14)).getAge());
    }

    public String getCityFemalePerson() {
        return fairy.person(PersonProperties.female()).getAddress().getCity();
    }

    public String getCityMalePerson(){
        return fairy.person(PersonProperties.male()).getAddress().getCity();
    }

    public String getEmail(){
        return fairy.person().getEmail();
    }

    public String getPhone(){
        return fairy.person().getTelephoneNumber();
    }

    public String getAddress(){
        return fairy.person().getAddress().getAddressLine1();
    }

    public String getCompany() {
        return fairy.person(PersonProperties.withUsername("Ahmed")).getCompany().getName();
    }

    public String getRandomMessage() {
        return fairy.textProducer().sentence();
    }

    public void generateLocalDate() {
        localDate = fairy.person(PersonProperties.withAge(30)).getDateOfBirth().toLocalDate();
        day = String.valueOf(localDate.getDayOfMonth());
        month = getMonthName(localDate.getMonthOfYear());
        year = String.valueOf(localDate.getYear());
    }

    private String getMonthName(int monthNumber) {
        String month = "January";
        DateFormatSymbols monthnames = new DateFormatSymbols();
        String[] months = monthnames.getMonths();
        if (monthNumber >=0 && monthNumber <=11) {
            month = months[monthNumber];
        }
        return month;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }
}
