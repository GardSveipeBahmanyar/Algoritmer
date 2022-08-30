
import java.util.PriorityQueue;
import java.io.*;

public class Bheap {
    // static ArrayList<Integer> a = new ArrayList<>();

    public static void Sort(PriorityQueue<Integer> heap, int first, int last) {
        // Genererer en kopi av heapen vi sender inn.
        PriorityQueue<Integer> copypq = new PriorityQueue<Integer>(heap);
        // Conditionen som returnerer når vi er ferdig med å sjekke alle elementene i
        // utgangsheapen
        if (first > last) {
            return;
        }

        // Finner midten av heapen, men dersom den er odde, plusser vi på 1.
        int middle = (first + last) / 2 + (first + last) % 2;

        // Fjener ett og ett element fra copiheapen for å finne det midterste elementet
        // vi skal ha. Setter verdien til x
        for (int i = 0; i < middle; i++) {
            copypq.poll();
        }
        int x = copypq.poll();
        // a.add(x); //dersom vi hadde at et arraylist/array vi hadde lagt verdiene inn
        // i, ville det vært en arraylist med elementene i den rekkefølgen hvor vi hadde
        // fått et BBST
        System.out.print(x + " ");
        // Vi kaller så på to rekusrvie kall som tar for seg den høyre og den venstre
        // delen av de nye heapene.
        Sort(heap, middle + 1, last);
        Sort(heap, first, middle - 1);

    }

    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            if (line.equals("")) {
                break;
            } else {
                pq.offer(Integer.parseInt(line));
            }
        }

        // Kan fjerne kommentar dersom man ønsker en autogenerert sortert liste
        // for (int i = 0; i < 11; i++) {
        // pq.offer(i);
        // }
        Sort(pq, 0, pq.size() - 1);

    }
}
