package za.ac.cput.factory;

/**
 * EntertainmentFactory.java
 * Factory class for the Login
 * Author: ??
 * Date: 8 October 2021
 **/

import za.ac.cput.entity.Entertainment;

public class EntertainmentFactory {

    public static Entertainment createEntertainment(int eventCode,String ChooseEvent, String about, String date, String time, String location, String cost, String security)
    {
        return new Entertainment.Builder().setEventCode(eventCode).setChooseEvent(ChooseEvent).setAbout(about).setDate(date).setTime(time).setLocation(location).setCost(cost).setSecurity(security).build();
    }

}
