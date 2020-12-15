package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ComprasTest {
    @Test
    public void testComprarDoces () {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\SimoneTorresdeSousaN\\Downloads\\chromedriver\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        navegador.get("https://shopcart-challenge.4all.com/");
        navegador.manage().window().maximize();

        navegador.findElement((By.id("open-categories-btn"))).click();
        navegador.findElement(By.id("category-1")).click();
        navegador.findElement(By.id("add-product-4-btn")).click();
        navegador.findElement(By.id("add-product-5-btn")).click();
        navegador.findElement(By.id("open-categories-btn")).click();
        navegador.findElement(By.id("category-all")).click();
        navegador.findElement(By.id("cart-products-qtd")).click();
        for(int i = 1; i <= 3; ++i) {
            navegador.findElement(By.id("add-product-4-qtd")).click();
        };
        navegador.findElement(By.id("finish-checkout-button")).click();
        String pedido = navegador.findElement(By.xpath("//div/h2[@class='sc-dNLxif jyncPa']")).getText();
        assertEquals("Pedido realizado com sucesso!",pedido);
        navegador.findElement(By.xpath("//button[text()='Fechar']")).click();
        navegador.quit();

    }
    @Test
    public void testComprarBebidas () {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\SimoneTorresdeSousaN\\Downloads\\chromedriver\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        navegador.get("https://shopcart-challenge.4all.com/");
        navegador.manage().window().maximize();

        navegador.findElement((By.id("open-categories-btn"))).click();
        navegador.findElement(By.id("category-0")).click();
        navegador.findElement(By.id("add-product-0-btn")).click();
        navegador.findElement(By.id("add-product-1-btn")).click();
        WebDriverWait wait = new WebDriverWait(navegador, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-product-2-btn"))).click();
        navegador.findElement(By.id("open-categories-btn")).click();
        navegador.findElement(By.id("category-all")).click();
        navegador.findElement(By.id("add-product-3-btn")).click();
        navegador.findElement(By.id("cart-products-qtd")).click();
        for(int i = 1; i <= 8; ++i) {
            navegador.findElement(By.id("add-product-3-qtd")).click();
        };
        for(int i = 1; i <= 4; ++i) {
            navegador.findElement(By.id("remove-product-3-qtd")).click();
        };
        WebElement quantidade = navegador.findElement(By.id("subtotal-price"));
        String valor = quantidade.getText();
        assertEquals("R$ 36,00",valor);
        navegador.findElement(By.id("finish-checkout-button")).click();
        String pedido = navegador.findElement(By.xpath("//div/h2[@class='sc-dNLxif jyncPa']")).getText();
        assertEquals("Pedido realizado com sucesso!",pedido);
        navegador.findElement(By.xpath("//button[text()='Fechar']")).click();
        navegador.quit();

    }
}
