package weekMatch.week.w243;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author: ÎÚÑ»×ø·É»úÙï
 * @date: 2021/5/30 10:07
 * @Description:
 */
public class Q03 {
    public static void main(String[] args) {
        int[] server = new int[]{10, 63, 95, 16, 85, 57, 83, 95, 6, 29, 71};
        int[] task = new int[]{70, 31, 83, 15, 32, 67, 98, 65, 56, 48, 38, 90, 5};
        System.out.println(Arrays.toString(new Q03().assignTasks(server, task)));
    }

    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<Server> freeServer = new PriorityQueue<>((s1, s2) -> {
            if (s1.weight != s2.weight) return s1.weight - s2.weight;
            return s1.index - s2.index;
        });
        PriorityQueue<Server> workServer = new PriorityQueue<>(Comparator.comparingInt(s -> s.freeTime));
        Server[] server = new Server[servers.length];
        for (int i = 0; i < servers.length; i++) {
            server[i] = new Server(i, servers[i]);
            freeServer.add(server[i]);
        }

        PriorityQueue<Task> waitTask = new PriorityQueue<>(Comparator.comparingInt(t -> t.index));
        Task[] task = new Task[tasks.length];
        for (int i = 0; i < tasks.length; i++) {
            task[i] = new Task(i, tasks[i]);
        }


        LinkedList<Integer> result = new LinkedList<>();
        int time = 0;

        while (time < task.length || !waitTask.isEmpty()) {
            if (time < task.length) waitTask.add(task[time]);
            else time = workServer.peek().freeTime;
            while (!workServer.isEmpty()) {
                Server s = workServer.peek();
                if (time >= s.freeTime) freeServer.add(workServer.poll());
                else break;
            }

            while (!waitTask.isEmpty() && !freeServer.isEmpty()) {
                Task t = waitTask.poll();
                Server s = freeServer.poll();
                s.freeTime = time + t.len;
                result.add(s.index);
                workServer.add(s);
            }

            if (time < task.length) time++;
        }


        int[] out = new int[result.size()];
        int i = 0;
        for (int v : result) out[i++] = v;
        return out;
    }

    static class Task {
        int index;
        int len;

        public Task(int index, int len) {
            this.index = index;
            this.len = len;
        }
    }

    static class Server {
        int index;
        int weight;
        boolean free = true;
        int freeTime;

        public Server(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }


}
