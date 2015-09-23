package lv.lgs.hibernate.controller;

import lv.lgs.hibernate.daoImpl.CityDaoImpl;
import lv.lgs.hibernate.daoImpl.LanguageDaoImpl;
import lv.lgs.hibernate.domain.City;
import lv.lgs.hibernate.domain.Language;

public class Main {

	public static void main(String[] args) {
		LanguageDaoImpl language = new LanguageDaoImpl();
		language.save(new Language("IT"));
		language.save(new Language("EN"));
		language.closeSessionFactory();

//		CityDaoImpl city = new CityDaoImpl();
//		city.save(new City("Rome"));
//		city.save(new City("Florence"));
//		city.save(new City("Naples"));
//		city.closeSessionFactory();
	}

}
