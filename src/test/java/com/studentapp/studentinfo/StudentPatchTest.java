package com.studentapp.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.testbase.TestBase;
import com.studentapp.utils.TestUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class StudentPatchTest extends TestBase {

    @Test
    public void updateStudentWithPatch(){
        //homework

        String email = TestUtils.getRandomValue() + "primetesting@gmail.com";


        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setEmail(email);


        Response response = given().log().ifValidationFails()
                .header("Content-Type", "application/json")
                .when()
                .body(studentPojo)
                .patch();

        response.then().log().ifValidationFails().statusCode(200);

    }
}
