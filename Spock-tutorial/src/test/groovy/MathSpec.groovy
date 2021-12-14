import com.learnspock.tutorial.service.CalculateService
import spock.lang.Shared
import spock.lang.Specification

class MathSpec extends Specification{
    @Shared
    CalculateService calculateService
    def setupSpec() {
        calculateService = new CalculateService()
        println ">>>>>>   setupSpec()"
    }
    def setup() {
        println ">>>>>>   setup()"
    }
    def cleanup() {
        println ">>>>>>   cleanup()"
    }
    def cleanupSpec() {
        println ">>>>>>   cleanupSpec()"
    }
    def "maximum of two numbers"() {
        println "start maximum of two numbers"
        expect:
        Math.max(1,3)==3
        Math.max(7,4)==7
        Math.max(0,0)==0
        println "end maximum of two numbers"
    }

    def "测试最大数"() {
        println "start 测试最大数"

        expect:
        Math.max(a,b) == result

        // 这样一个单元测试会验证两组数据
        // 第一组 a = 1 , b = 2, result = 2
        // 第二组 a = 3 , b = 0, result = 3
        where:
        a | b | result
        1 | 2 | 2
        3 | 0 | 3
    }

    def "测试最大数 AA"() {
        println "start 测试最大数 AA"

        expect:
        Math.max(a,b) == result

        // 这样一个单元测试会验证两组数据
        // 第一组 a = 1 , b = 2, result = 2
        // 第二组 a = 3 , b = 0, result = 3
        where:
        a << [1,3]
        b << [2,0]
        result << [2,3]
    }

    def "test plus >>>"() {
        given: "准备数据"
        def a = 1
        def b =1 << 1

        when: "测试方法"
        def c = calculateService.plus(a,b)

        then: "校验结果"
        c==(1<<2)-1

        println ">>>>> test plus >>>> b"
    }
}
