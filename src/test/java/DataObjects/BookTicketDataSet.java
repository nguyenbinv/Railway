package DataObjects;

import org.testng.annotations.DataProvider;

public class BookTicketDataSet {
    @DataProvider(name = "LoginDataSet")
    public static Object[][] getDataFromDataProvider() {
        return new Object[][]{
                {"6/24/2021", "Sài Gòn", "Nha Trang", "Soft bed with air conditioner", "1"},
                {"6/24/2021", "Sài Gòn", "Đà Nẵng", "Soft bed with air conditioner", "1"},
                {"6/24/2021", "Sài Gòn", "Huế", "Hard seat", "1"}
        };
    }
}
