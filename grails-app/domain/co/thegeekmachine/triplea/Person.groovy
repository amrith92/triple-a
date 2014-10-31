package co.thegeekmachine.triplea

class Person {

    static constraints = {
    }
	
	static mappedBy = [
		address: "none",
		spouse: "none",
		affiliation: "none",
		children: "none",
		follows: "none",
		knows: "none",
		parent: "none",
		relatedTo: "none"
	]
	
	static belongsTo = Organization
	
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
	
	User user
	Person spouse
	PostalAddress address
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
