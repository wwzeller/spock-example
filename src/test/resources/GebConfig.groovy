import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.firefox.FirefoxDriver

reportsDir = "target/geb-reports"
baseUrl = "http://localhost:8081"

enviroments {
    firefox {
        WebDriverManager.firefoxdriver().setup()
        driver = { new FirefoxDriver() }
    }
}