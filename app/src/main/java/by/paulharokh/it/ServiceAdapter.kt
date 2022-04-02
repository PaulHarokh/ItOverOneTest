package by.paulharokh.it

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ServiceAdapter(
    private val list: MutableList<AdaptedService>,
    private val activity: FilterActivity
) :
    RecyclerView.Adapter<ServiceAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.service_item, parent, false)
        val holder = ViewHolder(itemView)

        holder.itemView.findViewById<CheckBox>(R.id.cb_service_id).setOnClickListener {
            activity.isBanned(holder.adapterPosition)
        }

        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.tv_serv_name_id).text = list[position].name
        holder.itemView.findViewById<CheckBox>(R.id.cb_service_id).isChecked =
            list[position].isChecked
    }

    override fun getItemCount(): Int {
        return list.size
    }
}



