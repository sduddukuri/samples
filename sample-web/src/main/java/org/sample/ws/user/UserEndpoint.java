package org.sample.ws.user;

public class UserEndpoint implements MarshallingPersonService {

	@Override
	public PersonResponse getPersons(GetPersonsRequest request) {
		new Person();
		return new PersonResponse().withPerson(
				Person.withId(1).withFirstName("Joe").withLastName("Smith"),
				new Person().withId(2).withFirstName("John").withLastName("Jackson"));
	}

}
