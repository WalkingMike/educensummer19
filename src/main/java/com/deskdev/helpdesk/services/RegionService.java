package com.deskdev.helpdesk.services;

import com.deskdev.helpdesk.model.Region;
import com.deskdev.helpdesk.repo.RegionRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class RegionService {
    @Autowired
    private final RegionRepo regionRepo;

    @Transactional
    public List<Region> getAll(){
        return regionRepo.findAll();
    }

    @Transactional
    public void addRegion(Region rgn){
        regionRepo.save(rgn);
    }

    @Transactional
    public void removeRegion(Long id){
        regionRepo.deleteById(id);
    }

}
