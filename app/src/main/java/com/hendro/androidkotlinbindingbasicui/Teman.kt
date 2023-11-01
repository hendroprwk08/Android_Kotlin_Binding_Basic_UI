package com.hendro.androidkotlinbindingbasicui
class Teman (nama: String?, keterangan: String?, gambar: String?) {

    private var nama: String
    private var keterangan: String
    private var gambar: String

    init {
        this.nama = nama!!
        this.keterangan = keterangan!!
        this.gambar = gambar!!
    }

    fun getNama(): String? {
        return nama
    }

    fun getKeterangan(): String? {
        return keterangan
    }

    fun getGambar(): String? {
        return gambar
    }

}