import co.thegeekmachine.triplea.PostalAddress
import co.thegeekmachine.triplea.User

class BootStrap {

    def init = { servletContext ->
		if (!PostalAddress.count()) {
			new PostalAddress(
				country: 'India',
				locality: 'Sholinganallur, Chennai',
				region: 'Tamil Nadu',
				postOfficeBoxNumber: '475',
				postalCode: '600119',
				streetAddress: '475 Wipro Road, Off OMR'
			).save(failOnError: true)
		}
		
		if (!User.count()) {
			new User(
				username: "test",
				password: "password"
			).save(failOnError: true)
		}
    }
    def destroy = {
    }
}
