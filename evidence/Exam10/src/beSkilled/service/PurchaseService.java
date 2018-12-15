package beSkilled.service;

import beSkilled.Purchase;
import beSkilled.Summary;
import java.util.List;

public class PurchaseService {

    public static void insert(Purchase purchase) {

    }

    public static void update(Purchase purchase) {

    }

    public static Purchase getPurchaseByProductCode(String code) {
        return null;

    }

    public static Purchase getPurchaseByDetails(String code) {
        return null;

    }

    public static List<Purchase> getPurchaseList() {
        return null;

    }

    public static void insertMain(Purchase purchase) {
        if (purchase != null) {
            insert(purchase);
            Purchase p = getPurchaseByProductCode(purchase.getCode());
            try {
                Summary summary = SummaryService.getSummaryByProductCode(purchase.getCode());
                if (purchase.getCode().equalsIgnoreCase(summary.getCode())) {
                    int tQty = summary.getTotalQty() + purchase.getQty();
                    int aQty = summary.getAvailableQty() + purchase.getQty();
                    summary.setTotalQty(aQty);
                    summary.setAvailableQty(aQty);
                }
                SummaryService.update(summary);
            } catch (Exception e) {
                Summary summary2=new Summary(purchase.getId(), purchase.getName(), purchase.getCode(),purchase.getQty(), 0, purchase.getQty(), p);
                SummaryService.insert(summary2);
            }

        }
    }
}
