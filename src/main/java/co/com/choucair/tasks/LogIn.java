package co.com.choucair.tasks;

import co.com.choucair.models.DataModel;
import co.com.choucair.ui.LoginUI;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;

public class LogIn implements Task {

    private DataModel dataModel;

    public LogIn(DataModel dataModel) {
        this.dataModel = dataModel;
    }

    public static LogIn fillTheForm(DataModel dataModel) {
        return Tasks.instrumented(LogIn.class, dataModel);
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
        WebDriver driver = getDriver();
        actor.attemptsTo(
                WaitUntil.the(LoginUI.USER_NAME, isVisible()).forNoMoreThan(30).seconds(),
                SendKeys.of(dataModel.getUser()).into(LoginUI.USER_NAME),
                SendKeys.of(dataModel.getPassword()).into(LoginUI.PASSWORD),
                Click.on(LoginUI.LOGIN_BUTTON),
                WaitUntil.the(LoginUI.ADD_BUTTON_2, isVisible()).forNoMoreThan(30).seconds()
        );
        List<WebElement> lisList = driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']"));
        int counted = lisList.size();
        int x = 0;
        for (int i = 0; i <= counted; i++) {
            swipeScreen();
            actor.attemptsTo(
                    Click.on(LoginUI.ADD_BUTTON),
                    Click.on(LoginUI.ADD_BUTTON));
            swipeScreen();
            x+=2;
        }
        actor.attemptsTo(
                Click.on(LoginUI.CART_BUTTON));

    }
}
