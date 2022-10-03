package org.launchcode.codingevents.models;

import javax.persistence.*;
import javax.validation.Valid;
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

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    @NotNull
    private EventDetails eventDetails;

    public Event(String name, String location, EventCategory eventCategory) {

        this.name = name;
        this.location = location;
        this.eventCategory = eventCategory;

    }

    public Event() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public EventDetails getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(EventDetails eventDetails) {
        this.eventDetails = eventDetails;
    }

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
