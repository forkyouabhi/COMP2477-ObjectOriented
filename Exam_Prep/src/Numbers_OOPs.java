class Numbers_OOPs {
    //properties
    private int a;
    private int b;

    //Methods
    public void sum(){
        System.out.println(a+b);
    }

    public void sub(){
        System.out.println(a-b);
    }

    public static void main(String [] args){

        // Object Initialization
        Numbers_OOPs obj;
        obj = new Numbers_OOPs();
        // Assigning values to private values
        obj.a=1;
        obj.b=2;

        obj.sum();
        obj.sub();


    }

}