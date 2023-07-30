import java.util.*;
import java.io.*;

class Heap {
    int[] arr;
    int size;
    int idx;

    Heap(int n) {
        arr = new int[n];
        size = n;
        idx = -1;
    }

    public void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void push(int ele) {
        if (idx >= size - 1)
            return;

        idx++;
        int childIdx = idx;
        arr[childIdx] = ele;

        int parentIdx = (childIdx - 1) / 2;
        while (parentIdx >= 0 && arr[parentIdx] > arr[childIdx]) {
            swap(childIdx, parentIdx);
            childIdx = parentIdx;
            parentIdx = (childIdx - 1) / 2;
        }
    }

    public int remove() {
        if (idx < 0)
            return -1;

        int val = arr[0];
        arr[0] = arr[idx];

        int parentIdx = 0;
        while (parentIdx < idx) { // idx at last
            int childIdx1 = 2 * parentIdx + 1;
            int childIdx2 = 2 * parentIdx + 2;
            int smallIdx = parentIdx;

            if (childIdx1 <= idx && arr[childIdx1] < arr[smallIdx]) {
                smallIdx = childIdx1;
            }
            if (childIdx2 <= idx && arr[childIdx2] < arr[smallIdx]) {
                smallIdx = childIdx2;
            }
            if (parentIdx == smallIdx)
                break;

            swap(smallIdx, parentIdx);
            parentIdx = smallIdx;
        }
        idx--;
        return val;
    }
}

public class Solution {
    static int[] minHeap(int n, int[][] q) {
        ArrayList<Integer> ans = new ArrayList<>();
        Heap pq = new Heap(n);

        for (int[] query : q) {
            if (query[0] == 0)
                pq.push(query[1]);
            else {
                ans.add(pq.remove());
            }
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
