package org.fabricaescuela.stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.fabricaescuela.interactions.*;
import org.fabricaescuela.questions.SimulationResultIsCompleted;
import org.fabricaescuela.tasks.EnterBirthDate;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoanSimulationStepDefinitions {
    @Managed(driver = "chrome")
    private WebDriver driver;
    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Santiago");
    }
    @Given("^I am on the Bancolombia website$")
    public void iAmOnTheBancolombiaWebsite() {
        theActorInTheSpotlight().wasAbleTo(Open.url("https://www.bancolombia.com/personas"));
    }


    @When("^I click on \"([^\"]*)\" button under the title \"([^\"]*)\"$")
    public void iClickOnSaberMasButtonUnderTheTitle(String arg1, String arg2) {
        theActorInTheSpotlight().attemptsTo(ClickSaberMasBtn.makeInformation());
    }

        @And("^I select the \"([^\"]*)\" option in the Creditos de Consumo page$")
    public void iSelectTheSimularOptionInTheCreditosConsumoPage(String arg1) {
        theActorInTheSpotlight().attemptsTo(SelectSimularInCreditosConsumo.makeInformation());
    }

    @And("^I select \"([^\"]*)\"$")
    public void iSelectContinuarSimulation(String arg1) {
        theActorInTheSpotlight().attemptsTo(ContinueSimulation.makeInformation());
    }

    @And("^I select \"([^\"]*)\" for the question \"([^\"]*)\"$")
    public void iSelectSiForTheQuestion(String arg1, String arg2) {
        theActorInTheSpotlight().attemptsTo(SelectSiOption.makeInformation());
    }

    @And("^I enter a loan amount between (\\d+)'(\\d+)\\.(\\d+) and (\\d+)\\.(\\d+)\\.(\\d+)$")
    public void iEnterALoanAmountBetweenAnd(int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
        theActorInTheSpotlight().attemptsTo(EnterLoanAmount.makeInformation());
    }

    @And("^I enter a random number of months between (\\d+) and (\\d+)$")
    public void iEnterARandomNumberOfMonthsBetweenAnd(int arg1, int arg2) {
        theActorInTheSpotlight().attemptsTo(EnterMonthsNumber.makeInformation());
    }

    @And("^I enter a random birth date$")
    public void iEnterARandomBirthDate() {
        theActorInTheSpotlight().attemptsTo(EnterBirthDate.makeInformation());
    }

    @And("^I click on \"([^\"]*)\"$")
    public void iClickOnSimular(String arg1) {
        theActorInTheSpotlight().attemptsTo(SelectSimularInSimulation.makeInformation());
    }

    @Then("^I should see the estimated monthly payment$")
    public void iShouldSeeTheEstimatedMonthlyPayment() {
        theActorInTheSpotlight().should(seeThat(SimulationResultIsCompleted.onThePage()));
    }
}
