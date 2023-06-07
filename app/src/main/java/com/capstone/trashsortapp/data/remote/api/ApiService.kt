package com.capstone.trashsortapp.data.remote.api

import com.capstone.trashsortapp.data.remote.response.UploadImageResponse
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {
    @Multipart
    @POST("upload/image") // Ganti dengan endpoint yang sesuai untuk mengunggah gambar
    fun uploadImage(@Part image: MultipartBody.Part): Call<UploadImageResponse>
}