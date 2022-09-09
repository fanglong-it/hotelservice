package fiveman.hotelservice.repository;

import fiveman.hotelservice.entities.OverviewService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OverviewServiceRepository extends JpaRepository<OverviewService, Long> {
    OverviewService findOverviewServiceById(Long id);
}
