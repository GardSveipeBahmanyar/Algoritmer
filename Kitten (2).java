import java.io.*;
import java.util.ArrayList;

public class Kitten {

    public class Node {

        ArrayList<Node> children = new ArrayList<>();
        Node parent;
        int x = 0;
        boolean isKitten = false;

        Node(int x) {
            this.x = x;
        }
    }

    // liste med alle nodene som finnes i treet vårt
    ArrayList<Node> globalNodes = new ArrayList<>();
    // verdien på noden som er kitten-noden
    int kittenValue = 0;

    public void setKitten(int x) {
        kittenValue = x;
    }

    public Node Insert(Node p, int y, boolean isParent) {
        boolean exsist = false;
        Node n = null; // Pekernode

        for (int i = 0; i < globalNodes.size(); i++) {
            // sjekker om en av nodene allerede finnes
            if (globalNodes.get(i).x == y) {
                exsist = true;
                n = globalNodes.get(i);
                // dersom noden er en child, setter vi den inn i riktig childbeholder til
                // foreldrenoden
                if (!isParent) {
                    globalNodes.get(i).parent = p;
                    p.children.add(globalNodes.get(i));
                }
            }
        }
        // Dersom noden ikke eksiterer, lager vi en ny node og legger den til i
        // nodelista vår
        if (!exsist) {

            Node newNode = new Node(y);
            if (p != null) {
                p.children.add(newNode);
            }
            newNode.parent = p;
            globalNodes.add(newNode);
            return newNode;
        }
        return n;
    }

    // Metode som finner noden til den gitte verdien
    public Node findNode(int x) {
        for (int i = 0; i < globalNodes.size(); i++) {
            if (globalNodes.get(i).x == x) {
                return globalNodes.get(i);
            }
        }
        return null;
    }

    ArrayList<Integer> solution = new ArrayList<>();

    // Metode som finner veien fra en gitt node til rota
    public void findRoot(Node n) {
        if (n == null) {
            return;
        }
        solution.add(n.x);
        findRoot(n.parent);

    }

    // Finner utvei fra kitten-noden til rota
    public void helpKittenEscape() {
        for (int i = 0; i < globalNodes.size(); i++) {
            if (globalNodes.get(i).x == kittenValue) {
                findRoot(globalNodes.get(i));
            }
        }
        System.out.println("Solution: " + solution);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Kitten k = new Kitten();
        int teller = 0;
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            String nyLine = line.trim();
            if (nyLine.equals("-1")) {
                break;
            } else if (teller == 0) {
                int kittenNumber = Integer.parseInt(line);
                k.setKitten(kittenNumber);
                teller++;
            } else if (teller > 0) {
                String[] streng = line.split(" ");
                int parent = Integer.parseInt(streng[0]);
                Node p = k.Insert(null, parent, true);
                for (int i = 1; i < streng.length; i++) {
                    k.Insert(p, Integer.parseInt(streng[i]), false);
                }
            }
        }
        k.helpKittenEscape();
    }
}
