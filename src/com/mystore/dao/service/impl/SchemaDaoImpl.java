package com.mystore.dao.service.impl;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.StringTokenizer;
import com.mystore.dao.service.SchemaDao;
import com.mystore.dao.service.util.ConnectionProvider;
import com.mystore.dao.service.util.DBMetaData;

public class SchemaDaoImpl implements SchemaDao {
	@Override
	public void createTables(String getTablesScriptPath) {
		System.out.println(">> createTables");
		try {
			List<String> tables = (new DBMetaData()).getTables();
			FileInputStream fin = new FileInputStream(getTablesScriptPath);
			byte data[] = new byte[fin.available()];
			fin.read(data);
			fin.close();
			String str = new String(data);
			StringTokenizer st = new StringTokenizer(str, "/");
			while (st.hasMoreTokens()) {
				boolean tableExist = false;
				String query = st.nextToken();
				if (query.trim().equals("stop")) {
					break;
				}
				for (String table : tables) {
					if (query.split(" ")[2].equalsIgnoreCase(table)) {
						System.out.println(table + " table already exists.");
						tableExist = true;
					}
				}
				if (!tableExist) {
					try (Connection con = ConnectionProvider.getConnection(); Statement stmt = con.createStatement();) {
						stmt.execute(query);
						System.out.println(query.split(" ")[2] + " table is successfully created.");
					} catch (Exception e) {
						System.out.println(this.getClass().getSimpleName() + " " + e);
					}
				}
				System.out.println("<< createTables");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void dropTables(String getTablesScriptPath) {
		DBMetaData dbMetaData = new DBMetaData();
		List<String> dbTables = dbMetaData.getTables();
		List<String> applicationTables = dbMetaData.getApplicationTables(getTablesScriptPath);
		for (String appTable : applicationTables) {
			for (String dbTable : dbTables) {
				if (appTable.equalsIgnoreCase(dbTable)) {
					System.out.println("Dropping table: " + appTable);
					try (Connection con = ConnectionProvider.getConnection(); Statement stmt = con.createStatement();) {
						stmt.execute("DROP TABLE " + appTable);
						System.out.println("DROP TABLE " + appTable);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}