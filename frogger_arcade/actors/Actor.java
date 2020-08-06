package frogger_arcade.actors;
/**
 * Actor class
 * @author psymp5
 */

import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import frogger_arcade.stage.World;

import java.util.ArrayList;


public abstract class Actor extends ImageView{
    /**
     * Actor is an abstract class that provides an interface for objects.
     * @param dx sets the location of the object in x axis
     * @param dy sets the location of the object in y axis
     */
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    public World getWorld() {
        return (World) getParent();
    }

    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }

    /**
     * getOneIntersectingObject returns the the object that intersects the current actor.
     * @param cls
     * @param <A>
     * @return
     */
    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }
    
    public void manageInput(InputEvent e) {
        
    }

    /**
     * getOneIntersectingObject returns the the object that intersects the current actor.
     * @param cls
     * @param <A>
     * @return
     */
    public <A extends Actor> A getOneIntersectingObject(java.lang.Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
                break;
            }
        }
        return someArray.get(0);
    }

    /**
     * act method is called by the greenfoot framework to allow actors to perform some action.
     * @param now
     */
    public abstract void act(long now);

}
