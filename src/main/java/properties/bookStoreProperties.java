package properties;

public class bookStoreProperties {

    private static final PropertiesReader propertiesReader = new PropertiesReader();
    private static final String host = propertiesReader.getHost();

    public static final String getAllBooks = String.format("%s/BookStore/v1/Books", host);
    public static final String postBooks = String.format("%s/BookStore/v1/Books", host);

}
