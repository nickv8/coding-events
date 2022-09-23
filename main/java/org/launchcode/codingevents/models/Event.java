package org.launchcode.codingevents.models;

import javax.persistence.*;
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

//    @AssertTrue
//    private Boolean registered;

    @ManyToOne
    @NotNull(message= "Category is required")
    private EventCategory eventCategory;

    public Event(String name, String description, String location, String contactEmail, Boolean registered, EventCategory eventCategory) {

        this.name = name;
        this.description = description;
        this.location = location;
        this.contactEmail = contactEmail;
//        this.registered = registered;
        this.eventCategory = eventCategory;

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

//    public Boolean getRegistered() {
//        return registered;
//    }

//    public void setRegistered(Boolean registered) {
//        this.registered = registered;
//    }

    public EventCategory getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }

    @Override
    public String toString() {
        return name;
    }


}
