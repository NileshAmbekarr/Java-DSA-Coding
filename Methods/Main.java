package Methods;

            public class Main {
                public static void main(String[] args) {
                    // FOR LOOP
                    for(int i = 1; i <= 20; i++){
                        int sqr = (i*2) * (i*2);
                        System.out.print(sqr + " ");
                    }
                    System.out.println();

                    // WHILE LOOP
                    int j = 1;
                    while(j <= 20){
                        int sqr = (j*2 * j*2);
                        System.out.print(sqr + " ");
                        j++;
                    }
                    System.out.println();
                    // DO-WHILE LOOP
                    int k = 1;
                    do{
                        int sqr = k*2 * k*2;
                        System.out.print(sqr + " ");
                        k++;
                    }while(k<=20);
                }
            }
