package com.deskdev.helpdesk.repo;

import com.deskdev.helpdesk.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RegionRepo extends JpaRepository<Region, Long> {
}
