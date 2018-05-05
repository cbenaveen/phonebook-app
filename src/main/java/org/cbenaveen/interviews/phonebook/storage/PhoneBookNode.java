package org.cbenaveen.interviews.phonebook.storage;

import org.cbenaveen.interviews.phonebook.model.PhoneBookEntry;

import java.util.HashMap;
import java.util.Map;

/**
 * Trie node representation which will store the {@link PhoneBookEntry} in case
 * if its a leaf node.
 */
public class PhoneBookNode {
    /**
     * Phone book entry to be stored
     */
    private PhoneBookEntry phoneBookEntry;

    /**
     * {@link Character} representation of number
     */
    private char number;

    /**
     * All node entries
     */
    private final Map<Character, PhoneBookNode> entries;

    /**
     * Flag to indicate that this node is a leaf node
     */
    private boolean isLeaf;

    public PhoneBookNode() {
        this.entries = new HashMap();
    }

    public PhoneBookNode(char number) {
        this();
        this.number = number;
    }

    public PhoneBookEntry getPhoneBookEntry() {
        return phoneBookEntry;
    }

    public void setPhoneBookEntry(PhoneBookEntry phoneBookEntry) {
        this.phoneBookEntry = phoneBookEntry;
    }

    public char getNumber() {
        return number;
    }

    public Map<Character, PhoneBookNode> getEntries() {
        return entries;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    @Override
    public String toString() {
        return "[PhoneBookNode: Node Char:" + number + ", is Leaf? " + isLeaf + "]";
    }
}
