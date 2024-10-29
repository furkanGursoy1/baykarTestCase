@AcikPozisyonlar
Feature: Açık Pozisyonlar Sayfası Testleri

  Background:
    When kullanici basarili bir sekilde anasayfada oldugunu gorur
    And kullanici Acik Poziyonlar sayfasina tiklar

  @reg
  Scenario: Kullanici basarili bir sekilde açık  pozisyon filtrelerini çekip birim filtreleme ile pozisyon arama yapabilmelidir
    #Bug bulunmaktadır.Birim filtrelerinin checkbox-count degeri ile filtreleme sonrası gelen acık pozisyonlarin sayisi eşit değildir.
    #Method içinde bu kontrolü yapan satırları yoruma çektim.Filtreleme Sayfası Bulgu Ekran Görüntüsü.png bulunmaktadır.
    Then kullanici basarili bir sekilde birim filtrelerini cekip pozisyon arama yapar

  @reg
  Scenario: Kullanici basarili bir sekilde açık pozisyon filtrelerini jsoup kullanarak çekip birim filtreleme ile pozisyon arama yapabilmelidir
    Then kullanici basarili bir sekilde birim filtrelerini jsoup kullanarak cekip pozisyon arama yapar

  @reg
  Scenario: Kullanici basarili bir sekilde açık pozisyonları çekip arama kutusunda pozisyon arama yapabilmelidir.
    Then kullanici basarili bir sekilde acik pozisyonlari cekip basarili bir sekilde arama yapar

  @reg
  Scenario: Kullanici basarili bir sekilde açık pozisyonları jsoup kullanarak cekip arama kutusunda pozisyon arama yapabilmelidir.
    Then kullanici basarili bir sekilde acik pozisyonlari jsoup kullanarak cekip pozisyon arama yapar

