package ru.belov.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.belov.db.entity.*;
import ru.belov.db.repository.*;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class ComputingService {
    private final CompanyRepository companyRepository;
    private final CountryRepository countryRepository;
    private final RegionRepository regionRepository;
    private final SiteRepository siteRepository;
    private final UnitRepository unitRepository;

    public Collection<Unit> createUnits(Collection<Unit> units) {
        return unitRepository.saveAll(units);
    }

    public Collection<Region> createRegions(Collection<Region> regions) {
        return regionRepository.saveAll(regions);
    }

    public Collection<Country> createCountries(Collection<Country> countries) {
        return countryRepository.saveAll(countries);
    }

    public Collection<Site> createSites(Collection<Site> sites) {
        return siteRepository.saveAll(sites);
    }

    public Collection<Company> createCompanies(Collection<Company> companies) {
        return companyRepository.saveAll(companies);
    }
}
