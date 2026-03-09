import java.util.ArrayList;
import java.util.Scanner;

class Pembalap {
    String nama;
    String negara;
    int nomorMobil;
    String tim;

    Pembalap(String nama, String negara, int nomorMobil, String tim) {
        this.nama = nama;
        this.negara = negara;
        this.nomorMobil = nomorMobil;
        this.tim = tim;
    }

    void tampilkanInfo() {
        System.out.println("  Nama          : " + this.nama);
        System.out.println("  Negara        : " + this.negara);
        System.out.println("  Nomor Mobil   : " + this.nomorMobil);
        System.out.println("  Tim           : " + this.tim);
    }

    static void tambah(ArrayList<Pembalap> listPembalap, Scanner scanner) {
        System.out.println("\n--- Tambah Pembalap Baru ---");
        String nama     = Errorhandling.tidakBolehKosong("Nama Pembalap  : ", scanner);
        String negara   = Errorhandling.tidakBolehKosong("Negara         : ", scanner);
        int nomorMobil  = Errorhandling.wajibAngka ("Nomor Mobil    : ", scanner);
        String tim      = Errorhandling.tidakBolehKosong("Tim            : ", scanner);

        Pembalap p = new Pembalap(nama, negara, nomorMobil, tim);
        listPembalap.add(p);
        System.out.println("Pembalap \"" + nama + "\" berhasil ditambahkan!");
    }

    static void lihatSemua(ArrayList<Pembalap> listPembalap) {
        System.out.println("\n--- Daftar Pembalap F1 ---");
        if (listPembalap.isEmpty()) {
            System.out.println("Belum ada data pembalap.");
            return;
        }
        for (int i = 0; i < listPembalap.size(); i++) {
            System.out.println("\n[" + (i + 1) + "]");
            listPembalap.get(i).tampilkanInfo();
        }
    }

    static void ubah(ArrayList<Pembalap> listPembalap, Scanner scanner) {
        lihatSemua(listPembalap);
        if (listPembalap.isEmpty()) return;

        int index = Errorhandling.inputAngka("\nMasukkan nomor pembalap yang ingin diubah: ", scanner) - 1;
        if (index < 0 || index >= listPembalap.size()) {
            System.out.println("Nomor tidak valid.");
            return;
        }

        Pembalap p = listPembalap.get(index);
        System.out.println("Mengubah data: " + p.nama + " (kosongkan untuk tidak mengubah)");

        System.out.print("Nama Pembalap [" + p.nama + "]: ");
        String nama = scanner.nextLine().trim();
        if (!nama.isEmpty()) p.nama = nama;

        System.out.print("Negara [" + p.negara + "]: ");
        String negara = scanner.nextLine().trim();
        if (!negara.isEmpty()) p.negara = negara;

        while (true) {
            System.out.print("Nomor Mobil [" + p.nomorMobil + "]: ");
            String nomorStr = scanner.nextLine().trim();
            if (nomorStr.isEmpty()) break;
            try {
                p.nomorMobil = Integer.parseInt(nomorStr);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka. Silakan isi kembali.");
            }
        }

        System.out.print("Tim [" + p.tim + "]: ");
        String tim = scanner.nextLine().trim();
        if (!tim.isEmpty()) p.tim = tim;

        System.out.println("Data pembalap berhasil diubah!");
    }

    static void hapus(ArrayList<Pembalap> listPembalap, Scanner scanner) {
        lihatSemua(listPembalap);
        if (listPembalap.isEmpty()) return;

        int index = Errorhandling.inputAngka("\nMasukkan nomor pembalap yang ingin dihapus: ", scanner) - 1;
        if (index < 0 || index >= listPembalap.size()) {
            System.out.println("Nomor tidak valid.");
            return;
        }

        String nama = listPembalap.get(index).nama;
        listPembalap.remove(index);
        System.out.println("Pembalap \"" + nama + "\" berhasil dihapus!");
    }
}