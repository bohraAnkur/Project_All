package edu.neu.ccs.cs5004.assignment9;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IndividualInfoTest {

  String[] info;
  String[] info2;
  String[] info3;
  IndividualInfo person;
  IndividualInfo person2;
  IndividualInfo samePerson;
  IndividualInfo differentPerson;
  IndividualInfo nullPerson;
  String notAPerson;
  IndividualInfo person3;
  IndividualInfo newPerson;

  @Before
  public void setUp() throws Exception {
    info = new String[12];
    info[0] = "Sharice";
    info[1] = "Gilbert";
    info[2] = "Google";
    info[3] = "223 City Ave";
    info[4] = "Seattle";
    info[5] = "King";
    info[6] = "Washington";
    info[7] = "98434";
    info[8] = "555-555-5555";
    info[9] = "444-444-4444";
    info[10] = "email@gmail.com";
    info[11] = "website.com";

    info3 = new String[12];
    info3[0] = "Sharice";
    info3[1] = "Gilbert";
    info3[2] = "Google";
    info3[3] = "223 City Ave";
    info3[4] = "Seattle";
    info3[5] = "King";
    info3[6] = "Washington";
    info3[7] = "98434";
    info3[8] = "555-555-5555";
    info3[9] = "444-444-4444";
    info3[10] = "email@gmail.com";
    info3[11] = "website.com";

    info2 = new String[12];
    info2[0] = "Danitra";
    info2[1] = "Gilbert";
    info2[2] = "Google";
    info2[3] = "223 City Ave";
    info2[4] = "Seattle";
    info2[5] = "King";
    info2[6] = "Washington";
    info2[7] = "98434";
    info2[8] = "333-333-3333";
    info2[9] = "444-444-4444";
    info2[10] = "email@gmail.com";
    info2[11] = "website.com";
    person = new IndividualInfo(info);
    person2 = new IndividualInfo(info);
    person3 = new IndividualInfo(info);
    samePerson = person;
    differentPerson = new IndividualInfo(info2);
    nullPerson = null;
    notAPerson = "I am not a person!";
  }

  @Test (expected = IllegalArgumentException.class)
  public void get() {
    Assert.assertTrue(person.get("first_name").equals("Sharice"));
    Assert.assertTrue(person.get("last_name").equals("Gilbert"));
    Assert.assertTrue(person.get("company_name").equals("Google"));
    Assert.assertTrue(person.get("address").equals("223 City Ave"));
    Assert.assertTrue(person.get("city").equals("Seattle"));
    Assert.assertTrue(person.get("county").equals("King"));
    Assert.assertTrue(person.get("state").equals("Washington"));
    Assert.assertTrue(person.get("zip").equals("98434"));
    Assert.assertTrue(person.get("phone1").equals("555-555-5555"));
    Assert.assertTrue(person.get("phone2").equals("444-444-4444"));
    Assert.assertTrue(person.get("email").equals("email@gmail.com"));
    Assert.assertTrue(person.get("web").equals("website.com"));
    person.get("hello");
  }

  @Test
  public void generateFileName() {
    Assert.assertEquals(person.generateFileName(), "Sharice_Gilbert_555-555-5555.txt");
  }

  @Test
  public void testToString() {
    System.out.println(person.toString());
    String theString = "IndividualInfo{firstName='Sharice', lastName='Gilbert', companyName='Google', address='223 City Ave', city='Seattle', county='King', state='Washington', zip='98434', phone1='555-555-5555', phone2='444-444-4444', email='email@gmail.com', webPage='website.com'}";
    Assert.assertTrue(person.toString().equals(theString));
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(this.person.equals(this.person2));
    Assert.assertTrue(this.person2.equals(this.person));
    Assert.assertTrue(this.person.equals(this.samePerson));
    Assert.assertTrue(this.person.equals(this.person));
    Assert.assertEquals(this.person.equals(this.person2) &&
        this.person2.equals(this.person3), this.person3.equals(this.person));
    Assert.assertFalse(this.person.equals(this.differentPerson));
    Assert.assertFalse(this.person.equals(this.nullPerson));
    Assert.assertFalse(this.person.equals(this.notAPerson));

    for (int i = 0; i < 12; i++) {
      String tempString = this.info3[i];
      this.info3[i] = "hello";
      newPerson = new IndividualInfo(info3);
      Assert.assertFalse(this.person.equals(newPerson));
      this.info3[i] = tempString;
    }
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(this.person.equals(this.person2), this.person.hashCode() ==
        this.person2.hashCode());
    Assert.assertEquals(this.person.equals(this.samePerson), this.person.hashCode()
        == this.samePerson.hashCode());
  }
}