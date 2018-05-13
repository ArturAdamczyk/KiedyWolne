package lupedapps.com.kiedywolne.models

import android.app.Application
import lupedapps.com.kiedywolne.R
import lupedapps.com.kiedywolne.helpers.DateHelper
import lupedapps.com.kiedywolne.helpers.MovableHolidays
import lupedapps.com.kiedywolne.helpers.UnmovableHolidays
import java.util.*

/**
 *  Class counts the amount of days left to each of the holidays
 */
class HolidaysDataSet (nextYear :Boolean, application : Application) {
    var holidays :ArrayList<HolidayItem> = ArrayList()
    private val currentYear :Int = DateHelper.currentYear()
    private val unmovableHolidays : UnmovableHolidays
    private val movableHolidays : MovableHolidays
    private val currentDate = GregorianCalendar(
            currentYear,
            DateHelper.currentMonth(),
            DateHelper.currentDay(),
            DateHelper.currentHour(),
            DateHelper.currentMinute(),
            DateHelper.currentSecond())

    init{
        if(nextYear){
            unmovableHolidays = UnmovableHolidays(currentYear + 1)
            movableHolidays = MovableHolidays(currentYear + 1)
        }else{
            unmovableHolidays = UnmovableHolidays(currentYear)
            movableHolidays = MovableHolidays(currentYear)
        }

        createHoliday(application.resources.getString(R.string.new_years_day), unmovableHolidays.newYearsDay.time)
        createHoliday(application.resources.getString(R.string.epiphany_day), unmovableHolidays.epiphanyDay.time)
        createHoliday(application.resources.getString(R.string.easter_day), movableHolidays.easterDay.time)
        createHoliday(application.resources.getString(R.string.easter_monday_day), movableHolidays.easterMondayDay.time)
        createHoliday(application.resources.getString(R.string.labour_day), unmovableHolidays.labourDay.time)
        createHoliday(application.resources.getString(R.string.constitution_day), unmovableHolidays.constitutionDay.time)
        createHoliday(application.resources.getString(R.string.pentecost_day), movableHolidays.pentecostDay.time)
        createHoliday(application.resources.getString(R.string.corpus_day), movableHolidays.corpusDay.time)
        createHoliday(application.resources.getString(R.string.military_day), unmovableHolidays.militaryDay.time)
        createHoliday(application.resources.getString(R.string.all_saints_day), unmovableHolidays.allSaintsDay.time)
        createHoliday(application.resources.getString(R.string.independence_day), unmovableHolidays.independenceDay.time)
        createHoliday(application.resources.getString(R.string.christmas_day), unmovableHolidays.christmasDay.time)
        createHoliday(application.resources.getString(R.string.second_christmas_day), unmovableHolidays.secondChristmasDay.time)

        holidays.sortedWith(compareBy({ it.daysLeft })).reversed()
    }

    private fun createHoliday(holidayName: String, holidayDate: Date) {
        var daysBetween: Int = DateHelper.daysBetweenDates(currentDate.time, holidayDate)
        if(daysBetween >= 0) {
            holidays.add(HolidayItem(
                    holidayName,
                    holidayDate,
                    daysBetween))
        }
    }

}