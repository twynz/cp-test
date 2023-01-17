package clock.test.clearpoint.clock;

import clock.test.clearpoint.exception.ClockException;

public class Clocke {

    private static final Double PER_MINUTES_ANGLE = Double.valueOf(6);
    private static final Double PER_HOUR_ANGLE = Double.valueOf(30);
    private static final Double PER_HOUR_ANGLE_WITH_MINUTES = 0.5;

    private static final String INPUT_SPLITTER = ":";
    private static final String HOUR = "HOUR";
    private static final String MIN = "MIN";

    public Double Clocke(String inputTime) throws ClockException {
        //get the middle of the String
        final int divider = inputTime.length() / 2;
        String[] hourAndMin = {inputTime.substring(0, divider),inputTime.substring(divider)};
        Integer hour = Integer.parseInt(hourAndMin[0]);
        Integer minute = Integer.parseInt(hourAndMin[1]);
        checkIsValidFormat(hour, minute);
        //if hour larger than 12, do a convert
        if (hour >= 12) {
            hour -= 12;
        }
        Double hourAngle = calculateHandleAngle(HOUR, hour, minute);
        Double minuteAngle = calculateHandleAngle(MIN, minute);
        //divide two scenarios, one is minute handle before hour handle, the other is hour handle before minute handle
        return (minuteAngle - hourAngle >= 0) ? minuteAngle - hourAngle : (360 - hourAngle) + minuteAngle;
    }

    private void checkIsValidFormat(Integer hour, Integer minute) throws ClockException {
        if (hour > 24 || hour < 0 || minute > 59 || minute < 0) {
            throw new ClockException("The time input is not in range!");
        }
    }

    //to calculate angle of clock handle goes, if the type is hour, then also requires minutes
    private Double calculateHandleAngle(String type, Integer... number) throws ClockException {
        switch (type) {
            case HOUR:
                Integer hour = number[0];
                Integer minuteWithHour = number[1];
                return hour * PER_HOUR_ANGLE + minuteWithHour * PER_HOUR_ANGLE_WITH_MINUTES;
            case MIN:
                Integer minute = number[0];
                return minute * PER_MINUTES_ANGLE;
            default:
                throw new ClockException("Not valid type!");
        }
    }
}


