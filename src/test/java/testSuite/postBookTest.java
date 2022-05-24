package testSuite;

import entities.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import properties.bookStoreProperties;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static io.restassured.RestAssured.given;

public class postBookTest {

    @DataProvider(name = "user-id-testdata")
    public Iterator<Object[]> getuserIds() {
        Object[] usedIds = new Object[]{1, 2, 3, 4};
        List<Object[]> testData = new ArrayList<>();
        testData.add(usedIds);
        return testData.iterator();
    }

    @Test(groups = {"NONE"} ,dataProvider= "user-id-testdata")
    public void postBooksData(int userid) {
        isbn isbnObj = isbn.builder().isbn("12312344").build();
        List<isbn> isbnList = new ArrayList<>();
        isbnList.add(isbnObj);

        AddListOfBooks listOfBooks = AddListOfBooks.builder().userId("4237eeba-bb0c-4f9d-8656-435a09f4278f").collectionOfIsbns(isbnList).build();
        Response resp = given().contentType("application/json").body(listOfBooks).when().post(bookStoreProperties.postBooks);
        System.out.println(resp.asString());
        Assert.assertEquals(resp.getStatusCode(), 201);

    }
}

