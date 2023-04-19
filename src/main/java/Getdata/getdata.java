package Getdata;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.plaf.PanelUI;

import static io.restassured.RestAssured.given;

public class getdata {
    @Test
    public void testrespoundcode23() {
        Response resp = RestAssured.get("https://api.zippopotam.us/IN/110001");
        int code = resp.getStatusCode();
        System.out.println("The api response is " + code);
        System.out.println("The exapected code respose is 200");
        Assert.assertEquals(code, 200);

    }

    @Test
    public void getstringdata() {
        Response resp = RestAssured.get("https://samples.openweathermap.org/data/2.5/forecast/hourly?id=524901&appid=439d4b804bc8187953eb36d2a8c26a02");
        String data = resp.asString();
        System.out.println(data);

    }
    @Test
    public void demo2(){
        given().get("https://api.zippopotam.us/IN/110001").then().statusCode(200).log().all();
    }
    //Check the value with the parameter wise
    @Test
    public void get1(){
        given().queryParam("country","India")
                .queryParam("country abbreviation","IN")
                .queryParam("post code","110127")
                .when().get("https://api.zippopotam.us/IN/110001").then().log()
                .body();
    }


}
