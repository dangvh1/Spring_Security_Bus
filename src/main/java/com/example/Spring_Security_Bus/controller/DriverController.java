package com.example.Spring_Security_Bus.controller;


import org.springframework.web.bind.annotation.*;
import com.example.Spring_Security_Bus.entity.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import com.example.Spring_Security_Bus.service.DriverService;



import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class DriverController {
    @Autowired
    private DriverService driverService;

    @RequestMapping(value = "/drivers", method = RequestMethod.GET)
    public ModelAndView driver() {
        return new ModelAndView("driver-form", "command", new Driver());
    }

    @RequestMapping(value = "/driver", method = RequestMethod.POST)
    public String addNewDriver(@ModelAttribute("command") Driver driver) {
        driverService.insertDriver(driver);
            return "redirect:driver-list";
    }

    @RequestMapping(value = "/driver-list", method = RequestMethod.GET)
    public String getListDriver(ModelMap modelMap) {
        modelMap.put("drivers", driverService.getListDriver());
        return "driver-list";
    }


    @GetMapping(value = "/driver-remove")
    public String removeDriver(@PathVariable() int id) {
        driverService.removeDriver(id) ;
        return "redirect:/driver-list";

    }

    @RequestMapping(value = "/driver-update/{id}", method = RequestMethod.GET)
    public ModelAndView viewUpdate(@PathVariable("id") int id) {
        Driver driver = driverService.getById(id);
        return new ModelAndView("update-form-driver", "command", driver);
    }

    @RequestMapping(value = "/driver-update", method = RequestMethod.POST)
    public String updateDriver(@ModelAttribute("command") Driver driver) {
        driverService.updateDriver(driver);
        return "redirect:/driver-list";

    }
    @RequestMapping(value = "/driver-find", method = RequestMethod.GET)
    public String findDriverByName(@RequestParam String search ) {
        return "redirect:/driver-list-search"+"?name="+search;
    }

    @ModelAttribute("driverlever")
    public Map<String, String> getDriverlever() {
        Map<String, String> driverlever = new HashMap<>();
        driverlever.put("A","Loại A");
        driverlever.put("B","loại B");
        driverlever.put("C","loại C");
        driverlever.put("D","loại D");
        driverlever.put("F","loại F");
        return driverlever;
    }
}
