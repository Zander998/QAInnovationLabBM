package com.nttdata.steps;

import com.nttdata.page.CompraPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchWindowException;
import org.junit.jupiter.api.Assertions;
import com.nttdata.page.StorePage;

import java.time.Duration;

public class CompraActions {
    private WebDriver driver;

    public CompraActions(WebDriver driver) {
        this.driver = driver;
    }

    private String limpiarTexto(String texto) {
        return texto.replaceAll("[^\\p{Print}]", "").replaceAll("\\s+", " ").trim();
    }

    public void validarPreciosFinales() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        try {
            WebElement totalExclTaxElement = wait.until(ExpectedConditions.visibilityOfElementLocated(CompraPage.totalExclTax));
            String totalExclTaxText = limpiarTexto(totalExclTaxElement.getText()).replace("S/&nbsp;", "S/ ").trim();
            Assertions.assertEquals("S/ 38.24", totalExclTaxText, "Error en el total (excl. impuestos)");

            WebElement totalInclTaxElement = wait.until(ExpectedConditions.visibilityOfElementLocated(CompraPage.totalInclTax));
            String totalInclTaxText = limpiarTexto(totalInclTaxElement.getText()).replace("S/&nbsp;", "S/ ").trim();
            Assertions.assertEquals("S/ 38.24", totalInclTaxText, "Error en el total (incl. impuestos)");

            WebElement taxElement = wait.until(ExpectedConditions.visibilityOfElementLocated(CompraPage.taxValue));
            String taxText = limpiarTexto(taxElement.getText()).replace("S/&nbsp;", "S/ ").trim();
            Assertions.assertEquals("S/ 0.00", taxText, "Error en los impuestos");

        } catch (Exception e) {
            System.out.println("Se ha producido un error al validar los precios finales: " + e.getMessage());
        }
    }

    public void validarTituloCarrito() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            WebElement cartTitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(CompraPage.cartTitle));
            String cartTitleText = limpiarTexto(cartTitleElement.getText());
            Assertions.assertEquals("CARRITO", cartTitleText, "Error en el título del carrito");

        } catch (NoSuchWindowException e) {
            System.out.println("Error: La ventana del navegador se ha cerrado.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Se ha producido un error al validar el título del carrito: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void finalizarCompra() {

        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;        
            js.executeScript("document.querySelector('.modal .close').click();");
            driver.findElement(CompraPage.finalizarCompraButton).click();
            System.out.println("Se hizo clic en el botón de finalizar compra.");
        } catch (Exception e) {
            System.out.println("Se ha producido un error al intentar finalizar la compra: " + e.getMessage());
        }
    }
}
