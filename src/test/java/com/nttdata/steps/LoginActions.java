package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.nttdata.page.StorePage;

import java.time.Duration;

public class LoginActions {
    private WebDriver driver;

    public LoginActions(WebDriver driver) {
        this.driver = driver;
    }

    public void ingresarUsuario(String email) {
        WebElement userInputElement = driver.findElement(LoginPage.email);
        userInputElement.sendKeys(email);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.loginBtn));
    }

    public void ingresarClave(String clave) {
        driver.findElement(LoginPage.clave).sendKeys(clave);
    }

    public void iniciarSesion() {
        driver.findElement(LoginPage.loginBtn).click();
    }
}
