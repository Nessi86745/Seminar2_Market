import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Market implements MarketBehaviour, QueueBehaviour {
    private final Queue<Actor> queue;

    public Market() {
        this.queue = new LinkedList<>();
    }

    @Override
    public void acceptToMarket(Actor actor) {
        System.out.println(actor.getName() + " пришел в магазин");
        takeInQueue(actor);
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for (Actor actor : actors) {
            System.out.println(actor.getName() + "вышел из магазина");
            queue.remove(actor);
        }

    }

    @Override
    public void update() {
        takeOrders();
        giveOrders();
        releaseFromQueue();
    }

    @Override
    public void buy(Actor actor, String product) {

    }

    @Override
    public void leaveMarket(Actor actor) {

    }


    @Override
    public void takeInQueue(Actor actor) {
        System.out.println(actor.getName() + " стоит в очереди");
        queue.offer(actor);
        releaseFromQueue();
    }

    @Override
    public void takeOrders(Actor actor, String product) {

    }

    @Override
    public void giveOrders(Actor actor, String product) {

    }

    @Override
    public void takeOrders() {
        for (Actor actor : queue) {
            if (!actor.isMakeOrder()) {
                actor.setMakeOrder(true);
                System.out.println(actor.getName() + "оформил заказ");
            }
        }
    }

    @Override
    public void giveOrders() {
        for (Actor actor : queue) {
            if (actor.isMakeOrder()) {
                actor.setTakeOrder(true);
                System.out.println(actor.getName() + "забрал заказ");
            }
        }
    }

    @Override
    public void releaseFromQueue() {
        Queue<Actor> releasedActors = new LinkedList<>();
        for (Actor actor : queue) {
            if (actor.isTakeOrder()) {
                releasedActors.add(actor);
                System.out.println(actor.getName() + "вышел из очереди");
            }

        }
        releaseFromMarket((List<Actor>) releasedActors);
    }

}