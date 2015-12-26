require 'minitest/autorun'
require_relative '3_binary_numbers'

class TestBinaryNumbers < Minitest::Test
  def test_numbers
    assert_equal 11, BinaryNumbers::convert(13)
    assert_equal 61, BinaryNumbers::convert(47)
  end
end
