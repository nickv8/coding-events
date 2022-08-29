package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {


    private static List<Event> events = new ArrayList<>();
    
    @GetMapping
    public String displayedEvents(Model model) {;
        model.addAttribute("title", "All Events");
        model.addAttribute("events", events);
        return "events/index";
    }


    @GetMapping("create")

    public String displayCreatedEventsForm(){

    public String displayCreatedEventsForm(Model model){
        model.addAttribute("title", "Create Event");

        return "events/create";
    }

    @PostMapping("create")


    public String processCreateEventForm(@RequestParam String eventName) {
        events.add(eventName);

    public String createEvent(@RequestParam String eventName, String description) {
        events.put(eventName, description);


    public String processCreateEventForm(@RequestParam String eventName, @RequestParam String eventDescription) {
        events.add(new Event(eventName, eventDescription));

        return "redirect:";  //instructs browser to redirect to the root path
    }


}
