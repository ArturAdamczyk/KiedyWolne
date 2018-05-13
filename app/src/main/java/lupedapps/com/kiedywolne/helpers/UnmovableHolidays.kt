package lupedapps.com.kiedywolne.helpers

import lupedapps.com.kiedywolne.helpers.DateHelper
import java.util.*

/**
 *  Class holds unmovable holidays dates
 */
class UnmovableHolidays (currentYear :Int) {

    val newYearsDay: GregorianCalendar =
            GregorianCalendar(currentYear, 0,1, DateHelper.currentHour(), DateHelper.currentMinute(), DateHelper.currentSecond())
    val epiphanyDay: GregorianCalendar =
            GregorianCalendar(currentYear, 0,6, DateHelper.currentHour(), DateHelper.currentMinute(), DateHelper.currentSecond())
    val labourDay: GregorianCalendar =
            GregorianCalendar(currentYear, 4,1, DateHelper.currentHour(), DateHelper.currentMinute(), DateHelper.currentSecond())
    val constitutionDay: GregorianCalendar =
            GregorianCalendar(currentYear, 4, 3, DateHelper.currentHour(), DateHelper.currentMinute(), DateHelper.currentSecond())
    val militaryDay: GregorianCalendar =
            GregorianCalendar(currentYear, 7, 15, DateHelper.currentHour(), DateHelper.currentMinute(), DateHelper.currentSecond())
    val allSaintsDay: GregorianCalendar =
            GregorianCalendar(currentYear, 10, 1, DateHelper.currentHour(), DateHelper.currentMinute(), DateHelper.currentSecond())
    val independenceDay: GregorianCalendar =
            GregorianCalendar(currentYear, 10, 11, DateHelper.currentHour(), DateHelper.currentMinute(), DateHelper.currentSecond())
    val christmasDay: GregorianCalendar =
            GregorianCalendar(currentYear, 11, 25, DateHelper.currentHour(), DateHelper.currentMinute(), DateHelper.currentSecond())
    val secondChristmasDay: GregorianCalendar =
            GregorianCalendar(currentYear, 11, 26, DateHelper.currentHour(), DateHelper.currentMinute(), DateHelper.currentSecond())
}