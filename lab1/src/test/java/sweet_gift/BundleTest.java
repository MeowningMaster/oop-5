package sweet_gift;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import sweet_gift.Sweets.Cookie;
import sweet_gift.Sweets.Filling;
import sweet_gift.Sweets.Lollipop;
import sweet_gift.Sweets.Sweet;

public class BundleTest {
    @Test
    public void sortTest() {
        Lollipop l1 = new Lollipop("L1", 14, 1);
        Lollipop l2 = new Lollipop("L2", 20, 5);
        Lollipop l3 = new Lollipop("L3", 10, 3);
        l3.setWithGum(true);

        Cookie c1 = new Cookie("C1", 25, 5);
        Cookie c2 = new Cookie("C2", 40, 10);
        Cookie c3 = new Cookie("C3", 18, 4);
        c3.setFilling(Filling.MILK);

        Bundle bundle = new Bundle();
        bundle.add(l1);
        bundle.add(l2);
        bundle.add(l3);
        bundle.add(c1);
        bundle.add(c2);
        bundle.add(c3);

        bundle.sortSugar();
        Sweet[] cmp = { l1, l3, c3, l2, c1, c2 };
        assertArrayEquals(bundle.toArray(), cmp);
    }

    @Test
    public void findTest() {
        Lollipop l1 = new Lollipop("L1", 14, 1);
        Lollipop l2 = new Lollipop("L2", 20, 5);
        Lollipop l3 = new Lollipop("L3", 10, 3);
        l3.setWithGum(true);

        Cookie c1 = new Cookie("C1", 25, 5);
        Cookie c2 = new Cookie("C2", 40, 10);
        Cookie c3 = new Cookie("C3", 18, 4);
        c3.setFilling(Filling.MILK);

        Bundle bundle = new Bundle();
        bundle.add(l1);
        bundle.add(l2);
        bundle.add(l3);
        bundle.add(c1);
        bundle.add(c2);
        bundle.add(c3);

        Range r1 = new Range(10, 12);
        Sweet f1 = bundle.find(r1);
        assertEquals(f1, c2);

        Range r2 = new Range(15, 20);
        Sweet f2 = bundle.find(r2);
        assertNull(f2);
    }
}
