package library;

import library.entity.Author;
import library.entity.Book;
import library.entity.Publisher;

import java.util.Arrays;
import java.util.List;

import static library.AuthorTestData.*;
import static library.PublisherTestData.PUBLISHER_ONE;
import static library.PublisherTestData.PUBLISHER_TWO;
import static org.assertj.core.api.Assertions.assertThat;

public class BookTestData {
    public static Long BOOK_ONE_ID = 1L;
    public static Long BOOK_TWO_ID = 2L;
    public static Long BOOK_THREE_ID = 3L;

    public static String BOOK_TITLE_ONE = "Mother";
    public static String BOOK_TITLE_TWO = "The Lower Depths";
    public static String BOOK_TITLE_THREE = "The Twelve Chairs";

    public static List<Author> LIST_AUTHOR1 = Arrays.asList(AUTHOR1);
    public static List<Author> LIST_AUTHOR2 = Arrays.asList(AUTHOR1);
    public static List<Author> LIST_AUTHOR3 = Arrays.asList(AUTHOR2,AUTHOR3);

    public static Publisher PUBLISHER1= PUBLISHER_ONE;
    public static Publisher PUBLISHER2= PUBLISHER_TWO;

    public static Book BOOK1 = new Book(BOOK_ONE_ID, BOOK_TITLE_ONE, LIST_AUTHOR1, PUBLISHER1, null);
    public static Book BOOK2 = new Book(BOOK_TWO_ID, BOOK_TITLE_TWO, LIST_AUTHOR2, PUBLISHER1, null);
    public static Book BOOK3 = new Book(BOOK_THREE_ID, BOOK_TITLE_THREE, LIST_AUTHOR3, PUBLISHER1, null);

    //Сверяем игнорируя поля автор и издатель т.к. у нас lazy
    public static void assertMatch(Book actual, Book expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected,"author","publisher");
    }

    public static void assertMatch(Iterable<Book> actual, Iterable<Book> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("author","publisher").isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Book> actual, Book... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

}
