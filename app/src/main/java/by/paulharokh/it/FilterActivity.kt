package by.paulharokh.it

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_filter.*

class FilterActivity : AppCompatActivity() {
    var services = mutableListOf<AdaptedService>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)

        val arguments: Bundle = intent.extras!!
        val receivedServiceS = arguments["ALL SERVICES"]

        val servicesArr = receivedServiceS.toString().toCharArray()

        for (i in servicesArr.indices) {
            val bufferAdaptedService = AdaptedService(servicesArr[i].toString(), true)
            services.add(bufferAdaptedService)
        }

        rv_services_pref_id.adapter = ServiceAdapter(services, this)
        rv_services_pref_id.layoutManager = LinearLayoutManager(this)
    }


    fun savePref(view: android.view.View) {

        var bannedS = ""

        for (i in services.indices) {
            if (!services[i].isChecked){
                bannedS += services[i].name
            }
        }

        val intent = Intent(this@FilterActivity, MapsActivity::class.java)
        intent.putExtra("PREF S",bannedS)
        startActivity(intent)

    }

    fun isBanned(adapterPosition: Int) {
        services[adapterPosition].isChecked = !services[adapterPosition].isChecked
        rv_services_pref_id.adapter?.notifyDataSetChanged()
    }

}