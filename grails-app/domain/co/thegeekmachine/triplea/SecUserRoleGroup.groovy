package co.thegeekmachine.triplea

import org.apache.commons.lang.builder.HashCodeBuilder

class SecUserRoleGroup implements Serializable {

	private static final long serialVersionUID = 1

	SecUser secUser
	RoleGroup roleGroup

	boolean equals(other) {
		if (!(other instanceof SecUserRoleGroup)) {
			return false
		}

		other.secUser?.id == secUser?.id &&
		other.roleGroup?.id == roleGroup?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (secUser) builder.append(secUser.id)
		if (roleGroup) builder.append(roleGroup.id)
		builder.toHashCode()
	}

	static SecUserRoleGroup get(long secUserId, long roleGroupId) {
		SecUserRoleGroup.where {
			secUser == SecUser.load(secUserId) &&
			roleGroup == RoleGroup.load(roleGroupId)
		}.get()
	}

	static boolean exists(long secUserId, long roleGroupId) {
		SecUserRoleGroup.where {
			secUser == SecUser.load(secUserId) &&
			roleGroup == RoleGroup.load(roleGroupId)
		}.count() > 0
	}

	static SecUserRoleGroup create(SecUser secUser, RoleGroup roleGroup, boolean flush = false) {
		def instance = new SecUserRoleGroup(secUser: secUser, roleGroup: roleGroup)
		instance.save(flush: flush, insert: true)
		instance
	}

	static boolean remove(SecUser u, RoleGroup g, boolean flush = false) {
		if (u == null || g == null) return false

		int rowCount = SecUserRoleGroup.where {
			secUser == SecUser.load(u.id) &&
			roleGroup == RoleGroup.load(g.id)
		}.deleteAll()

		if (flush) { SecUserRoleGroup.withSession { it.flush() } }

		rowCount > 0
	}

	static void removeAll(SecUser u, boolean flush = false) {
		if (u == null) return

		SecUserRoleGroup.where {
			secUser == SecUser.load(u.id)
		}.deleteAll()

		if (flush) { SecUserRoleGroup.withSession { it.flush() } }
	}

	static void removeAll(RoleGroup g, boolean flush = false) {
		if (g == null) return

		SecUserRoleGroup.where {
			roleGroup == RoleGroup.load(g.id)
		}.deleteAll()

		if (flush) { SecUserRoleGroup.withSession { it.flush() } }
	}

	static constraints = {
		secUser validator: { SecUser u, SecUserRoleGroup ug ->
			if (ug.roleGroup == null) return
			boolean existing = false
			SecUserRoleGroup.withNewSession {
				existing = SecUserRoleGroup.exists(u.id, ug.roleGroup.id)
			}
			if (existing) {
				return 'userGroup.exists'
			}
		}
	}

	static mapping = {
		id composite: ['roleGroup', 'secUser']
		version false
	}
}
