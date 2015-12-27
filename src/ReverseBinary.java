package src;

public class ReverseBinary {

  public static void main(String[] args){
    int num;
    try {
      num = Integer.parseInt(args[0]);
    } catch (Exception e) {
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
