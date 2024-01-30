public class trappingRainwater
{
    public static void main(String[] args)
    {
        int[] test1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        int len1 = test1.length;

        int[] test2 = {4,2,0,3,2,5};
        int len2 = test2.length;

        System.out.println(trap(test1,len1));
        System.out.println(trap2(test1,len1));
        System.out.println(trap(test2,len2));
        System.out.println(trap2(test2,len2));


    }

    public static int trap(int[] x, int a) // using Math and brute force approach
    {
        int bucket = 0; //where water is going to be stored
        for (int i = 0; i < a - 1; i++)
        {
            int leftMax = x[i]; //left sides max
            for (int j = 0; j < i; j++)
                leftMax = Math.max(leftMax, x[j]);

            int rightMax = x[i]; //right sides max
            for (int j = i + 1; j < a; j++)
                rightMax = Math.max(rightMax, x[j]);

            bucket += Math.min(leftMax, rightMax) - x[i];


        }
        return bucket;
    }


    public static int trap2(int[] z, int b) //using Math and two pointers
    {
        int l = 0; //pointer
        int r = b -1;

        int lMax = 0; //max vals
        int rMax = 0;

        int bucket2 = 0;

        while (l <= r)
        {
            if (lMax <= rMax)
            {
                bucket2 += Math.max(0, lMax - z[l]);
                lMax = Math.max(lMax, z[l]);
                l += 1;
            } else
            {
                bucket2 += Math.max(0, rMax - z[r]);
                rMax = Math.max(rMax, z[r]);
                r -= 1;
            }
        }
        return bucket2;
    }

    public static int trap3(int[] z, int b) //using Math and two pointers
    {
        int l = 0; //pointer
        int r = b -1;

        int lMax = 0; //max vals
        int rMax = 0;

        int bucket2 = 0;

        while (l <= r) //line that almost made me lose hope
        {
            if (rMax <= lMax)
            {
                bucket2 += Math.max(0, rMax - z[r]);
                rMax = Math.max(rMax, z[r]);
                r -= 1;
            } else
            {
                bucket2 += Math.max(0, lMax - z[l]);
                lMax = Math.max(lMax, z[l]);
                l += 1;
            }
        }
        return bucket2;
    }

}
