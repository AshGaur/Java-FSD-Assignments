class VarargsDemo
{
    public static void main(String[] args) {
        VarargsDemo obj = new VarargsDemo();
        System.out.println(obj.add());
        System.out.println(obj.add(2,4));
        System.out.println(obj.add(2,4,5));
        System.out.println(obj.add(2,4,6,7));
        System.out.println(obj.add(new int[]{2,5,8,15,32}));//Arrays are also supported as arguments by varargs
    }
    int add(int... nums){
        int sum = 0;
        for(int n:nums){
            sum+=n;
        }
        return sum;
    }
}