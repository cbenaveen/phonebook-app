package org.cbenaveen.interviews.phonebook.model;

/**
 * Domain Object model represents the Phone book entry
 */
public class PhoneBookEntry {
    /**
     * Unique Phone Number
     */
    private final long phoneNumber;

    /**
     * User name
     */
    private String name;

    /**
     * Email Address
     */
    private String emailId;

    public PhoneBookEntry(final long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhoneBookEntry that = (PhoneBookEntry) o;

        return phoneNumber == that.phoneNumber;
    }

    @Override
    public int hashCode() {
        return (int) (phoneNumber ^ (phoneNumber >>> 32));
    }

    @Override
    public String toString() {
        return "[PhoneBookEntry: Number:" + phoneNumber
                + ", Name = " + name
                + ", EmailID = " + emailId
                + "]";
    }
}
