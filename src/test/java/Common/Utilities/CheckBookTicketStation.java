package Common.Utilities;

import PageObjects.Railway.BookTicketPage;
import org.openqa.selenium.support.ui.Select;

public class CheckBookTicketStation {
    public static boolean checkBookTicketStation(BookTicketPage bookTicketPage, String departStation, String arriveStation) {
        String departStationValue = bookTicketPage.getDepartStation();
        String arriveStationValue = bookTicketPage.getArriveStation();
        return departStationValue.equals(departStation) && arriveStationValue.equals(arriveStation);
    }
}
