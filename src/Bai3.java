import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số nguyên dương: ");
        int number = scanner.nextInt();

        // Kiểm tra xem số nhập vào có phải là số nguyên dương không
        if (number < 0) {
            System.out.println("Số phải là số nguyên dương.");
            return;
        }

        // Chuyển đổi số nguyên sang hệ nhị phân
        String binaryRepresentation = toBinary(number);
        System.out.println("Hệ nhị phân của số nguyên: " + binaryRepresentation);
    }

    private static String toBinary(int number) {
        // Sử dụng hàng đợi để lưu trữ các bit của số nguyên
        Queue<Integer> queue = new LinkedList<>();

        if (number == 0) {
            return "0";
        }

        // Chuyển đổi số nguyên sang hệ nhị phân
        while (number > 0) {
            queue.add(number % 2); // Lưu bit vào hàng đợi
            number /= 2; // Chia số nguyên cho 2
        }

        // Xây dựng chuỗi nhị phân từ hàng đợi
        StringBuilder binary = new StringBuilder();
        while (!queue.isEmpty()) {
            binary.append(queue.poll());
        }

        // Đảo ngược chuỗi để có thứ tự đúng
        return binary.reverse().toString();
    }
}
