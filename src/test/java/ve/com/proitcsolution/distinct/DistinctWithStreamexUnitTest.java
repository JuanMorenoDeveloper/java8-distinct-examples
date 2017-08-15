package ve.com.proitcsolution.distinct;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import one.util.streamex.StreamEx;
import ve.com.proitcsolution.distinct.util.PersonDataGenerator;
import ve.com.proitcsolution.dto.Person;

public class DistinctWithStreamexUnitTest {
    static List<Person> personList;

    @BeforeClass
    public static void init() {
        personList = PersonDataGenerator.getPersonListWithFakeValues();
    }

    @Test
    public void whenFilterListByName_thenSizeShouldBe4() {
        List<Person> personListFiltered = StreamEx.of(personList)
            .distinct(Person::getName)
            .toList();
        assertTrue(personListFiltered.size() == 4);
    }

    @Test
    public void whenFilterListByAge_thenSizeShouldBe2() {
        List<Person> personListFiltered = StreamEx.of(personList)
            .distinct(Person::getAge)
            .toList();
        assertTrue(personListFiltered.size() == 2);
    }

}
