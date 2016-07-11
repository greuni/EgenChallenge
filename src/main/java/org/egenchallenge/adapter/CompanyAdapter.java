package org.egenchallenge.adapter;

import org.bson.Document;
import org.egenchallenge.entity.Company;

public class CompanyAdapter {

	public static Document toDocument(Company company) {
		// TODO Auto-generated method stub
		if (company == null)
			return null;
		
		Document doc = new Document();
		
		doc.append("name", company.getName());
		doc.append("website", company.getWebsite());
		
		return doc;
	}

	public static Company toCompany(Document doc) {
		// TODO Auto-generated method stub
		if (doc == null)
			return null;
		
		Company company = new Company();
		
		company.setName(doc.getString("name"));
		company.setWebsite(doc.getString("website"));
		
		return company;
	}

}
