package Getdata;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostMethod {
    @Test
    public void createEmployee() {

        RestAssured.baseURI = "https://api.zippopotam.us/IN/110001";

        String requestBody = "{\n" +
                "  \"country\": \"India\",\n" +
                "  \"country abbreviation\": \"IN\",\n" +
                "  \"post code\": \"110001\"\n" +
                "}";


        Response response = null;

        try {
            response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                    .post("/create");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Response :" + response.asString());
        System.out.println("Status Code :" + response.getStatusCode());
        System.out.println("Does Reponse contains '110001'? :" + response.asString().contains("110001"));


        Assert.assertEquals(405, response.getStatusCode());
    }
}

