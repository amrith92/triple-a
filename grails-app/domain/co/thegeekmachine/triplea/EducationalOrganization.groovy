package co.thegeekmachine.triplea

class EducationalOrganization extends Organization {

    static constraints = {
    }
	
	static hasMany = [alumni: Person]
}
