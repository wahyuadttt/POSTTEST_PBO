import java.util.ArrayList;
import java.util.Scanner;

public class JadwalBalap {
    private String namaGrandPrix;
    private String lokasi;
    private String tanggal;
    protected int putaran;

    public JadwalBalap(String namaGrandPrix, String lokasi, String tanggal, int putaran) {
        this.namaGrandPrix = namaGrandPrix;
        this.lokasi = lokasi;
        this.tanggal = tanggal;
        this.putaran = putaran;
    }

    public String getNamaGrandPrix() {
        return namaGrandPrix;
    }

    public String getLokasi() {
        return lokasi;
    }

    public String getTanggal() {
        return tanggal;
    }

    public int getPutaran() {
        return putaran;
    }

    public void setNamaGrandPrix(String namaGrandPrix) {
        if (namaGrandPrix == null || namaGrandPrix.isEmpty()) {
            System.out.println("Nama Grand Prix tidak boleh kosong.");
        } else {
            this.namaGrandPrix = namaGrandPrix;
        }
    }

    public void setLokasi(String lokasi) {
        if (lokasi == null || lokasi.isEmpty()) {
            System.out.println("Lokasi tidak boleh kosong.");
        } else {
            this.lokasi = lokasi;
        }
    }

    public void setTanggal(String tanggal) {
        if (tanggal == null || tanggal.isEmpty()) {
            System.out.println("Tanggal tidak boleh kosong.");
        } else {
            this.tanggal = tanggal;
        }
    }

    public void setPutaran(int putaran) {
        if (putaran <= 0) {
            System.out.println("Putaran harus lebih dari 0.");
        } else {
            this.putaran = putaran;
        }
    }

    void tampilkanInfo() {
        System.out.println("  Grand Prix    : " + this.namaGrandPrix);
        System.out.println("  Lokasi        : " + this.lokasi);
        System.out.println("  Tanggal       : " + this.tanggal);
        System.out.println("  Putaran ke-   : " + this.putaran);
    }

    public static void urutkan(ArrayList<JadwalBalap> listJadwal) {
        int n = listJadwal.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (listJadwal.get(j).getPutaran() > listJadwal.get(j + 1).getPutaran()) {
                    JadwalBalap temp = listJadwal.get(j);
                    listJadwal.set(j, listJadwal.get(j + 1));
                    listJadwal.set(j + 1, temp);
                }
            }
        }
    }

    public static void tambah(ArrayList<JadwalBalap> listJadwal, Scanner scanner) {
        System.out.println("\n--- Tambah Jadwal Balapan Baru ---");
        String namaGP  = Errorhandling.tidakBolehKosong("Nama Grand Prix : ", scanner);
        String lokasi  = Errorhandling.tidakBolehKosong("Lokasi          : ", scanner);
        String tanggal = Errorhandling.tidakBolehKosong("Tanggal         : ", scanner);
        int putaran    = Errorhandling.wajibAngka("Putaran ke-     : ", scanner);

        JadwalBalap j = new JadwalBalap(namaGP, lokasi, tanggal, putaran);
        listJadwal.add(j);
        urutkan(listJadwal);
        System.out.println("Jadwal \"" + namaGP + "\" berhasil ditambahkan!");
    }

    public static void lihatSemua(ArrayList<JadwalBalap> listJadwal) {
        System.out.println("\n--- Daftar Jadwal Balapan F1 ---");
        if (listJadwal.isEmpty()) {
            System.out.println("Belum ada data jadwal.");
            return;
        }
        for (int i = 0; i < listJadwal.size(); i++) {
            System.out.println("\n[" + (i + 1) + "]");
            listJadwal.get(i).tampilkanInfo();
        }
    }

    public static void ubah(ArrayList<JadwalBalap> listJadwal, Scanner scanner) {
        lihatSemua(listJadwal);
        if (listJadwal.isEmpty()) return;

        int index = Errorhandling.inputAngka("\nMasukkan nomor jadwal yang ingin diubah: ", scanner) - 1;
        if (index < 0 || index >= listJadwal.size()) {
            System.out.println("Nomor tidak valid.");
            return;
        }

        JadwalBalap j = listJadwal.get(index);
        System.out.println("Mengubah data: " + j.getNamaGrandPrix() + " (kosongkan untuk tidak mengubah)");

        System.out.print("Nama Grand Prix [" + j.getNamaGrandPrix() + "]: ");
        String namaGP = scanner.nextLine().trim();
        if (!namaGP.isEmpty()) j.setNamaGrandPrix(namaGP);

        System.out.print("Lokasi [" + j.getLokasi() + "]: ");
        String lokasi = scanner.nextLine().trim();
        if (!lokasi.isEmpty()) j.setLokasi(lokasi);

        System.out.print("Tanggal [" + j.getTanggal() + "]: ");
        String tanggal = scanner.nextLine().trim();
        if (!tanggal.isEmpty()) j.setTanggal(tanggal);

        while (true) {
            System.out.print("Putaran ke- [" + j.getPutaran() + "]: ");
            String putaranStr = scanner.nextLine().trim();
            if (putaranStr.isEmpty()) break;
            try {
                j.setPutaran(Integer.parseInt(putaranStr));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka. Silakan isi kembali.");
            }
        }

        urutkan(listJadwal);
        System.out.println("Data jadwal berhasil diubah!");
    }

    public static void hapus(ArrayList<JadwalBalap> listJadwal, Scanner scanner) {
        lihatSemua(listJadwal);
        if (listJadwal.isEmpty()) return;

        int index = Errorhandling.inputAngka("\nMasukkan nomor jadwal yang ingin dihapus: ", scanner) - 1;
        if (index < 0 || index >= listJadwal.size()) {
            System.out.println("Nomor tidak valid.");
            return;
        }

        String namaGP = listJadwal.get(index).getNamaGrandPrix();
        listJadwal.remove(index);
        System.out.println("Jadwal \"" + namaGP + "\" berhasil dihapus!");
    }
}