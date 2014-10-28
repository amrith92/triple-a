package co.thegeekmachine.triplea

class RoleGroup {

	String name

	static mapping = {
		cache true
	}

	Set<SecRole> getAuthorities() {
		RoleGroupSecRole.findAllByRoleGroup(this).collect { it.secRole }
	}

	static constraints = {
		name blank: false, unique: true
	}
}
