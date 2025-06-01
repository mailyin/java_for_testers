package ru.stqa.mantis.manager;

import org.openqa.selenium.By;
import ru.stqa.mantis.model.UserData;

public class SessionHelper extends HelperBase {
    public SessionHelper(ApplicationManager manager) {
        super(manager);
    }

    public void login(String user, String password) {
        type(By.name("username"), user);
        click(By.cssSelector("input[type='submit']"));
        type(By.name("password"), password);
        click(By.cssSelector("input[type='submit']"));
    }

    public boolean isLoggedIn() {
        return isElementPresent(By.cssSelector("span.user-info"));
    }

    public void createUser(UserData user) {
        signupNewAccount();
        fillSighupForm(user);
        submitUserCreation();
    }

    public void completionRegistration(UserData user) {
        fillEditAccountForm(user);
        submitEditAccountForm();
    }

    private void submitEditAccountForm() {
        click(By.cssSelector("[type='submit']"));
    }

    private void fillEditAccountForm(UserData user) {
        type(By.name("realname"), user.username());
        type(By.id("password"), user.password());
        type(By.id("password-confirm"), user.password());
    }

    private void submitUserCreation() {
        click(By.cssSelector("[type='submit']"));
    }

    private void signupNewAccount() {
        click(By.linkText("Signup for a new account"));
    }

    private void fillSighupForm(UserData user) {
        type(By.name("username"), user.username());
        type(By.name("email"), user.email());
    }
}
