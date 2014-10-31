import co.thegeekmachine.triplea.PostalAddress

class BootStrap {

    def init = { servletContext ->
		new PostalAddress(
			country: 'India',
			locality: 'Sholinganallur, Chennai',
			region: 'Tamil Nadu',
			postOfficeBoxNumber: '475',
			postalCode: '600119',
			streetAddress: '475 Wipro Road, Off OMR'
		)
    }
    def destroy = {
    }
}
