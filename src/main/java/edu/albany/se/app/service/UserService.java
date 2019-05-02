package edu.albany.se.app.service;

import edu.albany.se.app.model.Car;
import edu.albany.se.app.model.Country;
import edu.albany.se.app.model.Location;
import edu.albany.se.app.repository.CarRepository;
import edu.albany.se.app.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.albany.se.app.model.User;
import edu.albany.se.app.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService
{
    public List<User> getAllUsers()
    {
        UserRepository userRepository = new UserRepository();
        List<User> users = userRepository.getAll();

        return users;
    }

    public User getById(int id)
    {
        UserRepository userRepository = new UserRepository();
        User user = userRepository.getById(id);

        return user;
    }

    public User getByEmail(String email)
    {
        UserRepository userRepository = new UserRepository();
        User user = userRepository.getByEmail(email);

        return user;
    }



    public String deleteUserById(int Id)
    {
        String result= "success";
        UserRepository userRepository = new UserRepository();
        User user= userRepository.getById(Id);
        if(user==null) {
            result = "Cannot find user";
            return result;
        }
        userRepository.delete(user);
        return result;
    }

    public void updateUser(int userId, String firstName, String lastName,int countryId, String licenseNumber, String email)
    {
        UserRepository userRepository = new UserRepository();
        User user = new User();
        user.setId(userId);
        Country C= CountryService.returnCountryById(countryId);
        Country c=new Country();
        c.setName(C.getName());
        user.setCountry(c);
        user.setCountryId(C.getId());
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setLicenseNumber(licenseNumber);
        user.setEmail(email);

        userRepository.update(user);
    }
}
