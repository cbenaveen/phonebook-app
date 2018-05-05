package org.cbenaveen.interviews.phonebook.storage;

import static org.junit.Assert.*;

import org.cbenaveen.interviews.phonebook.model.PhoneBookEntry;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class PhoneBookStorageImplJUnitTest {

    private PhoneBookStorage phoneStorage;

    @Before
    public void setup() {
        phoneStorage = new PhoneBookStorageImpl();
    }

    @Test
    public void testAddNumberToStorage() {
        PhoneBookEntry naveen = new PhoneBookEntry(9886004009l);
        naveen.setName("Naveen Kumar");

        PhoneBookEntry venugopal = new PhoneBookEntry(9886404009l);
        venugopal.setName("Venugopal");

        PhoneBookEntry ganesh = new PhoneBookEntry(9836004009l);
        ganesh.setName("Ganesh");

        PhoneBookEntry raja = new PhoneBookEntry(9886064009l);
        raja.setName("Raja");

        PhoneBookEntry jone = new PhoneBookEntry(9885004009l);
        jone.setName("Jone");

        PhoneBookEntry todd = new PhoneBookEntry(9886004709l);
        todd.setName("Todd");

        PhoneBookEntry sean = new PhoneBookEntry(8886004009l);
        sean.setName("Sean");

        phoneStorage.insert(naveen);
        phoneStorage.insert(venugopal);
        phoneStorage.insert(ganesh);
        phoneStorage.insert(raja);
        phoneStorage.insert(jone);
        phoneStorage.insert(todd);
        phoneStorage.insert(sean);
    }

    @Test
    public void test_PhoneBookEntrySearch_UsingPrefix_9886() {
        testAddNumberToStorage();
        Collection<PhoneBookEntry> entries = phoneStorage.search("9886");
        assertNotNull(entries);
        assertEquals(4, entries.size());
        for(PhoneBookEntry entry: entries) {
            System.out.println(entry);
        }
    }

    @Test
    public void test_PhoneBookEntrySearch_UsingPrefix_8886() {
        testAddNumberToStorage();
        Collection<PhoneBookEntry> entries = phoneStorage.search("8886");
        assertNotNull(entries);
        assertEquals(1, entries.size());
        for(PhoneBookEntry entry: entries) {
            System.out.println(entry);
        }
    }

    @Test
    public void test_PhoneBookEntrySearch_UsingNonExistingPrefix_886() {
        testAddNumberToStorage();
        Collection<PhoneBookEntry> entries = phoneStorage.search("886");
        assertNotNull(entries);
        assertEquals(0, entries.size());
        for(PhoneBookEntry entry: entries) {
            System.out.println(entry);
        }
    }

    @Test
    public void test_PhoneBookEntrySearch_UsingFullNumber_9886004009() {
        testAddNumberToStorage();
        PhoneBookEntry entry = phoneStorage.search(9886004009l);
        System.out.println(entry);
        assertNotNull(entry);
        assertEquals(9886004009l, entry.getPhoneNumber());
        assertEquals("Naveen Kumar", entry.getName());
    }

    @Test
    public void test_PhoneBookEntrySearch_UsingFullNumber_8886004009() {
        testAddNumberToStorage();
        PhoneBookEntry entry = phoneStorage.search(8886004009l);
        System.out.println(entry);
        assertNotNull(entry);
        assertEquals(8886004009l, entry.getPhoneNumber());
        assertEquals("Sean", entry.getName());
    }
}
