package weekofapr30;
import java.util.Arrays;
class Exercises678{
    protected int[] getSorted(int[] ar){
        for(int i=0;i<ar.length;i++){
            ar[i] = Integer.parseInt(new StringBuilder(String.valueOf(ar[i])).reverse().toString());
        }
        Arrays.sort(ar);
        return ar;
    }
    protected int getSecondSmallest(int ar[]){
        Arrays.sort(ar);
        return ar[1];
    }
    protected int calculateSum(int n){
        int sum = 0,count = 0,i=1;
        while(count<n){
            if(i%3==0||i%5==0){
                sum+=i;
                count++;
            }
            i++;
        }
        return sum;
    }
}