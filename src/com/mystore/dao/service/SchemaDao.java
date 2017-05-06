package com.mystore.dao.service;

public interface SchemaDao {
	public void createTables(String getTablesScriptPath);
	public void dropTables(String getTablesScriptPath);
}
