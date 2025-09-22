package threads.thread_groups;

public class ThreadGroupPriority {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getThreadGroup().getName()); //main
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getName()); //system
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getParent()); //null

        System.out.println();

        ThreadGroup parent = new ThreadGroup("Sun");
        System.out.println(parent.getName()); //Sun

        ThreadGroup child = new ThreadGroup(parent, "9 Planets");
        System.out.println(child.getName()); //9 Planets
        System.out.println(child.getParent().getName()); //Sun


        System.out.println();
        System.out.println("Setting Thread Priorities");
        System.out.println();

        Thread t1 = new Thread(child, "Thread 1");
        //every thread will have a default priority set to 5
        System.out.println("t1 priority: " + t1.getPriority()); //5

        //changing the priority of threads added to the child thread group
        //but it will be assigned only for the threads newly added to the child thread group and no to the old threads for which the priority is already set
        //i.e it won't set the priority retrospectively

        child.setMaxPriority(4);
        Thread t2 = new Thread(child, "Thread 2");

        System.out.println();
        System.out.println("After setting priority 4 to the child thread group");
        System.out.println("t1 priority: " + t1.getPriority()); //5
        System.out.println("t2 priority: " + t2.getPriority()); //4
    }
}

/*
output
---------
main
system
null

Sun
9 Planets
Sun

Setting Thread Priorities

t1 priority: 5

After setting priority 4 to the child thread group
t1 priority: 5
t2 priority: 4

 */