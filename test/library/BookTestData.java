package library;

import library.entity.Author;
import library.entity.Book;
import library.entity.Publisher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static library.AuthorTestData.AUTHOR1;
import static library.PublisherTestData.PUBLISHER_ONE;
import static org.assertj.core.api.Assertions.assertThat;

public class BookTestData {
    public static Long BOOK_ONE_ID = 1L;
    public static Long BOOK_TWO_ID = 2L;
    public static Long BOOK_THREE_ID = 3L;

    public static String BOOK_TITLE_ONE = "Mother";
    public static String BOOK_TITLE_TWO = "The Lower Depths";
    public static String BOOK_TITLE_THREE = "The Twelve Chairs";

    public static List<Author> LIST_AUTHOR = new ArrayList<>();
    public static Publisher PUBLISHER = new Publisher();

    {
       LIST_AUTHOR.add(AUTHOR1);
       PUBLISHER = PUBLISHER_ONE;
    }

    public static Book BOOK1 = new Book(BOOK_ONE_ID, BOOK_TITLE_ONE,LIST_AUTHOR, PUBLISHER,"");
    //   public static Book BOOK2 = new Book(BOOK_TWO_ID, BOOK_TITLE_TWO);
    //  public static Book BOOK3 = new Book(BOOK_THREE_ID, BOOK_TITLE_THREE);


    public static void assertMatch(Book actual, Book expected) {
        assertThat(actual).isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Book> actual, Iterable<Book> expected) {
        assertThat(actual).isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Book> actual, Book... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

}
