package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.TimeZone;
import java.util.Date;


@Controller
public class TimeController {
    @GetMapping("/worldclock")
    public String getTimeByTimeZone(ModelMap model, @RequestParam(name = "city",required = false) String city){
        if(city==null){
            return "index";
        }
        // Get current time at local
        Date date = new Date();
// Get timezone by the local
        TimeZone local = TimeZone.getDefault();
// Get timezone by the specified city
        TimeZone locale = TimeZone.getTimeZone(city);
        long locale_time = date.getTime() +
                (locale.getRawOffset()-local.getRawOffset());
        date.setTime(locale_time);
        model.addAttribute("city", city);
        model.addAttribute("date", date);
        return "index";
    }
}
