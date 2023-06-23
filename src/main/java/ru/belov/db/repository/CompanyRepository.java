package ru.belov.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.belov.db.entity.Company;
@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
