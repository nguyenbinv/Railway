package Common.Utilities;

import PageObjects.Railway.BookTicketPage;

public class CheckTicketInfo {
    public static boolean checkTicketInfo(BookTicketPage bookTicketPage, String departDate, String departStation, String arriveStation, String seatType, String ticketAmount) {
        String actualDepartDate = bookTicketPage.getDepartDateInfo();
        String actualDepartStation = bookTicketPage.getDepartStationInfo();
        String actualArriveStation = bookTicketPage.getArriveStationInfo();
        String actualSeatType = bookTicketPage.getSeatTypeInfo();
        String actualTicketAmount = bookTicketPage.getTicketAmountInfo();
        return actualDepartDate.equals(departDate) && actualDepartStation.equals(departStation) && actualArriveStation.equals(arriveStation) &&
                actualSeatType.equals(seatType) && actualTicketAmount.equals(ticketAmount);
    }
}
