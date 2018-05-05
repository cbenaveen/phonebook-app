package org.cbenaveen.interviews.phonebook;

import org.cbenaveen.interviews.phonebook.model.PhoneBookEntry;
import org.cbenaveen.interviews.phonebook.repository.PhoneBookRepository;
import org.cbenaveen.interviews.phonebook.repository.PhoneBookRepositoryImpl;
import org.cbenaveen.interviews.phonebook.storage.PhoneBookStorage;
import org.cbenaveen.interviews.phonebook.storage.PhoneBookStorageImpl;

import java.util.Collection;

public class PhoneBookApp {

    public static void main(String[] a) {
        // create instance of Phone book storage
        PhoneBookStorage storage = new PhoneBookStorageImpl();

        // create instance of phone book repository
        PhoneBookRepository repository = new PhoneBookRepositoryImpl(storage);

        PhoneBookEntry naveen = new PhoneBookEntry(9886004009l);
        naveen.setName("Naveen Kumar");
        repository.save(naveen);

        PhoneBookEntry venugopal = new PhoneBookEntry(9886404009l);
        venugopal.setName("Venugopal");
        repository.save(venugopal);

        PhoneBookEntry ganesh = new PhoneBookEntry(9836004009l);
        ganesh.setName("Ganesh");
        repository.save(ganesh);

        PhoneBookEntry raja = new PhoneBookEntry(9886064009l);
        raja.setName("Raja");
        repository.save(raja);

        PhoneBookEntry jone = new PhoneBookEntry(9885004009l);
        jone.setName("Jone");
        repository.save(jone);

        PhoneBookEntry todd = new PhoneBookEntry(9886004709l);
        todd.setName("Todd");
        repository.save(todd);

        PhoneBookEntry sean = new PhoneBookEntry(8886004009l);
        sean.setName("Sean");
        repository.save(sean);

        PhoneBookEntry entry = repository.find(9886404009l);
        System.out.println("Phone book entry found for thr number 9886404009 "
                 + " is "+ entry);

        Collection<PhoneBookEntry> allPhoneNumberStartsWith9886 = repository.findAllByNumberPrefix("9886");
        System.out.println(allPhoneNumberStartsWith9886);

        Collection<PhoneBookEntry> allPhoneNumberStartsWith8886 = repository.findAllByNumberPrefix("8886");
        System.out.println(allPhoneNumberStartsWith8886);
    }
}
