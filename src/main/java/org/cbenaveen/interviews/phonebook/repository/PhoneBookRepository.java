package org.cbenaveen.interviews.phonebook.repository;

import org.cbenaveen.interviews.phonebook.model.PhoneBookEntry;

import java.util.Collection;

/**
 * Repository interface exposes method to perform CRUD operation on
 * Phone book storage.
 */
public interface PhoneBookRepository {
    /**
     * Saves given {@link PhoneBookEntry} into underlying storage.
     *
     * @param entry {@link PhoneBookEntry}
     */
    void save(final PhoneBookEntry entry);

    /**
     * Updates the give {@link PhoneBookEntry} against the give phone number
     * @param fullNumber Full phone number to be used for searching the {@link PhoneBookEntry}
     * @param entry New {@link PhoneBookEntry} entry which will replace the old one.
     */
    void update(final long fullNumber, final PhoneBookEntry entry);

    /**
     * Finds the {@link PhoneBookEntry} using full phone number
     * @param fullNumber Full phone number to be used for searching {@link PhoneBookEntry}
     * @return {@link PhoneBookEntry} if found, else null
     */
    PhoneBookEntry find(final long fullNumber);

    /**
     * Deletes the {@link PhoneBookEntry} using full phone number
     * @param fullNumber Full phone number to be used for searching {@link PhoneBookEntry} and delete the same
     * @return Deleted {@link PhoneBookEntry} if found, else null
     */
    PhoneBookEntry delete(final long fullNumber);

    /**
     * Search all {@link PhoneBookEntry} using phone number prefix
     * @param prefix Phone number prefix
     * @return Collection of {@link PhoneBookEntry}
     */
    Collection<PhoneBookEntry> findAllByNumberPrefix(final String prefix);
}
