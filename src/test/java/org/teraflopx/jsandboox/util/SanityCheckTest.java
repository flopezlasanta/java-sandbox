package org.teraflopx.jsandboox.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.teraflopx.jsandboox.util.SanityCheck.SanityCheckResult;

public class SanityCheckTest {

  @Test
  public void testSanityChecks() {
    assertEquals(SampleSanityCheck.PASSED_SANITY_CHECK.check("string"), SanityCheckResult.PASSED);
    assertEquals(SampleSanityCheck.FAILED_SANITY_CHECK.check("string"), SanityCheckResult.FAILED);
  }

  // make it static because it is inner and otherwise it will failed to instantiate
  public static class PassedSanityCheckA implements SanityCheck.ISanityCheck<String> {

    @Override
    public SanityCheckResult check(String string) {
      return SanityCheckResult.PASSED;
    }
  }

  // make it static because it is inner and otherwise it will failed to instantiate
  public static class FailedSanityCheckB implements SanityCheck.ISanityCheck<String> {

    @Override
    public SanityCheckResult check(String string) {
      return SanityCheckResult.FAILED;
    }
  }

  private enum SampleSanityCheck implements SanityCheck.ISanityCheck<String> {

    PASSED_SANITY_CHECK(PassedSanityCheckA.class), FAILED_SANITY_CHECK(FailedSanityCheckB.class);

    private Class<? extends SanityCheck.ISanityCheck<String>> clazz;

    private SampleSanityCheck(Class<? extends SanityCheck.ISanityCheck<String>> clazz) {
      this.clazz = clazz;
    }

    @Override
    public SanityCheckResult check(String string) {
      return SanityCheck.check(clazz, string); // using helper...
    }
  }

}
