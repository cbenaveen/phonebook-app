package org.cbenaveen.interviews.phonebook.repository;

import org.cbenaveen.interviews.phonebook.model.PhoneBookEntry;
import org.cbenaveen.interviews.phonebook.storage.PhoneBookStorage;

import java.util.Collection;

/**
 * Implementation of {@link PhoneBookRepository} which makes use of instance of
 * {@link org.cbenaveen.interviews.phonebook.storage.PhoneBookStorage} to perform
 * CRUD operation on storage.
 */
public class PhoneBookRepositoryImpl implements PhoneBookRepository {
    private final PhoneBookStorage phoneBookStorage;

    public PhoneBookRepositoryImpl(final PhoneBookStorage phoneBookStorage) {
        this.phoneBookStorage = phoneBookStorage;
    }

    @Override
    public void save(PhoneBookEntry entry) {
        phoneBookStorage.insert(entry);
    }

    @Override
    public void update(long fullNumber, PhoneBookEntry newEntry) {
        PhoneBookEntry entry = find(fullNumber);
        if(entry != null) {
            entry.setName(newEntry.getName());
            entry.setEmailId(newEntry.getEmailId());
        }
    }

    @Override
    public PhoneBookEntry find(long fullNumber) {
        return phoneBookStorage.search(fullNumber);
    }

    @Override
    public PhoneBookEntry delete(long fullNumber) {
        return null;
    }

    @Override
    public Collection<PhoneBookEntry> findAllByNumberPrefix(String prefix) {
        return phoneBookStorage.search(prefix);
    }
}
