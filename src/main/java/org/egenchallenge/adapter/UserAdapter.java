package org.egenchallenge.adapter;

import org.bson.Document;
import org.egenchallenge.entity.User;

public class UserAdapter {
	
	public static Document toDocument(User user)
	{
		Document doc = new Document();
		
		doc.append("id", user.getId());
		doc.append("firstName", user.getFirstName());
		doc.append("lastName", user.getLastName());
		doc.append("email", user.getEmail());
		doc.append("dateCreated", user.getDateCreated());
		doc.append("company", CompanyAdapter.toDocument(user.getCompany()));
		doc.append("address", AddressAdapter.toDocument(user.getAddress()));
		
		return doc;
		
	}
	
	public static User toUser(Document doc)
	{
		User user = new User();
		
		user.setId(doc.getString("id"));
		user.setFirstName(doc.getString("firstName"));
		user.setLastName(doc.getString("lastName"));
		user.setEmail(doc.getString("email"));
		user.setDateCreated(doc.getString("dateCreated"));
		user.setAddress(AddressAdapter.toAddress((Document) doc.get("address")));
		user.setCompany(CompanyAdapter.toCompany((Document) doc.get("company")));
		return user;
		
	}
}
