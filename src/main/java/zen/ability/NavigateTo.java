package zen.ability;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;

public class NavigateTo implements Task {

    private Class<? extends PageObject> page;

    protected NavigateTo(Class<? extends PageObject> page) {
        this.page = page;
    }

    public static NavigateTo page(Class<? extends PageObject> page) {
        return Instrumented.instanceOf(NavigateTo.class).withProperties(page);
    }

    @Step("{0} open given page")
    public <T extends Actor> void performAs(T actor) {
        BrowseTheWeb.as(actor).on(page).open();
    }
}
