package divideandconquer;

/**
 * @author Tosca
 * @date 2020/7/7
 */
public class Pow {
  // #1 暴力法 超时
  public double myPow0(double x, int n) {
    double val = 1;
    int N = Math.abs(n);
    for (int i = 0; i < N; i++) {
      val *= x;
    }
    if (n > 0) {
      return val;
    } else if (n == 0) {
      return 1;
    } else {
      return 1 / val;
    }
  }

  public double myPow(double x, int n) {
    if (n >= 0) {
      return absPow(x, n);
    } else if (n > Integer.MIN_VALUE) {
      return 1 / absPow(x, -n);
    } else {
      // integer 取值[-2147483648, 2147483647]
      // 2不能直接取-n，会越界
      return 1 / absPow(x * x, - (n / 2));
    }
  }

  private boolean isOdd(int n) {
    return n % 2 == 1;
  }

  private double absPow(double x, int n) {
    if (n == 0) return 1;
    if (n == 1) return x;
    double y = absPow(x, n / 2);
    if (isOdd(n)) {
      return y * y * x;
    } else {
      return y * y;
    }
  }

  // #3 logN
  public static double myPow2(double base, int exponent) {
    if(exponent == 0) return 1;
    double result = exponent % 2 == 0 ? myPow2(base * base, Math.abs(exponent) / 2)
        : base * myPow2(base * base, (Math.abs(exponent) - 1) / 2);
    if(result == 0.0 && exponent < 0) return result;
    return exponent < 0 ? 1.0 / result : result;
  }


  public static void main(String[] args) {
    Pow p = new Pow();
    System.out.println(p.myPow(2.0, -2147483648));
  }
}
