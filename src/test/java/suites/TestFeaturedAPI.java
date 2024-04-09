package suites;

import dto.User;
import hooks.Hooks;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.extern.java.Log;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

import static io.restassured.RestAssured.*;

@Test
@Log
public class TestFeaturedAPI extends Hooks {

    @Ignore
    public void Test_getSingleId(){

        // 1# Prepare the request
        RequestSpecification request = given()
                .pathParam("id",1);

        // 2# Validate response, try to deserialize into dto object/bean
        ValidatableResponse user = given()
                    .pathParam("id",1)
                .when()
                    .get("/api/v1/users/{id}")
                .then()
                    .log().all()
                .assertThat()
                    .statusCode(200)
                    .contentType(ContentType.JSON);

        try{
            // try to deserialize to POJO
            User bodyUser = user.extract()
                    .response().body().as(new TypeRef<User>(){});
            Assert.assertTrue(true);
        }
        catch (Exception e){
            String responseString = user.extract().response().body().asString();
            log.info("failed to deserialize to User ," + responseString);
            Assert.fail("failed to deserialize to User " + responseString);
        }
    }

    public void Test_postSingleId(){

        // 1# Prepare the request
        User userRequest = new User();
        userRequest.setId("10000");
        userRequest.setAvatar("google.com");
        userRequest.setName("Tomson");

        RequestSpecification request = given().log().all()
                .body(userRequest);

        // 2# Validate response, try to deserialize into dto object/bean
        ValidatableResponse user = request
                .when()
                    .post("/api/v1/users/")
                .then()
                    .log().all()
                .assertThat()
                    .statusCode(201)
                    .contentType(ContentType.JSON);

        try{
            // try to deserialize to POJO
            User bodyUser = user.extract()
                    .response().body().as(new TypeRef<User>(){});
            Assert.assertTrue(true);
        }
        catch (Exception e){
            String responseString = user.extract().response().body().asString();

            log.info("failed to deserialize to User ," + responseString);
            Assert.fail("failed to deserialize to User " + responseString);
        }
    }


}
