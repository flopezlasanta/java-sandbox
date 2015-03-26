package org.teraflopx.jsandboox.util;

// provides interface for sanity checks and enums of sanity checks plus helper for common logic
public final class SanityCheck {

  public enum SanityCheckResult {
    PASSED, FAILED, SKIPPED;
  }

  // no instantiation allowed
  private SanityCheck() {}

  // this is the interface to be implemented by sanity checks and enums of sanity checks
  public interface ISanityCheck<U> {
    SanityCheckResult check(U u);
  }

  // this is the common business logic required by enums of sanity checks to execute sanity checks
  public static <U> SanityCheckResult check(Class<? extends ISanityCheck<U>> clazz, U u) {
    SanityCheckResult result = SanityCheckResult.SKIPPED;
    try {
      result = clazz.newInstance().check(u); // note: consider using constructor instead
    } catch (Exception e) {
      result = SanityCheckResult.FAILED;
    }
    return result;
  }
}

// TODO add summary to describe reason (specially for skipped and failure)
