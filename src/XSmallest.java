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


    public double partition(int lo, int hi){
        first = lo;
        last = hi;
        p = nums[lo];

        if(hi != lo){
            while(lo < hi){
                while (p <= nums[hi] && lo !=hi){
                    hi--;
                }
                if(hi != lo){
                    nums[lo] = nums[hi];
                    lo++;
                }

                while (p>=nums[lo] && lo!=hi){
                    lo++;
                }
                if(hi != lo){
                    nums[hi] = nums[lo];
                    hi--;
                }
            }
            nums[hi] = p;

            if(k <= hi){
                partition(first, hi);
            } else {
                partition(hi+1, last);
            }
        }
        return nums[first];
    }

}
