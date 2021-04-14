import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.RestaurantDAO;
import model.Restaurant;

public class DriverRestaurantDAO {

	public static void main(String[] args) {
		
		List<Restaurant> list = new ArrayList<>();
		RestaurantDAO dao = new RestaurantDAO();
		
		Map<String,Object> mapQuery = new HashMap<>();
		mapQuery.put("borough", "Bronx");
		mapQuery.put("cuisine", "American");
		
		list = dao.findBy(mapQuery);
		
		list.forEach(System.out::println);
		
		

	}

}
