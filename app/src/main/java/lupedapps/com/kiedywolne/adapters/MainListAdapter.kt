package lupedapps.com.kiedywolne.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.row_layout.view.*
import lupedapps.com.kiedywolne.models.HolidayItem
import lupedapps.com.kiedywolne.R


class MainListAdapter (
        private val items: ArrayList<HolidayItem>,
        private val listener: (HolidayItem) -> Unit) : RecyclerView.Adapter<MainListAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent.inflate(R.layout.row_layout))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position], listener)

    override fun getItemCount() :Int = items.size

    private fun ViewGroup.inflate(layoutRes: Int): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, false)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(item: HolidayItem, listener: (HolidayItem) -> Unit) = with(itemView) {
            daysLabel.text = item.daysLeft.toString()
            nameLabel.text = item.name
            setOnClickListener { listener(item) }
        }
    }
}