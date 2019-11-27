package com.example.candostlar

import android.widget.Filter

class FilterHelper( tumDostlar:ArrayList<Dost>,adapter:DostlarRecyclerViewAdapter):Filter() {


    var suankiListe=tumDostlar
    var suankiAdapter=adapter


    override fun performFiltering(constraint: CharSequence?): FilterResults { //filtreme yapıyor

        var sonuc=FilterResults()
        if(constraint !=null && constraint.length>0)
        {
            var aranilanAd=constraint.toString().toLowerCase()
            var eslesenler= ArrayList<Dost>()
            for(dost in suankiListe)
            {
                var adi =dost.isim.toLowerCase()
                if(adi.contains(aranilanAd.toString()))
                {
                    eslesenler.add(dost)
                }
            }
            sonuc.values=eslesenler
            sonuc.count=eslesenler.size
        }
        else{
            sonuc.values=suankiListe
            sonuc.count=suankiListe.size
        }

        return sonuc
    }

    override fun publishResults(constraint: CharSequence?, results: FilterResults?) {  //sonuçları


        suankiAdapter.setFilter(results?.values as ArrayList<Dost>)
        suankiAdapter.notifyDataSetChanged()
    }
}