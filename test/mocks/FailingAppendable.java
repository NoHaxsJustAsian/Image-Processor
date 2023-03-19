package mocks;

import java.io.IOException;

/**
 * Class for mocks with failing appendable.
 */
public class FailingAppendable implements Appendable {

  /**
   * This is failing appendable mock.
   * @param csq
   *         The character sequence to append.  If {@code csq} is
   *         {@code null}, then the four characters {@code "null"} are
   *         appended to this Appendable.
   *
   * @return A reference to this {@code Appendable}.
   * @throws IOException if the transmission of the message to the data output fails.
   */
  @Override
  public Appendable append(CharSequence csq) throws IOException {
    throw new IOException();
  }

  /**
   * This is failing appendable mock.
   * @param csq
   *         The character sequence from which a subsequence will be
   *         appended.  If {@code csq} is {@code null}, then characters
   *         will be appended as if {@code csq} contained the four
   *         characters {@code "null"}.
   *
   * @param start
   *         The index of the first character in the subsequence
   *
   * @param end
   *         The index of the character following the last character in the
   *         subsequence
   *
   * @return A reference to this {@code Appendable}
   * @throws IOException if the transmission of the message to the data output fails.
   */
  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    throw new IOException();
  }

  /**
   * This is failing appendable mock.
   * @param c
   *         The character to append
   *
   * @return A reference to this {@code Appendable}
   * @throws IOException if the transmission of the message to the data output fails.
   */
  @Override
  public Appendable append(char c) throws IOException {
    throw new IOException();
  }
}
