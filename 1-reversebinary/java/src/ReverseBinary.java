package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseBinary {

  public static void main(String[] args){

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num;
    System.out.print("Enter Integer: ");
    try {
      num = Integer.parseInt(br.readLine());
    } catch (Exception e) {
      System.out.println("Invalid input");
      return;
    }
    ReverseBinary.run(num);
  }

  private static void run(int num){
    System.out.println(ReverseBinary.convert(num));
  }

  public static Integer convert(int num){
    return bin2dec(dec2reverse_bin(num));
  }

  public static Integer bin2dec(String bin){
    return Integer.parseInt(bin, 2);
  }

  private static String dec2reverse_bin(int num) {
    String bin = Integer.toString(num, 2);
    return new StringBuilder(bin).reverse().toString();
  }
}
