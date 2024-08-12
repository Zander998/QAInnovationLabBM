package com.nttdata.page;

import org.openqa.selenium.By;

public class CompraPage {
    public static By totalExclTax = By.cssSelector(".total_excl_tax");
    public static By totalInclTax = By.cssSelector(".total_incl_tax");  
    public static By taxValue = By.cssSelector(".tax-value");  
    public static By finalizarCompraButton = By.cssSelector("a[href='//qalab.bensg.com/store/es/carrito?action=show']");  
    public static By cartTitle = By.cssSelector(".cart-title");
}
