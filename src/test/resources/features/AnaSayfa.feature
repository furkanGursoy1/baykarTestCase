@HomePage
Feature: Anasayfa Testleri

  Background:
    When kullanici basarili bir sekilde anasayfada oldugunu gorur

  @reg
  Scenario: Kullanici basarili bir sekilde navbar elementlerine tıklayabilmeli ilgili sayfayı basarili bir sekilde goruntuleyebilmeli
    Then kullanici navbar elementlerine tiklar ilgili sayfalari basarili bir sekilde goruntuler

  @reg
  Scenario: Kullanici basarili bir sekilde dil seceneklerinden birini secip sayfayi o dilde basarili bir sekilde goruntuleyebilmeli
    Then kullanici dil seceneklerinden birini secip sayfayi basarili bir sekilde goruntuler
