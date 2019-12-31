package manage;

import dao.CountryDAO;
import model.Country;

public class CountriesManager {

    CountryDAO countryDAO = new CountryDAO();

    public void showCountries() {
        System.out.println("-------- Countries --------------");
        for (Country country : countryDAO.findListOfCountries()) {
            System.out.println(country.getId() + " " + country.getName());
        }
        System.out.println("---------------------------------");
    }
}
