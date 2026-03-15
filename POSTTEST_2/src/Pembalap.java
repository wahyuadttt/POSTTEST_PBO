import java.util.ArrayList;
import java.util.Scanner;

public class Pembalap {
    private String nama;
    private String negara;
    private int nomorMobil;
    private String tim;

    public Pembalap(String nama, String negara, int nomorMobil, String tim) {
        this.nama = nama;
        this.negara = negara;
        this.nomorMobil = nomorMobil;
        this.tim = tim;
    }

    public String getNama() {
        return nama;
    }

    public String getNegara() {
        return negara;
    }

    public int getNomorMobil() {
        return nomorMobil;
    }

    public String getTim() {
        return tim;
    }

    public void setNama(String nama) {
        if (nama == null || nama.isEmpty()) {
            System.out.println("Nama tidak boleh kosong.");
        } else {
            this.nama = nama;
        }
    }

    public void setNegara(String negara) {
        if (negara == null || negara.isEmpty()) {
            System.out.println("Negara tidak boleh kosong.");
        } else {
            this.negara = negara;
        }
    }

    public void setNomorMobil(int nomorMobil) {
        if (nomorMobil <= 0) {
            System.out.println("Nomor mobil harus lebih dari 0.");
        } else {
            this.nomorMobil = nomorMobil;
        }
    }

    public void setTim(String tim) {
        if (tim == null || tim.isEmpty()) {
            System.out.println("Tim tidak boleh kosong.");
        } else {
            this.tim = tim;
        }
    }

    void tampilkanInfo() {
        System.out.println("  Nama          : " + this.nama);
        System.out.println("  Negara        : " + this.negara);
        System.out.println("  Nomor Mobil   : " + this.nomorMobil);
        System.out.println("  Tim           : " + this.tim);
    }

    public static void tambah(ArrayList<Pembalap> listPembalap, Scanner scanner) {
        System.out.println("\n--- Tambah Pembalap Baru ---");
        String nama     = Errorhandling.tidakBolehKosong("Nama Pembalap  : ", scanner);
        String negara   = Errorhandling.tidakBolehKosong("Negara         : ", scanner);
        int nomorMobil  = Errorhandling.wajibAngka("Nomor Mobil    : ", scanner);
        String tim      = Errorhandling.tidakBolehKosong("Tim            : ", scanner);

        Pembalap p = new Pembalap(nama, negara, nomorMobil, tim);
        listPembalap.add(p);
        System.out.println("Pembalap \"" + nama + "\" berhasil ditambahkan!");
    }

    public static void lihatSemua(ArrayList<Pembalap> listPembalap) {
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

    public static void ubah(ArrayList<Pembalap> listPembalap, Scanner scanner) {
        lihatSemua(listPembalap);
        if (listPembalap.isEmpty()) return;

        int index = Errorhandling.inputAngka("\nMasukkan nomor pembalap yang ingin diubah: ", scanner) - 1;
        if (index < 0 || index >= listPembalap.size()) {
            System.out.println("Nomor tidak valid.");
            return;
        }

        Pembalap p = listPembalap.get(index);
        System.out.println("Mengubah data: " + p.getNama() + " (kosongkan untuk tidak mengubah)");

        System.out.print("Nama Pembalap [" + p.getNama() + "]: ");
        String nama = scanner.nextLine().trim();
        if (!nama.isEmpty()) p.setNama(nama);

        System.out.print("Negara [" + p.getNegara() + "]: ");
        String negara = scanner.nextLine().trim();
        if (!negara.isEmpty()) p.setNegara(negara);

        while (true) {
            System.out.print("Nomor Mobil [" + p.getNomorMobil() + "]: ");
            String nomorStr = scanner.nextLine().trim();
            if (nomorStr.isEmpty()) break;
            try {
                p.setNomorMobil(Integer.parseInt(nomorStr));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka. Silakan isi kembali.");
            }
        }

        System.out.print("Tim [" + p.getTim() + "]: ");
        String tim = scanner.nextLine().trim();
        if (!tim.isEmpty()) p.setTim(tim);

        System.out.println("Data pembalap berhasil diubah!");
    }

    public static void hapus(ArrayList<Pembalap> listPembalap, Scanner scanner) {
        lihatSemua(listPembalap);
        if (listPembalap.isEmpty()) return;

        int index = Errorhandling.inputAngka("\nMasukkan nomor pembalap yang ingin dihapus: ", scanner) - 1;
        if (index < 0 || index >= listPembalap.size()) {
            System.out.println("Nomor tidak valid.");
            return;
        }

        String nama = listPembalap.get(index).getNama();
        listPembalap.remove(index);
        System.out.println("Pembalap \"" + nama + "\" berhasil dihapus!");
    }
}