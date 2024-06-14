package com.example.demo.User;

public class UserDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String currency;

    public Long getId() {
        return id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserDTO(Long id, String name, String surname, String email, String currency) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.currency = currency;
    }

    public static UserDTO fromUser(User user) {
        return new UserDTO(user.getId(), user.getName(), user.getSurname(), user.getEmail(), user.getCurrency());
    }
}
