import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class AmazonPurchaseTest {
    public static void main(String[] args) {
        // Configurar el ChromeDriver
        System.setProperty("webdriver.chrome.driver",
                "C:/chromedriver.exe");
        // Crear una instancia del navegador
        WebDriver driver = new ChromeDriver();
        try {
            // Abrir Swag Labs
            driver.get("https://www.saucedemo.com/");
            // Maximizar la ventana
            driver.manage().window().maximize();
            // Ingresar usuario y password
            WebElement login_user =
                    driver.findElement(By.id("user-name"));
                    login_user.sendKeys("standard_user");
            WebElement pass_user =
                    driver.findElement(By.id("password"));
                    pass_user.sendKeys("secret_sauce");
            WebElement btn_login =
                    driver.findElement(By.id("login-button"));
            btn_login.submit();
            // Seleccionar el primer producto
            WebElement firstProduct =
                    driver.findElement(By.id("item_5_title_link"));
            firstProduct.click();
            // Añadir al carrito
            WebElement addToCartButton =
                    driver.findElement(By.name("add-to-cart"));
            addToCartButton.click();
            System.out.println("Añadio primer producto");
            // Validar que el producto está en el carrito
            WebElement cart =
                    driver.findElement(By.id("shopping_cart_container"));
            cart.click();
            System.out.println("Se despliega el carrito correctamente");
            WebElement cartItem1 =
                    driver.findElement(By.id("item_5_title_link"));
                    cartItem1.isDisplayed();
            // Eliminar producto del carrito
            WebElement removeItem =
                    driver.findElement(By.id("remove-sauce-labs-fleece-jacket"));
            removeItem.click();
            System.out.println("Se elimino el producto 1 del carrito");
            // Validar que pueda continuar comprando
            WebElement continueShopping =
                    driver.findElement(By.id("continue-shopping"));
            continueShopping.click();
            System.out.println("Regresamos a ver todos los productos");
            // Validar catalogo ordenar productos
            WebElement sortProduct =
                    driver.findElement(By.className("product_sort_container"));
            sortProduct.click();
            System.out.println("Se despliega el filtro");
            WebElement sortProductoption =
                    driver.findElement(By.cssSelector("option[value='hilo']"));
            sortProductoption.click();
            System.out.println("Se ordenan los productos por precio mayor a menor");
            // Validar añadir otro producto al carrito
            WebElement secondItem =
                    driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
            secondItem.click();
            System.out.println("Añadio segundo producto");
            //validar segundo producto en el carrito
            WebElement cart1 =
                    driver.findElement(By.id("shopping_cart_container"));
            cart1.click();
            WebElement cartItem =
                    driver.findElement(By.id("item_1_title_link"));
            if (cartItem.isDisplayed()) {
                System.out.println("El producto 2 se muestra en el carrito de compras.");
            } else {
                System.out.println("El producto 2 no está en el carrito.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar el navegador
            driver.quit();
        }
    }
}