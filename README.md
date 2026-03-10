# LAB-PBO-13-2026

Harap membaca seluruh panduan berikut sebelum memulai proses pengumpulan tugas.

---

## 📌 Perhatian

> Setiap teks yang dibungkus `< >` wajib diganti sesuai dengan data masing-masing.  
> Contoh: `mkdir <NIM>` → `mkdir H071241066`

---

## 📥 Panduan Pengumpulan Tugas

### 1. Fork Repository

1. Buka repositori ini di GitHub.
2. Klik tombol **Fork** yang terletak di pojok kanan atas halaman.
3. Repositori akan tersalin secara otomatis ke akun GitHub masing-masing.

---

### 2. Clone Repository ke Perangkat

Buka terminal atau Git Bash, kemudian jalankan perintah berikut:

```bash
git clone <url-repositori-hasil-fork>
```

Contoh:

```bash
git clone https://github.com/username/LAB-PBO-13-2026.git
```

---

### 3. Masuk ke Direktori Repository

```bash
cd LAB-PBO-13-2026
```

---

### 4. Buat Folder Sesuai NIM

```bash
mkdir <NIM>
```

Contoh:

```bash
mkdir H071241066
```

---

### 5. Buat Folder Praktikum dan Tambahkan File

Setiap tugas praktikum dikumpulkan dalam folder tersendiri dengan format penamaan sebagai berikut:

```
Praktikum-<n>
```

> `n` adalah nomor praktikum. Contoh: `Praktikum-1`, `Praktikum-2`

Pastikan sudah berada di dalam folder NIM, kemudian buat folder praktikum dengan perintah:

```bash
cd <NIM>
mkdir Praktikum-<n>
```

Contoh:

```bash
cd H071241066
mkdir Praktikum-1
```

Letakkan seluruh file tugas ke dalam folder yang telah dibuat. Format penamaan file tugas adalah:

```
TP<n>_<nomor soal>_<NIM>.java
```

Contoh: `TP1_1_H071241066.java`, `TP1_2_H071241066.java`

Struktur keseluruhan repositori yang diharapkan:

```
LAB-PBO-13-2026/
├── H071241066/
│   ├── Praktikum-1/
│   │   ├── TP1_1_H071241066.java
│   │   └── TP1_2_H071241066.java
│   └── Praktikum-2/
│       ├── TP2_1_H071241066.java
│       └── TP2_2_H071241066.java
└── H071241067/
    ├── Praktikum-1/
    └── Praktikum-2/
```

---

### 6. Add, Commit, dan Push

Setelah seluruh file tugas siap, jalankan perintah berikut secara berurutan:

```bash
git add .
git commit -m "<pesan commit>"
git push origin main
```

---

## 💬 Ketentuan Pesan Commit

Pesan commit menggunakan format **Conventional Commits** untuk menjaga konsistensi dan keterbacaan riwayat perubahan.

**Format:**

```
<type>: <deskripsi singkat>
```

| Type | Penggunaan |
|------|------------|
| `feat` | Menambahkan tugas atau file baru |
| `fix` | Memperbaiki kesalahan atau kesalahan penulisan |
| `docs` | Memperbarui dokumentasi |
| `refactor` | Merapikan struktur kode tanpa mengubah fungsionalitas |
| `style` | Menyesuaikan format atau gaya penulisan kode |
| `chore` | Perubahan lain yang tidak berdampak pada kode utama |

**Contoh:**

```
feat: menambahkan Praktikum-1 H071241066
fix: memperbaiki kesalahan pada TP1_2_H071241066
```

---

## 🔃 Membuat Pull Request

Setelah melakukan push, buat Pull Request (PR) agar tugas dapat masuk ke repositori utama.

1. Buka repositori hasil fork di akun GitHub masing-masing.
2. Klik **Contribute** → **Open Pull Request**.
3. Judul PR wajib menggunakan format berikut:

```
Praktikum-<n>-<NIM>
```

Contoh:

```
Praktikum-1-H071241066
Praktikum-2-H071241066
```

4. Pada bagian deskripsi, cantumkan daftar file yang ditambahkan atau diperbarui.
5. Klik **Create Pull Request**.

---

> ⚠️ Dilarang mengubah atau menghapus folder milik praktikan lain.  
> Pull Request yang tidak sesuai format di atas tidak akan di-merge.
