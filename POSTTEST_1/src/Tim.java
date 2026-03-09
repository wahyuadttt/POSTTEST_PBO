import java.util.ArrayList;
import java.util.Scanner;

class Tim {
    String namaTim;
    String negaraAsal;
    String mesin;
    String namaChasis;

    Tim(String namaTim, String negaraAsal, String mesin, String namaChasis) {
        this.namaTim = namaTim;
        this.negaraAsal = negaraAsal;
        this.mesin = mesin;
        this.namaChasis = namaChasis;
    }

    void tampilkanInfo() {
        System.out.println("  Nama Tim      : " + this.namaTim);
        System.out.println("  Negara Asal   : " + this.negaraAsal);
        System.out.println("  Mesin         : " + this.mesin);
        System.out.println("  Nama Chasis   : " + this.namaChasis);
    }

    static void tambah(ArrayList<Tim> listTim, Scanner scanner) {
        System.out.println("\n--- Tambah Tim Baru ---");
        String namaTim    = Errorhandling.tidakBolehKosong("Nama Tim       : ", scanner);
        String negara     = Errorhandling.tidakBolehKosong("Negara Asal    : ", scanner);
        String mesin      = Errorhandling.tidakBolehKosong("Mesin          : ", scanner);
        String namaChasis = Errorhandling.tidakBolehKosong("Nama Chasis    : ", scanner);

        Tim t = new Tim(namaTim, negara, mesin, namaChasis);
        listTim.add(t);
        System.out.println("Tim \"" + namaTim + "\" berhasil ditambahkan!");
    }

    static void lihatSemua(ArrayList<Tim> listTim) {
        System.out.println("\n--- Daftar Tim F1 ---");
        if (listTim.isEmpty()) {
            System.out.println("Belum ada data tim.");
            return;
        }
        for (int i = 0; i < listTim.size(); i++) {
            System.out.println("\n[" + (i + 1) + "]");
            listTim.get(i).tampilkanInfo();
        }
    }

    static void ubah(ArrayList<Tim> listTim, Scanner scanner) {
        lihatSemua(listTim);
        if (listTim.isEmpty()) return;

        int index = Errorhandling.inputAngka("\nMasukkan nomor tim yang ingin diubah: ", scanner) - 1;
        if (index < 0 || index >= listTim.size()) {
            System.out.println("Nomor tidak valid.");
            return;
        }

        Tim t = listTim.get(index);
        System.out.println("Mengubah data: " + t.namaTim + " (kosongkan untuk tidak mengubah)");

        System.out.print("Nama Tim [" + t.namaTim + "]: ");
        String namaTim = scanner.nextLine().trim();
        if (!namaTim.isEmpty()) t.namaTim = namaTim;

        System.out.print("Negara Asal [" + t.negaraAsal + "]: ");
        String negara = scanner.nextLine().trim();
        if (!negara.isEmpty()) t.negaraAsal = negara;

        System.out.print("Mesin [" + t.mesin + "]: ");
        String mesin = scanner.nextLine().trim();
        if (!mesin.isEmpty()) t.mesin = mesin;

        System.out.print("Nama Chasis [" + t.namaChasis + "]: ");
        String namaChasis = scanner.nextLine().trim();
        if (!namaChasis.isEmpty()) t.namaChasis = namaChasis;

        System.out.println("Data tim berhasil diubah!");
    }

    static void hapus(ArrayList<Tim> listTim, Scanner scanner) {
        lihatSemua(listTim);
        if (listTim.isEmpty()) return;

        int index = Errorhandling.inputAngka("\nMasukkan nomor tim yang ingin dihapus: ", scanner) - 1;
        if (index < 0 || index >= listTim.size()) {
            System.out.println("Nomor tidak valid.");
            return;
        }

        String namaTim = listTim.get(index).namaTim;
        listTim.remove(index);
        System.out.println("Tim \"" + namaTim + "\" berhasil dihapus!");
    }
}