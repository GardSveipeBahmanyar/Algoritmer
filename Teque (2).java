import java.io.*;

public class Teque {

    public class Node {
        Node next;
        int x = 0;

        Node(int x) {
            this.x = x;
        }
    }

    int k = 0; // Lengden på lenkelisten
    Node first;

    // legger til først og oppdaterer lengden på lista
    void push_front(int x) {
        if (first == null) {
            k++;
            Node n = new Node(x);
            first = n;
        } else {
            k++;
            Node n = new Node(x);
            n.next = first;
            first = n;
        }
    }

    // legger på først om lista er tom, ellers legger til sist
    void push_back(int x) {
        if (first == null) {
            push_front(x);
        } else if (first.next == null) {
            Node n = new Node(x);
            first.next = n;
        } else {
            Node n = new Node(x);
            System.out.println("k: " + k);
            Node last = find_elem(k - 1);
            last.next = n;
            k++;
        }
    }

    // finner midterste verdien og legger til i midten, legger til først om lista er
    // tom
    void push_middle(int x) {
        if (k <= 1) {
            push_front(x);
        } else {
            int i = (k + 1) / 2;
            Node n = new Node(x);
            Node before_m = find_elem(i - 1);
            n.next = before_m.next;
            before_m.next = n;
            k++;
        }
    }

    // Traverserer gjennom lenkelisten og finner etterspurt element
    Node find_elem(int i) {
        Node trav = first;
        int p = 0;
        while (p != i) {
            trav = trav.next;
            p++;
        }
        return trav;
    }

    void get(int i) {
        System.out.println(find_elem(i).x);
    }

    void print_Llist() {
        Node trav = first;
        while (trav.next != null) {
            trav = trav.next;
        }
    }

    // LES KOMMENTARENE UNDER
    public static void main(String[] args) throws IOException {
        Teque t = new Teque();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            String cmd = line[0];
            int x = Integer.parseInt(line[1]);
            if (cmd.equals("push_back")) {
                t.push_back(x);
                t.print_Llist();
            } else if (cmd.equals("push_front")) {
                t.push_front(x);
                t.print_Llist();
            } else if (cmd.equals("push_middle")) {
                t.push_middle(x);
                t.print_Llist();
            } else if (cmd.equals("get")) {
                t.get(x);
                t.print_Llist();
            }
        }

        /*
         * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         * while (!br.readLine().equals(" ")) { String[] line =
         * br.readLine().split(" "); String command = line[0]; int x =
         * Integer.parseInt(line[1]); System.out.println(command);
         * System.out.println(x); if (command.equals("push_back")) {
         * System.out.println("1"); t.push_back(x); t.print_Llist(); } else if
         * (command.equals("push_front")) { System.out.println("2"); t.push_front(x);
         * t.print_Llist(); } else if (command.equals("push_middle")) {
         * System.out.println("3"); t.push_middle(x); t.print_Llist(); } else if
         * (command.equals("get")) { System.out.println("4"); t.get(x); t.print_Llist();
         * } }
         */
        // TESTKODE OM BUFFER IKKE FUNGERER: TESTKODEN FUNGERER HELT RIKTIG
        /*
         * t.push_back(9); t.print_Llist(); t.push_front(3); t.print_Llist();
         * t.push_middle(5); t.print_Llist(); t.get(0); t.get(1); t.get(2);
         * t.push_middle(1); t.get(1); t.get(2);
         */
    }

}