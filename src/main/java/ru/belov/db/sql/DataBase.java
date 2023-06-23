package ru.belov.db.sql;

import java.sql.*;

public class DataBase {
    private final Connection connection;

    public DataBase() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://dpg-ci8tqtenqql0ldeb37k0-a.frankfurt-postgres.render.com:5432/reactor_library", "user", "MQKUjW9ldYST3sRBV9EyuKLJ6ctDBJor");
    }

    public void calculateConsumption() throws SQLException {
        Statement st = connection.createStatement();
        String sql1 = """
                UPDATE public.units
                SET yearly_P = ( 365 * units.thermal_capacity * units.load_factor )/ (100 * 1000 * units.burnup)
                WHERE EXTRACT(YEAR FROM units.commercial_operation) < '2023' AND units.status = 'in operation';
                """;
        String sql2 = """
                UPDATE public.units
                SET yearly_P = first_load
                WHERE EXTRACT(YEAR FROM commercial_operation) = '2023' AND status = 'in operation';
                """;
        st.execute(sql1);
        st.execute(sql2);
    }

    public ResultSet calculateConsumptionByRegion() throws SQLException {
        Statement st = connection.createStatement();
        String sql = """
                SELECT region_name as "Регион", SUM(yearly_P) as "Объем ежегодного потребления,т."
                FROM public.units RIGHT JOIN public.sites ON units.site = sites.id
                RIGHT JOIN public.countries ON sites.place = countries.id
                RIGHT JOIN public.regions ON countries.region_id = regions.id
                GROUP BY region_name
                ORDER BY region_name;
                """;
        return st.executeQuery(sql);
    }
    public ResultSet calculateConsumptionByCountry() throws SQLException {
        Statement st = connection.createStatement();
        String sql = """
                SELECT country_name as "Страна", SUM(yearly_P) as "Объем ежегодного потребления,т." \s
                                           FROM public.units RIGHT JOIN public.sites ON units.site = sites.id
                                           RIGHT JOIN public.countries ON sites.place = countries .id
                                           GROUP BY country_name
                                           ORDER BY country_name;
                """;
        return st.executeQuery(sql);
    }
    public ResultSet calculateConsumptionByCompany() throws SQLException {
        Statement st = connection.createStatement();
        String sql = """
                SELECT companies_name as "Компания", SUM(yearly_P) as "Объем ежегодного потребления,т." \s
                                                                 FROM public.units RIGHT JOIN public.sites ON units.site = sites.id
                                                                 RIGHT JOIN public.companies ON sites.operator = companies.id
                                                                 GROUP BY companies_name
                                                                 ORDER BY companies_name;
                """;
        return st.executeQuery(sql);
    }
}
