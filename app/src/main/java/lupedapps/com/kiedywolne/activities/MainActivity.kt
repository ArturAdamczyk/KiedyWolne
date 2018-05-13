package lupedapps.com.kiedywolne.activities

import android.app.DatePickerDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.actionbar_layout.*
import kotlinx.android.synthetic.main.activity_main.*
import lupedapps.com.kiedywolne.models.HolidayItem
import lupedapps.com.kiedywolne.models.HolidaysDataSet
import lupedapps.com.kiedywolne.R
import lupedapps.com.kiedywolne.adapters.MainListAdapter
import lupedapps.com.kiedywolne.helpers.DateHelper
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MobileAds.initialize(this, "ca-app-pub-1217908804271021~7995820346")
        initViews()
    }

    private fun initViews(){
        initActionBar()
        initAd()
        initList()
        initSwitch()
        initTextViews()
    }

    private fun initTextViews(){
        currentYearTextView.text = DateHelper.currentYear().toString()
        nextYearTextView.text = DateHelper.nextYear().toString()
    }

    private fun initSwitch(){
        yearSwitch.setOnCheckedChangeListener{_, isChecked -> initList(isChecked) }
    }

    private fun initAd(){
        val request = AdRequest.Builder()
                .build()
        adView.loadAd(request)
    }

    private fun initList(nextYear :Boolean = false){
        val items : ArrayList<HolidayItem> = HolidaysDataSet(nextYear, application).holidays
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MainListAdapter(items, { item: HolidayItem -> openDatePicker(item) })
    }

    private fun initActionBar() {
        val actionBar = supportActionBar
        actionBar!!.setDisplayShowHomeEnabled(false)
        actionBar.setDisplayShowTitleEnabled(false)

        val customMenuView = LayoutInflater.from(this).inflate(R.layout.actionbar_layout, null)
        actionBar.customView = customMenuView
        actionBar.setDisplayShowCustomEnabled(true)
        actionBar.show()
    }

    private fun openDatePicker(item : HolidayItem){
        val cal = Calendar.getInstance()
        cal.time =  item.date
        val dialog = DatePickerDialog(this, null , cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH))
        dialog.show()
    }
}
