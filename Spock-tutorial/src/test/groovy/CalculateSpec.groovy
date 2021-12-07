import com.learnspock.tutorial.service.CalculateService
import spock.lang.Shared
import spock.lang.Specification

class CalculateSpec extends Specification {

    @Shared
    CalculateService calculateService

    // 初始化
    def setupSpec() {
        calculateService = new CalculateService()
        println ">>>>>>   setupSpec"
    }
    def setup() {
        println ">>>>>>   setup"
    }

    def cleanup() {
        println ">>>>>>   cleanup"
    }
    def cleanupSpec() {
        println ">>>>>>   cleanupSpec"
    }

    def "test life cycle"() {
        given:
        def a = 1
        def b = 2

        expect:
        a < b

        println "test method finished!"
    }

    // 声明一个测试
    def "test plus 1"() {
        given: "准备数据"
        def a = 1
        def b = a << 1

        when: "测试方法"
        def c = calculateService.plus(a, b)

        then: "校验结果"
        c == (1 << 2) - 1

        println ">>>>>>   test plus 1"
    }


    def "test person use with(p)"() {
        given: "init a person"
        Date now = new Date()
        Person p = new Person(name: "yawn", age: 18, birthday:   now)

        expect: "测试p"
        with(p) {
            name == "yawn"
            age < 20
            birthday == now
        }
    }


    def "多个预期值的测试使用 verifyAll()"() {
        when:
        Person p = new Person(name: "yawn", age: 18)

        then:
        verifyAll(p) {
            name == "yawn"
            age < 20
        }
    }

    def "没有参数的 verifyAll"() {
        when:
        int z1 = calculateService.plus(1, 1)
        int z2 = calculateService.plus(1, 2)
        int z3 = calculateService.plus(1, 3)

        then:
        verifyAll {
            z1 == 1
            z2 == 3
            z3 == 3
        }
    }



    // 使用where
    def "computing the maximum of two numbers"() {
        expect:
        Math.max(a, b) == c

        where:
        a << [5, 3] // 执行两次测试，值依次为5，3，下面类似
        b << [1, 9] // << is a Groovy shorthand for List.add()
        c << [5, 9]
    }

    def "test1"() {
        given: "准备mock数据"

        expect: "测试方法"
        z == calculateService.plus(x, y)

        where: "校验结果"
        x | y || z
        1 | 0 || 1
        2 | 1 || 3

    }

    def "length of Spock's and his friends' names"() {
        expect:
        name.size() == length

        where:
//        name     | length
//        "Spock"  | 5
//        "Kirk"   | 4
//        "Scotty" | 6

        // where 的两种方式任选一种
        name << ["Yawn", "Tim"]
        length << [4, 3]
    }

    def "多次执行测试语句"() {
        given:
        def a = 0

        expect: "aaa"
        3 * calculateService.plusPlus(a) == 3

        // 执行3次后结果为 3
    }


    static class Person {
        private String name
        private int age
        private Date birthday
    }

}