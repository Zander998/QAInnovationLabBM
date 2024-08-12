package com.nttdata.steps;

import com.nttdata.page.CarritoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.nttdata.page.StorePage;
import org.openqa.selenium.By;


import java.time.Duration;

public class CarritoActions {
    private WebDriver driver;

    public CarritoActions(WebDriver driver) {
        this.driver = driver;
    }

    public void seleccionarProducto() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productElement = wait.until(ExpectedConditions.elementToBeClickable(CarritoPage.firstProductThumbnail));
        productElement.click();
    }

    public void aumentarCantidad(int veces) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        for (int i = 0; i < veces; i++) {
            WebElement incrementButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".touchspin-up")));
            incrementButton.click();
        }
    }

    public void agregarAlCarrito() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(CarritoPage.addToCartButton));
        addToCartButton.click();
    }

    public void validarPopupConfirmacion(String mensajeEsperado) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(CarritoPage.confirmationMessage));

        String mensajeReal = messageElement.getText().trim();
        String mensajeLimpio = mensajeReal.replaceAll("[^\\p{Print}]", "").trim();
        String mensajeEsperadoLimpio = mensajeEsperado.replaceAll("[^\\p{Print}]", "").trim();

        if (!mensajeLimpio.equals(mensajeEsperadoLimpio)) {
            throw new AssertionError("Mensaje esperado: \"" + mensajeEsperadoLimpio + "\", pero se obtuvo: \"" + mensajeLimpio + "\"");
        }
    }
}
