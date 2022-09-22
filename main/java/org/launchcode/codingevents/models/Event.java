package org.launchcode.codingevents.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class Event extends AbstractEntity {


    @NotBlank (message= "Name is required")
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

    private EventType type;

    public Event(String name, String description, String location, String contactEmail, Boolean registered, EventType type) {

        this.name = name;
        this.description = description;
        this.location = location;
        this.contactEmail = contactEmail;
        this.registered = registered;
        this.type = type;

    }

    public Event() {}

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

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }



    @Override
    public String toString() {
        return name;
    }


}
