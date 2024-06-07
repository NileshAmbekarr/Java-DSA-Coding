package JavaBasics;

public class multipleVariables {
    public static void main(String[] args) {
        int x= 10, y = 12, z = 3;
        System.out.println("the value of x is "+x);
        System.out.println("the value of y is "+y);
        System.out.println("the value of z is "+z);
        System.out.println("hello"+x+y+z);
        System.out.println(x+y+"hello"+z);
        //inncreament decreament
        System.out.println(z++);
        System.out.println(++z);
        //++z means first increament then use
        // z++ means first use then increament
        // simi;arrrrly
        System.out.println(z--);
        System.out.println(--z);

    }
}
