package hash.demo;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:wanghuimin
 * Date:2020-05-21
 * Time:20:19
 * 一万年太久，只争朝夕，加油
 */
enum Sex{
    MALE,
    FEMALE,
    UNKNOWN,

}
public class TestEnum {
    public static void main(String[] args) {
        Sex s = Sex.MALE;
        System.out.println(s);
        System.out.println(Arrays.toString(Sex.values()));
    }
}
