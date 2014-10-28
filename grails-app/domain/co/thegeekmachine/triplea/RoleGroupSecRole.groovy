package co.thegeekmachine.triplea

import org.apache.commons.lang.builder.HashCodeBuilder

class RoleGroupSecRole implements Serializable {

	private static final long serialVersionUID = 1

	RoleGroup roleGroup
	SecRole secRole

	boolean equals(other) {
		if (!(other instanceof RoleGroupSecRole)) {
			return false
		}

		other.secRole?.id == secRole?.id &&
		other.roleGroup?.id == roleGroup?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (roleGroup) builder.append(roleGroup.id)
		if (secRole) builder.append(secRole.id)
		builder.toHashCode()
	}

	static RoleGroupSecRole get(long roleGroupId, long secRoleId) {
		RoleGroupSecRole.where {
			roleGroup == RoleGroup.load(roleGroupId) &&
			secRole == SecRole.load(secRoleId)
		}.get()
	}

	static boolean exists(long roleGroupId, long secRoleId) {
		RoleGroupSecRole.where {
			roleGroup == RoleGroup.load(roleGroupId) &&
			secRole == SecRole.load(secRoleId)
		}.count() > 0
	}

	static RoleGroupSecRole create(RoleGroup roleGroup, SecRole secRole, boolean flush = false) {
		def instance = new RoleGroupSecRole(roleGroup: roleGroup, secRole: secRole)
		instance.save(flush: flush, insert: true)
		instance
	}

	static boolean remove(RoleGroup rg, SecRole r, boolean flush = false) {
		if (rg == null || r == null) return false

		int rowCount = RoleGroupSecRole.where {
			roleGroup == RoleGroup.load(rg.id) &&
			secRole == SecRole.load(r.id)
		}.deleteAll()

		if (flush) { RoleGroupSecRole.withSession { it.flush() } }

		rowCount > 0
	}

	static void removeAll(SecRole r, boolean flush = false) {
		if (r == null) return

		RoleGroupSecRole.where {
			secRole == SecRole.load(r.id)
		}.deleteAll()

		if (flush) { RoleGroupSecRole.withSession { it.flush() } }
	}

	static void removeAll(RoleGroup rg, boolean flush = false) {
		if (rg == null) return

		RoleGroupSecRole.where {
			roleGroup == RoleGroup.load(rg.id)
		}.deleteAll()

		if (flush) { RoleGroupSecRole.withSession { it.flush() } }
	}

	static constraints = {
		secRole validator: { SecRole r, RoleGroupSecRole rg ->
			if (rg.roleGroup == null) return
			boolean existing = false
			RoleGroupSecRole.withNewSession {
				existing = RoleGroupSecRole.exists(rg.roleGroup.id, r.id)
			}
			if (existing) {
				return 'roleGroup.exists'
			}
		}
	}

	static mapping = {
		id composite: ['roleGroup', 'secRole']
		version false
	}
}
