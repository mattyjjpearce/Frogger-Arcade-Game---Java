package frogger_arcade.actors;


/**
 * Class Entity is the interface for our Factory class in order to set the Act Method.
 */
public abstract class Entity extends Actor {

    double speed;

    /**
     * Calling the method act. Setting the location of the objects once they reach the end.
     * @param now
     */
    @Override
    public void act(long now) {
        move(speed , 0);
        if (getX()>600 && speed>0)
            setX(-180);
        if (getX()<-300 && speed<0)
            setX(700);
    }
}
