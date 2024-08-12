package com.nttdata.page;

import org.openqa.selenium.By;

public class StorePage {

    // Localizadores de elementos en la página de inicio de la tienda
    public static By email = By.id("user_email");  // Reemplaza con el ID real
    public static By clave = By.id("user_password");  // Reemplaza con el ID real
    public static By loginBtn = By.id("login_button");  // Reemplaza con el ID real
    public static By logoutButton = By.id("logout_button");  // Reemplaza con el ID real

    // Localizadores adicionales según las necesidades de la prueba
    public static By firstProductThumbnail = By.cssSelector(".product-thumbnail");  // Reemplaza con el selector real
    public static By addToCartButton = By.cssSelector("#add_to_cart");  // Reemplaza con el ID real
    public static By confirmationPopup = By.id("confirmation_popup");  // Reemplaza con el ID real
    public static By confirmationMessage = By.cssSelector(".confirmation-message");  // Reemplaza con el selector real
    public static By subtotalValue = By.cssSelector(".cart-subtotal");  // Reemplaza con el selector real
    public static By totalInclTax = By.cssSelector(".total_incl_tax");  // Reemplaza con el selector real
    public static By totalExclTax = By.cssSelector(".total_excl_tax");  // Reemplaza con el selector real
    public static By taxValue = By.cssSelector(".tax-value");  // Reemplaza con el selector real

    // Otros elementos específicos de la página que podrían ser necesarios
    public static By clothesLink = By.cssSelector("a[href*='clothes']");  // Reemplaza con el selector real
    public static By categoryMenuContainer = By.id("category-menu");  // Reemplaza con el ID real
    public static By menLink = By.cssSelector("a[href*='men']");  // Reemplaza con el selector real
    public static By finalizarCompraButton = By.id("checkout_button");  // Reemplaza con el ID real
    public static By cartTitle = By.cssSelector(".cart-title");  // Reemplaza con el selector real
}
