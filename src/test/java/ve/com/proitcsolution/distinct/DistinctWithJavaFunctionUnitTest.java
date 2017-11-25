package ve.com.proitcsolution.distinct;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static ve.com.proitcsolution.distinct.DistinctWithJavaFunction.distinctByKey;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ve.com.proitcsolution.distinct.util.PersonDataGenerator;
import ve.com.proitcsolution.dto.Person;

public class DistinctWithJavaFunctionUnitTest {
    static List<Person> personList;

    @BeforeAll
    public static void init() {
        personList = PersonDataGenerator.getPersonListWithFakeValues();
    }

    @Test
    public void whenFilterListByName_thenSizeShouldBe4() {
        List<Person> personListFiltered = personList.stream()
            .filter(distinctByKey(p -> p.getName()))
            .collect(Collectors.toList());
        assertTrue(personListFiltered.size() == 4);
    }

    @Test
    public void whenFilterListByAge_thenSizeShouldBe2() {
        List<Person> personListFiltered = personList.stream()
            .filter(distinctByKey(p -> p.getAge()))
            .collect(Collectors.toList());
        assertTrue(personListFiltered.size() == 2);
    }

    @Test
    public void whenFilterListWithDefaultDistinct_thenSizeShouldBe5() {
        List<Person> personListFiltered = personList.stream()
            .distinct()
            .collect(Collectors.toList());
        assertTrue(personListFiltered.size() == 5);
    }

}
