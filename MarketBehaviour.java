import java.util.List;

public interface MarketBehaviour {
    void acceptToMarket(Actor actor);
    void releaseFromMarket(List<Actor> actors);
    void update();
    void buy(Actor actor, String product);
    void leaveMarket(Actor actor);

    void takeOrders();
}