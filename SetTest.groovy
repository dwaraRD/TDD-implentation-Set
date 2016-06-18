import junit.framework.Assert
import spock.lang.Specification

class BoseTest extends Specification {

    def "test when no data is sent to set"() {
        given:
        Bose bose = new Bose();

        when:
        boolean actualValue = bose.isEmpty();

        then:
        Assert.assertEquals(true, actualValue);
    }

    def "test object data sent to the set"() {
        given:
        List<Object> objectList = new ArrayList<>();
        objectList.add(new Object());

        Bose bose = new Bose(objectList);

        when:
        boolean actualValue = bose.isEmpty();

        then:
        Assert.assertEquals(false, actualValue);
    }


    def "contains when different element"() {

        given:
        String a = "A";
        Bose bose = new Bose(a);

        when:
        boolean actualValue = bose.contains("B");

        then:
        Assert.assertEquals(false, actualValue);
    }

    def "contains when same element"() {

        given:
        String a = "A";
        Bose bose = new Bose(a);

        when:
        boolean actualValue = bose.contains("A");

        then:
        Assert.assertEquals(true, actualValue);
    }

    def "test add method when no duplicates are passsed"() {

        given:
        Bose bose = new Bose("B");

        when:
        boolean actualValue = bose.add("A");

        then:
        Assert.assertEquals(true, actualValue);
    }


    def "test add method when duplicate is passed"() {

        given:
        Bose bose = new Bose("B");

        when:
        boolean actualValue = bose.add("B");

        then:
        Assert.assertEquals(true, actualValue);
    }

    def "test add method when null parameter is passed"() {

        given:
        Bose bose = new Bose("B");

        when:
        boolean actualValue = bose.add(null);

        then:
        Assert.assertEquals(false, actualValue);
    }


}