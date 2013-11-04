package com.fionchou.layout.test;

import junit.framework.Assert;

import com.fionchou.service.PersonService;

import android.test.AndroidTestCase;

public class PersonServiceTest extends AndroidTestCase {

	public void testSave() {
		PersonService personService = new PersonService();
		personService.savePerson(null);
		
	}
	
	public void testAdd() {
		PersonService personService = new PersonService();
		int actual =  personService.add(1, 2);
		Assert.assertEquals(3, actual);
		
	}
}
