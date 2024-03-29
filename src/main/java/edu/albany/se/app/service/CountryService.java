package edu.albany.se.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.albany.se.app.model.Country;
import edu.albany.se.app.repository.CountryRepository;

@Service
public class CountryService
{
    private CountryRepository countryRepository;

    public void updateCountry(int userId, String name)
    {
        CountryRepository countryRepository = new CountryRepository();
        Country country = new Country();
        country.setId(userId);
        country.setName(name);
        countryRepository.update(country);
    }
    public static Country returnCountryById(int countryId){
        Country c=CountryRepository.getCountry(countryId);
        if(c==null)
            return null;
        return c;
    }
}
