package hu.nive.ujratervezes.zarovizsga.people;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PeopleTest {

    @Test
    void getNumberOfMales() {
        People people = new People();
        int males = people.getNumberOfMales("src/test/resources/people.csv");
        assertEquals(545, males);
    }

    @Test
    void getNumberOfMalesOther() {
        People people = new People();
        int males = people.getNumberOfMalesOther("src/test/resources/people.csv");
        assertEquals(545, males);
    }
}