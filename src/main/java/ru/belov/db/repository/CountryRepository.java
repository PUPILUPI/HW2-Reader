package ru.belov.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.belov.db.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
