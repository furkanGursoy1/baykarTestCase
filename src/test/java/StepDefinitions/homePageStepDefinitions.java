package StepDefinitions;

import Pages.acikPozisyonlarPage;
import Pages.homePage;
import Utilities.ConfigurationReader;
import Utilities.Driver;
import Utilities.Util;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import java.util.List;

public class homePageStepDefinitions {
    homePage HomePage = new homePage();
    acikPozisyonlarPage AcikPozisyonlarPage = new acikPozisyonlarPage();
    @Then("kullanici basarili bir sekilde anasayfada oldugunu gorur")
    public void kullanici_basarili_bir_sekilde_anasayfada_oldugunu_gorur() {
        String currentUrl = Driver.get().getCurrentUrl();
        Assert.assertEquals(currentUrl, ConfigurationReader.get("url"));
        Assert.assertTrue(HomePage.homePageLogo.isEnabled());
        Assert.assertEquals(HomePage.homePageLogo.getAttribute("src"), "https://cdnik.baykartech.com/media/images/contents/hr-logo-white.png");
    }

    @Then("kullanici navbar elementlerine tiklar ilgili sayfalari basarili bir sekilde goruntuler")
    public void kullaniciNavbarElementlerineTiklarIlgiliSayfalariBasariliBirSekildeGoruntuler() {
        List<WebElement> navElements = HomePage.navbarElements;
        for (int i = 0; i < navElements.size(); i++) {
            String expectedUrl = navElements.get(i).getAttribute("href");
            navElements.get(i).click();
            try {
                if (HomePage.dropDownMenu.isDisplayed() && HomePage.dropDownMenu.isEnabled()) {
                    List<WebElement> dropdownItems = HomePage.dropdownItems;
                    for (int j = 0; j < dropdownItems.size(); j++) {
                        WebElement dropdownItem = dropdownItems.get(j);
                        String expectedDropUrl = dropdownItem.getAttribute("href");
                        dropdownItem.click();
                        Assert.assertTrue(Driver.get().getCurrentUrl().contains(expectedDropUrl));
                        Driver.get().navigate().back();
                        navElements = HomePage.navbarElements;
                        navElements.get(i).click();
                    }
                } else {
                    Assert.assertTrue(Driver.get().getCurrentUrl().contains(expectedUrl));
                }
            } catch (NoSuchElementException e) {
                System.out.println("expectedUrl = " + expectedUrl);
                Assert.assertTrue(Driver.get().getCurrentUrl().contains(expectedUrl));
            }
            Driver.get().get(ConfigurationReader.get("url"));
        }
    }

    @Then("kullanici dil seceneklerinden birini secip sayfayi basarili bir sekilde goruntuler")
    public void kullanici_dil_seceneklerinden_birini_secip_sayfayi_basarili_bir_sekilde_goruntuler() {
        List<String> languages = List.of("en", "tr");
        for (String language : languages) {
            String languageBtnUrl = HomePage.languageButton.getAttribute("href");
            Assert.assertTrue(HomePage.languageButton.getAttribute("href").contains(language));
            HomePage.languageButton.click();
            Assert.assertEquals(Driver.get().getCurrentUrl(), languageBtnUrl);
            Assert.assertTrue("Sayfa doğru dilde görüntülenmiyor:", Driver.get().getCurrentUrl().contains(language));
            List<String> expectedTexts;
            if (language.equals("en")) {
                expectedTexts = List.of("CAREER", "OPEN POSITIONS", "INTERNSHIP", "FAQ", "BAYKAR");
            } else {
                expectedTexts = List.of("KARİYER", "AÇIK POZİSYONLAR", "STAJ", "S.S.S", "BAYKAR");
            }
            for (int i = 0; i < HomePage.navbarElements.size(); i++) {
                Assert.assertEquals(expectedTexts.get(i), HomePage.navbarElements.get(i).getText());
            }
        }
    }

    @And("kullanici Acik Poziyonlar sayfasina tiklar")
    public void kullaniciAcikPoziyonlarSayfasinaTiklar() {
        Util.scrollToElement(HomePage.openPositionsButton);
        Util.clickWithJS(HomePage.openPositionsButton);
    }

}







