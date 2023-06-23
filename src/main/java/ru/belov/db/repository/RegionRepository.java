package ru.belov.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.belov.db.entity.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
}
