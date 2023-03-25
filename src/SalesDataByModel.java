import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class SalesDataByModel implements Comparable<SalesDataByModel> {
    private YearMonth fullDate;

    private Integer saleValue;

    public SalesDataByModel(String[] modelsInfo){
        setYearMonth(modelsInfo[0]);
        setSaleValue(Integer.parseInt(modelsInfo[1]));
    }

    public YearMonth getYearMonth() {
        return fullDate;
    }

    public void setYearMonth(String yearMonth) {
        this.fullDate = YearMonth.parse(yearMonth, DateTimeFormatter.ofPattern("MMM-yy"));
    }

    public Integer getSaleValue() {
        return saleValue;
    }

    public void setSaleValue(Integer saleValue) {
        this.saleValue = saleValue;
    }

    @Override
    public int compareTo(SalesDataByModel that) {
        return this.saleValue.compareTo(that.saleValue);

    }
}
