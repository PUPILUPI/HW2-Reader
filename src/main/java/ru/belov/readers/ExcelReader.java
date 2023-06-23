package ru.belov.readers;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.belov.db.entity.*;
import ru.belov.reactors.Reactor;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ExcelReader {
    private final File file;
    private XSSFWorkbook workbook;

    public ExcelReader(String fileName) {
        this.file = new File(fileName);
    }

    public Collection<Unit> readUnits(String sheetName, Map<String, Reactor> library, Map<Long, Site> sitesById) throws IOException, InvalidFormatException {
        workbook = new XSSFWorkbook(this.file);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        List<Unit> units = new ArrayList<>();
        for (int rowNum = 1; rowNum < sheet.getPhysicalNumberOfRows(); rowNum++) {
            Unit unit = new Unit();
            Row row = sheet.getRow(rowNum);
            for (int col = 0; col < sheet.getRow(0).getPhysicalNumberOfCells(); col++) {
                Cell cell = row.getCell(col);
                if (col == 0) {
                    unit.setId((long) cell.getNumericCellValue());
                } else if (col == 1) {
                    unit.setCode(cell.getStringCellValue());
                } else if (col == 2) {
                    unit.setUnitName(cell.getStringCellValue());
                } else if (col == 3) {
                    unit.setSite(sitesById.get(getLong(cell)));
                } else if (col == 4) {
                    unit.setStatus(cell.getStringCellValue().trim());
                } else if (col == 5) {
                    unit.setType(cell.getStringCellValue());
                } else if (col == 6) {
                    unit.setModel(cell.getStringCellValue());
                } else if (col == 7) {
                    unit.setReactorClass(fixValue(cell.getStringCellValue()));
                } else if (col == 8) {
                    unit.setRuDesign(cell.getBooleanCellValue());
                } else if (col == 9) {
                    unit.setOperator((int) cell.getNumericCellValue());
                } else if (col == 10) {
                    unit.setNsssSupplier((int) cell.getNumericCellValue());
                } else if (col == 11) {
                    unit.setThermalCapacity((int) cell.getNumericCellValue());
                } else if (col == 12) {
                    unit.setGrossCapacity((int) cell.getNumericCellValue());
                } else if (col == 13) {
                    unit.setNetCapacity((int) cell.getNumericCellValue());
                } else if (col == 14) {
                    unit.setConstructionStart(cell.getDateCellValue());
                } else if (col == 15) {
                    unit.setCommercialOperation(cell.getDateCellValue());
                } else if (col == 16) {
                    unit.setDateShutdown(cell.getDateCellValue());
                } else if (col == 17) {
                    unit.setEnrichment(cell.getNumericCellValue());
                } else if (col == 18) {
                    if ((cell == null || cell.getCellType() == CellType.BLANK)) {
                        unit.setLoadFactor(90);
                    } else {
                        unit.setLoadFactor((int) cell.getNumericCellValue());
                    }
                }

            }
            Date date = new Date(2023, Calendar.JANUARY, 0);

            if (unit.getCommercialOperation() != null) {
                if (unit.getStatus().contains("in operation") && unit.getCommercialOperation().before(date)) {
                    unit.setBurnUp(library.get(unit.getReactorClass().trim()).getBurnUp());
                }
                if (unit.getStatus().contains("in operation") && unit.getCommercialOperation().after(date)) {
                    unit.setFirstLoad(library.get(unit.getReactorClass().trim()).getFirstLoad());
                }
            }

            units.add(unit);
            workbook.close();
        }

        return units;
    }

    public Collection<Site> readSites(String sheetName, Map<Long, Country> countryById, Map<Long, Company> companyById) throws IOException, InvalidFormatException {
        workbook = new XSSFWorkbook(this.file);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        List<Site> sites = new ArrayList<>();
        for (int rowNum = 1; rowNum < sheet.getPhysicalNumberOfRows(); rowNum++) {
            Site site = new Site();
            Row row = sheet.getRow(rowNum);
            for (int col = 0; col < sheet.getRow(0).getPhysicalNumberOfCells(); col++) {
                Cell cell = row.getCell(col);
                if (col == 0) {
                    site.setId(getLong(cell));
                } else if (col == 1) {
                    site.setNppName(cell.getStringCellValue());
                } else if (col == 2) {
                    site.setPlace(countryById.get(getLong(cell)));
                } else if (col == 3) {
                    site.setOwnerId(getLong(cell));
                } else if (col == 4) {
                    site.setOperator(companyById.get(getLong(cell)));
                } else if (col == 5) {
                    site.setBuilder(getLong(cell));
                }
            }
            sites.add(site);
        }
        workbook.close();
        return sites;
    }

    public Long getLong(Cell cell) {
        if (cell != null && cell.getCellType() != CellType.BLANK) {
            String value = cell.toString();
            if (!value.isBlank()) {
                return (long) Double.parseDouble(cell.toString());
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public Collection<Region> readRegions(String sheetName) throws IOException, InvalidFormatException {
        workbook = new XSSFWorkbook(this.file);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        List<Region> regions = new ArrayList<>();
        for (int rowNum = 1; rowNum < sheet.getPhysicalNumberOfRows(); rowNum++) {
            Region region = new Region();
            Row row = sheet.getRow(rowNum);
            for (int col = 0; col < sheet.getRow(0).getPhysicalNumberOfCells(); col++) {
                Cell cell = row.getCell(col);
                if (col == 0) {
                    region.setId((long) cell.getNumericCellValue());
                } else if (col == 1) {
                    region.setRegionName(cell.getStringCellValue());
                }
            }
            regions.add(region);
        }
        workbook.close();
        return regions;
    }

    public Collection<Country> readCountries(String sheetName) throws IOException, InvalidFormatException {
        workbook = new XSSFWorkbook(this.file);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        List<Country> countries = new ArrayList<>();
        for (int rowNum = 1; rowNum < sheet.getPhysicalNumberOfRows(); rowNum++) {
            Country country = new Country();
            Row row = sheet.getRow(rowNum);
            for (int col = 0; col < sheet.getRow(0).getPhysicalNumberOfCells(); col++) {
                Cell cell = row.getCell(col);
                if (col == 0) {
                    country.setId((long) cell.getNumericCellValue());
                } else if (col == 1) {
                    country.setCountryName(cell.getStringCellValue());
                } else if (col == 2) {
                    country.setSubregion(cell.getStringCellValue());
                } else if (col == 3) {
                    country.setRegion(cell.getStringCellValue());
                } else if (col == 4) {
                    country.setRegionId((long) cell.getNumericCellValue());
                }
            }
            countries.add(country);
        }
        workbook.close();
        return countries;
    }

    public Collection<Company> readCompanies(String sheetName, Map<Long, Country> countryById) throws IOException, InvalidFormatException {
        workbook = new XSSFWorkbook(this.file);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        List<Company> companies = new ArrayList<>();
        for (int rowNum = 1; rowNum < sheet.getPhysicalNumberOfRows(); rowNum++) {
            Company company = new Company();
            Row row = sheet.getRow(rowNum);
            for (int col = 0; col < sheet.getRow(0).getPhysicalNumberOfCells(); col++) {
                Cell cell = row.getCell(col);
                if (col == 0) {
                    company.setId((long) cell.getNumericCellValue());
                } else if (col == 1) {
                    company.setCompaniesName(cell.getStringCellValue());
                } else if (col == 2) {
                    if (cell != null) {
                        company.setFullName(cell.getStringCellValue());
                    }
                } else if (col == 3) {
                    if (cell != null) {
                        long countryId = ((long) cell.getNumericCellValue());
                        company.setCountry(countryById.get(countryId));
                    }
                }
            }
            companies.add(company);
        }
        workbook.close();
        return companies;
    }

    public String fixValue(String oldValue) {
        if (oldValue.contains("AGR")) {
            return "MAGNOX";
        }
        if (oldValue.contains("CNP-1000")) {
            return "CPR-1000";
        }
        if (oldValue.contains("PWR")) {
            return "PWR";
        }
        if (oldValue.contains("VVER")) {
            return "VVER-1000";
        }
        return oldValue;
    }

}

