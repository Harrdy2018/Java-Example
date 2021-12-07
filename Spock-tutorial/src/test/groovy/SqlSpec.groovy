import groovy.sql.GroovyRowResult
import groovy.sql.Sql
import spock.lang.Shared
import spock.lang.Specification

class SqlSpec extends Specification {
    @Shared
            sql = Sql.newInstance("jdbc:mysql://localhost:3306/test?serverTimezone=UTC&characterEncoding=UTF-8&useUnicode=true", "root", "root", "com.mysql.cj.jdbc.Driver")

    def "sql test"() {
    // expect:
        List<GroovyRowResult> testList = sql.rows("select * from test")
        for (GroovyRowResult row : testList) {
            println row
            println row.get("id")
            println row.get("codes")
            println row.get("remark")
        }
        println testList

        boolean result =
                sql.execute("create table test(id INTEGER primary key , firstname VARCHAR(64), lastname VARCHAR(64))")
        List<List<Object>> list =
                sql.executeInsert("INSERT INTO Author (firstname, lastname) VALUES ('Dierk', 'Koenig')")

        def insertSql = 'INSERT INTO Author (firstname, lastname) VALUES (?,?)'
        def paramList = ['Jon', 'Skeet']
        def keys = sql.executeInsert(insertSql, paramList)

        def insertSql1 = 'INSERT INTO Author (firstname, lastname) VALUES (:firstname,:firstname)'
        def paramMap = ['firstname':'Jon', 'lastname':'Skeet']
        def keys1 = sql.executeInsert(paramMap, insertSql1)

        def first = 'Guillaume'
        def last = 'Laforge'
        def myKeyNames = ['ID']
        def myKeys = sql.executeInsert("""
          INSERT INTO Author (firstname, lastname)
          VALUES (${first}, ${last})
        """, myKeyNames)

        def updateSql = "UPDATE Author SET lastname='Pragt' where lastname='Thorvaldsson'"
        def updateCount = sql.executeUpdate updateSql
        assert updateCount == 1
        def row = sql.firstRow "SELECT * FROM Author where firstname = 'Erik'"
        assert "${row.firstname} ${row.lastname}" == 'Erik Pragt'

        assert sql.firstRow('SELECT COUNT(*) as num FROM Author').num == 3
        boolean r = sql.execute "DELETE FROM Author WHERE lastname = 'Skeet'"
        assert sql.firstRow('SELECT COUNT(*) as num FROM Author').num == 2
    }


    def "data query"() {
//        expect:
        def expected = ['Dierk Koenig', 'Jon Skeet', 'Guillaume Laforge']
        def rowNum = 0
        sql.query('SELECT firstname, lastname FROM Author') { resultSet ->
            while (resultSet.next()) {
                def first = resultSet.getString(1)
                def last = resultSet.getString('lastname')
                assert expected[rowNum++] == "$first $last"
            }
        }

        rowNum = 0
        sql.eachRow('SELECT firstname, lastname FROM Author') { row ->
            def first = row[0]
            def last = row.lastname
            assert expected[rowNum++] == "$first $last"
        }

        def first = sql.firstRow('SELECT lastname, firstname FROM Author')
        assert first.values().sort().join(',') == 'Dierk,Koenig'

        List authors = sql.rows('SELECT firstname, lastname FROM Author')
        assert authors.size() == 3
        assert authors.collect { "$it.FIRSTNAME ${it[-1]}" } == expected

        assert sql.firstRow('SELECT COUNT(*) AS num FROM Author').num == 3
    }

    def "sql advance"() {
//        expect:
        sql.withBatch(3) { stmt ->
            stmt.addBatch "INSERT INTO Author (firstname, lastname) VALUES ('Dierk', 'Koenig')"
            stmt.addBatch "INSERT INTO Author (firstname, lastname) VALUES ('Paul', 'King')"
            stmt.addBatch "INSERT INTO Author (firstname, lastname) VALUES ('Guillaume', 'Laforge')"
            stmt.addBatch "INSERT INTO Author (firstname, lastname) VALUES ('Hamlet', 'D''Arcy')"
            stmt.addBatch "INSERT INTO Author (firstname, lastname) VALUES ('Cedric', 'Champeau')"
            stmt.addBatch "INSERT INTO Author (firstname, lastname) VALUES ('Erik', 'Pragt')"
            stmt.addBatch "INSERT INTO Author (firstname, lastname) VALUES ('Jon', 'Skeet')"
        }

        sql.withTransaction { stmt ->
            stmt.addBatch "INSERT INTO Author (firstname, lastname) VALUES ('Dierk', 'Koenig')"
            stmt.addBatch "INSERT INTO Author (firstname, lastname) VALUES ('Paul', 'King')"
            stmt.addBatch "INSERT INTO Author (firstname, lastname) VALUES ('Guillaume', 'Laforge')"
            stmt.addBatch "INSERT INTO Author (firstname, lastname) VALUES ('Hamlet', 'D''Arcy')"
            stmt.addBatch "INSERT INTO Author (firstname, lastname) VALUES ('Cedric', 'Champeau')"
            stmt.addBatch "INSERT INTO Author (firstname, lastname) VALUES ('Erik', 'Pragt')"
            stmt.addBatch "INSERT INTO Author (firstname, lastname) VALUES ('Jon', 'Skeet')"
        }
    }

}
