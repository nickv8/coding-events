package org.launchcode.codingevents.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.constraints.*;
;




public class Event {

    private int id;
    private static int nextId = 1;


    @NotBlank
    @Size (min = 3, max = 50, message="Name must be between 3 and 50 characters.")
    private String name;
    @Size (max = 500, message="Description is too long.")
    private String description;

    @NotBlank
    @Size (max=150, message="Location is too long.")
    private String location;

    @NotBlank
    @Email(message = "Invalid email. Try again.")
    private String contactEmail;

    @AssertTrue
    private Boolean registered;

    public Event(String name, String description, String location, String contactEmail, Boolean registered) {
        this();
        this.name = name;
        this.description = description;
        this.location = location;
        this.contactEmail = contactEmail;
        this.registered = registered;

    }

    public Event() {
        this.id = nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getRegistered() {
        return registered;
    }

    public void setRegistered(Boolean registered) {
        this.registered = registered;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
