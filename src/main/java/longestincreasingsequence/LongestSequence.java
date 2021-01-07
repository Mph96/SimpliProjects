package longestincreasingsequence;


import java.util.*;

public class LongestSequence {

    int[] randArr = new int[99];
    Random random = new Random();

    public Integer[] getLongestIncreasingSubsequence() {

        //Creates and prints out a array willed with random numbers
        for(int i = 0; i < 99; i++){
            randArr[i] = random.nextInt(100);
        }
        System.out.println("Using this randomly filled array: \n" + Arrays.toString(randArr) + "\n");

        // Sequences we find
        List<Integer[]> sequences = new ArrayList<>();

        // Our method of recursion
        // helps to keep track of what we've seen previously
        Stack<Integer> entries = new Stack<>();

        // step through our numbers
        for (int r = 0; r < this.randArr.length; r++) {

            // Our number we're looking at
            Integer entry = this.randArr[r];

            // If this is our first number, we just add it and move on
            if (entries.empty()) {
                entries.push(entry);
                continue;
            }

            // The previous number
            Integer previous = entries.peek();

            // If our number is higher than the previous - add it to our stack
            if (previous < entry) {
                entries.push(entry);
            }

            // if the number is decreasing
            // or if we are at the end
            // then capture the sequence
            boolean atTheEnd = (r == this.randArr.length - 1);
            if (previous >= entry || atTheEnd) {

                // Capture the sequence we found
                sequences.add(toArray(entries));

                // Starting over so we clear out stack
                // Start the next sequence
                entries.push(entry);
            }
        }
        return longest(sequences);
    }

    public Integer[] longest(List<Integer[]> candidates) {
        TreeMap<Integer, Integer[]> byLength = new TreeMap<>();
        for (Integer[] candidate: candidates) {
            byLength.put(candidate.length, candidate);
        }
        return byLength.lastEntry().getValue();
    }

    private Integer[] toArray(Stack<Integer> entries) {
        Integer[] sequence = new Integer[entries.size()];
        int idx = entries.size() - 1;
        Integer sequenceEntry = entries.pop();
        while (sequenceEntry != null) {
            sequence[idx] = sequenceEntry;
            try {
                sequenceEntry = entries.pop();
            } catch (EmptyStackException e) {
                break;
            }
            idx--;
        }
        return sequence;
    }
}
