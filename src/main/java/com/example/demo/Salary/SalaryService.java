package com.example.demo.Salary;

import com.example.demo.SiteUser.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SalaryService {

    public int getNationalPension(int price){
        return (int) (price * 0.045);
    }

    public int getHealthInsurance(int price){
        return (int) (price * 0.03498);
    }

    public int getTradeUnion(int price){
        return (int) (price * 0.01);
    }

    public int getEmploymentInsurance(int price){
        return (int) (price * 0.008);
    }

    public int getIncomeTex(int price){
        int tax = 0;

        price *= 12;
        if (price <= 12000000) {
            tax = (int) (price * 0.06);
        } else if (price <= 46000000) {
            tax = (int) (12000000 * 0.06 + (price - 12000000) * 0.15);
        } else if (price <= 88000000) {
            tax = (int) (12000000 * 0.06 + (46000000 - 12000000) * 0.15 + (price - 46000000) * 0.24);
        } else {
            tax = (int) (12000000 * 0.06 + (46000000 - 12000000) * 0.15 + (88000000 - 46000000) * 0.24 + (price - 88000000) * 0.35);
        }
        return tax / 12;
    }

    public int getTex(SiteUser user){
        int sum = 0;
        sum += getNationalPension(user.getPrice());
        sum += getHealthInsurance(user.getPrice());
        sum += getTradeUnion(user.getPrice());
        sum += getEmploymentInsurance(user.getPrice());
        sum += getIncomeTex(user.getPrice());

        return sum;
    }

    public int getOverTimePrice(int price, int overTime){
        int timePrice = price / 209;
        timePrice = timePrice * overTime;

        return timePrice;
    }
    public int getNightTimePrice(int price, int nightTime){
        int timePrice = price / 209;
        timePrice = timePrice * nightTime;

        return timePrice;
    }
    public int getHolidayTimePrice(int price, int holidayTime){
        int timePrice = price / 209;
        timePrice = timePrice * holidayTime;

        return timePrice;
    }
    public int getFamilyPrice(int price, boolean spouse, int children){
        int sum = 0;
        if(spouse){
            sum += 50000;
        }
        sum = sum + children * 30000;

        return sum;
    }

    public int getPayment(SiteUser user){
        int sum = 0;
        sum += user.getPrice();
        sum += getOverTimePrice(user.getPrice(), user.getOverTime());
        sum += getNightTimePrice(user.getPrice(), user.getNightTime());
        sum += getHolidayTimePrice(user.getPrice(), user.getHolidayTime());
        sum += getFamilyPrice(user.getPrice(), user.isSpouse(), user.getChildren());

        return sum;
    }

    public int getPay(SiteUser user){
        return getPayment(user) - getTex(user);
    }

}
