package zen.login;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import zen.ability.NavigateTo;
import zen.task.Login;
import zen.ui.LoginGreyPage;

import static net.serenitybdd.screenplay.GivenWhenThen.andThat;
import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.GivenWhenThen.then;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static org.hamcrest.Matchers.containsString;

@RunWith(SerenityRunner.class)
public class LoginPageTest {

    @Managed
    private WebDriver hisBrowser;

    private Actor khoa = Actor.named("khoa");

    @Test
    public void loginSuccess() {
        givenThat(khoa).can(BrowseTheWeb.with(hisBrowser));
        andThat(khoa).wasAbleTo(NavigateTo.page(LoginGreyPage.class));
        when(khoa).attemptsTo(Login.as(System.getProperty("user.name"), System.getProperty("user.password")));
        then(khoa).should(seeThat(TheWebPage.title(), containsString("dashboard")));
    }
}
