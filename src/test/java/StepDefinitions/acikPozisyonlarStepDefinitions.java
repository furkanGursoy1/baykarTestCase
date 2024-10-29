package StepDefinitions;

import Pages.acikPozisyonlarPage;
import Utilities.Constant;
import Utilities.Util;
import io.cucumber.java.en.Then;
import org.jsoup.Jsoup;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;


public class acikPozisyonlarStepDefinitions {
    acikPozisyonlarPage AcikPozisyonlarPage = new acikPozisyonlarPage();

    @Then("kullanici basarili bir sekilde birim filtrelerini cekip pozisyon arama yapar")
    public void kullaniciBasariliBirSekildeBirimFiltreleriniCekipPozisyonAramaYapar() {
        List<WebElement> filters = AcikPozisyonlarPage.filtersText;
        for (WebElement filter : filters) {
            Constant.FilterTextList.add(filter.getText());
        }
        System.out.println("Filtre Listesi: " + Constant.FilterTextList);

        for (int i = 0; i < Constant.FilterTextList.size(); i++) {
            String filterText = Constant.FilterTextList.get(i);
            WebElement filter = AcikPozisyonlarPage.filtersText.get(i);
            Util.scrollToElement(filter);
            System.out.println("Secilen Filtre: " + filterText);


            //int checkboxCount = Integer.parseInt(AcikPozisyonlarPage.checboxCount.getText());

            Util.clickWithJS(filter);
            Util.sleep(1);

            //Assert.assertEquals("The checkbox count does not match the number of open positions.", checkboxCount, HomePage.openPositionsText.size());
            if (AcikPozisyonlarPage.openPositionsUnitText.size() == 0) {
                System.out.println("Seçilen birimde açık pozisyon bulunamadı.");
            } else {
                for (WebElement position : AcikPozisyonlarPage.openPositionsUnitText) {
                    Assert.assertEquals("Seçilen filtreye ait pozisyonlar listelenmiyor", filterText, position.getText());
                }
                System.out.println("Acik pozisyon sayısı: " + AcikPozisyonlarPage.openPositionsUnitText.size());
            }
            Util.clickWithJS(filter);
            Util.sleep(1);
        }
    }

    @Then("kullanici basarili bir sekilde birim filtrelerini jsoup kullanarak cekip pozisyon arama yapar")
    public void kullaniciBasariliBirSekildeBirimFiltreleriniJsoupKullanarakCekipPozisyonAramaYapar() {
        Util.sleep(1);
        String html = Util.getPageSource();
        org.jsoup.nodes.Document doc = Jsoup.parse(html);
        org.jsoup.select.Elements filters = doc.select(".form-check .form-check-label");

        for (org.jsoup.nodes.Element filter : filters) {
            Constant.FilterTextList.add(filter.text());
        }

        System.out.println("FilterTextList: " + Constant.FilterTextList);

        for (int i = 0; i < Constant.FilterTextList.size(); i++) {
            String filterText = Constant.FilterTextList.get(i);
            WebElement filter = AcikPozisyonlarPage.filtersText.get(i);
            Util.scrollToElement(filter);
            System.out.println("Secilen Filter: " + filterText);
            Util.clickWithJS(filter);
            Util.sleep(1);
            if (AcikPozisyonlarPage.openPositionsUnitText.size() == 0) {
                System.out.println("Seçilen birimde açık pozisyon bulunamadı.");
            } else {
                for (WebElement position : AcikPozisyonlarPage.openPositionsUnitText) {
                    Assert.assertEquals("Secilen filtreye ait pozisyonlar listelenmiyor.", filterText, position.getText());
                }
                System.out.println("Acik pozisyon sayısı: " + AcikPozisyonlarPage.openPositionsUnitText.size());
            }
            Util.clickWithJS(filter);
            Util.sleep(1);
        }
    }

    @Then("kullanici basarili bir sekilde acik pozisyonlari cekip basarili bir sekilde arama yapar")
    public void kullaniciBasariliBirSekildeAcikPozisyonlariCekipBasariliBirSekildeAramaYapar() {
        List<WebElement> openPositionsHeaders = AcikPozisyonlarPage.openPositionsHeaders;
        Util.scrollToElement(AcikPozisyonlarPage.searchBox);
        Util.sleep(1);
        for (WebElement headerText : openPositionsHeaders) {
            Constant.OpenPositionsHeadersTextList.add(headerText.getText());
        }
        System.out.println("Açık pozisyon baslıkları: " + Constant.OpenPositionsHeadersTextList);
        for (String headerText : Constant.OpenPositionsHeadersTextList) {
            System.out.println("Aranan Pozisyon: " + headerText);
            AcikPozisyonlarPage.searchBox.sendKeys(headerText);
            AcikPozisyonlarPage.searchBox.sendKeys(Keys.ENTER);
            Util.sleep(2);
            for (WebElement openPositionsHeader : AcikPozisyonlarPage.openPositionsHeaders) {
                Assert.assertEquals("Aranan pozisyona ait ilanlar listelenmiyor.", headerText, openPositionsHeader.getText());
            }
            AcikPozisyonlarPage.searchBox.clear();
        }
    }

    @Then("kullanici basarili bir sekilde acik pozisyonlari jsoup kullanarak cekip pozisyon arama yapar")
    public void kullaniciBasariliBirSekildeAcikPozisyonlariJsoupKullanarakCekipPozisyonAramaYapar() {
        Util.scrollToElement(AcikPozisyonlarPage.searchBox);
        String html = Util.getPageSource();
        org.jsoup.nodes.Document doc = Jsoup.parse(html);
        org.jsoup.select.Elements openPositions = doc.select("#filterOpenPositions div.workBox > h3.size-xs4");
        for (org.jsoup.nodes.Element openPosition : openPositions) {
            String openPositionText = openPosition.text();
            Constant.OpenPositionsHeadersTextList.add(openPositionText);
        }

        System.out.println("Açık pozisyon baslıkları: " + Constant.OpenPositionsHeadersTextList);

        for (String openPositionText : Constant.OpenPositionsHeadersTextList) {
            System.out.println("Aranan Pozisyon: " + openPositionText);
            AcikPozisyonlarPage.searchBox.sendKeys(openPositionText);
            AcikPozisyonlarPage.searchBox.sendKeys(Keys.ENTER);
            Util.sleep(2);
            for (WebElement openPositionsHeader : AcikPozisyonlarPage.openPositionsHeaders) {
                Assert.assertEquals("Aranan pozisyona ait ilanlar listelenmiyor.", openPositionText, openPositionsHeader.getText());
            }
            AcikPozisyonlarPage.searchBox.clear();
        }
    }


}


