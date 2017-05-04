package com.mystore.dao.service.impl;

import com.mystore.dao.service.SchemaDao;

public class SchemaDaoImpl implements SchemaDao {

	@Override
	public void createTables() {
		System.out.println("I'm creating tables.");
	}

	@Override
	public void dropTables() {
		System.out.println("I'm droping tables.");
	}

}
