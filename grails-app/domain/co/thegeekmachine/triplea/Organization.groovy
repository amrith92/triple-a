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
		memberOf: Organization
	]
	static hasOne = [address: PostalAddress]
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
