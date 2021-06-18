package Common.Utilities;

import PageObjects.Railway.MyTicketPage;

public class CheckMyTicketInfo {
    public static boolean checkMyTicketInfo(MyTicketPage myTicketPage, String departDate, String departStation, String arriveStation, String seatType, String ticketAmount){
        boolean actualTableExist = myTicketPage.isTableContentExist();

        if (!actualTableExist){
            String actualDepartDate = myTicketPage.getDepartDate();
            String actualDepartStation = myTicketPage.getDepartStation();
            String actualArriveStation = myTicketPage.getArriveStation();
            String actualSeatType = myTicketPage.getSeatType();
            String actualAmount = myTicketPage.getAmount();
            return actualDepartDate.equals(departDate) && actualDepartStation.equals(departStation) && actualArriveStation.equals(arriveStation) && actualSeatType.equals(seatType) && actualAmount.equals(ticketAmount);
        }

        return false;
    }
}
