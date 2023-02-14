package co.com.choucair.stepdefinitions;

import co.com.choucair.models.DataModel;
import co.com.choucair.questions.LastResponseProcess;
import co.com.choucair.tasks.LogIn;
import co.com.choucair.tasks.OpenUp;
import co.com.choucair.tasks.PlaceOrder;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SauceLabsStepDefinitions {

    @Before
    public void setStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("Access to the app")
    public void accessToTheApp() {
        OnStage.theActorCalled("Juan");
        theActorInTheSpotlight().attemptsTo(OpenUp.thePage());
    }

    @When("He logs in into the app")
    public void heLogsInIntoTheApp(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(LogIn.fillTheForm(DataModel.setData(dataTable).get(0)));
    }

    @When("Choses the items and places the info")
    public void chosesTheItemsAndPlacesTheInfo(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(PlaceOrder.chooseAndPlace(DataModel.setData(dataTable).get(0)));
    }

    @Then("He comfirms that the order is already placed")
    public void heComfirmsThatTheOrderIsAlreadyPlaced(DataTable dataTable) {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(LastResponseProcess.finishedProcess(DataModel.setData(dataTable).get(0))));
    }
}
