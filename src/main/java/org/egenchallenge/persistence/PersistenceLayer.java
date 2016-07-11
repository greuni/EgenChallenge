package org.egenchallenge.persistence;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.egenchallenge.adapter.UserAdapter;
import org.egenchallenge.entity.User;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;

public class PersistenceLayer {

	public static boolean insertUser(User user)
	{
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("test");
		MongoCollection<Document> collection = db.getCollection("Users");
		boolean success = true;
		
		if (!userExists(user.getId()))
		{
			collection.insertOne(UserAdapter.toDocument(user));
		}
		else
			success = false;
		
		
		mongoClient.close();
		
		return success;
	}
	
	public static List<User> findAllUser()
	{
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("test");
		MongoCollection<Document> collection = db.getCollection("Users");
		
		List<User> users = new ArrayList<User>();
		
		MongoCursor<Document> cursor = collection.find().iterator();
		
		try{
			while(cursor.hasNext())
			{
				users.add(UserAdapter.toUser(cursor.next()));
			}
		}
		finally{
			cursor.close();
		}
		
		mongoClient.close();
		return users;
		
	}
	
	public static User findUser(String id)
	{
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("test");
		MongoCollection<Document> collection = db.getCollection("Users");
		
		User user = new User();
		
		Document doc = collection.find(eq("id", id)).first();
		
		if (doc != null)
		{
			user = UserAdapter.toUser(doc);
		}
		else
			user = null;
		
		mongoClient.close();
		return user;
	}

	public static boolean userExists(String id)
	{
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("test");
		MongoCollection<Document> collection = db.getCollection("Users");
		boolean exists = false;
		
		User user = new User();
		
		MongoCursor<Document> docs = collection.find(eq("id", id)).iterator();
		
		if (docs.hasNext())
		{
			exists = true;
		}
		
		mongoClient.close();
		return exists;
	}

	public static boolean updateUser(User user) {
		// TODO Auto-generated method stub
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("test");
		MongoCollection<Document> collection = db.getCollection("Users");
		boolean success = true;
		
		Document query = new Document();
		query.append("id", user.getId());
		
		Document update = new Document("$set", UserAdapter.toDocument(user));
		
		if (userExists(user.getId()))
		{
			collection.updateOne(query, update);
		}
		else{
			success = false;
		}
			
		mongoClient.close();
		return success;
	}

}
