package lupedapps.com.kiedywolne.helpers

import java.util.*


class DateHelper {
    companion object {

        fun currentYear(): Int{
            return Calendar.getInstance().get(Calendar.YEAR)
        }

        fun nextYear(): Int{
            return currentYear() + 1
        }

        fun currentMonth(): Int{
            return Calendar.getInstance().get(Calendar.MONTH)
        }

        fun currentDay(): Int{
            return Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        }

        fun currentHour(): Int{
            return Calendar.getInstance().get(Calendar.HOUR)
        }

        fun currentMinute(): Int{
            return Calendar.getInstance().get(Calendar.MINUTE)
        }

        fun currentSecond(): Int{
            return Calendar.getInstance().get(Calendar.SECOND)
        }

        fun  daysBetweenDates(currentDate: Date, futureDate: Date): Int {
            val daysBetween: Int = ((futureDate.time - currentDate.time ) / (1000*60*60*24)).toInt()
            return when(daysBetween){
                0 -> -1
                else -> daysBetween
            }
        }
    }
}