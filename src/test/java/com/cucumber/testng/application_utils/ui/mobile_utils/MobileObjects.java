package com.cucumber.testng.application_utils.ui.mobile_utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.cucumber.testng.application_utils.ui.UIObjects.sleep;
import static com.cucumber.testng.application_utils.ui.UIObjects.waitForPageToLoad;
import static com.cucumber.testng.page_objects.UIBasePage.getDriver;
import static com.cucumber.testng.utilities.misc_utils.AssertClass.assertFail;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

public class MobileObjects {
    private static int TAP_DURATION = 250;
    private static int DEFAULT_WAIT_SECONDS = 15;

    /***************Basic Action For Native Applications************/

    public static WebElement getElement(By elementLocator) {
        waitForPageToLoad();
        WebDriverWait wait = new WebDriverWait(getDriver(), DEFAULT_WAIT_SECONDS);
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(getDriver().findElement(elementLocator)));
        } catch (StaleElementReferenceException se) {
            sleep(500);
            return getElement(elementLocator);
        } catch (WebDriverException se) {
            return handleUnkownException(elementLocator, se);
        } catch (Exception ex) {
            assertFail("Failure in Element Extraction using " + elementLocator + " - " + ex.getMessage());
            return null;
        }
    }

    public static List<WebElement> getElements(String elementLocator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), DEFAULT_WAIT_SECONDS);
        try {
            return wait.until(ExpectedConditions.visibilityOfAllElements(getDriver().findElementByXPath(elementLocator)));
        } catch (StaleElementReferenceException se) {
            sleep(500);
            return getElements(elementLocator);
        } catch (Exception ex) {
            assertFail("Failure in Element Extraction using " + elementLocator + " - " + ex.getMessage());
            return null;
        }
    }

    public static WebElement handleUnkownException(By elementLocator, WebDriverException se) {
        String error = se.getMessage();
        if (error.contains("Cannot find context with specified id")) {
            return getElement(elementLocator);
        } else {
            assertFail("Failure in Element Extraction using " + elementLocator + " - " + se.getMessage());
            return null;
        }
    }

    public static void input(By elementLocator, String input) {
        getElement(elementLocator).sendKeys(input);
    }

    public static void click(By elementLocator) {
        getElement(elementLocator).click();
    }

    public static void hideKeyboard() {
        getDriver().navigate().back();
    }

    public static void showKeyboard() {
        if (!((AndroidDriver<MobileElement>) getDriver()).isKeyboardShown()) {
            ((AndroidDriver<MobileElement>) getDriver()).getKeyboard();
        }
    }

    protected String getText(By elementLocator) {
        return getElement(elementLocator).getText();
    }

    public static void waitforElementTobevisible(String elementLocator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), DEFAULT_WAIT_SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementLocator)));
    }

    /****************Android UIAutomator functions*****************/

    public static void scrollToText(By elementLocator, String text) {
        click(elementLocator);
        ((AndroidDriver<AndroidElement>) getDriver()).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));");
    }


    /**************Touch Action Methods*****************************/
    //Tap to an element
    public static void tapByElement(String elementLocator) {
        new TouchAction((PerformsTouchActions) getDriver())
                .tap(tapOptions().withElement(element(getDriver().findElementByXPath(elementLocator))))
                .waitAction(waitOptions(Duration.ofMillis(TAP_DURATION))).perform();
    }

    //Tap by coordinates
    public static void tapByCoordinates(int x, int y) {
        new TouchAction((PerformsTouchActions) getDriver())
                .tap(point(x, y))
                .waitAction(waitOptions(Duration.ofMillis(TAP_DURATION))).perform();
    }

    //Press by element
    public static void pressByElement(String elementLocator, long seconds) {
        new TouchAction((PerformsTouchActions) getDriver())
                .press(element(getDriver().findElementByXPath(elementLocator)))
                .waitAction(waitOptions(ofSeconds(seconds)))
                .release()
                .perform();
    }

    //Press by coordinates
    public static void pressByCoordinates(int x, int y, long seconds) {
        new TouchAction((PerformsTouchActions) getDriver())
                .press(point(x, y))
                .waitAction(waitOptions(ofSeconds(seconds)))
                .release()
                .perform();
    }

    public static void dragAndDrop(String elementSource, String elementTarget) {

    }

    //Horizontal Swipe by percentages
    public static void horizontalSwipeByPercentage(double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = getDriver().manage().window().getSize();
        int anchor = (int) (size.height * anchorPercentage);
        int startPoint = (int) (size.width * startPercentage);
        int endPoint = (int) (size.width * endPercentage);

        new TouchAction((PerformsTouchActions) getDriver())
                .press(point(startPoint, anchor))
                .waitAction(waitOptions(ofMillis(TAP_DURATION * 4)))
                .moveTo(point(endPoint, anchor))
                .release().perform();
    }

    //Vertical Swipe by percentages
    public static void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = getDriver().manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);

        new TouchAction((PerformsTouchActions) getDriver())
                .press(point(anchor, startPoint))
                .waitAction(waitOptions(ofMillis(TAP_DURATION * 4)))
                .moveTo(point(anchor, endPoint))
                .release().perform();
    }

    //Swipe by elements
    public static void swipeByElements(String startElementLocator, String endElementLocator) {
        AndroidElement startElement = (AndroidElement) getDriver().findElementByXPath(startElementLocator);
        AndroidElement endElement = (AndroidElement) getDriver().findElementByXPath(endElementLocator);
        int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
        int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);

        int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
        int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);

        new TouchAction((PerformsTouchActions) getDriver())
                .press(point(startX, startY))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(endX, endY))
                .release().perform();
    }

    //Multitouch action by using an android element
    public static void multiTouchByElement(String elementLocator) {
        TouchAction press = new TouchAction((PerformsTouchActions) getDriver())
                .press(element(getDriver().findElementByXPath(elementLocator)))
                .waitAction(waitOptions(ofSeconds(1)))
                .release();

        new MultiTouchAction((PerformsTouchActions) getDriver())
                .add(press)
                .perform();
    }
}
