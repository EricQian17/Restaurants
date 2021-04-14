import java.util.HashMap;
import java.util.Map;

import dao.DistinctDAO;

public class DriverDistinctDAO {

	public static void main(String[] args) {
		
		Map<String, String> mapDB = new HashMap<>();
		mapDB.put("uri", "mongodb://eqian17:EEvee1337@cluster0-shard-00-00.1jdg9.mongodb.net:27017,cluster0-shard-00-01.1jdg9.mongodb.net:27017,cluster0-shard-00-02.1jdg9.mongodb.net:27017/sample_restaurants?ssl=true&replicaSet=atlas-9ozhs4-shard-0&authSource=admin&retryWrites=true&w=majority");
		mapDB.put("db", "sample_restaurants");
		mapDB.put("col", "restaurants");
		
		DistinctDAO.distinct(mapDB, "borough", String.class)
		.forEach(System.out::println);

	}

}
