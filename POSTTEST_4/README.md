Nama  : Wahyu Aditya <br>
Nim   : 2409106067 <br>
Kelas : B1'24 <br>

1. Isi Program <br>
   Program yang dibuat ini merupakan lanjutan dari posttest sebelumnya yang menerapkan konsep polymorphism.  Program
   berfungsi untuk melakukan crud (Untuk admin) dan read only untuk user sesuai dengan tema yang sudah dipilih. Tema
   yang dipilih praktikan adalah sistem informasi balapan formula 1. Untuk data yang bisa diubah sendiri ada 3, yaitu
   data pembalap, tim, dan jadwal balapan. Untuk data pembalap sendiri, yang bisa dicrud adalah nama, negara, nomor,
   dan tim. Untuk data tim yang bisa dicrud ada nama timnya, asal negara, mesin yang digunakan, dan nama chasisnya. 
   Dan untuk jadwalbalap yang bisa dicrud ada nama balapannya, lokasi, tanggal, dan putaran ke berapa balapan tersebut.
   Pada posttest ini, program menerapkan konsep polymorphism dengan membuat method overloading dan method overriding pada
   class peserta, pembalap, dan tim. <br>
   <br>

   2. Penerapan Polymorphism <br>
      2.1 Method Overloading <br>
          Overloading diterapkan pada class peserta dengan membuat 2 method tampilkanInfo() yang mana satu tidak memiliki
          parameter dan hanya menampilkan nama dan negara, sementara method satunya memiliki parameter string judul yang
          digunakan untuk menampilkan judul sebelum data ditampilkan <br>
          ![Overloading_Peserta](assets/Overloading_Peserta.png) <br>
      <br>
      <br>
      2.2 Method Overriding <br>
          Overriding diterapkan pada subclass pembalap dan tim. Kedua subclass mengoverride kedua method tampilkanInfo()
          milik peserta untuk menampilkan data tambahan yang dimiliki oleh masing-masing subclass. Pada pembalap, data
          tambahan yang ditampilkan adalah nomor mobil dan tim. Dan pada tim, data tambahan yang ditampilkan dalah mesin
          dan nama chasis. <br>
          ![Override_Pembalap](assets/Override_Pembalap.png) <br>
      <br>
          ![Override_Tim](assets/Override_Tim.png) <br>
      <br>
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