class MedianFinder {

    private List<Integer> arr;
    public MedianFinder() {
        arr=new ArrayList<>();
    }
    
    public void addNum(int num) {
    int idx = Collections.binarySearch(arr, num);
        if (idx < 0) idx = -(idx + 1); 
        arr.add(idx, num); 
    }

    
    public double findMedian() {
        int len=arr.size();
        if(len%2==0) {
            return ((double) (arr.get(len/2)+arr.get(len/2-1))/2.0);
        }
        return (double) arr.get(len/2);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */