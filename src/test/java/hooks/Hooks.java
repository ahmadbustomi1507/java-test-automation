package hooks;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.baseURI;

public class Hooks {


    @BeforeClass
    public void beforeClass(){
        baseURI = "https://632c1cac5568d3cad87cfb25.mockapi.io";

    }

    @AfterClass
    public void afterClass(){

    }

    @BeforeTest
    public void beforeTest(){

    }

    @AfterTest
    public void afterTest(){

    }

}
