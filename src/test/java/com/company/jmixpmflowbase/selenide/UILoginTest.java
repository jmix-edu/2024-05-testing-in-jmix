package com.company.jmixpmflowbase.selenide;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.company.jmixpmflowbase.test_support.selenidePages.SelenideLoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.editable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class UILoginTest {

    @Test
    public void test_username_field() {
        Selenide.open("http://localhost:8080/");
        SelenideElement usernameField = $(By.name("username"));
        usernameField.shouldBe(visible);
        usernameField.shouldBe(editable);

        Assertions.assertEquals("admin", usernameField.getAttribute("value"));
    }

    @Test
    public void test_password_field(){
        Selenide.open("http://localhost:8080/");
        SelenideElement passwordField = $(By.name("password"));
        passwordField.shouldBe(visible);
        passwordField.shouldBe(editable);

        Assertions.assertEquals("password", passwordField.getAttribute("type"));
    }

    @Test
    public void testLoginPage() {
        SelenideLoginPage loginPage = new SelenideLoginPage();

        loginPage.open();
        sleep(1000);
        loginPage.enterUsername("admin");
        loginPage.enterPassword("admin");
        sleep(1000);
        loginPage.clickLoginBtn();
    }
}
