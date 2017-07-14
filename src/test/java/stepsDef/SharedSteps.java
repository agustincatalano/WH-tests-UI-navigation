package stepsDef;

import driverFactory.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by agustin on 09/06/2017.
 */
public class SharedSteps {

    private static WebDriver driver;
    private final String juegoResponsableLocator = "//a[contains(.,'Juego responsable')]";
    private final String topSportListLocator = "//div[@id='mainNavB']/ul[1]/li";
    DriverFactory driverFactory = new DriverFactory();
    List<String> topEventsNameList = new ArrayList();
    Boolean getEventFlag = false;
    private int linkCount;

    public Boolean navigateToPage(String url) {
        if (driver == null) {
            driver = driverFactory.getDriver();
        }
        driver.get(url);
        driver.manage().window().maximize();
        String crrentURL = driver.getCurrentUrl();
        return url.equals(crrentURL);
    }

    public boolean validateSportsbookHomepageIsDisplayed() {
        return driver.findElement(By.id("contentCenter")).isDisplayed();
    }

    public void closeWindow() {
        if (driver == null) {
            System.out.println("there is not active windows");
        } else driver.close();
    }


    public boolean getEventList() {
        List<WebElement> topSportsLinkList = driver.findElements(By.xpath("//div[@id='productsNav']//a"));
        for (WebElement link : topSportsLinkList) {
            topEventsNameList.add(link.getText());
        }
        if (topSportsLinkList.size() == topEventsNameList.size()) {
            getEventFlag = true;
        }
        System.out.println("event on the web page : " + topEventsNameList);
        return getEventFlag;
    }

    public Boolean compareEventslist(List<String> myTopEvents) {
        return myTopEvents.containsAll(topEventsNameList);
    }

    public Boolean validateJuegoResponsableLinkonEachEvent(String textLink) {
        Boolean flag = false;
        Boolean elementFound;
        for (String event : topEventsNameList) {
            driver.findElement(By.xpath("//a[contains(.,'" + event + "')]")).click();
            elementFound = driver.findElement(By.xpath("//a[contains(.,'" + textLink + "')]")).isDisplayed();
            if (elementFound) {
                System.out.println("Element " + textLink + " in event " + event + " is displayed ");
                linkCount++;
            } else System.err.println("Element " + textLink + " in event " + event + " is  *NOT* displayed ");
        }
        if (topEventsNameList.size() == linkCount) {
            flag = true;
        }
        return flag;
    }

    public void validateJuegoResponsableonEachTopSport() {
        List<WebElement> topSortsWE = driver.findElements(By.xpath(topSportListLocator));
        //Stale element error on this method
//            for (WebElement sport: topSortsWE) {
//                    sport.click();
//            }

        for (int i = 0; i < topSortsWE.size(); i++) {
            WebElement thisSport = driver.findElements(By.xpath(topSportListLocator)).get(i);
            thisSport.click();
            Assert.assertTrue("Juego responsable link is not present on sport " + thisSport, driver.findElement(By.xpath(juegoResponsableLocator)).isDisplayed());
            try {
                System.out.println("Juego responsable link is present on " + thisSport.getText());
            } catch (StaleElementReferenceException e) {
                thisSport = driver.findElements(By.xpath(topSportListLocator)).get(i);
                System.out.println("Juego responsable link present on " + thisSport.getText());
            }

        }


    }

}
