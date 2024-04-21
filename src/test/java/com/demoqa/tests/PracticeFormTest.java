package com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.PracticeFormPage;
import com.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTest extends TestBase {

    @BeforeMethod

    public void precondition() {
        new HomePage(driver).getForms();
        new SidePanel(driver).selectPracticeForm();
    }

    @Test
    public void createStudentAccountTest() {
// to hide ads and footer
        new PracticeFormPage(driver).hideIframes();
        //enter personal data
        new PracticeFormPage(driver).enterPersonalData("John", "Travolta", "john_tra@gmail.com", "123654987789")
                // select gender (radio button)
                .selectGender("Male")
                // enter birthday
                .enterBirthDay("16 August 1987")
                // enter subject
                .enterSubject(new String[]{"Maths", "Chemistry"})
                // select hobby(checkbox)
                .selectHobby(new String[]{"Sports", "Reading"})
                // download file
                .uploadFile("C:/tools/cat.jpeg")
                // select state
                .selectState("NCR")
                // select city
                .selectCity("Delhi")
                // save
                // click on submit button
                .clickOnSubmit()
                // assert student form appears,
                .verifySuccessTitle("Thanks for submitting the form");
    }
}
