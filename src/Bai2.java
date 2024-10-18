import java.util.Stack;
import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số nguyên dương: ");
        int number = scanner.nextInt();
        System.out.println("Hệ nhị phân: " + toBinary(number));
        System.out.println("Hệ cơ số 8: " + toOctal(number));
        System.out.println("Hệ cơ số 16: " + toHexadecimal(number));
    }

    private static String toBinary(int number) {
        return convertBase(number, 2);
    }

    private static String toOctal(int number) {
        return convertBase(number, 8);
    }

    private static String toHexadecimal(int number) {
        return convertBase(number, 16);
    }

    private static String convertBase(int number, int base) {
        Stack<Character> stack = new Stack<>();
        String digits = "0123456789ABCDEF";
        while (number > 0) {
            stack.push(digits.charAt(number % base));
            number /= base;
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }
}
