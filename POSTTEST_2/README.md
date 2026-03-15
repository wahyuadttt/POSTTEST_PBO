Nama  : Wahyu Aditya <br>
Nim   : 2409106067 <br>
Kelas : B1'24 <br>

1. Isi Program <br>
   Program yang dibuat ini berfungsi untuk melakukan crud (Untuk admin) dan read only untuk user
   sesuai dengan tema yang sudah dipilih. Tema yang dipilih praktikan adalah sistem
   informasi balapan formula 1. Untuk data yang bisa diubah sendiri ada 3, yaitu data pembalap, tim, dan jadwal balapan.
   Untuk data pembalap sendiri, yang bisa dicrud adalah nama, negara, nomor, dan tim. Untuk data tim yang bisa dicrud
   ada nama timnya, asal negara, mesin yang digunakan, dan nama chasisnya. Dan untul jadwalbalap yang bisa dicrud
   ada nama balapannya, lokasi, tanggal, dan putaran ke berapa balapan tersebut. Pada posttest ini, program juga menerapkan
   konsep enkapsulasi dengan menggunakan access modifier dan getter setter pada setiap class<br>
   <br>

2. Penerapan Enkapsulasi <br>
   2.1 Access Modifier Private <br>
       Digunakan pada semua property di class pembalap, tim, dan jadwalbalap (kecuali properti putaran) <br>
       ![Property_Pembalap](assets/Property_Pembalap.png) <br>
   <br>
       ![Property_Tim](assets/Property_Tim.png) <br>
   <br>
       ![Property_Jadwal](assets/Property_Jadwal.png) <br>
   <br>
   <br>
   2.2 Access Modifier Public <br>
       Digunakan pada semua getter, setter, constructor, dan crud <br>
       ![Public_Pembalap](assets/Public_Pembalap.png) <br>
   <br>
       ![Public_Tim](assets/Public_Tim.png) <br>
   <br>
       ![Public_Jadwal](assets/Public_Jadwal.png) <br>
   <br>
   <br>
   2.3 Access Modifier Protected <br>
       Digunakan pada property putaran <br>
       ![Property_Jadwal](assets/Property_Jadwal.png) <br>
   <br>
   <br>
   2.4 Access Modifer Default <br>
       Digunakan pada method tampilkaninfo dan semua method yang ada di class errorhandling <br>
   <br>
   2.5 Getter dan Setter <br>
       Untuk mengambil data property yang bersifat private, diperlukan method getter. Sementara untuk mengubah nilai
       property yang bersifat private, digunakan method setter, karena tidak bisa langsung diubah dari luar calss. Pada
       posttest ini, Getter dan setter digunakan pada seluruh property di class pembalap, tim, dan jadwal. Pada setter
       juga terdapat validasi data seperti tidak boleh kosong, dan kalau input angka tidak boleh bernilai kurang atau
       sama dengan 0<br>
   <br>
3. Output Program <br>
   2.1 Output Awal <br>
   ![Output Awal](assets/Output_Awal.png) <br>
   <br>

   2.2 Login Admin <br>
   ![Login Admin](assets/Login_Admin.png) <br>
   <br>

   2.3 Menu Admin <br>
   ![Menu Admin](assets/Menu_Admin.png) <br>
   <br>

   2.4 Menu User <br>
   ![Menu User](assets/Menu_User.png) <br>
   <br>

   2.5 Menu Crud Pembalap <br>
   ![Menu Crud Pembalap](assets/Menu_Pembalap.png) <br>
   <br>

   2.6 Menu Crud Tim <br>
   ![Menu Crud Tim](assets/Menu_Tim.png) <br>
   <br>

   2.7 Menu Crud Jadwal <br>
   ![Menu Crud Jadwal](assets/Menu_Jadwal_Balapan.png) <br>
   <br>