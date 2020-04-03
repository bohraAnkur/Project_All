package edu.neu.ccs.cs5004;

import org.junit.Assert;

public class TestCaseUtils {

  private static void assertPassesStandardEqualsTest(Object original, Object copyOfOriginal,
                                                     Object anotherCopyOfOriginal,
                                                     Object sameReferenceAsOriginal) {
    Assert.assertTrue(original.equals(copyOfOriginal));
    Assert.assertTrue(copyOfOriginal.equals(original));
    Assert.assertTrue(original.equals(sameReferenceAsOriginal));
    Assert.assertTrue(original.equals(original));
    Assert.assertEquals(original.equals(copyOfOriginal) &&
            copyOfOriginal.equals(anotherCopyOfOriginal),
        original.equals(anotherCopyOfOriginal));
    Assert.assertNotEquals(original, new Object());
    Assert.assertFalse(original.equals(null));
  }

  public static void assertPassesEqualsTest(Object original, Object copyOfOriginal,
                                            Object anotherCopyOfOriginal,
                                             Object sameReferenceAsOriginal,
                                             Object differentFromOriginal) {
    assertPassesStandardEqualsTest(original, copyOfOriginal, anotherCopyOfOriginal,
        sameReferenceAsOriginal);
    Assert.assertNotEquals(original, differentFromOriginal);
  }

  public static void assertPassesAlwaysEqualsTest(Object original, Object copyOfOriginal,
                                     Object anotherCopyOfOriginal, Object sameReferenceAsOriginal,
                                                  Object differentFromOriginal) {
    assertPassesStandardEqualsTest(original, copyOfOriginal, anotherCopyOfOriginal,
        sameReferenceAsOriginal);
    Assert.assertEquals(original, differentFromOriginal);
  }

  public static void assertPassesHashCodeTest(Object original, Object copyOfOriginal,
                                              Object sameReferenceAsOriginal) {
    Assert.assertEquals(original.equals(copyOfOriginal),
        copyOfOriginal.hashCode() == original.hashCode());
    Assert.assertEquals(original.equals(sameReferenceAsOriginal),
        original.hashCode() == sameReferenceAsOriginal.hashCode());
  }

}
