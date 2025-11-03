public class RopeColor {

    public int minCost(String colors, int[] neededTime) {
        int n=neededTime.length;
        int totalCost=0;

        for(int start=0,end=0;start<n;start=end){
            end=start;
            int sum= 0;
            int gmax=0;
            while(end<n && colors.charAt(end)==colors.charAt(start)){
                sum+=neededTime[end];
                gmax= Math.max(gmax, neededTime[end]);
                end++;
            }

            if(end-start>1){
                totalCost= sum-gmax;
            }
        }

        return totalCost;
    }

    public static void main(String[] args){
        String colors = "abc";
        int[] neededTime={1,2,3};
        RopeColor obj = new RopeColor();
        System.out.println(obj.minCost(colors, neededTime));
    }
}
