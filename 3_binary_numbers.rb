class BinaryNumbers
  class << self

    def convert(num)
      bin2dec(dec2reverse_bin(num))
    end

    def dec2reverse_bin(num)
      bin = []
      while num > 0
        bin.push(num % 2)
        num = num / 2
      end
      bin.join.to_i
    end

    def bin2dec(num)
      dec = 0
      while num > 0
        if num.to_s.size == 1 then
          dec += num
          break
        end
        dec += 2 ** (num.to_s.size - 1)
        num = num - (10 ** (num.to_s.size-1))
      end
      dec
    end

  end
end
