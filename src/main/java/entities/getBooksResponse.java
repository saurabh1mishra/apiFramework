package entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class getBooksResponse {

    private List<Book> books;

    @Getter
    @Setter
    public static class Book {
        private String isbn;
        private String title;
        private String subTitle;
        private String author;
        private Date publish_date;
        private String publisher;
        private int pages;
        private String description;
        private String website;
    }
}
