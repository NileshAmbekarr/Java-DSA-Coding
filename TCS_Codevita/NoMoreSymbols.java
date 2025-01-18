package TCS_Codevita;

import java.util.*;

public class NoMoreSymbols {

    static Map<String, Integer> dn2 = new HashMap<>();
    static Map<String, Character> do1 = new HashMap<>();

    static {
        dn2.put("one", 1);
        dn2.put("two", 2);
        dn2.put("three", 3);
        dn2.put("four", 4);
        dn2.put("five", 5);
        dn2.put("six", 6);
        dn2.put("seven", 7);
        dn2.put("eight", 8);
        dn2.put("nine", 9);
        dn2.put("zero", 0);

        do1.put("add", '+');
        do1.put("sub", '-');
        do1.put("mul", '*');
        do1.put("rem", '%');
        do1.put("pow", '^');
    }

    public static int pfix(String exq) {
        Deque<Integer> ta = new ArrayDeque<>();
        Set<Character> ops = new HashSet<>(Arrays.asList('+', '-', '*', '/', '%', '^'));
        String[] to = exq.split(" ");

        for (int i = to.length - 1; i >= 0; i--) {
            String t1 = to[i];

            if (isNumeric(t1)) {
                ta.push(Integer.parseInt(t1));
            } else if (ops.contains(t1.charAt(0))) {
                if (ta.size() < 2) {
                    System.out.println("expression is not complete or invalid");
                    return -1;
                }

                int op1, op2;
                switch (t1) {
                    case "^":
                        int ex1 = ta.pop();
                        int be = ta.pop();
                        ta.push((int) Math.pow(ex1, be));
                        break;
                    case "/":
                        op2 = ta.pop();
                        if (op2 == 0) {
                            System.out.println("expression is not complete or invalid");
                            return -1;
                        }
                        op1 = ta.pop();
                        ta.push(op1 / op2);
                        break;
                    case "%":
                        op2 = ta.pop();
                        if (op2 == 0) {
                            System.out.println("expression is not complete or invalid");
                            return -1;
                        }
                        op1 = ta.pop();
                        ta.push(op1 % op2);
                        break;
                    case "+":
                        op1 = ta.pop();
                        op2 = ta.pop();
                        ta.push(op1 + op2);
                        break;
                    case "-":
                        op1 = ta.pop();
                        op2 = ta.pop();
                        ta.push(op1 - op2);
                        break;
                    case "*":
                        op1 = ta.pop();
                        op2 = ta.pop();
                        ta.push(op1 * op2);
                        break;
                    default:
                        System.out.println("expression is not complete or invalid");
                        return -1;
                }
            } else {
                System.out.println("expression is not complete or invalid");
                return -1;
            }
        }
        return (ta.size() == 1) ? ta.pop() : -1;
    }

    public static String conv(String s) {
        int nx = 0;

        String[] words = s.split("c");
        for (String word : words) {
            Integer value = dn2.get(word.trim());
            if (value != null) {
                nx = nx * 10 + value;
            } else {
                System.out.println("Invalid word encountered: " + word);
                return "-1"; // Mark as invalid if any segment is invalid
            }
        }
        return String.valueOf(nx);
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();

        if (s.isEmpty()) {
            System.out.println("Invalid input: Input cannot be empty.");
            sc.close();
            return;
        }

        String[] lee = s.split(" ");
        StringBuilder st = new StringBuilder();
        boolean flag = false;

        for (String i : lee) {
            if (!do1.containsKey(i)) {
                String jik = conv(i);
                if (jik.equals("-1")) {
                    flag = true;
                    System.out.println("expression evaluation stopped, invalid words present");
                    break;
                }
                st.append(jik).append(" ");
            } else {
                st.append(do1.get(i)).append(" ");
            }
        }

        if (!flag) {
            int result = pfix(st.toString().trim());
            if (result != -1) {
                System.out.println(result);
            }
        }
        sc.close();
    }
}


