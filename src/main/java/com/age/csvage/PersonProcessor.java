package com.age.csvage;

import com.age.csvage.domain.Person;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;
import java.time.Period;

public class PersonProcessor implements ItemProcessor<Person, Person> {

    @Override
    public Person process(Person item) throws Exception {
        return new Person(item.getFirstName(),  item.getLastName(),
                Period.between(LocalDate.parse(item.getBornDate()), LocalDate.now()).getYears()+"");
    }
}
