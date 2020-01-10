package sqlinjection

class NonInjectableController {

    def GetAllUsers() {

        def allUsers = Users.createCriteria().list(max: 2) { eq("firstname", "test")}

        render(contentType: 'text/json') {[
                'results': allUsers,
                'status': allUsers ? "OK" : "Nothing present"
        ]}
    }
}