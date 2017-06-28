import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by lxuser on 6/25/17.
 */
public class Permutation {

    public static void main(String[] args) {
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) {
            rq.enqueue(StdIn.readString());
        }
        int num = Integer.parseInt(args[0]);
        while(num-- > 0) {
            StdOut.println(rq.dequeue());
        }
    }
}
