package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Web {
    public static WebDriver createChrome() {
        //Abrindo o navegador
        System.setProperty("webdriver.chrome.driver","C:\\Users\\SimoneTorresdeSousaN\\Downloads\\chromedriver\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Navegando para a página de teste
        navegador.get("https://shopcart-challenge.4all.com/");
        navegador.manage().window().maximize();

        return navegador;
    }
}
