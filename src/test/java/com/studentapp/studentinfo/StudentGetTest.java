package com.studentapp.studentinfo;

import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class StudentGetTest extends TestBase {

    @Test
    public void getAllStudentsInfo() {
        Response response = given()
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleStudentInfo() {
        Response response = given()
                .pathParam("id", 5)
                .when()
                .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void searchStudentWithParameter() {

//        Map<String, Objects> qParams = new HashMap<>();
//        qParams.put("programme", "Computer Science");
//        qParams.put("limit", 2);

        Response response = given()
                .queryParam("programme", "Computer Science")
                .queryParam("limit", 2)
                .when()
                .get("/list");
        response.prettyPrint();
        response.then().statusCode(200);

    }

}