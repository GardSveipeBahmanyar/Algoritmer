import java.util.ArrayList;
import java.io.*;

public class BalanceArray {

    ArrayList<Integer> OddSortedArray = new ArrayList<>();
    ArrayList<Integer> EvenSortedArray = new ArrayList<>();

    public void SortOdd(int[] A) {
        // 1.Condition: arrayet har 2 elementer og vi legger til de to elementene i
        // arraylisten vår
        if (A.length == 2) {
            OddSortedArray.add(A[1]);
            OddSortedArray.add(A[0]);
            return;
        }
        // 2.Conditon: lik 1.
        if (A.length == 3) {
            OddSortedArray.add(A[1]);
            OddSortedArray.add(A[2]);
            OddSortedArray.add(A[0]);
            return;
        }
        // 3. Condition: Dersom arrayet ikke er delelig på 2, altså odde antall
        // elementer i listen,
        // finner vi det midterste elementet, splitter lista i to fra det midterste
        // elemntet(lager kopier)
        // og kaller rekursivt på listene. Rekkefølgen blir slik alltid høyre del av de
        // nye listene blir håndtert først
        if (A.length % 2 != 0) {
            int x = (A.length) / 2;
            OddSortedArray.add(A[x]);
            int[] smallerThan = new int[x];
            int[] biggerThan = new int[x];
            for (int i = 0; i < x; i++) {
                smallerThan[i] = A[i];
            }
            int in = 0;
            for (int j = x + 1; j < A.length; j++) {
                biggerThan[in] = A[j];
                in++;
            }
            SortOdd(biggerThan);
            SortOdd(smallerThan);
        }
        // Dersom den er delelig på to og ikke har en lengde på 2, vil vi splitte liten
        // i 2 slik at vi får et odde antall elementer i hver av de to listene, som de
        // øvre if-sjekke tar seg av gjennom rekursjonen.
        if (A.length % 2 == 0 && A.length != 2) {
            int x = A.length / 2;
            int[] smallerThan = new int[x];
            int[] biggerThan = new int[x];
            for (int i = 0; i < x; i++) {
                smallerThan[i] = A[i];
            }
            int in = 0;
            for (int j = x; j < A.length; j++) {
                biggerThan[in] = A[j];
                in++;
            }
            SortOdd(biggerThan);
            SortOdd(smallerThan);
        }
    }

    // Dersom listen har partall-antall elementer i seg, kjører denne
    void SortEven(int[] A, int first, int last) {
        if (first > last) {
            return;
        }
        // plusser på en dersom listen vi får inn er odde
        int middleIndex = (first + last) / 2 + (first + last) % 2;
        // Kjører en ifsjekk slik at vi ungår verdier som ikke finnes
        if (middleIndex > last) {
            return;
        }
        // Legger til verdien vi fant i arraylisten
        EvenSortedArray.add(A[middleIndex]);

        SortEven(A, middleIndex + 1, last);
        SortEven(A, first, middleIndex - 1);
    }

    public static void main(String[] args) throws IOException {
        BalanceArray s = new BalanceArray();

        ArrayList<Integer> tempList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            if (line.equals("")) {
                break;
            } else {
                tempList.add(Integer.parseInt(line));
            }
        }

        int[] A = new int[tempList.size()];
        for (int i = 0; i < tempList.size(); i++) {
            A[i] = tempList.get(i);
        }
        // Dersom listen er partall, kjøres partallsSorten
        if (tempList.size() % 2 == 0) {
            s.SortEven(A, 0, A.length - 1);
            System.out.println(s.EvenSortedArray);

        }
        // dersom den er odde, kjøres oddesorten
        else if (tempList.size() % 2 != 0) {
            s.SortOdd(A);
            System.out.println(s.OddSortedArray);
        }

    }
}
