package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Action {
    public static WebDriver driver;

    WebDriverWait wait = new WebDriverWait(WebdriverFactory.getDriver(), 30, 2500);

    public Action() {
        //System.out.println("ACTION");
        driver = WebdriverFactory.getDriver();
        driver.manage().window().setSize(new Dimension(2560, 1440));
        //driver.manage().window().maximize();
    }

    public enum Direction {
        XPATH,
        ID,
        CSS,
        CLASSNAME,
        LINKTEXT,
        ACCESSBILITYID
    }

    public By byDirection(Direction dir, String element) {
        By by = null;
        switch (dir) {
            case XPATH:
                by = By.xpath(element);
                break;
            case ID:
                by = By.id(element);
                break;
            case CSS:
                by = By.cssSelector(element);
                break;
            case CLASSNAME:
                by = By.className(element);
                break;
            case LINKTEXT:
                by = By.linkText(element);
        }
        return by;
    }

    public void getWindowHandle() {
        // Get window handles
        String originalTab = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(originalTab)) {
                driver.switchTo().window(tab);
                break;
            }
        }
    }

    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public void waitElementDisplayed(Direction dir, String elementBy) throws Exception {
        try {
            implicitWait();
            WebDriverWait wait = new WebDriverWait(driver, 30, 5000);
            wait.until(ExpectedConditions.presenceOfElementLocated(byDirection(dir, elementBy))).isDisplayed();
        } catch (Exception e) {
            throw new Exception("Element " + elementBy + " is cannot displayed in page");
        }
    }

    public boolean verifyTextElement(String text) {
        try {
            implicitWait();
            return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'" + text + "')]")))).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getText(Direction dir, String elementBy) throws Exception {
        waitElementDisplayed(Direction.XPATH, elementBy);
        String value = driver.findElement(byDirection(dir, elementBy)).getText();
        return value;
    }

    public void clickByText(String text) throws Exception {
        driver.findElement(By.xpath("//*[contains(text(),'" + text + "')]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'" + text + "')]"))).click();
    }

    public void click(Direction dir, String elementBy) throws Exception {
        waitElementDisplayed(Direction.XPATH, elementBy);
        driver.findElement(byDirection(dir, elementBy)).click();
    }

    public void enter(Direction dir, String elementBy) throws Exception {
        waitElementDisplayed(Direction.XPATH, elementBy);
        driver.findElement(byDirection(dir, elementBy)).sendKeys(Keys.ENTER);
    }

    public void sendText(Direction dir, String elementBy, String text) throws Exception {
        waitElementDisplayed(Direction.XPATH, elementBy);
        driver.findElement(byDirection(dir, elementBy)).sendKeys(text);
    }

    public boolean loadingState() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(@alt, 'animated-super-logo')]")));
        return true;
    }

    public boolean dataIdAndChildText(String dataId, String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("" + dataId + "//*[(text()=\"" + text + "\")]"))).isDisplayed();
        return true;
    }

    public boolean classAndChildText(String classname, String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("" + classname + "//*[(text()=\"" + text + "\")]"))).isDisplayed();
        return true;
    }

    public boolean classAndContainsChildText(String classname, String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("" + classname + "//*[contains(text(),\"" + text + "\")]"))).isDisplayed();
        return true;
    }

    public boolean classHaveText(String classname, String text) {
        driver.findElement(By.xpath("//*[@class=\"" + classname + "\" and text()=\"" + text + "\"]")).isDisplayed();
        return true;
    }

    public boolean dataIdHaveText(String dataId, String text) {
        driver.findElement(By.xpath("//*[@data-id=\"" + dataId + "\" and text()=\"" + text + "\"]")).isDisplayed();
        return true;
    }

    public boolean dataIdClassHaveText(String dataId, String classname, String text) {
        driver.findElement(By.xpath("//*[@data-id='" + dataId + "']//*[@class='" + classname + "' and text()='" + text + "']")).isDisplayed();
        return true;
    }

    public boolean dataIdContainClass(String flag, String dataId, String classname) {
        if (flag.equals("able")) {
            driver.findElement(By.xpath("" + dataId + "//*[contains(@class, '" + classname + "')]")).isDisplayed();
        } else if (flag.equals("unable")) {
            driver.findElement(By.xpath("" + dataId + "//*[not(contains(@class, '" + classname + "'))]")).isDisplayed();
        } else {
            driver.findElement(By.xpath("//*[@data-id=\"" + dataId + "\" and not(.//*[contains(@class, '" + classname + "')])]")).isDisplayed();
        }
        return true;
    }

    public boolean idOrClassChildText(String element, String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("" + element + "//*[(text()=\"" + text + "\")]"))).isDisplayed();
        return true;
    }

    public boolean verifyTextNotDisplayed(String text) {
        WebDriverWait w = new WebDriverWait(WebdriverFactory.getDriver(), 0, 0);

        try {
            w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"" + text + "\"]"))).isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isDisabled(String dataid) {
        try {
            driver.findElement(By.xpath("//*[contains(@data-id, '" + dataid + "') and @disabled]")).isDisplayed();
        } catch (NoSuchElementException err) {
            driver.findElement(By.xpath("//*[contains(@id, '" + dataid + "') and @disabled]")).isDisplayed();
        }
        return true;
    }

    public boolean classDisplayed(String classname) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class=\"" + classname + "\"]")));
        return true;
    }

    public boolean classNotDisplayed(String classname) {
        WebDriverWait w = new WebDriverWait(WebdriverFactory.getDriver(), 0, 0);

        try {
            w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"" + classname + "\"]"))).isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean elementDisplayed(String element) {
        WebDriverWait w = new WebDriverWait(WebdriverFactory.getDriver(), 0, 0);

        try {
            w.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element))).isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean elementContainText(String element, String text) {
        WebDriverWait w = new WebDriverWait(WebdriverFactory.getDriver(), 0, 0);

        try {
            //System.out.println(element+"//*[text()=\""+text+"\"]");
            w.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element + "//*[text()=\"" + text + "\"]"))).isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean elementContainClassHaveText(String element, String text) {
        WebDriverWait w = new WebDriverWait(WebdriverFactory.getDriver(), 0, 0);

        try {
            w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class, \"" + element + "\") and text()=\"" + text + "\"]"))).isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String formattedDate(String a) {
        String inputDateTime = a;

        SimpleDateFormat inputFormat = new SimpleDateFormat("E MMM dd yyyy HH:mm:ss 'GMT'Z (zzzz)");

        String outputTime = null;
        try {
            Date date = inputFormat.parse(inputDateTime);
            SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm:ss");
            outputTime = outputFormat.format(date);

            System.out.println("Converted time: " + outputTime);
        } catch (ParseException e) {
            System.err.println("Error parsing date and time: " + e.getMessage());
        }

        return outputTime;
    }

    public String splitNumberSpecChar(String value) {
        String[] splitPrice1 = value.split("\\$");
        String[] splitPrice2 = splitPrice1[1].split("\\.");
        return splitPrice2[0] + splitPrice2[1];
    }

    public String splitPriceTotal(String value) {
        String[] splitPrice1 = value.split("Total\\: \\$");
        String[] splitPrice2 = splitPrice1[1].split("\\.");
        return splitPrice2[0] + splitPrice2[1];
    }

    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
}
