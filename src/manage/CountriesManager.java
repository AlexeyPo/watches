package manage;

import dao.CountryDAO;
import model.Country;

import java.util.List;

public class CountriesManager {

    CountryDAO countryDAO = new CountryDAO();

    public void showCountries() {
        System.out.println("-------- Countries --------------");
        List<Country> countries = countryDAO.showListOfCountries();

        countries.forEach(country -> System.out.println(country.getId() + " " + country.getName()));
        System.out.println("---------------------------------");
    }
}
