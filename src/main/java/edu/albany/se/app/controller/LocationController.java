package edu.albany.se.app.controller;

import edu.albany.se.app.model.Country;
import edu.albany.se.app.model.Location;
import edu.albany.se.app.service.CountryService;
import edu.albany.se.app.service.LocationService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class LocationController
{
	@GetMapping("/location/all")
	public String allLocations()
	{
		LocationService locationService = new LocationService();
		List<Location> locations = locationService.getAllLocations();

		JSONArray jsonArray = new JSONArray();

		for (Location location : locations)
		{
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", location.getId());
			jsonObject.put("name", location.getName());
			jsonObject.put("description", location.getDescription());

			jsonArray.put(jsonObject);
		}

		return jsonArray.toString();
	}

	@PostMapping("/location/delete")
	public String deleteLocationById(@RequestParam int id)
	{
		LocationService locationService = new LocationService();
		String result=locationService.deleteLocationById(id);
        return result;
	}

	@PostMapping("/location/update")
	public void update(@RequestParam int id, @RequestParam String name, @RequestParam String description)
	{
		LocationService locationService = new LocationService();
		locationService.updateLocation(id, name, description);
	}

	@GetMapping("country/getById")
	public Country getById(@RequestParam int id)
	{
		Country c=CountryService.returnCountryById(id);
		return c;
	}
}
