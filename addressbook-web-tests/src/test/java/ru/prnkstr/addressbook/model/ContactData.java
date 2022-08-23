package ru.prnkstr.addressbook.model;

public record ContactData(String firstName, String middleName, String lastName, String nickname, String title,
                          String company, String address, String homePhone, String mobilePhone, String workPhone,
                          String email) {
}