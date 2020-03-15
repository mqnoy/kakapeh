/*
 * aplikasi ini 
 */

package test;

import java.util.ArrayList;

/**
 *
 * @author qnoy
 */
public class Testarea {
    public static void main(String[] args){
        ArrayList<Integer> check_data_stock = new ArrayList<Integer>();
        
        check_data_stock.add(100);
        check_data_stock.add(200);
        System.out.println(check_data_stock);
        
        for (int i = 0; i < check_data_stock.size(); i++) {
            if (check_data_stock.get(i) == 100) {
                System.out.println("seratuss");
            }
            if (!check_data_stock.get(i).equals(100)) {
                System.out.println("dua ratusss");
            }
        }
        
    }
}
