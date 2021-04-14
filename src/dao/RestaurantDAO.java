package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import model.Restaurant;
import template.IQuery;

public class RestaurantDAO implements IQuery<Integer, Restaurant> {
	
	@Override
	public List<Restaurant> findBy(Map<String, Object> mapQuery) {
		
		MongoClientURI uri = new MongoClientURI(
				"mongodb://eqian17:password1029@cluster0-shard-00-00.1jdg9.mongodb.net:27017,cluster0-shard-00-01.1jdg9.mongodb.net:27017,cluster0-shard-00-02.1jdg9.mongodb.net:27017/sample_restaurants?ssl=true&replicaSet=atlas-9ozhs4-shard-0&authSource=admin&retryWrites=true&w=majority");
		MongoClient mongoClient = new MongoClient(uri);
		MongoDatabase database = mongoClient.getDatabase("sample_restaurants");
		
		MongoCollection<Document> collection = database.getCollection("restaurants");

		
		String borough = mapQuery.get("borough").toString();
		String cuisine = mapQuery.get("cuisine").toString();
		String limit = mapQuery.get("limit").toString();
		int numLimit;
		try {
			numLimit = Integer.parseInt(limit);
		} catch (Exception e) {
			numLimit=0;
		}
		
		Document filter = new Document();
		if(!borough.equalsIgnoreCase("All"))
		{
			filter.append("borough",borough);
		}
		if(!cuisine.trim().equalsIgnoreCase("All"))
		{
			filter.append("cuisine", cuisine);
		}
		FindIterable<Document> rows;
		if(numLimit==0)
		{
			rows = collection.find(filter);
		}
		else
		{
			rows = collection.find(filter).limit(numLimit);
		}
		
		List<Restaurant> list = new ArrayList<>();
		Gson gson = new Gson();
		for (Document document : rows) {
			String json = document.toJson();
			Restaurant restaurant = gson.fromJson(json, Restaurant.class);

			list.add(restaurant);

		}

		mongoClient.close();

		return list;
		
	}

	@Override
	public List<Restaurant> findAll() {
		
		MongoClientURI uri = new MongoClientURI(
				"mongodb://eqian17:password1029@cluster0-shard-00-00.1jdg9.mongodb.net:27017,cluster0-shard-00-01.1jdg9.mongodb.net:27017,cluster0-shard-00-02.1jdg9.mongodb.net:27017/sample_restaurants?ssl=true&replicaSet=atlas-9ozhs4-shard-0&authSource=admin&retryWrites=true&w=majority");
		MongoClient mongoClient = new MongoClient(uri);
		MongoDatabase database = mongoClient.getDatabase("sample_restaurants");
		
		MongoCollection<Document> collection = database.getCollection("restaurants");

		FindIterable<Document> rows = collection.find();

		List<Restaurant> list = new ArrayList<>();
		Gson gson = new Gson();
		for (Document document : rows) {
			String json = document.toJson();
			Restaurant restaurant = gson.fromJson(json, Restaurant.class);

			list.add(restaurant);

		}

		mongoClient.close();

		return list;
	}

}
