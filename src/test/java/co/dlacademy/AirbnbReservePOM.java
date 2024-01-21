package co.dlacademy;

import co.dlacademy.pages.HomePage;
import org.junit.jupiter.api.Test;

public class AirbnbReservePOM  extends  BaseTest{

    @Test
    void reserve(){
        HomePage homePage = new HomePage(driver);

        homePage.opensearch();
        homePage.selectCity("Santa marta");
        homePage.selectDate("Marzo 2024","10");
        homePage.selectDate("Marzo 2024","20");
        homePage.selectNumberGuest(5);
        homePage.searchResult();
    }
}
