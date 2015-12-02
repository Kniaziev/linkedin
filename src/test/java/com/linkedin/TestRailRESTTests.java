package com.linkedin;


import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.basic;
import static com.jayway.restassured.RestAssured.given;

public class TestRailRESTTests {

    @BeforeClass
    public void beforeClass() {
        RestAssured.baseURI = "https://okniaziev.testrail.net";
        RestAssured.authentication = basic("knyazev.alexandr@gmail.com", "w2WMNr7giNex1DUkH3TP");
        RestAssured.requestContentType(ContentType.JSON);


    }


    @DataProvider(name = "Priorities")
    public Object[][] createdata() {
        return new Object[][] {
                new Object[] { 1 },
                new Object[] { 2 },
                new Object[] { 3 },
                new Object[] { 222}};
    }

    @Test
    public void getTestCaseTest() {
        int testCaseId = 1;
        Response response = given().header("Authorization", "Basic a255YXpldi5hbGV4YW5kckBnbWFpbC5jb206dzJXTU5yN2dpTmV4MURVa0gzVFA=")
                .when().get("/index.php?/api/v2/get_case/{t}", testCaseId);

        //System.out.println("Status code - "+ response.getStatusCode());

        //print out json
        System.out.println(response.asString());
        String testCaseTitle = "Verify successfull user login";
        Assert.assertTrue(response.asString().contains(testCaseTitle), "Test case title not found in output");
        Assert.assertEquals(response.getStatusCode(), 200, "Status code is wrong");
    }

    @Test
    public void test2() {
        given()
                .header("Authorization", "Basic a255YXpldi5hbGV4YW5kckBnbWFpbC5jb206dzJXTU5yN2dpTmV4MURVa0gzVFA=")
                .expect()
                .statusCode(200)
                .response()
                .when()
                .get("/index.php?/api/v2/get_case/1");
    }

    @Test
    public void SetTesCaseStatusTest() throws JSONException {
        int testCaseId = 1;
        int testCaseStatus = 2;
        JSONObject obj = new JSONObject();
        obj.put("status_id", testCaseStatus);
        Response response = given().header("Authorization", "Basic a255YXpldi5hbGV4YW5kckBnbWFpbC5jb206dzJXTU5yN2dpTmV4MURVa0gzVFA=")
                .body(obj.toString())
                .when().post("/index.php?/api/v2/add_result/{t}", testCaseId);
        System.out.println(response.asString());
        Assert.assertTrue(response.asString().contains("\"status_id\":" + testCaseStatus), "Status id was not set");
        Assert.assertEquals(200, response.getStatusCode(), "Status code is wrong");

    }
        //System.out.println("Status code - "+ responce.getStatusCode());

       /* print out json
        System.out.println(responce.asString());
        String testCaseTitle = "Verify successfull user login";
        Assert.assertTrue(responce.asString().contains(testCaseTitle), "Test case title not found in output");
        Assert.assertEquals(responce.getStatusCode(), 200, "Status code is wrong");
*/
/////////////////////////////////////////////////////////////////
    //Test possibility of status update
    @Test(dataProvider = "Priorities")
    public void updateTestCasePriority(int testCasePriority) throws JSONException {
        int testCaseId = 1;
        JSONObject obj = new JSONObject();
        obj.put("priority_id", testCasePriority);
        Response response = given().header("Authorization", "Basic a255YXpldi5hbGV4YW5kckBnbWFpbC5jb206dzJXTU5yN2dpTmV4MURVa0gzVFA=")
                .body(obj.toString())
                .when().post("/index.php?/api/v2/update_case/{t}", testCaseId);
        switch (testCasePriority) {
            case 1:
                System.out.println("Test case priority is set to "+testCasePriority);
                 Assert.assertEquals(200, response.getStatusCode(), "Priority id is wrong");
                break;
            case 2:
                System.out.println("Test case priority is set to "+testCasePriority);
                Assert.assertTrue(response.asString().contains("\"priority_id\":" + testCasePriority), "Priority id was not set");
                break;
            case 3:
                System.out.println("Test case priority is set to "+testCasePriority);
                Assert.assertTrue(response.asString().contains("\"priority_id\":" + testCasePriority), "Priority id was not set");
                break;
            case 222:
                System.out.println("Test case priority is set to "+testCasePriority);
                Assert.assertTrue(response.asString().contains("is not a valid priority"));
                break;
            default:
                break;
        }
            System.out.println(response.asString());
        }

//Checking user name
    @Test
    public void checkUserDetails() {
       Response response = given().header("Authorization", "Basic a255YXpldi5hbGV4YW5kckBnbWFpbC5jb206dzJXTU5yN2dpTmV4MURVa0gzVFA=")
                .when().get("index.php?/api/v2/get_user_by_email&email=knyazev.alexandr@gmail.com");
        System.out.println(response.asString());
        Assert.assertEquals(200, response.getStatusCode(), "Status code is wrong");
        Assert.assertTrue(response.asString().contains("Oleksandr Kniaziev"), "User not found");
    }

    //Testing adding new run with add_run
    @Test
    public void addNewRun() {
        Response response = given().header("Authorization", "Basic a255YXpldi5hbGV4YW5kckBnbWFpbC5jb206dzJXTU5yN2dpTmV4MURVa0gzVFA=")
                .when().post("index.php?/api/v2/add_run/1");

    }



    }
