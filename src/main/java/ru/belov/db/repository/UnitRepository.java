package ru.belov.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.belov.db.entity.Unit;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {
}
