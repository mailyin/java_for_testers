package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.CommonFunctions;
import ru.stqa.mantis.model.UserData;

import java.time.Duration;
import java.util.regex.Pattern;

public class UserRegistrationTests extends TestBase {

    @Test
    void canRegisterUser() {
//Содаём ящик Пользователя на почтовом сервере
        var name = CommonFunctions.randomString(8);
        var email = String.format("%s@localhost", name);
        var password = CommonFunctions.randomString(8);
        app.jamesCli().addUser(email, password);
//Регистрируем Пользователя в Mantis
        var user = new UserData()
                .withUsername(name)
                .withEmail(email)
                .withPassword(password);
        app.session().createUser(user);
//Ждём почту и извлекаем ссылку из письма
        var message = app.mail().receive(email, password, Duration.ofSeconds(10));
        var text = message.get(0).content();
        var pattern = Pattern.compile("http://\\S*");
        var matcher = pattern.matcher(text);
        if (matcher.find()) {
            var url = text.substring(matcher.start(), matcher.end());
            System.out.println(url);
//Проходим по ссылке
            app.driver().get(url);
        }
//Завершаем регистрацию
        app.session().completionRegistration(user);
//Проверяем, что созданный Пользователь может залогиниться
        app.http().login(name, password);
    }
}


