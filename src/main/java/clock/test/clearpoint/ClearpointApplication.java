package clock.test.clearpoint;

import clock.test.clearpoint.clock.Clocke;
import clock.test.clearpoint.exception.ClockException;

public class ClearpointApplication {

    public static void main(String[] args) throws ClockException {
        Clocke clocke = new Clocke();
        System.out.println(clocke.Clocke(args[0]));
//        System.out.println(clocke.Clocke("1230"));
//        System.out.println(clocke.Clocke("0245"));
//        System.out.println(clocke.Clocke("1445"));
//        System.out.println(clocke.Clocke("1754"));
//        System.out.println(clocke.Clocke("1710"));
//        System.out.println(clocke.Clocke("1200"));
    }

}
