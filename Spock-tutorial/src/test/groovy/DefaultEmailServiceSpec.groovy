import com.learnspock.tutorial.Customer
import com.learnspock.tutorial.service.CustomerService
import com.learnspock.tutorial.service.DefaultEmailService
import com.learnspock.tutorial.service.EmailSender
import com.learnspock.tutorial.service.EventRecorder
import spock.lang.Specification

class DefaultEmailServiceSpec extends Specification{

    private DefaultEmailService defaultEmailService

    private CustomerService customerService
    private EmailSender emailSender
    private EventRecorder eventRecorder

    private Customer customer

    def "setup"(){
        customerService = Stub(CustomerService.class)
        emailSender = Mock(EmailSender.class)
        eventRecorder = Mock(EventRecorder.class)

        customer = new Customer("luck")

        defaultEmailService = new DefaultEmailService(customerService, emailSender, eventRecorder)
    }

    def "customer describe email and send email"(){
        given: "a customer has describe email, and we will send it"
        customerService.hasSubscribeEmail(customer) >> true

        when: "we check email should be sent"
        defaultEmailService.notifyIfNecessary(customer)

        then: "customer has received email"
        1 * emailSender.sendEmail(customer)

        and: "event has be recorded"
        // argument check
        1 * eventRecorder.recordEvent({
            event -> event.getType() == Event.Type.SENT &&
                    event.getTimestamp() != null &&
                    event.getCustomerName() == "luck"
        })
    }

    def "customer don't describe email and send no email"(){
        given: "a customer has't describe email, and we will not send it"
        customerService.hasSubscribeEmail(customer) >> false

        when: "we check email should be not sent"
        defaultEmailService.notifyIfNecessary(customer)

        then: "customer has't received email"
        0 * emailSender.sendEmail(customer)

        and: "event has be recorded"
        1 * eventRecorder.recordEvent({
            event -> event.getType() == Event.Type.NOT_SENT &&
                    event.getTimestamp() != null &&
                    event.getCustomerName() == "luck"
        })
    }
}