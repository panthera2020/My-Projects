public class MostWater {

    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;

        while(left < right){
            int area = Math.min(heights[left], heights[right]) * (right - left);

            if(area > maxArea){maxArea = area;}

            if(heights[left] < heights[right]){ left++;}
            else {right--;}
        }
        return maxArea;
    }

}
