package co.thegeekmachine.triplea

import grails.rest.*

@Resource(uri='/postal-address')
class PostalAddress {

    static constraints = {
    }
	
	String country
	String locality
	String region
	String postOfficeBoxNumber
	String postalCode
	String streetAddress
}
