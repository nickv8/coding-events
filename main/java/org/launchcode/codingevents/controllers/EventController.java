package org.launchcode.codingevents.controllers;

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

    private static HashMap<String, String> events = new HashMap<>();
//    @GetMapping
//    public String displayedEvents(Model model){
//        model.addAttribute("events", events);
//        return "events/index";
//    }

    @GetMapping
    public String displayedEvents(Model model) {;
        events.put("Menteaship","A fun meetup for connecting with mentors");
        events.put("Code With Pride","A fun meetup sponsored by LaunchCode");
        events.put("Javascripty", "An imaginary meetup for Javascript developers");
        events.put("Code With Pride","A fun meetup sponsored by LaunchCode");
        events.put("Javascripty", "An imaginary meetup for Javascript developers");
        model.addAttribute("events", events);
        return "events/index";
    }




    //lives at /events/create
    @GetMapping("create")
    public String displayCreatedEventsForm(){
        return "events/create";
    }

    //lives at /events/create
    @PostMapping("create")

    public String processCreateEventForm(@RequestParam String eventName) {
        events.add(eventName);

    public String createEvent(@RequestParam String eventName, String description) {
        events.put(eventName, description);

        return "redirect:";  //instructs browser to redirect to the root path
    }


}
