import io.github.bonigarcia.wdm.managers.ChromeDriverManager
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver

reportsDir = "target/geb-reports"
baseUrl= "http://localhost:8081"
environments {
    chrome {
        // tag::chromedriver[]
        ChromeDriverManager.getInstance().setup()
        driver = { new ChromeDriver() }
        // end::chromedriver[]
    }

    firefox {
        driver = { new FirefoxDriver() }
    }
}

////driver = {
////    FirefoxDriverManager.getInstance().setup()
////    new FirefoxDriver()
////}
//ChromeDriverManager.getInstance().setup()
//driver = { new ChromeDriver() }