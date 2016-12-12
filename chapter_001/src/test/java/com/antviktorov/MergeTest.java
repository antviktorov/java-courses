package com.antviktorov;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Merge test class.
 *
 * @author Anton Viktorov
 * @since 1.0
 */
public class MergeTest {

    /**
     * Max in two.
     */
    @Test
    public void mergeTest() {
        Merge merge = new Merge();
        assertThat(
                merge.merge(new int[]{1,32,67,7,2}, new int[]{99,8,3,4}),
                is(new int[]{1,32,67,7,2,99,8,3,4})
        );
    }

    /**
     * Max in two.
     */
    @Test
    public void sortTest() {
        Merge merge = new Merge();
        assertThat(
                merge.sort(new int[]{1,18,54,45,2,99,8,3,4}),
                is(new int[]{1,2,3,4,8,18,45,54,99})
        );
    }

}
