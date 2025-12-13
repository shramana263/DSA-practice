import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CouponCodeValidator {
    
    private static class Coupon {
        String code;
        String businessLine;
        
        Coupon(String code, String businessLine) {
            this.code = code;
            this.businessLine = businessLine;
        }
    }
    
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int n = code.length;
        List<Coupon> validCoupons = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            if(code[i].isEmpty() || !code[i].matches("^[a-zA-Z0-9_]+$")){
                continue;
            }
            if(!businessLine[i].equals("electronics") && !businessLine[i].equals("grocery") && 
               !businessLine[i].equals("pharmacy") && !businessLine[i].equals("restaurant")){
                continue;
            }
            if(isActive[i] == false){
                continue;
            }
            validCoupons.add(new Coupon(code[i], businessLine[i]));
        }
        
        Collections.sort(validCoupons, new Comparator<Coupon>() {
            @Override
            public int compare(Coupon c1, Coupon c2) {
                int order1 = getBusinessLineOrder(c1.businessLine);
                int order2 = getBusinessLineOrder(c2.businessLine);
                
                if(order1 != order2) {
                    return order1 - order2;
                }
                return c1.code.compareTo(c2.code);
            }
        });
        
        List<String> result = new ArrayList<>();
        for(Coupon coupon : validCoupons) {
            result.add(coupon.code);
        }
        return result;
    }
    
    private int getBusinessLineOrder(String business) {
        switch(business) {
            case "electronics": return 0;
            case "grocery": return 1;
            case "pharmacy": return 2;
            case "restaurant": return 3;
            default: return 4;
        }
    }
    
    public static void main(String[] args) {
        String[] code = { "SAVE20","","PHARMA5","SAVE@20" };
        String[] businessLine = {"restaurant","grocery","pharmacy","restaurant"};
        boolean[] isActive = {true,true,true,true};

        CouponCodeValidator obj = new CouponCodeValidator();
        System.out.println(obj.validateCoupons(code, businessLine, isActive));
    }
}
