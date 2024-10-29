package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class acikPozisyonlarPage extends basePage {
    @FindBy(css = ".form-check .form-check-label")
    public List<WebElement> filtersText;

    @FindBy(css = "#filterOpenPositions .subHead .size-xs4")
    public List<WebElement> openPositionsUnitText;

    @FindBy(css = ".checkbox-count")
    public WebElement checboxCount;

    @FindBy(css = "#filterOpenPositions div.workBox > h3.size-xs4")
    public List<WebElement> openPositionsHeaders;

    @FindBy(id = "search")
    public WebElement searchBox;
}
