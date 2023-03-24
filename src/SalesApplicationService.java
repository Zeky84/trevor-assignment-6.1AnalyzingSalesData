import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SalesApplicationService {

    public  void  modelYearlySalesReport(List<SalesDataByModel> modelDataInfo, String teslaModel){

        System.out.println("Model " + teslaModel + " Yearly Sales Report");
        System.out.println("---------------------------");
        
        //Getting sales by year and printing them
        modelYearlySalesReport(modelDataInfo);

        //Getting object by the higher and lower sale value and printing best & worst month.
        bestWorstMonthSale(modelDataInfo, teslaModel);

        System.out.println();
    }

    private static void bestWorstMonthSale(List<SalesDataByModel> modelDataInfo, String teslaModel) {
        SalesDataByModel bestMonthSaleValue = modelDataInfo.stream().max(SalesDataByModel::compareTo).get();
        SalesDataByModel worstMonthSaleValue = modelDataInfo.stream().min(SalesDataByModel::compareTo).get();
        System.out.println("The "+ "best month" + " for Model "+ teslaModel + " was: " + bestMonthSaleValue.getYearMonth());
        System.out.println("The "+ "worst month" + " for Model "+ teslaModel + " was: " + worstMonthSaleValue.getYearMonth());
    }

    private static void modelYearlySalesReport(List<SalesDataByModel> modelDataInfo) {
        //Streaming list to get a map with the sum of all sales by year
        Map<Integer, Integer> modelYearsSales = modelDataInfo.stream()
                .collect(Collectors.groupingBy(model->model.getYearMonth().getYear(),Collectors.summingInt(SalesDataByModel::getSaleValue)));

        for(Integer year: modelYearsSales.keySet()){
            System.out.println(year + " -> " + modelYearsSales.get(year));
        }
    }
}
