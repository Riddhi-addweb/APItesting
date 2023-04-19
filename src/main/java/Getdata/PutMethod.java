package Getdata;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;



public class PutMethod {
    @Test
    public static void Put(){
        {

            Response resp = RestAssured.get("https://api.zippopotam.us/IN/110001");
            String data = resp.asString();
            System.out.println(data);

            RestAssured.baseURI = "https://api.zippopotam.us/IN/110001";

            String requestBody = "{\r\n" +
                    " \"country\":\"India\",\r\n" +
                    " \"country abbreviation\":\"IN\",\r\n" +
                    " \"body\":\"testing\"\r\n" +
                    "}";


            Response response = null;

            try {
                response = RestAssured.given()
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .put("India");
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Response :" + response.asString());
            System.out.println("Status Code :" + response.getStatusCode());
            System.out.println("Does Reponse contains 'India'? :" + response.asString().contains("India"));


            assertEquals(200, response.getStatusCode());
        }
    }

    private static void assertEquals(int i, int statusCode) {
    }
    public static void getResponseHeaders(){
//        System.out.println("The headers in the response "+
//                get(url).then().extract()
//                        .headers());
    }
}


