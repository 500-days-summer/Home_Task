package steps;

import domains.Post;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static io.restassured.RestAssured.given;

public class APItest {

    @Before
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

    }

    @Test
    public void getRequest() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/posts")
                .then()
                .extract().response();

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals("sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                response.jsonPath().getString("title[0]"));
    }

    @Test
    public void getRequestQueryParamBody() {
        Response response = given()
                .contentType(ContentType.JSON)
                .param("id", "2")
                .when()
                .get("/posts")
                .then()
                .extract().response();

        String bodyExpected = "est rerum tempore vitae\n" +
                "sequi sint nihil reprehenderit dolor beatae ea dolores neque\n" +
                "fugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\n" +
                "qui aperiam non debitis possimus qui neque nisi nulla";

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(bodyExpected,
                response.jsonPath().getString("body[0]"));
    }

    @Test
    public void getRequestQueryParamUserId() {
        Response response = given()
                .contentType(ContentType.JSON)
                .param("id", "2")
                .when()
                .get("/posts")
                .then()
                .extract().response();

        String bodyExpected = "1";

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(bodyExpected,
                response.jsonPath().getString("userId[0]"));
    }

    @Test
    public void getRequestQueryParamId() {
        Response response = given()
                .contentType(ContentType.JSON)
                .param("id", "2")
                .when()
                .get("/posts")
                .then()
                .extract().response();

        String bodyExpected = "2";

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(bodyExpected,
                response.jsonPath().getString("id[0]"));
    }

    @Test
    public void getRequestQueryParamTitle() {
        Response response = given()
                .contentType(ContentType.JSON)
                .param("id", "2")
                .when()
                .get("/posts")
                .then()
                .extract().response();

        String bodyExpected = "qui est esse";

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(bodyExpected,
                response.jsonPath().getString("title[0]"));
    }

    @Test
    public void getRequestUniqueIds() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/posts")
                .then()
                .extract().response();

        Gson gson = new Gson();
        List<Post> postList = gson.fromJson(response.getBody().asString(), new TypeToken<List<Post>>() {}.getType());
        Set<Integer> uniqueIds = new HashSet<>();
        for(int i = 0; i < postList.size(); i++){
            uniqueIds.add(postList.get(i).getId());
        }
        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals("Some ids are not unique", postList.size(), uniqueIds.size());

    }
}
