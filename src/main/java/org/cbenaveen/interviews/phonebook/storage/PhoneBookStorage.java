package org.cbenaveen.interviews.phonebook.storage;

import org.cbenaveen.interviews.phonebook.model.PhoneBookEntry;

import java.util.Collection;

/**
 * Interface exposes phone book operations.
 */
public interface PhoneBookStorage {
    /**
     * Insert a given {@link PhoneBookEntry} into storage
     * @param entry
     */
    void insert(final PhoneBookEntry entry);

    /**
     * Search phone books using number prefix
     * @param numberPrefix Number prefix in string form
     * @return Collection of {@link PhoneBookEntry} if at all entries are found.
     */
    Collection<PhoneBookEntry> search(final String numberPrefix);

    /**
     * {@link PhoneBookEntry} search using Full number
     * @param number Full number of {@link PhoneBookEntry} to be searched
     * @return PhoneBookEntry if its found.
     */
    PhoneBookEntry search(final long number);

    /**
     * Delete a {@link PhoneBookEntry} using the full phone number
     */
    void delete(final long number);
}
