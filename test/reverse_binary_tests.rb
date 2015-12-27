require 'minitest/autorun'
require_relative '../src/reverse_binary'

# Task
# Your task will be to write a program for reversing numbers in binary.
# For instance, the binary representation of 13 is 1101, and reversing it
# gives 1011, which corresponds to number 11.
#
# Input
# The input contains a single line with an integer N, 1 ≤ N ≤ 1000000000.
#
# Output
# Output one line with one integer, the number we get by reversing the
# binary representation of N.
#
# Sample input 1
# 13
# Sample output 1
# 11
# Sample input 2
# 47
# Sample output 2
# 61

class TestReverseBinary < Minitest::Test
  def test_numbers
    assert_equal 1, ReverseBinary::convert(1)
    assert_equal 1, ReverseBinary::convert(2)
    assert_equal 3, ReverseBinary::convert(6)
    assert_equal 11, ReverseBinary::convert(13)
    assert_equal 61, ReverseBinary::convert(47)
    assert_equal 1, ReverseBinary::convert(1024)
  end

  def test_dec2reverse_bin
    assert_equal 1, ReverseBinary::dec2reverse_bin(1)
    assert_equal 1, ReverseBinary::dec2reverse_bin(2)
    assert_equal 1, ReverseBinary::dec2reverse_bin(4)
    assert_equal 101, ReverseBinary::dec2reverse_bin(5)
  end

  def test_bin2dec
    assert_equal 1, ReverseBinary::bin2dec(1)
    assert_equal 2, ReverseBinary::bin2dec(10)
    assert_equal 8, ReverseBinary::bin2dec(1000)
    assert_equal 1024, ReverseBinary::bin2dec(10000000000)
  end
end
