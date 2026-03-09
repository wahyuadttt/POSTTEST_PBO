import java.util.ArrayList;
import java.util.Scanner;

class JadwalBalap {
    String namaGrandPrix;
    String lokasi;
    String tanggal;
    int putaran;

    JadwalBalap(String namaGrandPrix, String lokasi, String tanggal, int putaran) {
        this.namaGrandPrix = namaGrandPrix;
        this.lokasi = lokasi;
        this.tanggal = tanggal;
        this.putaran = putaran;
    }

    void tampilkanInfo() {
        System.out.println("  Grand Prix    : " + this.namaGrandPrix);
        System.out.println("  Lokasi        : " + this.lokasi);
        System.out.println("  Tanggal       : " + this.tanggal);
        System.out.println("  Putaran ke-   : " + this.putaran);
    }

    static void urutkan(ArrayList<JadwalBalap> listJadwal) {
        int n = listJadwal.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (listJadwal.get(j).putaran > listJadwal.get(j + 1).putaran) {
                    JadwalBalap temp = listJadwal.get(j);
                    listJadwal.set(j, listJadwal.get(j + 1));
                    listJadwal.set(j + 1, temp);
                }
            }
        }
    }

    static void tambah(ArrayList<JadwalBalap> listJadwal, Scanner scanner) {
        System.out.println("\n--- Tambah Jadwal Balapan Baru ---");
        String namaGP  = Errorhandling.tidakBolehKosong("Nama Grand Prix : ", scanner);
        String lokasi  = Errorhandling.tidakBolehKosong("Lokasi          : ", scanner);
        String tanggal = Errorhandling.tidakBolehKosong("Tanggal         : ", scanner);
        int putaran    = Errorhandling.wajibAngka ("Putaran ke-     : ", scanner);

        JadwalBalap j = new JadwalBalap(namaGP, lokasi, tanggal, putaran);
        listJadwal.add(j);
        urutkan(listJadwal);
        System.out.println("Jadwal \"" + namaGP + "\" berhasil ditambahkan!");
    }

    static void lihatSemua(ArrayList<JadwalBalap> listJadwal) {
        System.out.println("\n--- Daftar Jadwal Balapan F1  ---");
        if (listJadwal.isEmpty()) {
            System.out.println("Belum ada data jadwal.");
            return;
        }
        for (int i = 0; i < listJadwal.size(); i++) {
            System.out.println("\n[" + (i + 1) + "]");
            listJadwal.get(i).tampilkanInfo();
        }
    }

    static void ubah(ArrayList<JadwalBalap> listJadwal, Scanner scanner) {
        lihatSemua(listJadwal);
        if (listJadwal.isEmpty()) return;

        int index = Errorhandling.inputAngka("\nMasukkan nomor jadwal yang ingin diubah: ", scanner) - 1;
        if (index < 0 || index >= listJadwal.size()) {
            System.out.println("Nomor tidak valid.");
            return;
        }

        JadwalBalap j = listJadwal.get(index);
        System.out.println("Mengubah data: " + j.namaGrandPrix + " (kosongkan untuk tidak mengubah)");

        System.out.print("Nama Grand Prix [" + j.namaGrandPrix + "]: ");
        String namaGP = scanner.nextLine().trim();
        if (!namaGP.isEmpty()) j.namaGrandPrix = namaGP;

        System.out.print("Lokasi [" + j.lokasi + "]: ");
        String lokasi = scanner.nextLine().trim();
        if (!lokasi.isEmpty()) j.lokasi = lokasi;

        System.out.print("Tanggal [" + j.tanggal + "]: ");
        String tanggal = scanner.nextLine().trim();
        if (!tanggal.isEmpty()) j.tanggal = tanggal;

        while (true) {
            System.out.print("Putaran ke- [" + j.putaran + "]: ");
            String putaranStr = scanner.nextLine().trim();
            if (putaranStr.isEmpty()) break;
            try {
                j.putaran = Integer.parseInt(putaranStr);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka. Silakan isi kembali.");
            }
        }

        urutkan(listJadwal);
        System.out.println("Data jadwal berhasil diubah!");
    }

    static void hapus(ArrayList<JadwalBalap> listJadwal, Scanner scanner) {
        lihatSemua(listJadwal);
        if (listJadwal.isEmpty()) return;

        int index = Errorhandling.inputAngka("\nMasukkan nomor jadwal yang ingin dihapus: ", scanner) - 1;
        if (index < 0 || index >= listJadwal.size()) {
            System.out.println("Nomor tidak valid.");
            return;
        }

        String namaGP = listJadwal.get(index).namaGrandPrix;
        listJadwal.remove(index);
        System.out.println("Jadwal \"" + namaGP + "\" berhasil dihapus!");
    }
}