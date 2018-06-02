package zen.task;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;
import zen.ui.LoginGreyPage;
import zen.ui.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class Login implements Task {

    private LoginPage loginPage;
    private LoginGreyPage loginGreyPage;

    private String email;
    private String password;

    protected Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static Login as(String email, String password) {
        return Instrumented.instanceOf(Login.class).withProperties(email, password);
    }

    @Step("{0} login Gooddata application")
    public <T extends Actor> void performAs(T actor) {
        loginGreyPage.enterEmail(email);
        loginGreyPage.enterPassword(password);
        loginGreyPage.clickSignInButton();
    }
}
