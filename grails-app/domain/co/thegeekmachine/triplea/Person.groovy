package co.thegeekmachine.triplea

class Person {

    static constraints = {
    }
	
	static hasOne = [user: User, address: PostalAddress, spouse: Person]
	static hasMany = [
		affiliation: Organization,
		alumniOf: EducationalOrganization,
		brands: Organization,
		children: Person,
		colleague: Person,
		follows: Person,
		knows: Person,
		memberOf: Organization,
		parent: Person,
		relatedTo: Person,
		siblings: Person,
		worksFor: Organization
	]
	String additionalName
	Date birthDate
	Date deathDate
	String duns
	String email
	String familyName
	String faxNumber
	String gender
	String givenName
	String honorificPrefix
	String honorificSuffix
	String jobTitle
	String naics
	String nationality
	String taxId
	String telephone
	String vatId
}
