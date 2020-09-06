package com.dicoding.mahasiswa_app_almisyarifchaniago

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dicoding.mahasiswa_app_almisyarifchaniago.Config.NetworkModule
import com.dicoding.mahasiswa_app_almisyarifchaniago.Model.action.ResponseAction
import com.dicoding.mahasiswa_app_almisyarifchaniago.Model.getdata.DataItem
import com.dicoding.mahasiswa_app_almisyarifchaniago.R
import kotlinx.android.synthetic.main.activity_input.*
import kotlinx.android.synthetic.main.list_item.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InputActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        val getData = intent.getParcelableExtra<DataItem>("data")

        if (getData != null){
            etNama.setText(getData.mahasiswaNama)
            etNohp.setText(getData.mahasiswaNohp)
            etAlamat.setText(getData.mahasiswaAlamat)

            btn1.text = "Update"

        }

        when (btn1.text) {
            "Update" -> {

                btn1.setOnClickListener {
                    updateData(getData?.idMahasiswa, etNama.text.toString(), etNohp.text.toString(), etAlamat.text.toString() )
                }

            } else -> {

            btn1.setOnClickListener {
                inputData(etNama.text.toString(), etNohp.text.toString(), etAlamat.text.toString())

            }
        }
        }



        btn2.setOnClickListener {
            finish()
        }

    }


    private fun inputData(nama: String?, nohp: String?, alamat: String?){

        val input = NetworkModule.service().insertData(nama ?: "", nohp ?: "", alamat ?: "")
        input.enqueue(object : Callback<ResponseAction> {

            override fun onResponse(
                call: Call<ResponseAction>,
                response: Response<ResponseAction>
            ) {

                Toast.makeText(applicationContext, "Data berhasil disimpan", Toast.LENGTH_SHORT).show()
                finish()

            }

            override fun onFailure(call: Call<ResponseAction>, t: Throwable) {

                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()

            }

        })

    }

    private fun updateData(id: String?, nama: String?, nohp: String?, alamat: String?){

        val input = NetworkModule.service().updateData(id ?: "", nama ?: "", nohp ?: "", alamat ?: "")
        input.enqueue(object : Callback<ResponseAction> {

            override fun onResponse(
                call: Call<ResponseAction>,
                response: Response<ResponseAction>
            ) {

                Toast.makeText(applicationContext, "Data berhasil diupdate", Toast.LENGTH_SHORT).show()
                finish()

            }

            override fun onFailure(call: Call<ResponseAction>, t: Throwable) {

                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()

            }

        })

    }


}
