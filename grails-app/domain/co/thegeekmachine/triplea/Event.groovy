package co.thegeekmachine.triplea

import org.joda.time.DateTime
import org.joda.time.Duration

class Event {

    static constraints = {
    }
	
	static hasMany = [
		attendee: Attendee
	]
	
	static mappedBy = [
		organizer: "none",
		attendee: "none"
	]
	
	Person organizer
	DateTime doorTime
	Duration duration
	DateTime endDate
	String eventStatus
	String location
	List<DateTime> previousStartDate
	DateTime startDate
}
