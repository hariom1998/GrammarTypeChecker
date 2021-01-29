import java.util.*;

class typechecker {
    Scanner sc = new Scanner(System.in);
    ArrayList<Character> terminals = new ArrayList<Character>();
    ArrayList<Character> nonterminals = new ArrayList<Character>();
    ArrayList<ArrayList<String>> productions = new ArrayList<ArrayList<String>>();
    char start;

    int type0(int p, String lhs) {
        for (int n = 0; n < lhs.length(); n++) {
            for (int i = 0; i < nonterminals.size(); i++) {
                if (lhs.charAt(0) == nonterminals.get(i)) {
                    return 0;
                }
            }
        }
        return 9;
    }

    int type1(int p, String lhs, String rhs, int l, int r) {
        int j = 0, k = 0;
        for (int q = 0; q < lhs.length(); q++) {
            if (lhs.charAt(q) == start) {
                j = j + 1;
            }
        }
        for (int t = 0; t < rhs.length(); t++) {
            if (rhs.charAt(t) == start) {
                k = k + 1;
            }
        }
        if ((j == 0) && (k != 0))
            return 0;
        if ((lhs.equals(Character.toString(start)))) {
            for (int i = 0; i < terminals.size(); i++) {
                if (rhs.charAt(0) == terminals.get(i)) {
                    return 1;
                }
            }
        }
        if (l <= r)
            return 1;
        return 0;
    }

    int type2(int l) {
        if (l == 1)
            return 2;
        else
            return 1;
    }

    int type3_LL(int p, String rhs, String lhs) {
        int counter = 0;
        for (int j = 0; j < rhs.length(); j++) {
            for (int i = 0; i < terminals.size(); i++) {
                if (rhs.charAt(j) == terminals.get(i)) {
                    counter = counter + 1;
                }
            }
        }
        if (counter == 0)
            return 3;
        else
            return 2;
    }

    int type3_RL(int p, String rhs) {
        int counter = 0;
        for (int j = 0; j < rhs.length(); j++) {
            for (int i = 0; i < terminals.size(); i++) {
                if (rhs.charAt(j) == terminals.get(i)) {
                    counter = counter + 1;
                }
            }
        }
        if (counter == 1) {
            for (int i = 0; i < terminals.size(); i++) {
                if (rhs.charAt(rhs.length() - 1) != terminals.get(i))
                    return 3;
            }
        }
        return 2;

    }

    void initiate() {
        System.out.println("Enter no of terminal symbols");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter TERMINAL Symbol - ");
            terminals.add(sc.next().charAt(0));
        }
        System.out.println("Enter no of non-terminal symbols");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter NON-TERMINAL Symbol - ");
            nonterminals.add(sc.next().charAt(0));
        }
        System.out.println("Enter START symbol");
        start = sc.next().charAt(0);
        System.out.println("Enter no of Productions - ");
        n = sc.nextInt();
        int min = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("Enter LHS of " + (i + 1) + " th/st production function : ");
            ArrayList<String> str = new ArrayList<String>();
            str.add(sc.next());
            System.out.println("Enter RHS of " + (i + 1) + " th/st production function : ");
            str.add(sc.next());
            productions.add(str);
            int l_len = productions.get(i).get(0).length();
            int r_len = productions.get(i).get(1).length();
            min = type0(i, productions.get(i).get(0));
            if (min == 0)
                min = type1(i, productions.get(i).get(0), productions.get(i).get(1), l_len, r_len);
            if (min == 1)
                min = type2(l_len);
            if (min == 2) {
                int flag = 0;
                for (int j = 0; j < nonterminals.size(); j++) {
                    if (productions.get(i).get(1).charAt(0) == nonterminals.get(j)) {
                        flag = 1;
                        break;
                    } else if (productions.get(i).get(1).charAt(0) == terminals.get(j)) {
                        flag = 2;
                        break;
                    }
                }
                if (flag == 1)
                    min = type3_LL(i, productions.get(i).get(1), productions.get(i).get(0));
                else if (flag == 2)
                    min = type3_RL(i, productions.get(i).get(1));
            }
            continue;
        }
        if (min == 0 || min == 1 || min == 2 || min == 3) {
            System.out.println("TYPE IS : " + min);
        } else {
            System.out.println("NO TYPE");
        }
    }

    public static void main(String[] args) {
        typechecker obj = new typechecker();
        obj.initiate();
    }
}
