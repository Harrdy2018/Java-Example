import spock.lang.Specification
import spock.lang.Unroll
// 运行时名称会替换成实际参数值
class DataDrivenBSpec extends Specification{
    @Unroll
    def "maximum of #a and #b should be #c"() {
        expect:
        Math.max(a,b)==c

        where:
        a | b || c
        3 | 5 || 5
        7 | 0 || 7
        0 | 0 || 0
    }
}
