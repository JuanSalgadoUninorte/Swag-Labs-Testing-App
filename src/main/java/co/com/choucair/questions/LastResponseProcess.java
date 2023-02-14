package co.com.choucair.questions;

import co.com.choucair.models.DataModel;
import co.com.choucair.ui.LoginUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class LastResponseProcess implements Question<Boolean> {

    private DataModel dataModel;

    public LastResponseProcess(DataModel dataModel) {
        this.dataModel = dataModel;
    }

    public static LastResponseProcess finishedProcess(DataModel dataModel) {
        return new LastResponseProcess(dataModel);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String answer = Text.of(LoginUI.CONFIRMATION_MESSAGE).answeredBy(actor).toString();
        return dataModel.getMessage().equals(answer);
    }
}
