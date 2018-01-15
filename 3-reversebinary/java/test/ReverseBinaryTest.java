package test;

import org.junit.*;
import static org.junit.Assert.*;
import src.ReverseBinary;

public class ReverseBinaryTest {

  @Test
  public void testReverseBinary() {
      assertSame(1, ReverseBinary.convert(1));
      assertSame(1, ReverseBinary.convert(2));
      assertSame(3, ReverseBinary.convert(6));
      assertSame(11, ReverseBinary.convert(13));
      assertSame(61, ReverseBinary.convert(47));
      assertSame(1, ReverseBinary.convert(1024));
  }

  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("test.ReverseBinaryTest");
  }
}
