package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {
    
    @GetMapping
    public String displayedEvents(Model model) {;
        model.addAttribute("title", "All Events");
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }


    @GetMapping("create")

    public String displayCreatedEventsForm(){

    public String displayCreatedEventsForm(Model model){
        model.addAttribute("title", "Create Event");

        return "events/create";
    }

    @PostMapping("create")

    public String processCreateEventForm(@ModelAttribute Event newEvent) {
        EventData.add(newEvent);

        return "redirect:";  //instructs browser to redirect to the root path
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventForm(@RequestParam(required = false) int[] eventIds) {

        if(eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }

        return "redirect:";

    }


}
