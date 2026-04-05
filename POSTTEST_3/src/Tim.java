import java.util.ArrayList;
import java.util.Scanner;

public class Tim extends Peserta {
    private String mesin;
    private String namaChasis;

    public Tim(String namaTim, String negaraAsal, String mesin, String namaChasis) {
        super(namaTim, negaraAsal);
        this.mesin = mesin;
        this.namaChasis = namaChasis;
    }

    public String getNamaTim() {
        return getNama();
    }

    public String getNegaraAsal() {
        return getNegara();
    }

    public String getMesin() {
        return mesin;
    }

    public String getNamaChasis() {
        return namaChasis;
    }

    public void setNamaTim(String namaTim) {
        setNama(namaTim);
    }

    public void setNegaraAsal(String negaraAsal) {
        setNegara(negaraAsal);
    }

    public void setMesin(String mesin) {
        if (mesin == null || mesin.isEmpty()) {
            System.out.println("Mesin tidak boleh kosong.");
        } else {
            this.mesin = mesin;
        }
    }

    public void setNamaChasis(String namaChasis) {
        if (namaChasis == null || namaChasis.isEmpty()) {
            System.out.println("Nama chasis tidak boleh kosong.");
        } else {
            this.namaChasis = namaChasis;
        }
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("  Nama Tim      : " + this.getNama());
        System.out.println("  Negara Asal   : " + this.getNegara());
        System.out.println("  Mesin         : " + this.mesin);
        System.out.println("  Nama Chasis   : " + this.namaChasis);
    }

    public static void tambah(ArrayList<Tim> listTim, Scanner scanner) {
        System.out.println("\n--- Tambah Tim Baru ---");
        String namaTim    = Errorhandling.tidakBolehKosong("Nama Tim       : ", scanner);
        String negara     = Errorhandling.tidakBolehKosong("Negara Asal    : ", scanner);
        String mesin      = Errorhandling.tidakBolehKosong("Mesin          : ", scanner);
        String namaChasis = Errorhandling.tidakBolehKosong("Nama Chasis    : ", scanner);

        Tim t = new Tim(namaTim, negara, mesin, namaChasis);
        listTim.add(t);
        System.out.println("Tim \"" + namaTim + "\" berhasil ditambahkan!");
    }

    public static void lihatSemua(ArrayList<Tim> listTim) {
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

    public static void ubah(ArrayList<Tim> listTim, Scanner scanner) {
        lihatSemua(listTim);
        if (listTim.isEmpty()) return;

        int index = Errorhandling.inputAngka("\nMasukkan nomor tim yang ingin diubah: ", scanner) - 1;
        if (index < 0 || index >= listTim.size()) {
            System.out.println("Nomor tidak valid.");
            return;
        }

        Tim t = listTim.get(index);
        System.out.println("Mengubah data: " + t.getNamaTim() + " (kosongkan untuk tidak mengubah)");

        System.out.print("Nama Tim [" + t.getNamaTim() + "]: ");
        String namaTim = scanner.nextLine().trim();
        if (!namaTim.isEmpty()) t.setNamaTim(namaTim);

        System.out.print("Negara Asal [" + t.getNegaraAsal() + "]: ");
        String negara = scanner.nextLine().trim();
        if (!negara.isEmpty()) t.setNegaraAsal(negara);

        System.out.print("Mesin [" + t.getMesin() + "]: ");
        String mesin = scanner.nextLine().trim();
        if (!mesin.isEmpty()) t.setMesin(mesin);

        System.out.print("Nama Chasis [" + t.getNamaChasis() + "]: ");
        String namaChasis = scanner.nextLine().trim();
        if (!namaChasis.isEmpty()) t.setNamaChasis(namaChasis);

        System.out.println("Data tim berhasil diubah!");
    }

    public static void hapus(ArrayList<Tim> listTim, Scanner scanner) {
        lihatSemua(listTim);
        if (listTim.isEmpty()) return;

        int index = Errorhandling.inputAngka("\nMasukkan nomor tim yang ingin dihapus: ", scanner) - 1;
        if (index < 0 || index >= listTim.size()) {
            System.out.println("Nomor tidak valid.");
            return;
        }

        String namaTim = listTim.get(index).getNamaTim();
        listTim.remove(index);
        System.out.println("Tim \"" + namaTim + "\" berhasil dihapus!");
    }
}