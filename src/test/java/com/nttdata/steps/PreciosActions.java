package com.nttdata.steps;

import com.nttdata.page.CarritoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.nttdata.page.StorePage;
import org.junit.jupiter.api.Assertions;


import java.time.Duration;

public class PreciosActions {
    private WebDriver driver;

    public PreciosActions(WebDriver driver) {
        this.driver = driver;
    }

    private String limpiarTexto(String texto) {
        return texto.replaceAll("[^\\p{Print}]", "").replaceAll("\\s+", " ").trim();
    }

    public void validarPreciosEnPopup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement confirmationPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(CarritoPage.confirmationPopup));
            WebElement totalInclTaxElement = wait.until(ExpectedConditions.visibilityOfElementLocated(CarritoPage.totalInclTax));
            String totalInclTaxText = limpiarTexto(totalInclTaxElement.getText()).replace("S/&nbsp;", "S/ ").trim();
            Assertions.assertEquals("S/ 38.24", totalInclTaxText, "Error en el total (incl. impuestos)");

            WebElement subtotalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(CarritoPage.subtotalValue));
            String subtotalText = limpiarTexto(subtotalElement.getText()).replace("S/&nbsp;", "S/ ").trim();
            Assertions.assertEquals("S/ 38.24", subtotalText, "Error en el subtotal");

            WebElement taxElement = wait.until(ExpectedConditions.visibilityOfElementLocated(CarritoPage.taxValue));
            String taxText = limpiarTexto(taxElement.getText()).replace("S/&nbsp;", "S/ ").trim();
            Assertions.assertEquals("S/ 0.00", taxText, "Error en los impuestos");

        } catch (Exception e) {
            System.out.println("Se ha producido un error al validar los precios en el popup: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
