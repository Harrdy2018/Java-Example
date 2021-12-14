import spock.lang.Specification

class DataDrivenSpec extends Specification{
    def "maximum of two numbers"() {
        expect:
        Math.max(a,b)==c

        where:
        a | b || c
        3 | 5 || 5
        7 | 0 || 7
        0 | 0 || 0
    }
}
