/**
 * Created by tae on 5/16/14.
 */

public class XSmallest{

    private Double[] nums;
    private int k, first, last;
    private double p;


    public XSmallest(Double[] nums, int k) {
        this.nums = nums;
        this.k = k;
    }


    public double findXSmallest(int lo, int hi){
        first = lo;
        last = hi;
        p = nums[lo];

        if(lo != hi){
            while(lo < hi){
                while (p <= nums[hi] && lo != hi){
                    hi--;
                }
                if(lo != hi){ // And therefore p > nums[hi]
                    nums[lo] = nums[hi];
                    lo++;
                }

                while (p >= nums[lo] && lo != hi){
                    lo++;
                }
                if(lo != hi){
                    nums[hi] = nums[lo];
                    hi--;
                }
            }
            nums[hi] = p;

            if(k <= hi){
                findXSmallest(first, hi);
            } else {
                findXSmallest(hi+1, last);
            }
        }
        return nums[first];
    }

}
