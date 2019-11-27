package com.example.candostlar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import android.widget.SearchView


import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() /*, SearchView.OnQueryTextListener*/ {

    var tumDostlar=ArrayList<Dost>()
   lateinit var myAdapter:DostlarRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        veriKaynagiDoldur()

        myAdapter=DostlarRecyclerViewAdapter(tumDostlar)
        recyclerViewDostlar.adapter=myAdapter

        var mylayourManager= StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        recyclerViewDostlar.layoutManager=mylayourManager
        searchViewDost.setOnQueryTextListener(object: SearchView.OnQueryTextListener,
            android.support.v7.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                myAdapter.filter.filter(newText)
                return false
            }

        })
    }
/*
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.filtre_menu,menu)
        var aramaItem=menu?.findItem(R.id.app_bar_search)
        var searchView=aramaItem?.actionView as SearchView

            searchView.setOnQueryTextListener(this)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(p0: String?): Boolean {

        return false
    }

    override fun onQueryTextChange(p0: String?): Boolean {

        var girilenVeri=p0?.toLowerCase()
        var arananlar=ArrayList<Dost>()
        for (dost in tumDostlar)
        {
            var adi=dost.isim.toLowerCase()
            if(adi.contains(girilenVeri.toString()))
            {
                arananlar.add(dost)
            }
        }

        myAdapter.setFilter(arananlar)
        return true

    }
*/

    private fun veriKaynagiDoldur() {
        var resimler = arrayOf(R.drawable.ani_cat_one,
            R.drawable.ani_cat_two,
            R.drawable.ani_cat_three,
            R.drawable.ani_cat_four,
            R.drawable.ani_cat_five,
            R.drawable.ani_cat_six,
            R.drawable.ani_cat_seven,

            R.drawable.ani_dog_one,
            R.drawable.ani_dog_two,
            R.drawable.ani_dog_three,
            R.drawable.ani_dog_four,
            R.drawable.ani_dog_five,

            R.drawable.ani_deer_one,
            R.drawable.ani_deer_two,
            R.drawable.ani_deer_three,
            R.drawable.ani_deer_four,

            R.drawable.bird_parrot_one,
            R.drawable.bird_parrot_two,
            R.drawable.bird_parrot_three,
            R.drawable.bird_parrot_four,
            R.drawable.bird_parrot_five,
            R.drawable.bird_parrot_six,
            R.drawable.bird_parrot_seven,
            R.drawable.bird_parrot_eight)

        var isimler = arrayOf("Kedi 1", "Kedi 2", "Kedi 3", "Kedi 4", "Kedi 5", "Kedi 6", "Kedi 7",
            "Köpek 1", "Köpek 2", "Köpek 3", "Köpek 4", "Köpek 5",
            "Geyik 1", "Geyik 2", "Geyik 3", "Geyik 4",
            " Papagan 1", " Papagan 2", " Papagan 3", " Papagan 4", " Papagan 5", " Papagan 6", " Papagan 7", " Papagan 8")

        for (i in 0..resimler.size - 1) {

            var eklenecekDost = Dost(isimler[i], resimler[i])
            tumDostlar.add(eklenecekDost)

        }


    }
}
