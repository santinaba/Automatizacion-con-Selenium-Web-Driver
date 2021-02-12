package com.example.service;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalculadoraTestSelenium {

    // Resultados
    private WebDriver driver;
    String result = "/html/body/form/h1[2]/p";
    WebElement Suma;
    WebElement Resta;
    WebElement Multiplicacion;
    WebElement Division;
    WebElement Limpiar;
    WebElement Fibonacci;
    WebElement Factorial;
    WebElement Raiz;
    WebElement Potencia;

    // Ingreso de los datos
    public WebElement x;
    public WebElement y;
    public WebElement z;

    public WebElement elem(By locator) {
        // Retorna el elemento sin importar el tipo de localizador
        return driver.findElement(locator);
    }

    public void x() {
        // Asignamos a y lo limpiamos
        x = elem(By.name("a"));
        x.clear();
    }

    public void y() {
        // Asignamos b y lo limpiamos
        y = elem(By.name("b"));
        y.clear();
    }

    public void z() {
        // Asignamos c y lo limpiamos
        z = elem(By.name("c"));
        z.clear();
    }

    public WebDriver driver() {
        // Generea el driver de conexion
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }

    public void fixPage() {
        // Hace los ajustes de la pagina
        driver.manage().window().maximize();
        driver.navigate().to("http://localhost:8080/calculadora");
    }

    public void writeSimple(WebElement textA, WebElement textB, String a, String b) {
        // Escribe en la calculadora simple
        textA.sendKeys(a);
        textB.sendKeys(b);
    }

    public void writeAdvance(WebElement textWebElement, String textSend) {
        // Escribe en la calculadora avanzada
        textWebElement.sendKeys(textSend);
    }

    public String returnResult() {
        return driver.findElement(By.xpath(result)).getText();
    }

    public void mySleep() {
        // Tiempo de espera
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void setUp() {
        driver();
        fixPage();
    }

    @After
    public void tearDow() {
        driver.close();
    }

    @Test
    public void testSuma() {
        // Suma
        x();
        y();
        Suma = elem(By.cssSelector("input[value='+']"));
        writeSimple(x, y, "7", "3");
        Suma.click();
        mySleep();
        assertTrue(returnResult().contains("Resultado: 10"));
    }

    @Test
    public void testResta() {
        // Resta
        x();
        y();
        Resta = elem(By.cssSelector("input[value='-']"));
        writeSimple(x, y, "19", "13");
        Resta.click();
        mySleep();
        assertTrue(returnResult().contains("Resultado: 6"));
    }

    @Test
    public void testMultiplicacion() {
        // Multiplicacion
        x();
        y();
        Multiplicacion = elem(By.cssSelector("input[value='*']"));
        writeSimple(x, y, "4", "3");
        Multiplicacion.click();
        mySleep();
        assertTrue(returnResult().contains("Resultado: 12"));
    }

    @Test
    public void testDivision() {
        // Division
        x();
        y();
        Division = elem(By.cssSelector("input[value='/']"));
        writeSimple(x, y, "25", "5");
        Division.click();
        mySleep();
        assertTrue(returnResult().contains("Resultado: 5.0"));
    }

    @Test
    public void testLimpiar() {
        // Limpiar
        Limpiar = elem(By.cssSelector("input[value='C']"));
        Limpiar.click();
        mySleep();
        assertTrue(returnResult().contains("Resultado: 0"));
    }

    @Test
    public void testFibonacci() {
        // Fibonacci
        z();
        Fibonacci = elem(By.cssSelector("input[value='fib']"));
        writeAdvance(z, "9");
        Fibonacci.click();
        mySleep();
        assertTrue(returnResult().contains("Resultado: 34"));
    }

    @Test
    public void testFactorial() {
        // Factorial
        z();
        Factorial = elem(By.cssSelector("input[value='!']"));
        writeAdvance(z, "7");
        Factorial.click();
        mySleep();
        assertTrue(returnResult().contains("Resultado: 5040"));
    }

    @Test
    public void testRaiz() {
        // Raiz 
        z();
        Raiz = elem(By.name("sqrt"));
        writeAdvance(z, "100");
        Raiz.click();
        mySleep();
        assertTrue(returnResult().contains("Resultado: 10.0"));
    }

    @Test
    public void testPotencia() {
        // Potencia
        z();
        Potencia = elem(By.name("power"));
        writeAdvance(z, "10");
        Potencia.click();
        mySleep();
        assertTrue(returnResult().contains("Resultado: 100"));
    }
}
