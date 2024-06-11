package quinstreet.tests;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import quinstreet.pages.JobDescriptionPage;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class QuinStreetTest extends BaseTest{
    final static String QUIN_STREET_URL = "https://www.quinstreet.com/";
    String firstName = "Daria";
    String lastName = "Ryzhykova";
    String email = "dariella.ryzhykova@gmail.com";
    String phoneNumber = "3125393027";
    String location = "Chicago, Illinois, United States";
    String resume = "src/test/resources/resume/Daria Ryzhykova.pdf";
    String linkedIn = "https://www.linkedin.com/in/dariella-ryzhykova-3794b3139/";
    String webSite = "https://github.com/dariellaryzhykova";
    String referral = "LinkedIn";
    String workAuthorizationOpt = "Yes";
    String visaSponsorshipOpt = "No";
    String salaryExpectation = "80000 - 100000";


    @Test
    @Description("Fill in the job opening: QA Automation Engineer")
    void verifyApplyingForQAAutomationEngineer(){
        JobDescriptionPage jobDescription = new JobDescriptionPage();
        step("Open \'QA Automation Engineer\' opening:", () -> {
            open(QUIN_STREET_URL + "/careers/?__jvst=Job+Board&__jvsd=LinkedIn&gh_jid=6003639");
        });

        step("Fill in the job position", () -> {
            switchTo().frame(0);
            jobDescription.typeFirstName(firstName);
            jobDescription.typeLastName(lastName);
            jobDescription.typeEmail(email);
            jobDescription.typePhoneNumber(phoneNumber);
            jobDescription.typeLocation(location);
            jobDescription.attachResume(new File(resume));
            jobDescription.typeLinkedInProfile(linkedIn);
            jobDescription.typeWebsite(webSite);
            jobDescription.typeReferral(referral);
            jobDescription.selectWorkAuthorization(workAuthorizationOpt);
            jobDescription.selectVisaSponsorship(visaSponsorshipOpt);
            jobDescription.typeSalaryExpectation(salaryExpectation);
        });

        step("Submit Application", () -> {
            //jobDescription.submit();
        });
    }

}
