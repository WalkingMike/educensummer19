import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.HashSet;

public class Main {
    public static void main(String[] args){
        int number = 1000;
        Cat[] kittys = {null, null, null, null};

        // addition
        //
        ArrayList <Cat> catArrayList = new ArrayList();
        long startTime = System.nanoTime();
        for (int i = 0; i < number; i++){
            if (i == number / 2) {
                kittys[0] = new Cat();
                catArrayList.add(kittys[0]);
                continue;
            }
                catArrayList.add(new Cat());
        }
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("ArrayList addition: " + estimatedTime);

        LinkedList <Cat> catLinkedList = new LinkedList();
        startTime = System.nanoTime();
        for (int i = 0; i < number; i++){
            if (i == number / 2) {
                kittys[1] = new Cat();
                catLinkedList.add(kittys[1]);
                continue;
            }
            catLinkedList.add(new Cat());
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("LinkedList addition: " + estimatedTime);

        TreeSet <Cat> catTreeSet = new TreeSet();
        startTime = System.nanoTime();
        for (int i = 0; i < number; i++){
            if (i == number / 2) {
                kittys[2] = new Cat();
                catTreeSet.add(kittys[2]);
                continue;
            }
            catTreeSet.add(new Cat());
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("TreeSet addition: " + estimatedTime);

        HashSet <Cat> catHashSet = new HashSet();
        startTime = System.nanoTime();
        for (int i = 0; i < number; i++){
            if (i == number / 2) {
                kittys[3] = new Cat();
                catHashSet.add(kittys[3]);
                continue;
            }
            catHashSet.add(new Cat());
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("HashSet addition: " + estimatedTime);

        //access
        //
        startTime = System.nanoTime();
        catArrayList.contains(kittys[0]);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("ArrayList access: " + estimatedTime);

        startTime = System.nanoTime();
        catLinkedList.contains(kittys[1]);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("LinkedList access: " + estimatedTime);

        startTime = System.nanoTime();
        catTreeSet.contains(kittys[2]);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("TreeSet access: " + estimatedTime);

        startTime = System.nanoTime();
        catHashSet.contains(kittys[3]);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("HashSet access: " + estimatedTime);

        //deletion
        //
        startTime = System.nanoTime();
        catArrayList.remove(kittys[0]);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("ArrayList deletion: " + estimatedTime);

        startTime = System.nanoTime();
        catLinkedList.remove(kittys[1]);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("LinkedList deletion: " + estimatedTime);

        startTime = System.nanoTime();
        catTreeSet.remove(kittys[2]);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("TreeSet deletion: " + estimatedTime);

        startTime = System.nanoTime();
        catHashSet.remove(kittys[3]);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("HashSet deletion: " + estimatedTime);
    }
}
