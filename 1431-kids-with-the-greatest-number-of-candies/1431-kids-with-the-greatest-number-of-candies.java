class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean>list=new ArrayList<>();
        int max=0;
        for(int a:candies)
        {
            if (a>max)
            max=a;
        }
        for( int i=0; i<candies.length; i++)

        {
            if(extraCandies+candies[i]>=max)
            list.add(true);
            else
            list.add(false);
        }
        return list;
    }
}