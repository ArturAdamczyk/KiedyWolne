package lupedapps.com.kiedywolne.models

import java.util.*

data class HolidayItem (var name: String,
                        var date : Date,
                        var daysLeft :Int = 0)