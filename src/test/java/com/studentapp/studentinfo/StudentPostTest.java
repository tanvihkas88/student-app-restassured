package com.studentapp.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.testbase.TestBase;
import com.studentapp.utils.TestUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class StudentPostTest extends TestBase {

    @Test
    public void createStudent() {

        String email = TestUtils.getRandomValue() + "primetesting@gmail.com";

        List<String> courseList = new ArrayList<>();
        courseList.add("Accounting");
        courseList.add("Statastic");
        courseList.add("Java");
        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Prime");
        studentPojo.setLastName("Testing");
        studentPojo.setEmail(email);
        studentPojo.setProgramme("Api automation");
        studentPojo.setCourses(courseList);

        Response response = given().log().ifValidationFails()
                .header("Content-Type", "application/json")
                .when()
                .body(studentPojo)
                .post();
//        response.prettyPrint();
        response.then().log().ifValidationFails().statusCode(201);

    }
}