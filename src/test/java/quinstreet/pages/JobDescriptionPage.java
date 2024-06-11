package quinstreet.pages;

import com.codeborne.selenide.SelenideElement;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class JobDescriptionPage {
    private SelenideElement firstName = $("#first_name");
    private SelenideElement lastName = $("#last_name");
    private SelenideElement email = $("#email");
    private SelenideElement phone = $("#phone");
    private SelenideElement location = $("#auto_complete_input");
    private SelenideElement resume = $("button[data-source='attach']");
    private SelenideElement coverLetter = $("#cover_letter_chosen");
    private SelenideElement linkedInProfile = $("#job_application_answers_attributes_0_text_value");
    private SelenideElement website = $("#job_application_answers_attributes_1_text_value");
    private SelenideElement referral = $("#job_application_answers_attributes_2_text_value");
    private SelenideElement authorizedToWork = $("#s2id_job_application_answers_attributes_3_boolean_value");
    private SelenideElement visaSponsorship = $("#s2id_job_application_answers_attributes_4_boolean_value");
    private SelenideElement salaryExpectation = $("#job_application_answers_attributes_5_text_value");
    private SelenideElement submitButton = $("#submit_app");

    public void typeFirstName(String name) {
        firstName.setValue(name);
    }

    public void typeLastName(String name) {
        lastName.setValue(name);
    }

    public void typeEmail(String emailAddress) {
        email.setValue(emailAddress);
    }

    public void typePhoneNumber (String number) {
        phone.setValue(number);
    }

    public void typeLocation(String city) {
        location.setValue(city);
        SelenideElement autocomplete = $("#location_autocomplete-items-popup");
        autocomplete.$$("li").findBy(text(city)).click();

    }

    public void typeLinkedInProfile (String linkedIn) {
        linkedInProfile.setValue(linkedIn);
    }

    public void typeWebsite(String site) {
        website.setValue(site);
    }

    public void typeReferral(String jobReferral) {
        referral.setValue(jobReferral);
    }

    public void selectWorkAuthorization(String option) {
        authorizedToWork.shouldBe(visible);
        authorizedToWork.click();
        $$("#select2List0").findBy(text(option)).click();
    }

    public void selectVisaSponsorship(String option) {
        visaSponsorship.shouldBe(visible);
        visaSponsorship.click();
        $("#job_application_answers_attributes_4_boolean_value").selectOption(option);
    }

    public void typeSalaryExpectation(String expectation) {
        salaryExpectation.setValue(expectation);
    }

    public void submit() {
        submitButton.click();
    }

    public void attachResume(File filePath) throws ScriptException {
        resume.click();
        SelenideElement fileInput = $("input[type='file']");
        fileInput.should(exist);
        fileInput.uploadFile(filePath);
    }

    public void attachCoverLatter(File filePath) {
        coverLetter.click();
        SelenideElement fileInput = $("input[type='file']");
        fileInput.should(exist);
        fileInput.uploadFile(filePath);
    }
}
