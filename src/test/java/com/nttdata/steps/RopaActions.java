package com.nttdata.steps;

import com.nttdata.page.ClothesPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.nttdata.page.StorePage;
import java.time.Duration;

public class RopaActions {
    private WebDriver driver;

    public RopaActions(WebDriver driver) {
        this.driver = driver;
    }
    public void  navegarACategoriaClothes(){

        WebElement clothesElement = driver.findElement(ClothesPage.clothesLink);
        clothesElement.click();
    }

    public void navegarACategoriaHombres() {

        WebElement menElement = driver.findElement(ClothesPage.menLink);
        menElement.click();
    }
}
