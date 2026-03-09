import java.util.Scanner;

class Errorhandling {

    static String tidakBolehKosong(String label, Scanner scanner) {
        String input = "";
        while (input.isEmpty()) {
            System.out.print(label);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input tidak boleh kosong. Silakan isi kembali.");
            }
        }
        return input;
    }

    static int wajibAngka(String label, Scanner scanner) {
        while (true) {
            System.out.print(label);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input tidak boleh kosong. Silakan isi kembali.");
                continue;
            }
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka. Silakan isi kembali.");
            }
        }
    }

    static int inputAngka(String label, Scanner scanner) {
        while (true) {
            System.out.print(label);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka. Silakan isi kembali.");
            }
        }
    }
}
