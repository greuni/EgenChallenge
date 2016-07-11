package org.egenchallenge.adapter;

import org.bson.Document;
import org.egenchallenge.entity.Address;

public class AddressAdapter {

	public static Document toDocument(Address address) {
		// TODO Auto-generated method stub
		if (address == null)
			return null;
		
		Document doc = new Document();
		
		doc.append("street", address.getStreet());
		doc.append("city", address.getCity());
		doc.append("zip", address.getZip());
		doc.append("state", address.getState());
		doc.append("country", address.getCountry());
		
		return doc;
	}

	public static Address toAddress(Document doc) {
		// TODO Auto-generated method stub
		if (doc == null)
			return null;
		
		Address address = new Address();
		
		address.setStreet(doc.getString("street"));
		address.setCity(doc.getString("city"));
		address.setZip(doc.getString("zip"));
		address.setState(doc.getString("state"));
		address.setCountry(doc.getString("country"));
		
		return address;
	}

}
