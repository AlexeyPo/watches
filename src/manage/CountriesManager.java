package manage;

import dao.CountryDAO;
import model.Country;

import java.util.List;

public class CountriesManager {

    CountryDAO countryDAO = new CountryDAO();

    public void showCountries() {
        System.out.println("-------- Countries --------------");
        List<Country> countries = countryDAO.showListOfCountries();

        for (Country country : countries) {
            System.out.println(country.getId() + " " + country.getName());
        }
        System.out.println("---------------------------------");
    }
}
