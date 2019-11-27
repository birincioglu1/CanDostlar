package com.example.candostlar

import android.content.Intent
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.Toast
import kotlinx.android.synthetic.main.tek_uye.view.*


class DostlarRecyclerViewAdapter(tumDostlar:ArrayList<Dost>): RecyclerView.Adapter<DostlarRecyclerViewAdapter.DostViewHolder>(), Filterable {


    var dostlar=tumDostlar
    var myFilter:FilterHelper= FilterHelper(tumDostlar,this)

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): DostViewHolder {

        var inflater=LayoutInflater.from(p0.context)
        var tek_uye=inflater.inflate(R.layout.tek_uye,p0,false)

        return DostViewHolder(tek_uye)


    }

    override fun getItemCount(): Int {
    return dostlar.size
    }

    override fun onBindViewHolder(p0: DostViewHolder, p1: Int) {

        var oanOlusturulanDost=dostlar.get(p1)
        p0.setData(oanOlusturulanDost,p1)

    }

   inner class DostViewHolder(tek_uye: View) : RecyclerView.ViewHolder(tek_uye) {


        var tek_dostBilgisi=tek_uye as CardView


        var dostAd=tek_dostBilgisi.tvDostAdi
        var dostResim=tek_dostBilgisi.imgDost

        fun setData(oanOlusturulanDost: Dost, p1: Int) {

            dostAd.text=oanOlusturulanDost.isim
            dostResim.setImageResource(oanOlusturulanDost.resim)

          tek_dostBilgisi.setOnClickListener { v ->
              var intent=Intent(v.context,DetailActivity::class.java)
              intent.putExtra("ad",oanOlusturulanDost.isim)
              intent.putExtra("resim",oanOlusturulanDost.resim)

              v.context.startActivity(intent)
          }

        }


    }

    fun setFilter(arrayList:ArrayList<Dost>)
    {
        dostlar=arrayList
    }

    override fun getFilter(): Filter {


        return myFilter
    }

/*
    fun setFilter(arananlar:ArrayList<Dost>)
    {
        dostlar= ArrayList<Dost>()
        dostlar.addAll(arananlar)
        notifyDataSetChanged()
    } */
}