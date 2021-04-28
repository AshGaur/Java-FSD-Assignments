class FibonacciSeries{
    public static void main(String[] args) {
        //To print till 89
        int first = 0;
        int second = 1;
        int nextTerm = 0;
        System.out.print(second+" ");
        while(nextTerm<=89){
            nextTerm = first+second;
            System.out.print(nextTerm+" ");
            first = second;
            second = nextTerm;
        }
        System.out.println();
    }
}