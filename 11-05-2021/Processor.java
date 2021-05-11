class Actions{
    void startProcess(){
        new Thread(new Runnable(){  //Anonymous sub class of Runnable
            @Override
            public void run(){
                System.out.println("Thread created inside anonymous class :"+Thread.currentThread().getName());
            }
        }).start();
    }
}


class Processor{
    public static void main(String[] args) {
        new Actions().startProcess();
    }
}