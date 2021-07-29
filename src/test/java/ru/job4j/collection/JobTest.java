package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.collection.Comparators.*;

import java.util.ArrayList;
import java.util.List;

public class JobTest {

    private final Job job1_1 = new Job("Job1", 1);
    private final Job job1_2 = new Job("Job1", 2);
    private final Job job1_3 = new Job("Job1", 3);
    private final Job job2_1 = new Job("Job2", 1);
    private final Job job2_2 = new Job("Job2", 2);
    private final Job job2_3 = new Job("Job2", 3);
    private final Job job3_3 = new Job("Job3", 3);
    private final Job job4_4 = new Job("Job4", 4);
    private final Job job5_5 = new Job("Job5", 5);

    @Test
    public void nameAscSort() {
        List<Job> jobs = new ArrayList<>();
        jobs.add(job3_3);
        jobs.add(job5_5);
        jobs.add(job1_1);
        jobs.add(job2_2);
        jobs.add(job4_4);

        Job[] expected = {
                job1_1,
                job2_2,
                job3_3,
                job4_4,
                job5_5
        };

        jobs.sort(new JobNameAscComparator());

        Assert.assertArrayEquals(expected, jobs.toArray());
    }

    @Test
    public void nameDescSort() {
        List<Job> jobs = new ArrayList<>();
        jobs.add(job3_3);
        jobs.add(job5_5);
        jobs.add(job1_1);
        jobs.add(job2_2);
        jobs.add(job4_4);

        Job[] expected = {
                job5_5,
                job4_4,
                job3_3,
                job2_2,
                job1_1
        };

        jobs.sort(new JobNameDescComparator());

        Assert.assertArrayEquals(expected, jobs.toArray());
    }

    @Test
    public void priorityAscSort() {
        List<Job> jobs = new ArrayList<>();
        jobs.add(job3_3);
        jobs.add(job5_5);
        jobs.add(job1_1);
        jobs.add(job2_2);
        jobs.add(job4_4);

        Job[] expected = {
                job1_1,
                job2_2,
                job3_3,
                job4_4,
                job5_5
        };

        jobs.sort(new JobPriorityAscComparator());

        Assert.assertArrayEquals(expected, jobs.toArray());
    }

    @Test
    public void priorityDescSort() {
        List<Job> jobs = new ArrayList<>();
        jobs.add(job3_3);
        jobs.add(job5_5);
        jobs.add(job1_1);
        jobs.add(job2_2);
        jobs.add(job4_4);

        Job[] expected = {
                job5_5,
                job4_4,
                job3_3,
                job2_2,
                job1_1
        };

        jobs.sort(new JobPriorityDescComparator());

        Assert.assertArrayEquals(expected, jobs.toArray());
    }

    @Test
    public void nameAscAndPriorityDescSort() {
        List<Job> jobs = new ArrayList<>();
        jobs.add(job2_2);
        jobs.add(job1_1);
        jobs.add(job2_1);
        jobs.add(job1_3);
        jobs.add(job2_3);
        jobs.add(job1_2);

        Job[] expected = {
                job1_3,
                job1_2,
                job1_1,
                job2_3,
                job2_2,
                job2_1
        };

        jobs.sort(new JobNameAscComparator()
                .thenComparing(new JobPriorityDescComparator()));

        Assert.assertArrayEquals(expected, jobs.toArray());
    }

    @Test
    public void priorityAscAndNameDescSort() {
        List<Job> jobs = new ArrayList<>();
        jobs.add(job2_2);
        jobs.add(job1_1);
        jobs.add(job2_1);
        jobs.add(job1_3);
        jobs.add(job2_3);
        jobs.add(job1_2);

        Job[] expected = {
                job2_1,
                job1_1,
                job2_2,
                job1_2,
                job2_3,
                job1_3
        };

        jobs.sort(new JobPriorityAscComparator()
                .thenComparing(new JobNameDescComparator()));

        Assert.assertArrayEquals(expected, jobs.toArray());
    }
}