package co.com.choucair.tasks;

import co.com.choucair.interaction.TakeScreenshot;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.logging.Logger;

public class OpenUp implements Task {

    public static OpenUp thePage() {
        return Tasks.instrumented(OpenUp.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Logger.getAnonymousLogger().info("App is running");
        actor.attemptsTo(TakeScreenshot.asEvidence());
    }
}
