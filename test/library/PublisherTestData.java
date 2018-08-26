package library;

import library.entity.Author;
import library.entity.Publisher;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PublisherTestData {

    public static Long PUBLISHER_ONE_ID = 1L;
    public static Long PUBLISHER2_TWO_ID = 2L;

    public static Publisher PUBLISHER_ONE = new Publisher(PUBLISHER_ONE_ID, "Open Book");
    public static Publisher PUBLISHER_TWO = new Publisher(PUBLISHER2_TWO_ID, "Azbuka");

    public static void assertMatch(Publisher actual, Publisher expected) {
        assertThat(actual).isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Publisher> actual, Iterable<Publisher> expected) {
        assertThat(actual).isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Publisher> actual, Publisher... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }
}
