package library;

import library.entity.Author;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class AuthorTestData {
    public static Long AUTHOR1_ID = 1L;
    public static Long AUTHOR2_ID = 2L;
    public static Long AUTHOR3_ID = 3L;

    public static Author AUTHOR1 = new Author(AUTHOR1_ID, "Maxim Gorky");
    public static Author AUTHOR2 = new Author(AUTHOR2_ID, "Ilya Ilf");
    public static Author AUTHOR3 = new Author(AUTHOR3_ID, "Eugeny Petrov");

    public static void assertMatch(Author actual, Author expected) {
        assertThat(actual).isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Author> actual, Iterable<Author> expected) {
        assertThat(actual).isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Author> actual, Author... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }
}
