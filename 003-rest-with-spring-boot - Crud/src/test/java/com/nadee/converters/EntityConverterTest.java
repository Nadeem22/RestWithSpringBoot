package com.nadee.converters;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.nadeem.converters.EntityConverter;
import com.nadeem.converters.mocks.MockPerson;
import com.nadeem.model.Person;
import com.nadeem.vo.v1.PersonVo;

public class EntityConverterTest {

	MockPerson inputObject;

	@Before
	public void setUp() {
		inputObject = new MockPerson();
	}

	@Test
	public void parseEntityToVOTest() {
		PersonVo output = EntityConverter.parseObject(inputObject.mockEntity(), PersonVo.class);
		Assert.assertEquals(Long.valueOf(0L), output.getId());
		Assert.assertEquals("First Name Test0", output.getFirstName());
		Assert.assertEquals("Last Name Test0", output.getLastName());
		Assert.assertEquals("Addres Test0", output.getAddress());
		Assert.assertEquals("Male", output.getGender());
	}

	@Test
	public void parseEntityListToVOListTest() {
		List<PersonVo> outputList = EntityConverter.parseListObject(inputObject.mockEntityList(), PersonVo.class);
		PersonVo outputZero = outputList.get(0);

		Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
		Assert.assertEquals("First Name Test0", outputZero.getFirstName());
		Assert.assertEquals("Last Name Test0", outputZero.getLastName());
		Assert.assertEquals("Addres Test0", outputZero.getAddress());
		Assert.assertEquals("Male", outputZero.getGender());

		PersonVo outputSeven = outputList.get(7);

		Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
		Assert.assertEquals("First Name Test7", outputSeven.getFirstName());
		Assert.assertEquals("Last Name Test7", outputSeven.getLastName());
		Assert.assertEquals("Addres Test7", outputSeven.getAddress());
		Assert.assertEquals("Female", outputSeven.getGender());

		PersonVo outputTwelve = outputList.get(12);

		Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
		Assert.assertEquals("First Name Test12", outputTwelve.getFirstName());
		Assert.assertEquals("Last Name Test12", outputTwelve.getLastName());
		Assert.assertEquals("Addres Test12", outputTwelve.getAddress());
		Assert.assertEquals("Male", outputTwelve.getGender());
	}

	@Test
	public void parseVOToEntityTest() {
		Person output = EntityConverter.parseObject(inputObject.mockVO(), Person.class);
		Assert.assertEquals(Long.valueOf(0L), output.getId());
		Assert.assertEquals("First Name Test0", output.getFirstName());
		Assert.assertEquals("Last Name Test0", output.getLastName());
		Assert.assertEquals("Addres Test0", output.getAddress());
		Assert.assertEquals("Male", output.getGender());
	}

	@Test
	public void parserVOListToEntityListTest() {
		List<Person> outputList = EntityConverter.parseListObject(inputObject.mockVOList(), Person.class);
		Person outputZero = outputList.get(0);

		Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
		Assert.assertEquals("First Name Test0", outputZero.getFirstName());
		Assert.assertEquals("Last Name Test0", outputZero.getLastName());
		Assert.assertEquals("Addres Test0", outputZero.getAddress());
		Assert.assertEquals("Male", outputZero.getGender());

		Person outputSeven = outputList.get(7);

		Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
		Assert.assertEquals("First Name Test7", outputSeven.getFirstName());
		Assert.assertEquals("Last Name Test7", outputSeven.getLastName());
		Assert.assertEquals("Addres Test7", outputSeven.getAddress());
		Assert.assertEquals("Female", outputSeven.getGender());

		Person outputTwelve = outputList.get(12);

		Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
		Assert.assertEquals("First Name Test12", outputTwelve.getFirstName());
		Assert.assertEquals("Last Name Test12", outputTwelve.getLastName());
		Assert.assertEquals("Addres Test12", outputTwelve.getAddress());
		Assert.assertEquals("Male", outputTwelve.getGender());
	}
}
