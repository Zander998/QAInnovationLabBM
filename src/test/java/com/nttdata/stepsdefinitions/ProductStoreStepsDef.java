package com.nttdata.stepsdefinitions;

import com.nttdata.steps.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class ProductStoreStepsDef {
    private WebDriver driver;

    private LoginActions loginActions;
    private CarritoActions carritoActions;
    private RopaActions ropaActions;
    private CompraActions compraActions;
    private PreciosActions preciosActions;

    public ProductStoreStepsDef() {
        this.driver = getDriver();
        this.loginActions = new LoginActions(driver);
        this.carritoActions = new CarritoActions(driver);
        this.ropaActions = new RopaActions(driver);
        this.compraActions = new CompraActions(driver);
        this.preciosActions = new PreciosActions(driver);
    }

    @Given("estoy en la página de la tienda y me logueo con mi usuario {string} y clave {string}")
    public void estoyEnLaPaginaDeLaTiendaYMeLogueoConMiUsuarioYClave(String usuario, String clave) {
        driver.get("https://qalab.bensg.com/store/pe/iniciar-sesion");

        loginActions.ingresarUsuario(usuario);
        loginActions.ingresarClave(clave);
        loginActions.iniciarSesion();
        screenShot();
    }

    @When("navego a la categoría 'Clothes' y subcategoría 'Men'")
    public void navegoALaCategoriaClothesYSubcategoriaMen() {
        ropaActions.navegarACategoriaClothes();
        ropaActions.navegarACategoriaHombres();
        screenShot();
    }

    @And("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int cantidad) {
        carritoActions.seleccionarProducto();
        carritoActions.aumentarCantidad(cantidad - 1);  // Ajusta la cantidad si es necesario
        carritoActions.agregarAlCarrito();
        screenShot();
    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmacionDelProductoAgregado() {
        carritoActions.validarPopupConfirmacion("Producto añadido correctamente a su carrito de compra");
        screenShot();
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        preciosActions.validarPreciosEnPopup();
        screenShot();
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        compraActions.finalizarCompra();
    }

    @Then("valido el título de la página del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        compraActions.validarTituloCarrito();
        screenShot();
    }

    @And("vuelvo a validar el cálculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        compraActions.validarPreciosFinales();
        screenShot();
    }
}
