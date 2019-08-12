package com.deskdev.helpdesk.controller;

import com.deskdev.helpdesk.model.Region;
import com.deskdev.helpdesk.services.RegionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
public class RegionController {
    @Autowired
    private final RegionService regionService;

    @RequestMapping(value = "/region/selectall", method = RequestMethod.GET)
    public @ResponseBody List<Region> selectAll() {
        return regionService.getAll();
    }

    @RequestMapping(value = "/region/add", method = RequestMethod.POST)
    public void addRegion(@RequestBody Region region) {
        regionService.addRegion(region);
    }

    @RequestMapping(value = "/region/remove", method = RequestMethod.DELETE)
    public void removeRegion(@RequestParam Long id) {
        regionService.removeRegion(id);
    }

}