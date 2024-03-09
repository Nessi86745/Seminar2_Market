public interface QueueBehaviour {
    void takeInQueue(Actor actor);
    void takeOrders(Actor actor, String product);
    void giveOrders(Actor actor, String product);

    void giveOrders();

    void releaseFromQueue();
}