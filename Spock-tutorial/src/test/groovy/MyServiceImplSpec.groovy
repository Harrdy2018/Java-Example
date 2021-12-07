import com.learnspock.tutorial.impl.MyServiceImpl
import com.learnspock.tutorial.service.DependencyService
import com.learnspock.tutorial.service.MyService
import com.sun.org.apache.xpath.internal.operations.Bool
import spock.lang.Specification

class MyServiceImplSpec extends Specification {
    def "testMakeDecision"() {
        given: "mock相关准备(参数A代表决策通过，B代表决策否决)"
        DependencyService dependencyService = Stub(DependencyService.class);
        String trueParam = "A"
        String falseParam = "B";
        dependencyService.make(trueParam) >> true
        dependencyService.make(falseParam) >> false

        and: "可以分多段"
        MyService myService = new MyServiceImpl(dependencyService)

        when: "执行方法调用"
        Boolean trueParamResult = myService.makeDecision(trueParam);
        Boolean falseParamResult = myService.makeDecision(falseParam);

        then: "结果断言"
        trueParamResult == true
        falseParamResult == false
    }
}
