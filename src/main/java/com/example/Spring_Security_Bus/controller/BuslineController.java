package com.example.Spring_Security_Bus.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.Spring_Security_Bus.entity.Busline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import com.example.Spring_Security_Bus.service.BuslineService;




@Controller
@RequestMapping("/")
@AllArgsConstructor
public class BuslineController {
    @Autowired
    private BuslineService buslineService;

    @RequestMapping(value = "/buslines", method = RequestMethod.GET)
    public ModelAndView busline() {
        return new ModelAndView("busline-form", "command", new Busline());
    }

    @RequestMapping(value = "/busline", method = RequestMethod.POST)
    public String addNewBusline(@ModelAttribute("command") Busline busline, ModelMap modelMap) {
        buslineService.insertBusline(busline);
        return "redirect:busline-list";
    }

    @RequestMapping(value = "/busline-list", method = RequestMethod.GET)
    public String getListBusline(ModelMap modelMap) {
        modelMap.put("buslines", buslineService.getListBusline());
        return "busline-list";
    }

    @GetMapping(value = "/busline-remove/{id}")
    public String removeBusline(@PathVariable("id") int id, ModelMap modelMap) {
        buslineService.removeBusline(id);
            return "redirect:/busline-list";

    }

    @RequestMapping(value = "/busline-update/{id}", method = RequestMethod.GET)
    public ModelAndView viewUpdateBusline(@PathVariable("id") int id) {
        Busline busline = buslineService.getById(id);
        return new ModelAndView("update-form-busline", "command", busline);
    }

    @RequestMapping(value = "/busline-update/{id}", method = RequestMethod.POST)
    public String updateBusline(@ModelAttribute("command") Busline busline, ModelMap modelMap) {
        buslineService.updateBusline(busline);
            return "redirect:/busline-list";
    }
}
