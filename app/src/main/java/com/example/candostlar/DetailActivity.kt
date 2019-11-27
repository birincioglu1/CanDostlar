package com.example.candostlar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var gelenıntent=intent
        if(gelenıntent!=null)
        {
            tvDetay.text=gelenıntent.getStringExtra("ad")
            imgDetay.setImageResource(gelenıntent.getIntExtra("resim",R.drawable.bird_parrot_one))
        }
    }
}
