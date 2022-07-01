package com.leaper.controllers;

import com.leaper.entities.Timetable;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TimetableRestController extends ServiceController {

    @PatchMapping("/timetable/update")
    public Timetable updateTimetable(@RequestBody Timetable timetable) {
        timetableService.updateTimetable(timetable.getFirst(), timetable.getSecond(), timetable.getThird(),
                timetable.getFourth(), timetable.getFifth(), timetable.getSixth(), timetable.getSeventh(),
                timetable.getEighth(), timetable.getId());

        return timetable;
    }
}
