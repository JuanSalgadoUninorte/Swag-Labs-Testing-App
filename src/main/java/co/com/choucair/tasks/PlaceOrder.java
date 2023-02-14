package co.com.choucair.tasks;

import co.com.choucair.models.DataModel;
import co.com.choucair.ui.LoginUI;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Dimension;

import java.time.Duration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;

public class PlaceOrder implements Task {

    private DataModel dataModel;

    public PlaceOrder(DataModel dataModel) {
        this.dataModel = dataModel;
    }

    public static PlaceOrder chooseAndPlace(DataModel dataModel) {
        return Tasks.instrumented(PlaceOrder.class, dataModel);
    }

    public void swipeScreen() {
        AndroidDriver driver2 = getProxiedDriver();
        Dimension dimension = driver2.manage().window().getSize();
        int startX = (int) (dimension.width * 0.29);
        int startY = (int) (dimension.height * 0.5);
        int endX = (int) (dimension.width * 0.29);
        int endY = (int) (dimension.height * 0.15);
        TouchAction touchAction = new TouchAction(driver2);
        touchAction.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();
    }

    public void swipeForTimes(int k){
        for (int i = 0; i <= k; i++) {
            swipeScreen();
        }
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        swipeForTimes(11);
        actor.attemptsTo(
                WaitUntil.the(LoginUI.CHECKOUT, isVisible()).forNoMoreThan(50).seconds().then(Click.on(LoginUI.CHECKOUT)),
                SendKeys.of(dataModel.getInfoName()).into(LoginUI.FIRST_NAME),
                SendKeys.of(dataModel.getInfoLast()).into(LoginUI.LAST_NAME),
                SendKeys.of(dataModel.getPostal()).into(LoginUI.POSTAL_CODE));
        swipeScreen();
        actor.attemptsTo(
                Click.on(LoginUI.CONTINUE_BUTTON));
        swipeForTimes(11);
        actor.attemptsTo(
                Click.on(LoginUI.FINISH_BUTTON)
        );
    }
}
