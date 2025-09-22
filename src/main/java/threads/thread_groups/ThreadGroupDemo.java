package threads.thread_groups;

class ThreadGroupDemo {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getThreadGroup().getName()); //main
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getName()); //system
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getParent()); //null

        ThreadGroup parent = new ThreadGroup("Sun");
        System.out.println(parent.getName()); //Sun

        ThreadGroup child = new ThreadGroup(parent, "9 Planets");
        System.out.println(child.getName()); //9 Planets
        System.out.println(child.getParent().getName()); //Sun
    }
}