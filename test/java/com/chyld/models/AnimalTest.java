package com.chyld.models;

import com.chyld.util.Mysql;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;

import static org.junit.Assert.*;

public class AnimalTest {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Before
    public void setUp() throws Exception {
        Session session = Mysql.getSession();
        session.beginTransaction();
        session.createNativeQuery("truncate table animals").executeUpdate();
        Animal animal = new Animal("Fido", format.parse("2013-02-11"), format.parse("2013-02-12"), Sex.M, Species.DOG);
        session.save(animal);
        session.getTransaction().commit();
        session.close();
    }

    @After
    public void tearDown() throws Exception {
    }

    // **************
    // *** CREATE ***
    // **************

    @Test
    public void shouldCreateNewAnimalAndSave() throws Exception {
        Session session = Mysql.getSession();
        session.beginTransaction();
        Animal animal = new Animal("Clark", format.parse("2013-02-11"), format.parse("2013-02-12"), Sex.M, Species.DOG);
        session.save(animal);
        session.getTransaction().commit();
        session.close();
        assertEquals(2, animal.getId());
    }
}
