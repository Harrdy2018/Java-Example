import com.learnspock.tutorial.service.Sum
import spock.lang.Specification

class SumSpec extends Specification{
    def sum = new Sum();
    def "sum should return param1+param2"() {
        expect:
        sum.sum(1,1)==2
    }
}
