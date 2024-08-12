package com.nttdata.page;

import org.openqa.selenium.By;

public class CarritoPage {
    public static By firstProductThumbnail = By.cssSelector(".product-thumbnail");  // Reemplaza con el selector real
    public static By addToCartButton = By.cssSelector("button.add-to-cart");  // Reemplaza con el ID real
    public static By confirmationPopup = By.id("confirmation_popup");  // Reemplaza con el ID real
    public static By confirmationMessage = By.cssSelector("h4#myModalLabel");  // Reemplaza con el selector real
    public static By subtotalValue = By.cssSelector(".cart-subtotal");  // Reemplaza con el selector real
    public static By totalInclTax = By.cssSelector(".total_incl_tax");  // Reemplaza con el selector real
    public static By totalExclTax = By.cssSelector(".total_excl_tax");  // Reemplaza con el selector real
    public static By taxValue = By.cssSelector(".tax-value");  // Reemplaza con el selector real
}
