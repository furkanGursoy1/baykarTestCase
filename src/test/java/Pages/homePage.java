package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class homePage extends basePage {

    @FindBy(css = ".logo img[src]")
    public WebElement homePageLogo;
    @FindBy(css = ".navbar-nav .nav-item > .nav-link:not(.offcanvas-button .nav-link)")
    public List<WebElement> navbarElements;
    @FindBy(css = ".dropdown-menu.show")
    public WebElement dropDownMenu;
    @FindBy(css = ".dropdown-menu.show .dropdown-item\n")
    public List<WebElement> dropdownItems;

    @FindBy(css = ".offcanvas-button .nav-item .nav-link")
    public WebElement languageButton;
    @FindBy(css = ".openPositions button.btn")
    public WebElement openPositionsButton;

}
