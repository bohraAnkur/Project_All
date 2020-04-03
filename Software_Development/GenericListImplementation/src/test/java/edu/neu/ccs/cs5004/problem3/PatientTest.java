package edu.neu.ccs.cs5004.problem3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PatientTest {

  private Name patientName;
  private Name otherPatientName;

  private Urgency patientUrgency;
  private Urgency otherPatientUrgency;

  private Patient patientOne;
  private Patient patientTwo;
  private Patient patientThree;
  private Patient samePatient;
  private Patient differentPatient;
  private Patient nullPatient;
  

  @Before
  public void setUp() throws Exception {
    patientName = new Name("Sharice", "Gilbert");
    otherPatientName = new Name ("John", "Doe");

    patientUrgency = new Urgency(5);
    otherPatientUrgency = new Urgency(2);

    patientOne = new Patient(patientUrgency, patientName);
    patientTwo = new Patient(patientUrgency, patientName);
    patientThree = new Patient(patientUrgency, patientName);
    samePatient = patientOne;
    differentPatient = new Patient(otherPatientUrgency, otherPatientName);
    nullPatient = null;

  }

  @Test
  public void compareTo() {
    Assert.assertEquals(patientOne.compareTo(patientTwo), 0);
    Assert.assertEquals(patientOne.compareTo(differentPatient), 1);
    Assert.assertEquals(differentPatient.compareTo(patientOne), -1);
  }

  @Test
  public void getUrgency() {
    Assert.assertEquals(patientOne.getUrgency(), patientUrgency);
  }

  @Test
  public void getValue() {
    Assert.assertEquals(patientOne.getValue(), patientName);
  }

  @Test
  public void moreUrgentThan() {
    Assert.assertEquals(patientOne.moreUrgentThan(differentPatient), patientOne);
    Assert.assertEquals(differentPatient.moreUrgentThan(patientOne), patientOne);
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(this.patientOne.equals(this.patientTwo));
    Assert.assertTrue(this.patientTwo.equals(this.patientOne));
    Assert.assertTrue(this.patientOne.equals(this.samePatient));
    Assert.assertTrue(this.patientOne.equals(this.patientOne));
    Assert.assertEquals(this.patientOne.equals(this.patientTwo) &&
            this.patientTwo.equals(this.patientThree),
        this.patientThree.equals(this.patientOne));
    Assert.assertFalse(this.patientOne.equals(this.differentPatient));
    Assert.assertFalse(this.patientOne.equals(this.nullPatient));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(this.patientOne.equals(this.patientTwo),
        this.patientOne.hashCode() == this.patientTwo.hashCode());
    Assert.assertEquals(this.patientOne.equals(this.samePatient),
        this.patientOne.hashCode() == this.samePatient.hashCode());
  }

  @Test
  public void testToString() {
    String equalsString = "Patient{urgency=Urgency{value=5}, name=Name{first='Sharice', last='Gilbert'}, orderNumber=0}";
    Assert.assertEquals(patientOne.toString(), equalsString);
  }
}