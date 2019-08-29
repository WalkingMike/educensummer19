package com.deskdev.helpdesk.controller;

import com.deskdev.helpdesk.model.Region;
import com.deskdev.helpdesk.services.RegionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
public class RegionController {
    @Autowired
    private final RegionService regionService;

    @GetMapping (value = "/region/selectall")
    public @ResponseBody List<Region> selectAll() {
        return regionService.getAll();
    }

    @PostMapping(value = "/region/add")
    @PreAuthorize("hasRole('admin')")
    public void addRegion(@RequestBody Region region) {
        regionService.addRegion(region);
    }

    @DeleteMapping(value = "/region/remove")
    @PreAuthorize("hasRole('admin')")
    public void removeRegion(@RequestParam Long id) {
        regionService.removeRegion(id);
    }

}