import io.github.bonigarcia.wdm.WebDriverManager
import io.github.bonigarcia.wdm.managers.ChromeDriverManager
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver

reportsDir = "target/geb-reports"
baseUrl = "http://localhost:8081"

enviroments {
    firefox {
        WebDriverManager.firefoxdriver().setup()
        driver = { new  FirefoxDriver() }
    }

    chrome {
        ChromeDriverManager.chromedriver().setup()
        driver = { new ChromeDriver() }
    }
}