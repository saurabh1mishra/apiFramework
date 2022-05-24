package testSuite;

import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;
import properties.bookStoreProperties;
import entities.getBooksResponse;

import java.util.*;

import static io.restassured.RestAssured.given;

public class getBooksTest extends baseTest {

    @Test(groups = {"NONE"})
    public void getAllBooksData() {
        Response resp = given().contentType("application/json").when().get(bookStoreProperties.getAllBooks);
        System.out.println(resp.asString());
        getBooksResponse getBooksResponse = resp.as(entities.getBooksResponse.class);

        Assert.assertEquals(resp.getStatusCode(), 200, "status code not matched.");
        System.out.println("no of records found : " + getBooksResponse.getBooks().size());

        Map<String, Integer> accrance = new HashMap<>();
        List<entities.getBooksResponse.Book> listBooks = getBooksResponse.getBooks();

        listBooks.forEach((record) -> {
            if (accrance.containsKey(record)) {
                accrance.put(record.getIsbn(), accrance.get(record.getIsbn()) + 1);
            } else {
                accrance.put(record.getIsbn(), 1);
            }
        });

        Set<Map.Entry<String, Integer>> entrySet = accrance.entrySet();
        List<String> dupRecords = new ArrayList<>();
        System.out.println(accrance);
        for (Map.Entry<String, Integer> entry : entrySet) {
            if (entry.getValue() > 1) {
                dupRecords.add(entry.getKey());
            }
        }

        Assert.assertTrue(dupRecords.isEmpty(), "records had dup entries" + dupRecords);
    }
}
