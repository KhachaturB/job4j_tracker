package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.collection.Comparators.*;

import java.util.Arrays;
import java.util.List;

public class JobTest {

    @Test
    public void nameAscSort() {
        Job job1 = new Job("Job1", 1);
        Job job2 = new Job("Job2", 2);
        Job job3 = new Job("Job3", 3);
        Job job4 = new Job("Job4", 4);
        Job job5 = new Job("Job5", 5);

        List<Job> jobs = Arrays.asList(job3, job5, job1, job2, job4);
        List<Job> expected = Arrays.asList(job1, job2, job3, job4, job5);

        jobs.sort(new JobNameAscComparator());

        Assert.assertEquals(expected, jobs);
    }

    @Test
    public void nameDescSort() {
        Job job1 = new Job("Job1", 1);
        Job job2 = new Job("Job2", 2);
        Job job3 = new Job("Job3", 3);
        Job job4 = new Job("Job4", 4);
        Job job5 = new Job("Job5", 5);

        List<Job> jobs = Arrays.asList(job3, job5, job1, job2, job4);
        List<Job> expected = Arrays.asList(job5, job4, job3, job2, job1);

        jobs.sort(new JobNameDescComparator());

        Assert.assertEquals(expected, jobs);
    }

    @Test
    public void priorityAscSort() {
        Job job1 = new Job("Job1", 1);
        Job job2 = new Job("Job2", 2);
        Job job3 = new Job("Job3", 3);
        Job job4 = new Job("Job4", 4);
        Job job5 = new Job("Job5", 5);

        List<Job> jobs = Arrays.asList(job3, job5, job1, job2, job4);
        List<Job> expected = Arrays.asList(job1, job2, job3, job4, job5);

        jobs.sort(new JobPriorityAscComparator());

        Assert.assertEquals(expected, jobs);
    }

    @Test
    public void priorityDescSort() {
        Job job1 = new Job("Job1", 1);
        Job job2 = new Job("Job2", 2);
        Job job3 = new Job("Job3", 3);
        Job job4 = new Job("Job4", 4);
        Job job5 = new Job("Job5", 5);

        List<Job> jobs = Arrays.asList(job3, job5, job1, job2, job4);
        List<Job> expected = Arrays.asList(job5, job4, job3, job2, job1);

        jobs.sort(new JobPriorityDescComparator());

        Assert.assertEquals(expected, jobs);
    }

    @Test
    public void nameAscAndPriorityDescSort() {
        Job job11 = new Job("Job1", 1);
        Job job12 = new Job("Job1", 2);
        Job job13 = new Job("Job1", 3);
        Job job21 = new Job("Job2", 1);
        Job job22 = new Job("Job2", 2);
        Job job23 = new Job("Job2", 3);

        List<Job> jobs = Arrays.asList(job22, job11, job21, job13, job23, job12);
        List<Job> expected = Arrays.asList(job13, job12, job11, job23, job22, job21);

        jobs.sort(new JobNameAscComparator()
                .thenComparing(new JobPriorityDescComparator()));

        Assert.assertEquals(expected, jobs);
    }

    @Test
    public void priorityAscAndNameDescSort() {
        Job job11 = new Job("Job1", 1);
        Job job12 = new Job("Job1", 2);
        Job job13 = new Job("Job1", 3);
        Job job21 = new Job("Job2", 1);
        Job job22 = new Job("Job2", 2);
        Job job23 = new Job("Job2", 3);

        List<Job> jobs = Arrays.asList(job22, job11, job21, job13, job23, job12);
        List<Job> expected = Arrays.asList(job21, job11, job22, job12, job23, job13);

        jobs.sort(new JobPriorityAscComparator()
                .thenComparing(new JobNameDescComparator()));

        Assert.assertEquals(expected, jobs);
    }
}
