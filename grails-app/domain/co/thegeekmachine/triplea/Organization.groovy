package co.thegeekmachine.triplea

class Organization {

    static constraints = {
		duns unique: true
		email unique: true
    }
	
	static hasMany = [
		brands: Organization,
		departments: Organization,
		employees: Person,
		founders: Person,
		memberOf: Organization,
		events: Event
	]
	
	static mappedBy = [
		address: "none",
		brands: "none",
		departments: "none",
		founders: "none",
		memberOf: "none",
		events: "none"
	]
	
	PostalAddress address
	Date dissolutionDate
	String duns
	String email
	String faxNUmber
	Date foundingDate
	String logo
	String naics
	String taxId
	String telephone
	String vatId
}
