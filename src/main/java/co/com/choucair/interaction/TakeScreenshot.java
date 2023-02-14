package co.com.choucair.interaction;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class TakeScreenshot implements Interaction {

    public static TakeScreenshot asEvidence() {
        return Tasks.instrumented(TakeScreenshot.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Serenity.takeScreenshot();
    }
}
