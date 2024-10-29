package Utilities;

import org.openqa.selenium.*;


public class Util {

    public static void sleep(int second) {
        try {
            Thread.sleep(second * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
        Util.sleep(1);
    }

    public static void clickWithJS(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) Driver.get();
        executor.executeScript("arguments[0].click();", element);
    }

    public static String getPageSource() {
        return Driver.get().getPageSource();
    }
}


