package _17_refferences;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ReferencesDemo {

    public static void main(String[] args) {
        MyObject o = new MyObject(); // strong reference, GC deletes it when no strong references left

        // SoftReference will be deleted when GC detects that no free memory left
        SoftReference<MyObject> softReference = new SoftReference<>(o);

        // WeakReference will be deleted immediately when GC starts (if no other references on its object exist)
        WeakReference<MyObject> weakReference = new WeakReference<>(o);

        // PhantomReference places object for removal into ReferenceQueue, so we can view it and then remove permanently
        ReferenceQueue<MyObject> referenceQueue = new ReferenceQueue<>();
        PhantomReference<MyObject> phantomReference = new PhantomReference<>(o, referenceQueue);

        o = null; // cleared strong reference

        new Thread(() -> {
            // check every second whether softReference has been deleted by GC
            // while it is not deleted, weakReference still can not be deleted, too
            while (softReference.get() != null) {
                System.gc();

                System.out.println("softReference = " + softReference.get());
                System.out.println("weakReference = " + weakReference.get());
                System.out.println("phantomReference = " + phantomReference.get()); // always null

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            System.out.println("softReference = " + softReference.get());
            System.out.println("weakReference = " + weakReference.get());
            System.out.println("phantomReference = " + phantomReference.get()); // always null
            try {
                System.out.println("referenceQueue = " + referenceQueue.remove());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }).start();

        // fill the list with Long items until GC decides there is no free memory and deletes softReference and other references
        List<Long> list = new LinkedList<>();
        long i = 0;
        while (softReference.get() != null) {
            if (i % 10_000_000 == 0) {
                System.out.println("list.size() = " + list.size());
            }
            list.addFirst(i++);
        }
        System.out.println("Final list.size() = " + list.size());
    }

    private static class MyObject {
    }
}

