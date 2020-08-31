package team1.deal.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import team1.deal.service.DemandService;

@SpringBootTest
public class test {

    @Autowired
    private DemandService demandPowerPlantService;


    @Test
    public void test_1(){
        {
            int[]arr = new int[]{2,3,4,5};
            change(arr);
            System.out.println(arr[1]);
        }
    }
    public static void change(int[] arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            if(i%2==1)
            {
                arr[i]+=2;
            }
        }
    }



}
