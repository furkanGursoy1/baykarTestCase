# baykarTestCase

KariyerBaykarManuelTestCase.xlsx excelinde manuel test dökümanını bulabilirsiniz.
###################################################################################
src/test/java/Runner/CukesRunner.java classini kullanarak veya .featurelar üzerinden otomasyon senaryoları run edebilirsiniz.
################################################################################################################################
kariyerBaykarYukTestiLocust.py dosyasında locust ile oluşturulmuş yük testini bulabilirsiniz.
Locust kütüphanesi yüklenmelidir. Terminalden dosyanın bulundugu dizine gidilmeli sonrasında locust -f kariyerBaykarYukTestiLocust.py komutunu çalıştırabilirsiniz.
Tarayıcınızı açın ve http://localhost:8089 adresine gidin veya terminalde gelen url tıklayınız.
Number of users (peak concurrency): Simüle edilecek sanal kullanıcı sayısı.
Ramp up (users started/second):Yeni kullanıcıların teste eklenme hızını ifade eder.
Bu değerler değiştirilerek yük artırılabilir ve sistemin performansı test edilebilmektedir. 
################################################################################################################################
kariyer.baykar.performanstest.jmx dosyasında jmeter üzerinden oluşturulmuş test scriptini bulabilirsiniz.
Thread groupta bulunan parametreler ile yük testi ve performans testlerinizi gerçekleştirebilirsiniz.
Number of Threads (users): Simüle edilecek sanal kullanıcı sayısı.
Ramp-up period (seconds): Yeni kullanıcıların teste eklenme hızını ifade eder.
Loop Count: Her bir kullanıcının test planını kaç kez yürüteceğini ifade etmektedir. Bu değerler değiştirilerek yük artırılabilir ve sistemin performansı test edilebilmektedir. Scripti jmeter arayüzünden ve komut satırından çalıştırılabilmektedir. jmeter -n -t /path/to/your/kariyerBaykarYukTestiJmeter.jmx -l /path/to/results.jtl html raporu oluşturmak için jmeter -g /path/to/results.jtl -o /path/to/output/report komutunu calıştırabilirsiniz.

 
