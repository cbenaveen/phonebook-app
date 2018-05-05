package org.cbenaveen.interviews.phonebook.storage;

import org.cbenaveen.interviews.phonebook.model.PhoneBookEntry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * Trie implementation that supports {@link PhoneBookStorage} business contract.
 */
public class PhoneBookStorageImpl implements PhoneBookStorage {
    private final PhoneBookNode rootNode;

    public PhoneBookStorageImpl() {
        this.rootNode = new PhoneBookNode();
    }

    @Override
    public void insert(final PhoneBookEntry entry) {
        System.out.println("Inserting PhoneNumber: " + entry);

        if(entry == null) {
            throw new IllegalArgumentException("Invalid phone book entry");
        }

        String phoneNumber = Long.toString(entry.getPhoneNumber());
        Map<Character, PhoneBookNode> nodeEntries = rootNode.getEntries();

        PhoneBookNode node = null;
        for(char c: phoneNumber.toCharArray()) {
            if(nodeEntries.containsKey(c)) {
                node = nodeEntries.get(c);
            } else {
                node = new PhoneBookNode(c);
                nodeEntries.put(c, node);
            }
            nodeEntries = node.getEntries();
        }

        node.setPhoneBookEntry(entry);
        node.setLeaf(true);
    }

    @Override
    public Collection<PhoneBookEntry> search(String numberPrefix) {
        System.out.println("Searching all Phone numbers using prefix:"
                + numberPrefix);
        if(numberPrefix == null) {
            throw new IllegalArgumentException("Invalid number prefix to search for " +
                    "PhoneNumbers");
        }

        Collection<PhoneBookEntry> allEntries = new ArrayList<>();
        Map<Character, PhoneBookNode> entries = rootNode.getEntries();

        for(char c: numberPrefix.toCharArray()) {
            if(entries.containsKey(c)) {
                entries = entries.get(c).getEntries();
            } else {
                return allEntries;
            }
        }

        getPhoneBookEntry(allEntries, entries.values());
        return allEntries;
    }

    private void getPhoneBookEntry(Collection<PhoneBookEntry> allEntries,
                                   Collection<PhoneBookNode> phoneBookNodes) {
        if(phoneBookNodes != null && !phoneBookNodes.isEmpty()) {
            for(PhoneBookNode phoneBookNode: phoneBookNodes) {
                if(phoneBookNode.isLeaf()) {
                    allEntries.add(phoneBookNode.getPhoneBookEntry());
                }

                getPhoneBookEntry(allEntries, phoneBookNode.getEntries().values());
            }
        }
    }

    @Override
    public PhoneBookEntry search(long number) {
        System.out.println("Searching Phone numbers:" + number);
        String phoneNumber = Long.toString(number);
        Map<Character, PhoneBookNode> nodeEntries = rootNode.getEntries();

        PhoneBookNode node = null;
        for(char c: phoneNumber.toCharArray()) {
            if(nodeEntries.containsKey(c)) {
                node = nodeEntries.get(c);
            } else {
                return null;
            }

            nodeEntries = node.getEntries();
        }

        if(node.isLeaf()) {
            return node.getPhoneBookEntry();
        }

        return null;
    }

    @Override
    public void delete(final long number) {
        throw new UnsupportedOperationException("Delete operation not yet implemented");
    }
}
