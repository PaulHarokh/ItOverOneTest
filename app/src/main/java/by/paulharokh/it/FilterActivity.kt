package by.paulharokh.it

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_filter.*

class FilterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)
        val services = mutableListOf<AdaptedService>()


//        for(element in ){
//            services.add()
//        }


        rv_services_pref_id.adapter = ServiceAdapter(services, this)
        rv_services_pref_id.layoutManager = LinearLayoutManager(this)
    }


    fun savePref(view: android.view.View) {
        val intent = Intent(this@FilterActivity, MapsActivity::class.java)
        startActivity(intent)
    }

    fun isBanned(adapterPosition: Int) {

    }

}