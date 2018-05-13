package lupedapps.com.kiedywolne.helpers

import java.util.*


/**
 *  Class counts dates of movable holidays
 *  uses modified algorithm from here :https://www.rosettacode.org/wiki/Holidays_related_to_Easter#Java
 */
class MovableHolidays(currentYear :Int){
    var easterDay: GregorianCalendar = GregorianCalendar()
    var easterMondayDay: GregorianCalendar = GregorianCalendar()
    var pentecostDay: GregorianCalendar = GregorianCalendar()
    var corpusDay: GregorianCalendar = GregorianCalendar()

    private val holidayOffsets = listOf(
            "Easter" to 1,
            "EasterMonday" to 2,
            "Pentecost" to 50,
            "Corpus" to 61
    )

    init{
        calculateHolidays(currentYear)
    }

    private fun calculateEaster(year: Int): GregorianCalendar {
        val a = year % 19
        val b = year / 100
        val c = year % 100
        val d = b / 4
        val e = b % 4
        val f = (b + 8) / 25
        val g = (b - f + 1) / 3
        val h = (19 * a + b - d - g + 15) % 30
        val i = c / 4
        val k = c % 4
        val l = (32 + 2 * e + 2 * i - h - k) % 7
        val m = (a + 11 * h + 22 * l) / 451
        val n = h + l - 7 * m + 114
        val month = (n / 31) -1 // months indexed from 0
        val day = (n % 31)
        return GregorianCalendar(year, month, day)
    }

    private fun calculateHolidays(year: Int) {
        val date = calculateEaster(year)
        easterDay.set(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH))
        easterDay.add(Calendar.DATE, holidayOffsets[0].second)

        easterMondayDay.set(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH))
        easterMondayDay.add(Calendar.DATE, holidayOffsets[1].second)

        pentecostDay.set(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH))
        pentecostDay.add(Calendar.DATE, holidayOffsets[2].second)

        corpusDay.set(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH))
        corpusDay.add(Calendar.DATE, holidayOffsets[3].second)
    }


}