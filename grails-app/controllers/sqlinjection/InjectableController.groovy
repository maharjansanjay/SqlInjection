package sqlinjection

import com.google.gson.JsonObject
import groovy.sql.Sql

import javax.sql.DataSource

class InjectableController {

    DataSource dataSource

    def index() {
        def connection = dataSource.getConnection()
        Sql sql = new Sql(connection)
        def users = sql.rows("select * from users Limit 0,2")

        println(users.getClass())

        render (contentType: 'text/json'){[
                'results': users,
                'status': users ? "OK" : "Nothing present"
        ]}
    }


    def test() {
        def a = ["group1", "group2"]

        def b =["program1", "program2"]

        render a
    }
}
