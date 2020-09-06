package com.dicoding.mahasiswa_app_almisyarifchaniago.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.mahasiswa_app_almisyarifchaniago.Model.getdata.DataItem
import com.dicoding.mahasiswa_app_almisyarifchaniago.R
import kotlinx.android.synthetic.main.list_item.view.*

class DataAdapter(val data: List<DataItem?>?, val itemClick: OnClickListener) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data?.get(position)

        holder.nama.text = item?.mahasiswaNama
        holder.nohp.text = item?.mahasiswaNohp
        holder.alamat.text = item?.mahasiswaAlamat

        holder.view.setOnClickListener {
            itemClick.detail(item)
        }

        holder.btnHapus.setOnClickListener {
            itemClick.hapus(item)
        }

    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        val nama = view.txtNama
        val nohp = view.txtNoHP
        val alamat = view.txtAlamat
        val btnHapus = view.btnHapus


    }

    interface OnClickListener {
        fun detail(item: DataItem?)
        fun hapus(item: DataItem?)
    }

}