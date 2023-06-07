package com.capstone.trashsortapp.ui.camera

import androidx.lifecycle.ViewModel
import com.capstone.trashsortapp.data.remote.api.ApiService
import com.capstone.trashsortapp.data.remote.response.UploadImageResponse
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CameraViewModel : ViewModel() {
    private val apiService: ApiService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.example.com/") // Ganti dengan URL API yang sesuai
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(ApiService::class.java)
    }

    fun uploadImage(base64Image: String) {
        val requestFile = RequestBody.create("image/jpeg".toMediaType(), base64Image)
        val body = MultipartBody.Part.createFormData("image", "image.jpg", requestFile)

        apiService.uploadImage(body).enqueue(object : Callback<UploadImageResponse> {
            override fun onResponse(call: Call<UploadImageResponse>, response: Response<UploadImageResponse>) {
                if (response.isSuccessful) {
                    // Proses berhasil
                    val uploadImageResponse = response.body()
                    // Lakukan tindakan sesuai dengan tanggapan API yang berhasil
                } else {
                    // Proses gagal
                    // Handle kesalahan seperti response.code(), response.message(), dll.
                }
            }

            override fun onFailure(call: Call<UploadImageResponse>, t: Throwable) {
                // Proses gagal karena jaringan atau kesalahan lainnya
                // Handle kesalahan seperti t.message(), dll.
            }
        })
    }
}





